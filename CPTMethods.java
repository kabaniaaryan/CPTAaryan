import arc.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Font;

public class CPTMethods{
	public static void mainMenu(Console con){
		char chrChoice;
		int intTemp;
		intTemp = 2;
		while(true){
			con.setDrawColor(new Color(3, 100, 230));
			con.fillRoundRect(350, 25, 300, 100, 350, 0);
			con.fillRoundRect(350, 150, 300, 300, 350, 0);
			con.println("\n");
			con.println("                                     Welcome to");
			con.println("                                   GUESS THE WORD");
			con.println("\n \n \n");
			con.println("                                  1.    (P)lay");
			con.println("");
			con.println("                                  2. (L)eaderboard");
			con.println("");
			con.println("                                  3.   (T)heme");
			con.println("");
			con.println("                                  4.   (H)elp");
			con.println("");
			con.println("                                  5.   (E)xit");
			con.println("\n \n ");
			con.println("                Select the first letter that corresponds with your option");
			chrChoice  = Character.toLowerCase(con.getChar());
			con.clear();
			
			//setting background back to black
			con.setDrawColor(Color.black); 
			con.fillRect(0, 0, 1280, 720);
			
			//user choosing their choice
			if(chrChoice == 'p'){
				con.clear();
				CPTMethods.play(con);
			}else if(chrChoice == 'l'){
				con.clear();
				CPTMethods.leaderboard(con);
			}else if(chrChoice == 't'){
				con.clear();
				CPTMethods.addTheme(con);
			}else if(chrChoice == 'h'){
				con.clear();
				CPTMethods.help(con);
			}else if(chrChoice == 'e'){
				con.clear();
				break;
			}else if(chrChoice == 's'){
				con.clear();
				CPTMethods.secretMenu(con);
			}else{
				con.clear();
				con.println("                                    Not an option");
				con.sleep(2000);
				con.clear();
				con.setDrawColor(new Color(3, 100, 230));
				con.fillRoundRect(350, 25, 300, 100, 350, 0);
				con.fillRoundRect(350, 150, 300, 300, 350, 0);
			}
			
			
		} 
	}
	
