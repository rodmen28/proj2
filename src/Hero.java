//Hero IS-A entity
public abstract class Hero extends Entity {

	private String attack; // hero HAS-A attack

	/**
	 * Purpose: hero constructor
	 * 
	 * @param String, String, int, int, Attack object
	 * @return
	 */
	public Hero(String type, String name, int AP, int HP, Attack attack) {
		setType(type);
		setAttackPoints(AP);
		setHitPoints(HP);
		setName(name);

	}

	/**
	 * Purpose: setter method for attack
	 * 
	 * @param String
	 * @return none
	 */
	public void setAttack(String attack) {
		this.attack = attack;
	}

	/**
	 * Purpose: getter method for attack
	 * 
	 * @param none
	 * @return String
	 */
	public String getAttack() {
		return attack;
	}

	/**
	 * Purpose: default name for hero attack
	 * 
	 * @param none
	 * @return String
	 */
	public String heroAttackName() {
		return null;
	}

	/**
	 * Purpose: default power for hero attack
	 * 
	 * @param none
	 * @return int
	 */
	public int heroAttackPower() {
		return 1;
	}

}
