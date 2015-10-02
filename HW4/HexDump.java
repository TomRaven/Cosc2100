import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HexDump {
	public static void main(String args[]){
		String fileName =  args[0];
		File file = null;
		Scanner in = null;
		//Get The File and initize the Scanner and file
		try {
			file = new File(fileName);
			in = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.err.println("Caught Null File Exception" + e.getMessage());
		}


		//Get the whole string and store it
		String wholesale = "";
		while (in.hasNextLine())
			wholesale += in.nextLine();

		//Print Out Each char of the string
		for(int i=0; i < wholesale.length()-1; i++){
			System.out.println(wholesale.substring(i,i+1) + stringToHex(wholesale.substring(i,i+1)));
		}
	}


	static String stringToHex(String string) {
 		StringBuilder buf = new StringBuilder(200);
  		for (char ch: string.toCharArray()) {
			if (buf.length() > 0)
				buf.append(' ');
			buf.append(String.format("%04x", (int) ch));
			}
  		returUn buf.toString();
	}
}
