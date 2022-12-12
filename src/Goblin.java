import java.util.Random;

//goblin IS-A monster
public class Goblin extends Monster {

	static Random rand = new Random(); // random number generator
	static int x = rand.nextInt(2);// selects goblin attack
	static Attack[] attacks = { new Attack("Bite", 2), new Attack("Scratch", 1) };// stores goblin attacks

	/**
	 * Purpose: goblin constructor
	 * 
	 * @param String, int, int
	 * @return none
	 */
	Goblin(String monsterName, int a, int h) {
		super("Goblin", monsterName, calcAttackPoints(a), calcHitPoints(h), attacks[x]);
	}

	/**
	 * Purpose: calculate attack points
	 * 
	 * @param int
	 * @return int
	 */
	public static int calcAttackPoints(int a) {
		return 1 + a;
	}

	/**
	 * Purpose: calculate hit points
	 * 
	 * @param int
	 * @return int
	 */
	public static int calcHitPoints(int h) {
		return 1 + h;
	}

	/**
	 * Purpose: getter method for monster attack name
	 * 
	 * @param none
	 * @return String
	 */
	public String monsterAttackName() {
		return attacks[x].getAttackName();
	}

	/**
	 * Purpose: getter method for monster attack power
	 * 
	 * @param none
	 * @return int
	 */
	public int monsterAttackPower() {
		return attacks[x].getAttackPower();
	}

}
