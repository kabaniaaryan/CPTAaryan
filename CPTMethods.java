import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTMethods{
	public static void mainMenu(Console con){
		int intChoice;
		while(true){
			con.println("Guess The Word");
			con.println("1. Play");
			con.println("2. View Leaderboard");
			con.println("3. Add Theme");
			con.println("4. Exit");
			con.println("Choose a number that corresponds with the option");
			intChoice = con.readInt();
		
			if(intChoice == 1){
				con.clear();
				CPTMethods.play(con);
			}else if(intChoice == 2){
				con.clear();
				CPTMethods.leaderboard(con);
			}else if(intChoice == 3){
				con.clear();
				CPTMethods.addTheme(con);
			}else if(intChoice == 4){
				con.clear();
				break;
			}else{
				con.clear();
				con.println("Not an option");
			}
			
		} 
	}
	
	public static void play(Console con){
		String strName;
		con.println("What is your name?");
		strName = con.readLine();
		con.clear();
		//find what theme the user wants
		TextInputFile masterFile = new TextInputFile("masterfile.txt");
		
		//finding how many themes are in master file
		String strThemes[];
		String strTemp;
		int intLinesInFile; 
		intLinesInFile = 0;
		
		while(masterFile.eof() == false){
			intLinesInFile = intLinesInFile + 1;
			strTemp = masterFile.readLine();
		}
		masterFile.close();
		
		//getting all themes into array
		masterFile = new TextInputFile("masterfile.txt");
		strThemes = new String[intLinesInFile];
		int intCount;
		for(intCount = 0; intCount < intLinesInFile; intCount++){
			strThemes[intCount] = masterFile.readLine();
		
		}		
		masterFile.close();
		//telling user all themes in array and letting them pick
		int intCount2;
		int intThemeChoice;
		
		con.println("Here are the available themes");
		con.println("Plese choose the number to the left of the theme");
		for(intCount2 = 0; intCount2 < intLinesInFile; intCount2++){
			con.println((intCount2+1)+". "+strThemes[intCount2]);			
		}
		intThemeChoice = con.readInt();
		String strThemeName;
		intThemeChoice = intThemeChoice - 1;
		
		strThemeName = strThemes[intThemeChoice]+".txt";
		con.clear();
		
		//opening chosen theme and finding how many lines are in file
		TextInputFile chosenTheme = new TextInputFile(strThemeName);
		int intThemeWordsNum;
		intThemeWordsNum = 0;
		
		while(chosenTheme.eof() == false){
			strTemp = chosenTheme.readLine();
			intThemeWordsNum = intThemeWordsNum + 1;
		}
		chosenTheme.close();
		
		//getting all theme words into array
		chosenTheme = new TextInputFile(strThemeName);
		String strThemeWords[][];
		strThemeWords = new String[intThemeWordsNum][2];
		
		int intCount3;
		int intRandomNum;
		for(intCount3 = 0; intCount3 < intThemeWordsNum; intCount3++){
			strThemeWords[intCount3][0] = chosenTheme.readLine();
			intRandomNum = (int)(Math.random() * 100);
			strThemeWords[intCount3][1] = Integer.toString(intRandomNum);
		}
		chosenTheme.close();
		con.clear();
		
		//bubble sorting the words in the chosen theme
		int intCount4;
		int intCount5;
		String strTempName;
		String strTempNum;
		
		for(intCount4 = 0; intCount4 < intThemeWordsNum; intCount4++){
			for(intCount5 = 0; intCount5 < intThemeWordsNum - 1; intCount5++){
				if(Integer.parseInt(strThemeWords[intCount5][1]) < Integer.parseInt(strThemeWords[intCount5 + 1][1])){
					//swap name
					strTempName = strThemeWords[intCount5][0];
					strThemeWords[intCount5][0] = strThemeWords[intCount5+1][0];
					strThemeWords[intCount5+1][0] = strTempName;
					//swap random numbers
					strTempNum = strThemeWords[intCount5][1];
					strThemeWords[intCount5][1] = strThemeWords[intCount5+1][1];
					strThemeWords[intCount5+1][1] = strTempNum;
				}					
			}
		}
		
		//actually playing the game
		int intPoints;
		intPoints = strThemeWords[0][0].length();
		int intTest;
		for(intTest = 0; intTest < intThemeWordsNum; intTest++){
			con.println(strThemeWords[intTest][0]);
			con.println(strThemeWords[intTest][1]);
		}
		
		
		
		
		
		//going back to main menu
		String strRandom;
		
		con.println("Press any key to go back to the main menu");
		strRandom = con.readLine();
		if(strRandom != "SuperRandomNoOneWillEverGuessLalalalalasdfsdf"){
			con.clear();
		}	
	}
	
	public static void leaderboard(Console con){
		TextInputFile leaderboardFile = new TextInputFile("leaderboard.txt");
		
		int intCount;
		int intArrayNum;
		String strTemp;
		intArrayNum = 0;
		intCount = 0;
		
		//number of lines in file
		while(leaderboardFile.eof() == false){
			strTemp = leaderboardFile.readLine();
			intCount = intCount + 1;
		}
		intArrayNum = intCount/2;
		leaderboardFile.close();
		
		//getting leaderboard data into array
		leaderboardFile = new TextInputFile("leaderboard.txt");	
		
		String strLeaderboard[][];
		strLeaderboard = new String[intArrayNum][2];
		
		int intCount2;
		for(intCount2 = 0; intCount2 < intArrayNum; intCount2++){
			strLeaderboard[intCount2][0] = leaderboardFile.readLine();
			strLeaderboard[intCount2][1] = leaderboardFile.readLine();
		}
		leaderboardFile.close();
		
		//sorting leaderboard file
		int intCount3;
		int intCount5;
		String strTempName;
		String strTempScore;
		for(intCount5 = 0; intCount5<intArrayNum; intCount5++){
			for(intCount3 = 0; intCount3 < intCount2 - 1; intCount3++){
				if(Integer.parseInt(strLeaderboard[intCount3][1]) < Integer.parseInt(strLeaderboard[intCount3 + 1][1])){
					//swap name
					strTempName = strLeaderboard[intCount3][0];
					strLeaderboard[intCount3][0] = strLeaderboard[intCount3 + 1][0];
					strLeaderboard[intCount3+1][0] = strTempName;
					//swap nmumbers
					strTempScore = strLeaderboard[intCount3][1];
					strLeaderboard[intCount3][1] = strLeaderboard[intCount3 + 1][1];
					strLeaderboard[intCount3+1][1] = strTempScore;
				}
			}	
		}
		//display leaderboard
		int intCount4;
		con.println("The top 5 are:");
		for(intCount4 = 0; intCount4 < 5; intCount4++){
			con.println((intCount4 + 1)+". "+strLeaderboard[intCount4][0] + " with "+ strLeaderboard[intCount4][1]+" words revealed");
			
			}
		
		//going back to main menu
		String strRandom;
		
		con.println("Press any key to go back to the main menu");
		strRandom = con.readLine();
		if(strRandom != "lajsldkjfsdf"){
			con.clear();
		}
	}
	
	public static void addTheme(Console con){
		//getting new theme name
		String strNewTheme;
		con.println("What is the name of the new theme?");
		strNewTheme = con.readLine();
		//adding file name to master file
		TextOutputFile masterFile = new TextOutputFile("masterfile.txt", true);
		masterFile.println(strNewTheme);
		masterFile.close();
		
		//adding .txt to make the new theme it's own file
		strNewTheme = strNewTheme.toLowerCase() +".txt";
		
		TextOutputFile addThemeFile = new TextOutputFile(strNewTheme);
		
		//adding words into new theme file
		boolean blnLoop;
		String strNewWord;
		int intWordsAdded;
		
		blnLoop = true;
		con.println("If you would like to stop then type 'stop'");
		while(blnLoop == true){
			con.println("Your new word is: ");
			
			strNewWord = con.readLine();
			if(strNewWord.equalsIgnoreCase("stop")){
				break;
			}else if(strNewWord.length() < 4){
				con.println("Try again, the word must have 4 or more characters");
			}else{
				addThemeFile.println(strNewWord);
			}
			
		}
		addThemeFile.close();
		String strRandom;
		
		con.println("Press any key to go back to the main menu");
		strRandom = con.readLine();
		if(strRandom != "lajsldkjfsdf"){
			con.clear();
		}
		
	}	
	
	public static void testColor(String strColorName){
		strColorName = strColorName.toLowerCase();
		if(strColorName == "red"){
			//con.setDrawColor(Color.RED);
		}
	}

}
