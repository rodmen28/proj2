import java.util.Random;

//Hunter IS-A hero
public class Hunter extends Hero {

	static Random rand = new Random(); // random number generator
	static int x = rand.nextInt(2); // selects hunters attack
	static Attack[] attacks = { new Attack("Rain of arrows", 2), new Attack("Bow and Arrow", 1) }; // stores hunters attacks
																					

	/**
	 * Purpose: Hunter constructor
	 * 
	 * @param String
	 * @return none
	 */
	public Hunter(String heroName) {
		super("Hunter", heroName, calcAttackPoints(), calcHitPoints(), attacks[x]);
	}

	/**
	 * Purpose: calculate attack points
	 * 
	 * @param none
	 * @return int
	 */
	public static int calcAttackPoints() {
		return 3;
	}

	/**
	 * Purpose: calculate hit points
	 * 
	 * @param none
	 * @return int
	 */
	public static int calcHitPoints() {
		return 25;
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
