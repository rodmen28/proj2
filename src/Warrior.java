import java.util.Random;

//Warrior IS-A hero
public class Warrior extends Hero {

	static Random rand = new Random(); // random number generator
	static int x = rand.nextInt(2); // selects warrior attack
	static Attack[] attacks = { new Attack("Two-handed sword", 2), new Attack("One-handed sword", 1) }; // stores warriors attacks
																									

	/**
	 * Purpose: warrior constructor
	 * 
	 * @param String
	 * @return none
	 */
	public Warrior(String heroName) {
		super("Warrior", heroName, calcAttackPoints(), calcHitPoints(), attacks[x]);
	}

	/**
	 * Purpose: calculate attack points
	 * 
	 * @param none
	 * @return int
	 */
	public static int calcAttackPoints() {
		return 4;
	}

	/**
	 * Purpose: calculate hit points
	 * 
	 * @param none
	 * @return int
	 */
	public static int calcHitPoints() {
		return 20;
	}

	/**
	 * Purpose: getter method for hero attack name
	 * 
	 * @param none
	 * @return String
	 */
	public String heroAttackName() {
		return attacks[x].getAttackName();
	}

	/**
	 * Purpose: getter method for hero attack power
	 * 
	 * @param none
	 * @return int
	 */
	public int heroAttackPower() {
		return attacks[x].getAttackPower();
	}

}
