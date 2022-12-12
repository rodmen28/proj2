import java.util.Random;

//Dragon IS-A monster
public class Dragon extends Monster {

	static Random rand = new Random(); // random number generator
	static int x = rand.nextInt(2); // selects dragon attack
	static Attack[] attacks = { new Attack("Fire Breathe", 2), new Attack("Claw slash", 1) }; // stores dragon attacks

	/**
	 * Purpose: dragon constructor
	 * 
	 * @param String, int, int
	 * @return none
	 */
	public Dragon(String monsterName, int a, int h) {
		super("Dragon", monsterName, calcAttackPoints(a), calcHitPoints(h), attacks[x]);
	}

	/**
	 * Purpose:calculate attack points
	 * 
	 * @param int
	 * @return int
	 */
	public static int calcAttackPoints(int a) {
		return 2 + a;
	}

	/**
	 * Purpose: calculate hit points
	 * 
	 * @param int
	 * @return int
	 */
	public static int calcHitPoints(int h) {
		return 2 + h;
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
