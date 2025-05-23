import arc.*;

public class repotest{
	public static void main(String[] arg){
		
		String strWord;
		String strLetter;
		Console con = new Console();
		con.println("Helllo World");
		con.println("Give me a word");
		strWord = con.readLine();
		strLetter = strWord.substring(0,1);
		con.println("The first letter is" +strLetter);
		
	}
}
