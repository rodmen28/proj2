//monster IS-A entity
public abstract class Monster extends Entity {

	/**
	 * Purpose: Monster constructor
	 * 
	 * @param String, String, int , int, Attack object
	 * @return none
	 */
	public Monster(String type, String name, int AP, int HP, Attack attack) {
		setType(type);
		setAttackPoints(AP);
		setHitPoints(HP);
		setName(name);
	}

	/**
	 * Purpose: to string method that places monster information into string
	 * 
	 * @param none
	 * @return String
	 */
	public String toString() {
		return getName() + " the " + getType() + "\nMonster Stats: HP: " + getHitPoints() + "  AP: "
				+ getAttackPoints();
	}

	/**
	 * Purpose: default name for monster attack
	 * 
	 * @param none
	 * @return String
	 */
	public String monsterAttackName() {
		return null;
	}

	/**
	 * Purpose: default power for monster attack
	 * 
	 * @param none
	 * @return int
	 */
	public int monsterAttackPower() {
		return 1;
	}

}
