import org.bitcoinj.core.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;
import org.bitcoinj.params.RegTestParams;
import org.bitcoinj.params.TestNet3Params;
import org.bitcoinj.script.Script;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mars
 * https://www.infoworld.com/article/2078482/bitcoin-for-beginners--part-3--the-bitcoinj-api.html
 */
@Slf4j
public class CreateAdress {

	public CreateAdress(String[] args) {

		ECKey key = new ECKey();
		log.info("We created key:\n{}", key);

		final NetworkParameters params = selectNetwork(args);

		// get valid Bitcoin address from public key
		Address addressFromKey = Address.fromKey(params, key, Script.ScriptType.P2PKH);
		
		log.info("On the " + args[0]+ " network, we can use this address:\n" + addressFromKey); 
	}

	private NetworkParameters selectNetwork(String[] args) {
		final NetworkParameters params;

		if (args[0].equals("testnet")) {
		    params = TestNet3Params.get();
		    System.out.println("Using test network.");
		} else if (args[0].equals("regtest")) {
		    params = RegTestParams.get();
		    System.out.println("Using regtest network.");
		} else {
		    params = MainNetParams.get();
		    System.out.println("Using main network.");
		}
		return params;
	}

	public static void main(String[] args) {
		String[] net = new String[1];
		net[0] = "testnet";
		new CreateAdress(net);
	}

}
