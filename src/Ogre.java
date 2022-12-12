import java.util.Random;

//ogre IS-A monster
public class Ogre extends Monster {

	static Random rand = new Random(); // random number generator
	static int x = rand.nextInt(2);// selects ogre attack
	static Attack[] attacks = { new Attack("Head butt", 2), new Attack("Punch", 1) };// stores ogre attacks

	/**
	 * Purpose: ogre constructor
	 * 
	 * @param String, int, int
	 * @return none
	 */
	public Ogre(String monsterName, int a, int h) {
		super("Ogre", monsterName, calcAttackPoints(a), calcHitPoints(h), attacks[x]);
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
	 * @return ont
	 */
	public int monsterAttackPower() {
		return attacks[x].getAttackPower();
	}
}
