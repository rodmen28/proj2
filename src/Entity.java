
public class Entity {

	private String type, name; // Entity HAS-A type/name
	private int attackPoints, hitPoints; // Entity HAS attack points and hit points

	/**
	 * Purpose: setter method for type
	 * 
	 * @param String
	 * @return none
	 */

	public void setType(String inType) {
		type = inType;
	}

	/**
	 * Purpose: setter method for name
	 * 
	 * @param String
	 * @return none
	 */
	public void setName(String inName) {
		name = inName;
	}

	/**
	 * Purpose: Setter method for attack points
	 * 
	 * @param int
	 * @return none
	 */
	public void setAttackPoints(int inStrength) {
		attackPoints = inStrength;
	}

	/**
	 * Purpose: setter method for hit points
	 * 
	 * @param int
	 * @return none
	 */
	public void setHitPoints(int inHitPoints) {
		hitPoints = inHitPoints;
	}

	/**
	 * Purpose: getter method for name
	 * 
	 * @param none
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Purpose: getter method for type
	 * 
	 * @param none
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Purpose: getter method for attack points
	 * 
	 * @param none
	 * @return int
	 */
	public int getAttackPoints() {
		return attackPoints;
	}

	/**
	 * Purpose: getter method for hit points
	 * 
	 * @param none
	 * @return int
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * Purpose: method that will retrieve a monster object from an array of monsters
	 * 
	 * @param int, int
	 * @return Monster object
	 */
	public static Monster getMonsters(int x, int y) {
		Monster[][] monsterJail = {
				{ new Dragon("Mushu", 1, 1), new Goblin("Garbo", 1, 1), new Ogre("Shrek", 1, 1),
						new Dragon("Arman", 2, 2), new Goblin("Dobby", 2, 2), new Ogre("Fiona", 2, 2) },
				{ new Dragon("Eragon", 3, 4), new Goblin("Gryh", 3, 4), new Ogre("Bral", 3, 4),
						new Dragon("Avrae", 4, 6), new Goblin("Drarm", 4, 6), new Ogre("Tach", 4, 6) },
				{ new Dragon("Derolth", 5, 8), new Goblin("Ismoka", 5, 8), new Ogre("Vak", 5, 8),
						new Dragon("Galzara", 7, 10), new Goblin("Drux", 7, 10), new Ogre("Zesh", 7, 10) } };

		return monsterJail[x][y];
	}

	/**
	 * Purpose: method that will return a defenseless object from an array of
	 * defenseless
	 * 
	 * @param int
	 * @return Defenseless object
	 */
	public static Defenceless getDefenceless(int i) {
		Defenceless[] captured = { new Defenceless("Cindy", "Student"), new Defenceless("Carl", "Noble"),
				new Defenceless("Ben", "Farmer"), new Defenceless("Greg", "Infant"), new Defenceless("Ruby", "Teacher"),
				new Defenceless("Ann", "Elderly Woman") };
		return captured[i];
	}
}
