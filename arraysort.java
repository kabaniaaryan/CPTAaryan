import arc.*;

public class arraysort{
	public static void main(String[] args){
		Console con = new Console();
		
		// 2d array with rows and columns
		String strMovies[][];
		// has 5 rows and 3 columns
		strMovies = new String[5][3];
		
		// column 0  is the movie name
		// column 1 is critic score
		// column 2 is people sore
		// each row is a new movie category
		
		strMovies[0][0] = "Thunderbolts";
		strMovies[0][1] = "88";
		strMovies[0][2] = "93";
		
		strMovies[1][0] = "Sinners";
		strMovies[1][1] = "96";
		strMovies[1][2] = "97";
		
		strMovies[2][0] = "Minecraft";
		strMovies[2][1] = "48";
		strMovies[2][2] = "86";
		
		strMovies[3][0] = "Lilo";
		strMovies[3][1] = "69";
		strMovies[3][2] = "93";
		
		strMovies[4][0] = "Brutalist";
		strMovies[4][1] = "93";
		strMovies[4][2] = "80";
		
		// print out array;
		int intCount;
		con.println("before sorting");
		for(intCount = 0; intCount < 5; intCount++){
			con.println(strMovies[intCount][0] + ": " +strMovies[intCount][1]+ " - "+strMovies[intCount][2]);
		}
		
		int intCount2;
		String strNameTemp;
		String strCriticsTemp;
		String strPeopleTemp;
		
		for(intCount2 = 0; intCount2 < 5-1; intCount2++){
			for(intCount = 0; intCount <5-1; intCount++){
				if(Integer.parseInt(strMovies[intCount][1]) > Integer.parseInt(strMovies[intCount + 1][1])){
					// Swap
					// Swap name
					strNameTemp = strMovies[intCount][0];
					strMovies[intCount][0] = strMovies[intCount + 1][0];
					strMovies[intCount+1][0] = strNameTemp;
					// swap critics
					strCriticsTemp = strMovies[intCount][1];
					strMovies[intCount][1] = strMovies[intCount+1][1];
					strMovies[intCount+1][1] = strCriticsTemp;
					// swap people
					strPeopleTemp = strMovies[intCount][2];
					strMovies[intCount][2] = strMovies[intCount+1][2];
					strMovies[intCount+1][2] = strPeopleTemp;
				}
			}
		}
		
		con.println("\n\nAfter sorting");
		for(intCount = 0; intCount < 5; intCount++){
			con.println(strMovies[intCount][0] + ": " +strMovies[intCount][1]+ " - "+strMovies[intCount][2]);
		}
	}
}
