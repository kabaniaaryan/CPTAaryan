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
			}
		}
	}
	
	public static void play(Console con){
		con.println("Play");
	}
	
	public static void leaderboard(Console con){
		con.println("leaderboard");
	}
	
	public static void addTheme(Console con){
		con.println("add theme");
	}	
}
