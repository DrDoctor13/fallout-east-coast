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

class player{ //class to hold certain variables pertaining to the player.
	String name;
	String gender;
	boolean alive;
	void playerDeath(){ //a void is a function that can be called on at any time, anywhere in the code.
		double rand = Math.random(); //Generates a random number between 0 and 1
		double randRound = rand * 5; //multiples the random number by 5.
		double deathNumber = Math.floor(randRound); //rounds down to the nearest whole number, resulting in choosing from 0 to 4.
		ArrayList<String> deaths;
		deaths = new ArrayList<>(Arrays.asList("The darkness of the afterlife is all that awaits you now. May you find more peace in that world than you found in this one.", "Not even the carrion eaters are interested in your irradiated corpse...", "Your life ends in the wasteland.", "You fought valiantly, but to no avail. Your twisted and ruined body goes down in a hail of bullets... and thus ends your life in the wasteland.", "You have perished.", "Rest in peace."));
		System.out.println(deaths.get((int) deathNumber));
	}
	ArrayList<String> inv = new ArrayList<>(); //Opens an array for the inv command
}

class FalloutEastCoast {
	public static void main(String[] args) {

		
		player p1 = new player(); //sets up the "player" by initializing empty variables
		p1.name = "";
		p1.gender = "";
		p1.alive = true;
		
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in); //opens a "scanner" to receive input and commands
		
		int gameState = 0; //sets the starting gamestate to 0
		//the gamestate system works for a nonlinear game, like this one
		//the 0th gamestate is the opening, then it continues from there
		
		boolean gameRunning = true; //a loop to keep the game from closing prematurely
		
