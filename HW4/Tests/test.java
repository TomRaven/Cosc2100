import org.apache.commons.codec.binary.Hex;

public class test{
	public static void main(String args[]){
		String myString = "e";
		String hexString = Hex.encodeHexString(myString.getBytes(/* charset */));
	}
}
