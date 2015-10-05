//Author Tom Lazar
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
while (in.hasNextLine()){
wholesale += in.nextLine();

}
char boby = 10;
wholesale += new StringBuilder().append(boby).append(boby).toString();
//Print Out Each char of the string
/*   TEST USE ONLY
for(int i=0; i < wholesale.length()-1; i++){
String temp = wholesale.substring(i, i +1);
String out = temp + " " + stringToHex(temp);
System.out.println(out);
}
*/
int x = 0;
int rowCounter = 0;
String RowNumber = "00000000";
String rowT = "00000000";
for(int i = 0; x < wholesale.length(); i++){


String rowNumber = stringToHex(Integer.toString(x));
String holder1 = "";
String holder2 = "";


for(int j = 0;(x < wholesale.length()) && (j<16)  ; j++){

rowCounter++;
String temp = new StringBuilder().append("").append(wholesale.charAt(x)).toString();;
holder1 += stringToHex(temp) + " ";
if(temp.charAt(0) == (char)10)
	temp = ".";
holder2 += temp;
if(j == 7)
holder1 += " ";
x++;
}
/*
int testContainer = 16 - holder2.length();
System.out.println(holder2);
for(int j = 0; j < testContainer; j++){
System.out.println("hi "+ j + "   " + testContainer);
holder1 = new StringBuilder().append(holder1).append("    ").toString();
holder2 = new StringBuilder().append(holder2).append(" ").toString();
}
*/

int cnt = 16 - holder2.length();
if(cnt > 8)
holder1 += new StringBuilder().append(" ").toString();
 for(int j = 0; j < cnt; j++){
holder1 += new StringBuilder().append("   ").toString();
holder2 += new StringBuilder().append(" ").toString();
}

System.out.println(RowNumber + "  " + holder1 + "  |" +holder2+ "|");
RowNumber = Integer.toHexString(rowCounter);
int cut = 8 - RowNumber.length();
String cuter = rowT.substring(0,cut);
RowNumber = new StringBuilder().append(cuter).append(RowNumber).toString();
}
System.out.println(RowNumber);
}


static String stringToHex(String string) {
 StringBuilder buf = new StringBuilder(200);
  for (char ch: string.toCharArray()) {
if (buf.length() > 0)
buf.append(' ');
buf.append(String.format("%04x", (int) ch));
}
  //return buf.toString().substring(1,3);
String temp = buf.toString();
String f1 = new StringBuilder().append("").append(temp.charAt(2)).append(temp.charAt(3)).toString();
return f1.toUpperCase();
}
}

