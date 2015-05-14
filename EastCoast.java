import java.util.Scanner;

/*
Fallout: East Coast
Fallout was originally created by Interplay and is copyrighted by Bethesda Softworks
"East Coast" is owned by Buck Shockley
This work is licensed under the Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License. 
To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/4.0/.
*/

class player{
	String name;
	String gender;
	boolean alive;
}

public class FalloutEastCoast {
	public static void main(String[] args) {
		boolean gameRunning = true;
		
		player p1 = new player();
		p1.name = "";
		p1.gender = "";
		p1.alive = true;
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int gameState = 0;
		while (gameRunning == true){
			while (gameState == 0){
				
			}
		}
	}
}

//shoutout to eclipse for erasing half my code
//*headdesk*


