import java.util.Random;

//Mage IS-A hero
public class Mage extends Hero {

	static Random rand = new Random(); // random number generator
	static int x = rand.nextInt(2); // selects mage attacks
	static Attack[] attacks = { new Attack("Explosion spell", 2), new Attack("Fire spell", 1) }; // stores mage attacks

	/**
	 * Purpose: mage constructor
	 * 
	 * @param String
	 * @return none
	 */
	public Mage(String heroName) {
		super("Mage", heroName, calcAttackPoints(), calcHitPoints(), attacks[x]);
	}

	/**
	 * Purpose: calculate attack Points
	 * 
	 * @param none
	 * @return int
	 */
	public static int calcAttackPoints() {
		return 2;
	}

	/**
	 * Purpose: calculate hit points
	 * 
	 * @param none
	 * @return int
	 */
	public static int calcHitPoints() {
		return 30;
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
