package Mining;

import java.util.Date;

public class Block {
	public static String hash;
	public static String data;
	public static int nonce = 0;
	public static String previousHash;
	public static long timeStamp;
	
	Block(String data, String previousHash){
		this.data = data;
		this.previousHash = previousHash;
		this.hash= getHash();
		this.timeStamp = new Date().getTime();
	}
	
	public static  String getHash() {
		String calculatedhash = Mining.SHA256( 
				previousHash +
				Long.toString(timeStamp) +
				Integer.toString(nonce) + 
				data 
				);
		return calculatedhash;

	}
	
	public static void mine(int difficulty) {
		StringBuffer diff = new StringBuffer();
		for(int i=0; i<difficulty; i++) diff.append("0");
		while(!hash.substring(0,difficulty).equals(diff.toString())) {
			nonce++;
			hash = getHash();
		}
	}
	
}