		while (gameRunning){
			if (gameState == 5862){ //a gamestate to terminate the game
				gameRunning = false;
			}
			/*if (gameState == 9999){ // This was debugging, printing out all of my death messages.
				p1.playerDeath();
			}
			*/

			if (gameState == 0){
				System.out.println("Welcome to Fallout: East Coast.");
				System.out.println("This game contains themes of violence, death, religion, and atheism. Are you sure you want to continue? (y/n)");
				String choice = input.nextLine();
				switch (choice){ //a switch is kind of an if-then statement, just cleaner and handled slightly differently by Java
				case "y": //if the variable it's "switching" equals "y", it does whatever is inside that case.
					System.out.println("Let's get started, then.");
					gameState = 1;
					break;
				case "n":
					System.out.println("I'll see you at Weenie Hut Jrs.");
					break;
				}
					
				
			}
			if (gameState == 1){ //if statements to hold gamestates
				System.out.println("A blinding light greets you as your eyes open.");
				System.out.println("You hear the sound of seagulls in the distance, and small waves crashing on a beach shore.");
				System.out.println("'You're awake...how about that?'");
				System.out.println("The voice startled you, you tried to sit up, but felt a hand on your chest.");
				System.out.println("'Easy there, kid...you've been out for a while, now...'");
				System.out.println("'Do you remember your name?'");
				p1.name = input.nextLine();
				p1.alive = true; //IT'S ALIIIIIIVE
				System.out.println("'" + p1.name + ", eh? Well, I can't say it's the name I'd have picked for you, but if you say so...'");
				System.out.println("'You were beat around quite a bit out there, those mutants nearly turned you to mush.'");
				System.out.println("'You better make sure that I put everything back the way it was...don't worry, I'll turn away.'");
				System.out.println("[Are you a boy or a girl?]");
				String gender = input.nextLine();
				//p1.gender = gender; deprecated
				switch (gender){ //thanks to Eben for helping me work this
				case "boy":
					p1.gender = "boy";
					break;
				case "girl":
					p1.gender = "girl";
					break;
				default: //default cases are cases that run whenever the other cases can't be satisfied.
					System.out.println("[Fine, you're a boy, then.]");
					p1.gender = "boy";
					break;
				}
				System.out.println("'Well, I guess I got most of it right...the stuff that mattered, anyway.");
				System.out.println("'Okay...let's get you up.'");
				System.out.println("The man's hands grabbed yours and helped pull you out of a bed. He was an older gentleman, wearing overwalls and a handkerchief covering his neck.");
				System.out.println("Your head ached as you stood, and you saw you were in an old house. It looked like it was nice once, owned by a rich family.");
				System.out.println("The man hands you a 10mm pistol, some Stimpaks, ammo, and some food before sending you into the world.");
				p1.inv.addAll(Arrays.asList("10mm Pistol", "5 stimpaks", "100 10mm bullets", "2 bottles of Sunset Sarsaparilla", "5 pieces of Gecko Meat"));
				System.out.println("When you leave the house, you see you're at a beach. There were seagulls squawking and flying above, and to your right was a beach.");
				System.out.println("To your left is an old shack and a housing district.");
				while (gameState == 1){
					String direction = input.nextLine();
					switch (direction){
					case "go right":
						gameState = 2;
						break;
					case "go left":
						gameState = 3;
						break;
					case "whoami":
						System.out.println("You are " + p1.name + ", and you have just begun your adventure.");
						break;
					case "inv":
						System.out.println(p1.inv); //this prints out the contents of the "inv" array
						break;
					default:
						System.out.println("Sorry, I don't understand your input.");
						break;
				}
				
			}
				
				
		}
			if (gameState == 2){

				System.out.println("You decide to venture to the right, towards the beach.");
				System.out.println("At the beach, you are greeted with abandoned cars in a parking lot. The cars are all rusted and were already looted.");
				System.out.println("The sand looked pale on the overcast day, and was cold to the touch. Derelict benches and lifeguard chairs littered the sand.");
				System.out.println("You are startled by the sound of people talking in the distance. Raiders.");
				System.out.println("You lack the abilities for a fight, and your pistol will be inaccurate from this distance.");
				System.out.println("There are some dunes you can hide behind nearby.");

				while (gameState == 2) {
					String hidingspot = input.nextLine();
					switch (hidingspot){
					case "hide":
						gameState = 4;
						break;
					case "fight":
						gameState = 6;
						break;
					case "whoami":
						System.out.println("You are " + p1.name + ", and you're on a local beach, with raiders incoming.");
						break;
					case "inv":
						System.out.println(p1.inv);
						break;
					default:
						System.out.println("Enter some real input. Please.");
						break;
					}
				}
			}
			if (gameState == 3){
				System.out.println("You venture westward towards the shack and houses.");
				System.out.println("There is a flickering light eminating from the shack, likely from a gas lantern.");
				System.out.println("The housing district, however, could be full of things to loot, but also could be a raider camp...or worse.");
				
				while (gameState == 3){
					String direction = input.nextLine();
					switch (direction){
					case "go to shack":
						gameState = 5;
						break;
					case "explore":
						gameState = 7;
						break;
					case "whoami":
						System.out.println("You are " + p1.name + ", and you are heading towards the ruined town.");
						break;
					case "inv":
						System.out.println(p1.inv);
						break;
					default:
						System.out.println("I don't understand your input.");
						break;
				}
				
			}
		}
			if (gameState == 4){
				System.out.println("You scramble to take cover by a nearby dune, just barely peeking over.");
				System.out.println("There were four raiders traveling in this pack, each carrying a rifle or shotgun.");
				System.out.println("Their armor, or what little they had, was made out of metal and discarded road signs. To be fair, no one would need the latter anytime soon.");
				if (p1.gender.equals("boy")){ //code diverges here to give context-sensitive dialogue based on p1.gender
					System.out.println("'Could you believe that guy? He charged those mutants like it was nothin'!' one spoke.");
					System.out.println("'Shut it, Dozer,' another, bigger one growled, 'there's a difference between bravery and stupidity.'");
					System.out.println("'YOU shut it, Tank!' Dozer replied, 'I wish I had half the guts that guy had!");
					System.out.println("'Maybe you can go find them, they're probably splattered all over the ground,' another one quipped.");
				}
				if (p1.gender.equals("girl")){
					System.out.println("'Did you see that dumb broad heading for those mutants?!' one spoke, 'man, she must've had guts!");
					System.out.println("'Maybe you can go pick them up, Dozer,' a bigger one in the group quipped, 'then you could start pulling your own weight around here.'");
				}
				System.out.println("They all laughed and continued on their way, paying you no mind.");
				System.out.println("When they were out of earshot, you snuck around the dunes, heading towards where they came from.");
				System.out.println("You saw a body in the distance, the water gently washing over it. A puddle of red surrounded him.");
				System.out.println("You can check the body, or follow footprints nearby that lead farther down the beach.");
				
				while (gameState == 4){
					String choice = input.nextLine();
					switch (choice){
					case "check the body":
						gameState = 8;
						break;
					case "follow footprints":
						gameState = 10;
						break;
					case "whoami":
						System.out.println("You are " + p1.name + ", and you narrowly avoided a run-in with raiders.");
						break;
					case "inv":
						System.out.println(p1.inv);
						break;
					default:
						System.out.println("I don't understand your input.");
					}
					
				}
				
			}
			if (gameState == 5){
				System.out.println("Inside the shack, there were wooden tables and chairs lining the walls. The tables had various guns and used syringes on them.");
				System.out.println("Inside the syringes were traces of a growing green liquid. Psycho. You knew what it was, and to avoid it.");
				System.out.println("In the corner, you saw a man hunched over, breathing quickly. When he heard you, he spun around. His eyes were bloodshot and he was grinning madly.");
				System.out.println("He pulled out a knife and lunged at you, making quick work with the weapon.");
				p1.playerDeath(); //calls the function that prints a death message
				gameState = 5862;
			}
			if (gameState == 6){
				System.out.println("You ready your gun and jump out, aiming to take them by surprise.");
				System.out.println("Unfortunately, there's four of them and one of you. They also have bigger guns.");
				p1.playerDeath();
				gameState = 5862;
			}
			
			if (gameState == 7){
				System.out.println("You choose to venture past the shack and to the housing district.");
				System.out.println("The first and farthest street had a dock, overlooking a canal. On the far side looked like a shopping district.");
				System.out.println("The one bridge that went in-between looked like it had been exploded some time ago, and the gap is too long for a jump.");
				System.out.println("The streets of houses seemed to stretch on and on, vines and grass overgrowing and covering most of the houses.");
				System.out.println("You find some families living in the houses, as surprising as that was. None of them had any to offer you.");
				System.out.println("However, as time went on, the houses would grow emptier and emptier. Eventually, you came across a fort");
				System.out.println("The fort was lit by torches and was surrounded by walls made up of scrap metal.");
				System.out.println("You didn't hear that many people around inside and could spot a gap in the metal on one side of the wall.");
				System.out.println("You could easily slip through the gap, but with the little amount of people inside, you could probably take them all out if things went bad.");
				
				while (gameState == 7){
					String choice = input.nextLine();
					switch (choice){
					case "sneak":
						gameState = 9;
						break;
					case "go around front":
						gameState = 11;
						break;
					case "inv":
						System.out.println(p1.inv);
						break;
					case "whoami":
						System.out.println("You are " + p1.name + ". You've decided to explore the housing district and have come across a fort.");
						break;
					default:
						System.out.println("I don't understand your input.");
						break;
					}
				}
			}
			if (gameState == 8){
				System.out.println("You opt to move towards the body, examining it.");
				System.out.println("Standing over him, you could see he was covered in blood, but there was no wound for the blood to have come from.");
				System.out.println("The person you were looking over suddenly opens his eyes and grabs you by the shirt.");
				System.out.println("You manage to rip free and stumble away, stopping when you feel the waiting muzzle of a gun against your head.");
				System.out.println("'Not so gutsy after all.'");
				p1.playerDeath();
				gameState = 5862;
			}
			if (gameState == 9){
				System.out.println("You sneak around the side to the small opening, easily squeezing through.");
				System.out.println("Unfortunately, someone was standing right by the opening. Someone with a happy trigger finger.");
				p1.playerDeath();
				gameState = 5862;
			}
			if (gameState == 10){
				System.out.println("You trudge past the body and follow the footprints, which lead you into some thick bushes.");
				System.out.println("A path through them was cleared, leading back to the far side of the housing district.");
				System.out.println("The walk wasn't too bad, the worst things being some geckos trying to gnaw on you.");
				System.out.println("Towards the end of the path, you saw a large fort.");
				System.out.println("The fort was lit by torches and was surrounded by walls made up of scrap metal.");
				System.out.println("You didn't hear that many people around inside and could spot a gap in the metal on one side of the wall.");
				System.out.println("You could easily slip through the gap, but with the little amount of people inside, you could probably take them all out if things went bad.");
				while (gameState == 10){
					String choice = input.nextLine();
					switch (choice){
					case "sneak":
						gameState = 9;
						break;
					case "walk through front":
						gameState = 11;
						break;
					case "inv":
						System.out.println(p1.inv);
						break;
					case "whoami":
						System.out.println("You are " + p1.name + ". You walked past a dead body and have now found a fort.");
						break;
					default:
						System.out.println("I don't understand your input.");
						break;
				}
				
			}
			if (gameState == 11){
				System.out.println("You readied your pistol and pushed open the door, ready for whatever onslaught you may experience.");
				System.out.println("To your surprise, there were quite a few people inside, all wearing red and gold armor, and you had caught their attention.");
				System.out.println("Far back in the fort, there was a throne of sorts, and the man seated on it leaned forward.");
				System.out.println("'You must be the one I've been hearing about...surviving a mutant attack,' he spoke.");
				System.out.println("His voice was calm and smooth, almost a growl. He stood up and walked towards you.");
				System.out.println("'Very few people can accomplish such a feat. You're the kind of person I could use.'");
				System.out.println("'You see...this town, this...place needs a leader. We must bring civilization to this wasteland. God has given us this opportunity to rebuild.'");
				System.out.println("'Quite unfortunately, not everyone has the same vision as we do. Those who wish to oppose us must be...dealt with.'");
				System.out.println("'You may be what we've been waiting for, what God has  brought to us. Will you join our cause?'");
				while (gameState == 11){
					String decision = input.nextLine();
					switch (decision){
					case "join":
						gameState = 12;
						break;
					case "decline":
						gameState = 13;
						break;
					case "whoami":
						System.out.println("You are " + p1.name + ", and you must decide the future of the wasteland.");
						break;
					case "inv":
						System.out.println(p1.inv);
						break;
					default:
						System.out.println("I don't understand your input.");
						break;
					}
				}
			}
			if (gameState == 12){
				System.out.println("The leader nods, a grin spreading across his face.");
				System.out.println("'I knew you'd see things my way...'");
				System.out.println("Your crusade would begin at dawn in the morning. The 'fort' was actually a vault, which housed hundreds more soldiers.");
				System.out.println("They were armed to the teeth with weapons of every kind, and repurposed their scrap metal to build a bridge across the canal, to the rest of the city.");
				System.out.println("Many opposed, and the leader, identifying himself as Zeus, sent you to 'deal with them'.");
				System.out.println("The wasteland soon fell under a harsh rule. Civilization, as unforgiving as it was, had finally come to the wasteland.");
				gameState = 5862;
			}
			if (gameState == 13){
				System.out.println("'No,' you reply, 'the wasteland needs to be free. People fighting over it is how we got here. We can't let it happen again.'");
				System.out.println("The leader frowned. 'How...disappointing. I expected more...'");
				System.out.println("With a flick of his hand, he ordered his men to raise his guns. They were quick, but you were quicker.");
				System.out.println("He was close to you, so it wasn't a hard shot. Red splattered the ground as the leader fell back, a newfound hole in his head.");
				System.out.println("The surrounding men froze, they didn't know what to do. Their leader had just fallen, the image of their cause dead on the ground.");
				System.out.println("This is your chance. You can take over and bring civilization peacefully, or you can leave them to their own devices.");
				while (gameState == 13){
					String choice = input.nextLine();
					switch (choice){
					case "join":
						gameState = 14;
						break;
					case "leave":
						gameState = 15;
						break;
					case "inv":
						System.out.println(p1.inv);
						break;
					case "whoami":
						System.out.println("You are " + p1.name + ". You have just killed the leader of a bad-looking empire.");
						break;
					default:
						System.out.println("It's time to choose.");
						break;
					}
				}
			}
			if (gameState == 14){
				System.out.println("You calmly walk to the throne and sit down, assuming your position as their leader.");
				System.out.println("Under your leadership, this empire would still move to bring civilization, but peacefully and democratically.");
				if (p1.gender.equals("boy")){
					System.out.println("You donned the name 'Ulysses', someone who fought to unite.");
				}
				if (p1.gender.equals("girl")){
					System.out.println("You donned the name 'Athena', for the goddess of wisdom. You were a brilliant strategist, and did not wish to fight without a cause.");
				}
				System.out.println("There were always bad apples, but they would be dealt with fairly. Civilization, as different as it was, had finally come to the wasteland.");
				gameState = 5862;
			}
			if (gameState == 15){
				System.out.println("You turned around and walked out of the fort, leaving the soldiers to handle their own problems.");
				System.out.println("Along the wasteland, word would soon get out that the mysterious empire had fallen, their leader killed by a mysterious wanderer.");
				System.out.println("Without the fear looming over them, anarchy would take to the streets. People would go to make their own rules.");
				System.out.println("A society of sorts would soon begin, with several small gang wars invading the streets. As time went on, these would thin out.");
				System.out.println("Civilization, as uncertain as it was, had finally come to the wasteland.");
				gameState = 5862;
				}
			}
		}
	}
}
//so long, and thanks for all the fish.