	public static void play(Console con){
		String strName;
		//asking user for name
		con.setDrawColor(new Color(3, 100, 230));
		con.fillRoundRect(340, 75, 325, 200, 350, 0);
		con.println("\n \n \n \n");
		con.println("                                 WHAT IS YOUR NAME?");
		con.println("\n");
		con.print("                                      ");
		strName = con.readLine();
		con.clear();
		//find what theme the user wants
		TextInputFile masterFile = new TextInputFile("masterfile.txt");
		
		//finding how many themes are in master file
		String strThemes[];
		String strTemp;
		int intLinesInFile; 
		intLinesInFile = 0;
		
		//setting background back to black
		con.setDrawColor(Color.black); 
		con.fillRect(0, 0, 1280, 720);
		
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
		con.setDrawColor(new Color(3, 100, 230));
		con.fillRoundRect(340, 75, 325, 400, 350, 0);
		int intCount2;
		int intThemeChoice;
		
		con.println("                           Here Are The Available Themes");
		con.println("                   Plese Choose The Number To The Left Of The Theme");
		con.println("\n \n \n");
		for(intCount2 = 0; intCount2 < intLinesInFile; intCount2++){
			con.println("                                   "+(intCount2+1)+". "+strThemes[intCount2]);			
		}
		con.print("\n \n \n \n \n \n \n \n \n \n \n \n                                         ");
		intThemeChoice = con.readInt();
		String strThemeName;
		intThemeChoice = intThemeChoice - 1;
		
		strThemeName = strThemes[intThemeChoice]+".txt";
		con.clear();
		
		//setting background back to black
		con.setDrawColor(Color.black); 
		con.fillRect(0, 0, 1280, 720);
		
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
		//playing the game - interacting with user (the main code)
		int intGame;
		boolean blnPlayAgain;
		int intWordsGuessed;
		intWordsGuessed = 0;
		blnPlayAgain = true;
		while(blnPlayAgain == true){
			con.clear();
			for(intGame = 0; intGame < intThemeWordsNum; intGame++){
				//setting up format - how many dashes to put
				int intLength;
				intLength = strThemeWords[intGame][0].length();	
				int intPoints;
				intPoints = intLength;	
				
				//another 4+++ checklist, if user's name is 'statitan' they get double points
				if(strName.equals("statitan")){
					intPoints = intPoints * 2;
				}
				
				char charProgress[];
				charProgress = new char[intLength];
				int intDashNum;
				con.print("                                  ");
				for(intDashNum = 0; intDashNum < intLength; intDashNum++){
					charProgress[intDashNum] = '_';
					con.print(charProgress[intDashNum]);
				}
				strThemeWords[intGame][0] = strThemeWords[intGame][0].toLowerCase();
				char[] charLetters = strThemeWords[intGame][0].toCharArray();
				
				//guessing the letters in the actual word
				boolean blnWordGuessed;
				blnWordGuessed = false;
				while(blnWordGuessed == false && intPoints > 0){					
					String strGuess;
					con.println("");
					con.println("\n \n \n \n \n                                Guess A Letter");
					con.print("                                      ");
					strGuess = con.readLine();
					strGuess = strGuess.toLowerCase();
					
					if(strGuess.length() != 1){
						con.println("Only guess one letter");
					}
					
					char charGuess;
					charGuess = strGuess.toLowerCase().charAt(0);
					
					//checking to see if the letter guessed is correct
					int intChecking;
					boolean blnCorrect;
					blnCorrect = false;
					for(intChecking = 0; intChecking < intLength; intChecking++){
						if(charLetters[intChecking] == charGuess){
							con.clear();
							charProgress[intChecking] = charGuess;
							blnCorrect = true;
							con.println("                        You Guessed The Correct Letter");
							intWordsGuessed = intWordsGuessed + 1;
						}
					}
					
					//if user guesses wrong
					if(blnCorrect == false){
						intPoints = intPoints - 1;
						con.clear();
						con.print("                   WRONG!!! You Only Have " +intPoints+ " More Points Left");
						con.println("                             Here Is Your Progress:");
					}
					
					//printing users progress
					con.println("                             Here Is Your Progress:");
					con.print("                                   ");
					int intUserProgress;
					for(intUserProgress = 0; intUserProgress < intLength; intUserProgress++){
						con.print(charProgress[intUserProgress]);
					}
					
					//checking if word is guessed
					if(String.valueOf(charProgress).equals(strThemeWords[intGame][0])){
						blnWordGuessed = true;
						con.clear();
						con.println("          CONGRATULATIONS!!! You guessed the word: "+strThemeWords[intGame][0]+ " correctly!");
						con.sleep(5000);
					}else if(intPoints <= 0){
						con.clear();
						con.println("                      Sorry you lost, try again next time!");
						blnWordGuessed = true;
						con.sleep(5000);
					}else{
						continue;
					}
				}
				//seeing if user wants to play again
				con.clear();
				String strOption;
				con.println("                        Would you like to play again? \n          Select 'p' to play again or any other key to go to main menu");
				con.println("\n \n \n \n \n");
				con.print("                                      ");
				strOption = con.readLine();
				
				if(strOption.equals("p")){
					blnPlayAgain = true;
					con.clear();
				}else{
					blnPlayAgain = false;
					con.clear();
					break;
				}	
			}
		//adding name and words guessed to the leaderboard
		TextOutputFile leaderboard = new TextOutputFile("leaderboard.txt", true);
		leaderboard.println(strName);
		leaderboard.println(intWordsGuessed);
		leaderboard.close();
		
		}
		
		//going back to main menu
		con.clear();
		String strRandom;
		con.println("");
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
		
		//going back to main menu
		String strRandom;
		con.println("Press any key to go back to the main menu");
		strRandom = con.readLine();
		if(strRandom != "lajsldkjfsdf"){
			con.clear();
		}
		
	}	
	
	public static void help(Console con){
		con.println("Tip 1 - Read quickly you only have 15 seconds or else this disappears!");
		con.println("Tip 2 - Try to guess the vowels first as they are most common!");
		con.println("Tip 3 - Do NOT guess multiple letters at the same time, guess word by word.");
		con.println("Tip 4 - Ensure you are confident in your guesses or else you will lose a point.");
		
		con.sleep(15000);
		con.clear();
		
		//going back to main menu
		String strRandom;
		con.println("Press any key to go back to the main menu");
		strRandom = con.readLine();
		if(strRandom != "lajsldkjfsdf"){
			con.clear();
		}
	}
	
	public static void secretMenu(Console con){
		//printing funny joke
		con.println("Ready for a funny joke?");
		con.sleep(2000);
		con.clear();
		con.println("What did one snowman say to the other snowman?");
		con.sleep(5000);
		con.clear();
		con.println("It smells like carrots !!!!!");
		con.sleep(5000);
		con.clear();
		
		//going back to main menu
		String strRandom;
		con.println("Press any key to go back to the main menu");
		strRandom = con.readLine();
		if(strRandom != "lajsldkjfsdf"){
			con.clear();
		}
	}
		

}
