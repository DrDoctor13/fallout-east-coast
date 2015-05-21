import java.util.ArrayList;
import java.util.Arrays;
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

		
		player p1 = new player();
		p1.name = "";
		p1.gender = "";
		p1.alive = true;
		String choice = ""; //Thanks Kolby
		ArrayList<String> inv = new ArrayList<String>();
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int gameState = 0;
		
		boolean gameRunning = true;
		
		while (gameRunning == true){
			if (gameState == 5862){
				gameRunning = false;
			}
			if (gameState == 5863){
				double rando = Math.random();
				double randoRound = rando * 5;
				double deathNumber = Math.ceil(randoRound);
				ArrayList<String> deaths = new ArrayList<String>(); //Thanks Kolby (for help implementing) and Alina (for array idea).
				deaths.addAll(Arrays.asList("The darkness of the afterlife is all that awaits you now. May you find more peace in that world than you found in this one...", "Not even the carrion eaters are interested in your irradiated corpse...", "Your life ends in the wasteland...", "You fought valiantly, but to no avail. Your twisted and ruined body goes down in a hail of bullets... and thus ends your life in the wasteland...", "You have perished."));
				System.out.println(deaths.get((int) deathNumber));
				gameRunning = false;
				}
			while (gameState == 0){
				System.out.println("Welcome to Fallout: East Coast.");
				System.out.println("This game contains themes of violence, death, religion, and atheism. Are you sure you want to continue? (y/n)");
				choice = input.nextLine();
				switch (choice){
				case "y":
					System.out.println("Let's get started, then.");
					gameState = 1;
					break;
				case "n":
					System.out.println("I'll see you at Weenie Hut Jrs.");
					gameState = 5862;
					break;
				}
					
				
			}
			while (gameState == 1){
				System.out.println("A blinding light greets you as your eyes open.");
				System.out.println("You hear the sound of seagulls in the distance, and small waves crashing on a beach shore.");
				System.out.println("'You're awake...how about that?'");
				System.out.println("The voice startled you, you tried to sit up, but felt a hand on your chest.");
				System.out.println("'Easy there, kid...you've been out for a while, now...'");
				System.out.println("'Do you remember your name?'");
				String name = input.nextLine();
				p1.name = name;
				p1.alive = true;
				System.out.println("'" + p1.name + ", eh? Well, I can't say it's the name I'd have picked for you, but if you say so...'");
				System.out.println("'You were beat around quite a bit out there, those mutants nearly turned you to mush.'");
				System.out.println("'You better make sure that I put everything back the way it was...don't worry, I'll turn away.'");
				System.out.println("[Are you a boy or a girl?]");
				String gender = input.nextLine();
				p1.gender = gender;
				if (gender != "boy" && gender != "girl"){
					p1.gender = "boy";
				}
				System.out.println("'Well, I guess I got most of it right...the stuff that mattered, anyway.");
				System.out.println("'Okay...let's get you up.'");
				System.out.println("The man's hands grabbed yours and helped pull you out of a bed. He was an older gentleman, wearing overwalls and a handkerchief covering his neck.");
				System.out.println("Your head ached as you stood, and you saw you were in an old house. It looked like it was nice once, owned by a rich family.");
				System.out.println("The man hands you a 10mm pistol, some Stimpaks, ammo, and some food before sending you into the world.");
				inv.addAll(Arrays.asList("10mm Pistol", "5 stimpaks", "100 10mm bullets", "2 bottles of Sunset Sarsaparilla", "5 pieces of Gecko Meat"));
				System.out.println("When you leave the house, you see you're at a beach. There were seagulls squawking and flying above, and to your right was a beach.");
				System.out.println("To your left is an old shack and a housing district.");
				String direction = input.nextLine();
				switch (direction){
				case "go right":
					gameState = 2;
					break;
				case "go left":
					gameState = 3;
					break;
				}
				
				
			}
			if (gameState == 2){
				System.out.println("You decide to venture to the right, towards the beach.");
				System.out.println("At the beach, you are greeted with abandoned cars in a parking lot. The cars are all rusted and were already looted.");
				System.out.println("The sand looked pale on the overcast day, and was cold to the touch. Derelict benches and lifeguard chairs littered the sand.");
				System.out.println("You are startled by the sound of people talking in the distance. Raiders.");
				System.out.println("You lack the abilities for a fight, and your pistol will be inaccurate from this distance.");
				System.out.println("There are some dunes you can hide behind nearby.");
				String hidingspot = input.nextLine();
				switch (hidingspot){
				case "hide":
					gameState = 5;
					break;
				case "fight":
					gameState = 5863;
				}
				}
			
			}
		}
	}
