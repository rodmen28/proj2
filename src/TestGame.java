import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TestGame extends Entity implements Combat {

	private static Scanner input = new Scanner(System.in); // for player input
	static Hero player = null; // hero object
	static Monster first, second, last; // monster objects for each round
	static Random rand = new Random(); // random number generator

	/**
	 * Purpose: Main method that will run the game
	 * 
	 * @param none
	 * @return none
	 */
	public static void main(String[] args) {
		

		int chara = 0;
		
		String hero;

		System.out.println("█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█\n" + "█░░╦ ╦╔╗╦ ╔╗╔╗╔╦╗╔╗░░█\n" + "█░░║║║╠ ║ ║ ║║║║║╠ ░░█\n"
				+ "█░░╚╩╝╚╝╚╝╚╝╚╝╩ ╩╚╝░░█\n" + "█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█\n" + "....TO THE DUNGEON....");

		do {
			System.out.print("\nSelect your character:\n\n[1]Mage\n[2]Hunter\n[3]Warrior\nSelection: ");
			try {
				chara = Integer.parseInt(input.next());
				if (chara < 1 || chara > 3)
					throw new Exception();
			} catch (Exception e) {
				System.out.println("\nError: Not an acceptable choice");
			}
		} while (chara < 1 || chara > 3);

		System.out.print("\nEnter player name: ");
		input.nextLine();
		String heroName = input.nextLine();

		if (chara == 1) {
			hero = "Mage";
			player = createHero(chara, heroName);
		} else if (chara == 2) {
			hero = "Hunter";
			player = createHero(chara, heroName);
		} else {
			hero = "Warrior";
			player = createHero(chara, heroName);
		}

		Defenceless help = getDefenceless(rand.nextInt(6));

		System.out.print("\n\n*****************************\n" + "Welcome " + heroName + " the " + hero
				+ "\n*****************************\n\n\nThe King has reaches out in need of your help. "
				+ help.toString() + " has been captured. Your mission is to go and save them from the dungeon.\n");
		int mission = 0;
		do {
			System.out.print("Do you accept this mission?\n\nYES[1]\nNO[2]\nSelection: ");
			
			try {
				mission = Integer.parseInt(input.next());
				if (mission < 1 || mission > 2)
					throw new Exception();
			} catch (Exception e) {
				System.out.println("\nError: Not an acceptable choice");
			}
		} while (mission < 1 || mission > 2);

		if (mission == 2) {
			System.out.println("\n\nCoward. Defenceless has been lost. Game over.");
			System.exit(1);
		}

		System.out.println(
				"\n\nThe king will be informed and you will recieve great treasure should you return successfully, Good Luck Hero!\n(press enter/return to continue)\n\n");
		input.nextLine();
		input.nextLine();

		System.out.println("Begining Stats:\n----------------- \nHit Points: " + player.getHitPoints()
				+ "\nAttack Points: " + player.getAttackPoints() + "\nAttack: " + player.heroAttackName() + "(Power: "
				+ player.heroAttackPower() + ")");

		System.out.print("\n\nWarning....you are now entering the dungeon.");
		int afraid = 0;
		do {
			System.out.print(" Are you afraid?\nYes[1]\nNO[2]\nSelection: ");
			try {
				afraid = Integer.parseInt(input.next());
				if (afraid < 1 || afraid > 2)
					throw new Exception();
			} catch (Exception e) {
				System.out.println("\nError: Not an acceptable choice");
			}
		} while (afraid < 1 || afraid > 2);

		if (afraid == 1) {
			System.out.println("\nYou are smart.\n(press enter/return to continue)\n");
			input.nextLine();
			input.nextLine();
		} else if (afraid == 2) {
			System.out.println("\nNo need to act brave.\n(press enter/return to continue)\n");
			input.nextLine();
			input.nextLine();
		}

		System.out.println("Suddenly a monster appears!\n(press enter/return to continue)");
		input.nextLine();

		first = getMonsters(0, rand.nextInt(5));
		System.out.println(first.toString());
		battle(player, first);

		System.out.println("\n\nMonster Defeated!\nThat was easy\nYou're One step closer to saving " + help.toString()
				+ ".\n(press enter/return to continue)");
		input.nextLine();
		input.nextLine();

		System.out.print("\nSecond Monster appears!\n(press enter/return to continue)\n");
		input.nextLine();

		second = getMonsters(1, rand.nextInt(5));
		System.out.println(second.toString());
		battle(player, second);

		System.out.print("\n\nMonster Defeated!\nThat was easy\nOne more monster to save the defenceless.\n\n");
		heal(player);
		input.nextLine();
		input.nextLine();

		System.out.print("Last Monster appears!\n(press enter/return to continue)\n ");
		input.nextLine();

		last = getMonsters(2, rand.nextInt(5));
		System.out.println(last.toString());
		battle(player, last);

		System.out.println(
				"\n\nYou made it. You reached the defenceless and saved them. \n(press enter/return to continue)");
		input.nextLine();
		input.nextLine();

		System.out.println(
				"\n\nThe king congratulates you. As a reward he lets you pick one of the four chests in front of you.\n\nRed Chest[1]\nBlue Chest[2]\nBlack Chest[3]\nWhite Chest[4]\n");
		int chest = 0;
		do {
			System.out.print("\nSelection: ");
			try {
				chest = Integer.parseInt(input.next());
				if (chest < 1 || chest > 5)
					throw new Exception();
			} catch (Exception e) {
				System.out.println("\nError: Not an acceptable choice");
			}
		} while (chest < 1 || chest > 5);

		String score = reward(chest, player);
		saveScoresToFile(heroName, score);

		input.close();

	}

	/**
	 * Purpose: methods purpose is to create the hero
	 * 
	 * @param arguments are an int and a String
	 * @return Hero object
	 */
	public static Hero createHero(int num, String heroName) {
		if (num == 1) {
			Mage player = new Mage(heroName);
			return player;
		} else if (num == 2) {
			Hunter player = new Hunter(heroName);
			return player;
		} else if (num == 3) {
			Warrior player = new Warrior(heroName);
			return player;
		}
		return null;
	}

	/**
	 * Purpose: methods purpose is to increase hero's health
	 * 
	 * @param Hero object
	 * @return no return
	 */
	public static void heal(Hero player) {
		int h = rand.nextInt(4) + 1;
		player.setHitPoints(player.getHitPoints() + h);
		System.out.println("You healed yourself: HP + " + h + "\n(press enter/return to continue)");

	}

	/**
	 * Purpose: methods purpose is to calculate reward earned
	 * 
	 * @param int and Hero object
	 * @return is string
	 */
	public static String reward(int chest, Hero player)

	{
		if (chest == 1) {
			int reward = (player.getHitPoints() * (rand.nextInt(4) + 1));
			System.out.println("SCORE\n------------\nReward $ " + reward + ",000");
			return reward + ",000";
		} else if (chest == 2) {
			int reward = (player.getHitPoints() * (rand.nextInt(7) + 1));
			System.out.println("SCORE\n------------\nReward $ " + reward + ",000");
			return reward + ",000";
		} else if (chest == 3) {
			int reward = (player.getHitPoints() * (rand.nextInt(6) + 1));
			System.out.println("SCORE\n------------\nReward $ " + reward + ",000");
			return reward + "";
		} else {
			int reward = (player.getHitPoints() * (rand.nextInt(4) + 1));
			System.out.println("SCORE\n------------\nReward $ " + reward + ",000");
			return reward + ",000";
		}
	}

	/**
	 * Purpose: Methods purpose is to have player and mob enter a battle.
	 * 
	 * @param Hero and monster object
	 * @return No return
	 */
	public static void battle(Hero player, Monster mob) {
		battleOngoing(player, mob);

		isPlayerDead(player);

	}

	/**
	 * Purpose: Methods purpose is to give player options 1-3 to choose an attack.
	 * 
	 * @param Hero and monster object
	 * @return No return
	 */
	public static void battleOngoing(Hero player, Monster mob) {
		Random rand = new Random();

		while (player.getHitPoints() > 0 && mob.getHitPoints() > 0) {

			System.out.print("\n\nThe gods will decide who attacks.");
			int pSelection = 0;
			do {
				System.out.print("\nEnter a number between 1-3\nSelection: ");

				try {
					pSelection = Integer.parseInt(input.next());
					if (pSelection < 1 || pSelection > 3)
						throw new Exception();
				} catch (Exception e) {
					System.out.println("\nError: Not an acceptable choice");
				}
			} while (pSelection < 1 || pSelection > 3);

			int mSelection = rand.nextInt(3) + 1;

			battleDecider(pSelection, mSelection, player, mob);

			System.out.println(
					"---------------\nPlayer HP: " + player.getHitPoints() + "\nMonster HP: " + mob.getHitPoints());
		}
	}

	/**
	 * Purpose: Methods purpose is to figure out who won the round.
	 * 
	 * @param int, int, Hero object, and Monster object
	 * @return No return
	 */
	public static void battleDecider(int pSelection, int mSelection, Hero player, Monster mob) {
		if (pSelection == mSelection) {
			System.out.println("\n\nGods are in no ones favor");
		} else if (pSelection == 1 && mSelection == 3 || pSelection == 2 && mSelection == 1
				|| pSelection == 3 && mSelection == 2) {
			damageGiven(player, mob);
		}

		else if (mSelection == 1 && pSelection == 3 || mSelection == 2 && pSelection == 1
				|| mSelection == 3 && pSelection == 2) {
			damageTaken(player, mob);

		}

	}

	/**
	 * Purpose: Method purpose is to print out damage done by mob to player, and
	 * prints out player's new hit point after taken mob attack points.
	 * 
	 * @param Hero object and Monster object.
	 * @return No return
	 */
	public static void damageTaken(Hero player, Monster mob) {
		System.out.println("\n\nGods are NOT in your favor\n---------------");
		System.out.println(mob.getName() + " used " + mob.monsterAttackName());
		player.setHitPoints(player.getHitPoints() - (mob.getAttackPoints() + mob.monsterAttackPower()));
		System.out.println("You recieved " + (mob.getAttackPoints() + mob.monsterAttackPower()) + " damage");
	}

	/**
	 * Purpose: Method purpose is to print out players attack points to mob's hit
	 * points.
	 * 
	 * @param Hero object and monster object
	 * @return No return
	 */
	public static void damageGiven(Hero player, Monster mob) {
		System.out.println("\n\nGods are in your favor\n---------------");
		System.out.println("You used " + player.heroAttackName());
		mob.setHitPoints(mob.getHitPoints() - (player.getAttackPoints() + player.heroAttackPower()));
		System.out.println("You caused " + (player.getAttackPoints() + player.heroAttackPower()) + " damage");
	}

	/**
	 * Purpose:Methods purpose is to print out a death symbol for when player health
	 * is 0 or less.
	 * 
	 * @param Hero object
	 * @return No return
	 */
	public static void isPlayerDead(Hero player) {
		if (player.getHitPoints() <= 0) {
			System.out.println("´´´´´´´´´´´´´´´´´´´ ¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶´´´´´´´´´´´´´´´´´´´`\n"
					+ "´´´´´´´´´´´´´´´´´¶¶¶¶¶¶´´´´´´´´´´´´´¶¶¶¶¶¶¶´´´´´´´´´´´´´´´´\n"
					+ "´´´´´´´´´´´´´´¶¶¶¶´´´´´´´´´´´´´´´´´´´´´´´¶¶¶¶´´´´´´´´´´´´´´\n"
					+ "´´´´´´´´´´´´´¶¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´´´´´´´´´´´\n"
					+ "´´´´´´´´´´´´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´´´´´´´´´´\n"
					+ "´´´´´´´´´´´¶¶´´´´´´´´´´´´´´´´´´´´´`´´´´´´´´´´´¶¶´´´´´´´´´´`\n"
					+ "´´´´´´´´´´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´´´´´´´´´\n"
					+ "´´´´´´´´´´¶¶´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´¶¶´´´´´´´´´´\n"
					+ "´´´´´´´´´´¶¶´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´¶´´´´´´´´´´\n"
					+ "´´´´´´´´´´¶¶´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´¶´´´´´´´´´´\n"
					+ "´´´´´´´´´´¶¶´´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´¶¶´´´´´´´´´´\n"
					+ "´´´´´´´´´´¶¶´´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´¶¶´´´´´´´´´´\n"
					+ "´´´´´´´´´´´¶¶´¶¶´´´¶¶¶¶¶¶¶¶´´´´´¶¶¶¶¶¶¶¶´´´¶¶´¶¶´´´´´´´´´´´\n"
					+ "´´´´´´´´´´´´¶¶¶¶´¶¶¶¶¶¶¶¶¶¶´´´´´¶¶¶¶¶¶¶¶¶¶´¶¶¶¶¶´´´´´´´´´´´\n"
					+ "´´´´´´´´´´´´´¶¶¶´¶¶¶¶¶¶¶¶¶¶´´´´´¶¶¶¶¶¶¶¶¶¶´¶¶¶´´´´´´´´´´´´´\n"
					+ "´´´´¶¶¶´´´´´´´¶¶´´¶¶¶¶¶¶¶¶´´´´´´´¶¶¶¶¶¶¶¶¶´´¶¶´´´´´´¶¶¶¶´´´\n"
					+ "´´´¶¶¶¶¶´´´´´¶¶´´´¶¶¶¶¶¶¶´´´¶¶¶´´´¶¶¶¶¶¶¶´´´¶¶´´´´´¶¶¶¶¶¶´´\n"
					+ "´´¶¶´´´¶¶´´´´¶¶´´´´´¶¶¶´´´´¶¶¶¶¶´´´´¶¶¶´´´´´¶¶´´´´¶¶´´´¶¶´´\n"
					+ "´¶¶¶´´´´¶¶¶¶´´¶¶´´´´´´´´´´¶¶¶¶¶¶¶´´´´´´´´´´¶¶´´¶¶¶¶´´´´¶¶¶´\n"
					+ "¶¶´´´´´´´´´¶¶¶¶¶¶¶¶´´´´´´´¶¶¶¶¶¶¶´´´´´´´¶¶¶¶¶¶¶¶¶´´´´´´´´¶¶\n"
					+ "¶¶¶¶¶¶¶¶¶´´´´´¶¶¶¶¶¶¶¶´´´´¶¶¶¶¶¶¶´´´´¶¶¶¶¶¶¶¶´´´´´´¶¶¶¶¶¶¶¶\n"
					+ "´´¶¶¶¶´¶¶¶¶¶´´´´´´¶¶¶¶¶´´´´´´´´´´´´´´¶¶¶´¶¶´´´´´¶¶¶¶¶¶´¶¶¶´\n"
					+ "´´´´´´´´´´¶¶¶¶¶¶´´¶¶¶´´¶¶´´´´´´´´´´´¶¶´´¶¶¶´´¶¶¶¶¶¶´´´´´´´´\n"
					+ "´´´´´´´´´´´´´´¶¶¶¶¶¶´¶¶´¶¶¶¶¶¶¶¶¶¶¶´¶¶´¶¶¶¶¶¶´´´´´´´´´´´´´´\n"
					+ "´´´´´´´´´´´´´´´´´´¶¶´¶¶´¶´¶´¶´¶´¶´¶´¶´¶´¶¶´´´´´´´´´´´´´´´´´\n"
					+ "´´´´´´´´´´´´´´´´¶¶¶¶´´¶´¶´¶´¶´¶´¶´¶´¶´´´¶¶¶¶¶´´´´´´´´´´´´´´\n"
					+ "´´´´´´´´´´´´¶¶¶¶¶´¶¶´´´¶¶¶¶¶¶¶¶¶¶¶¶¶´´´¶¶´¶¶¶¶¶´´´´´´´´´´´´\n"
					+ "´´´´¶¶¶¶¶¶¶¶¶¶´´´´´¶¶´´´´´´´´´´´´´´´´´¶¶´´´´´´¶¶¶¶¶¶¶¶¶´´´´\n"
					+ "´´´¶¶´´´´´´´´´´´¶¶¶¶¶¶¶´´´´´´´´´´´´´¶¶¶¶¶¶¶¶´´´´´´´´´´¶¶´´´\n"
					+ "´´´´¶¶¶´´´´´¶¶¶¶¶´´´´´¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶´´´´´¶¶¶¶¶´´´´´¶¶¶´´´´\n"
					+ "´´´´´´¶¶´´´¶¶¶´´´´´´´´´´´¶¶¶¶¶¶¶¶¶´´´´´´´´´´´¶¶¶´´´¶¶´´´´´´\n"
					+ "´´´´´´¶¶´´¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶´´¶¶´´´´´´\n"
					+ "´´´´´´´¶¶¶¶´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´´¶¶¶¶´´´´´´´");
			System.exit(1);
		}
	}

	/**
	 * Purpose: Methods purpose is to print out those who have won when the game is
	 * done.
	 * 
	 * @param String
	 * @return No return
	 */
	public static void saveScoresToFile(String heroName, String score) {
		PrintWriter outputFileWriter = null;
		try {
			FileWriter myFile = new FileWriter("winnerCircle.txt", true);
			outputFileWriter = new PrintWriter(myFile);
			outputFileWriter.println("Player: " + heroName + " || Score: " + score + "\n");
		} catch (Exception e) {
			System.out.println("An error occured");
		} finally {
			outputFileWriter.close();
		}

		File myFile = new File("winnerCircle.txt");

		Scanner sc = null;
		try {
			sc = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error has Occured");
		}
		System.out.println("\n\nWINNERS CIRCLE\n----------------------\n");
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(line);
		}
		sc.close();

	}

}
