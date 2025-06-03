import arc.*;

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
				CPTMethods.play(con);
			}else if(intChoice == 2){
				CPTMethods.leaderboard(con);
			}else if(intChoice == 3){
				CPTMethods.leaderboard(con);
			}else if(intChoice == 4){
				con.println("Quit");
			}else{
				con.println("Not an option");
			}
			
		} 
	}
	
	public static void play(Console con){
		con.println("Play");
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
			con.println(strLeaderboard[intCount2][0]+" - "+strLeaderboard[intCount2][1]);
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
		for(intCount4 = 0; intCount4 < 5; intCount4++){
			con.println((intCount4 + 1)+". "+strLeaderboard[intCount4][0] + " with "+ strLeaderboard[intCount4][1]+" words revealed");
		}
		
	}
	
	public static void addTheme(Console con){
		con.println("add theme");
	}	
}
