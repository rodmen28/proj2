
//Monster and Hero objects HAS-A attack
public class Attack extends Entity {

	private int attackPower = 0; // default attack power
	private String attackName = null; // default attack name

	/**
	 * Purpose: attack constructor
	 * 
	 * @param String, int
	 * @return none
	 */
	Attack(String attackName, int attackPower) {
		this.attackPower = attackPower;
		this.attackName = attackName;
	}

	/**
	 * Purpose: setter method for attack name
	 * 
	 * @param String
	 * @return none
	 */
	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}

	/**
	 * Purpose: setter method for attack power
	 * 
	 * @param int
	 * @return none
	 */
	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	/**
	 * Purpose: getter method for attack name
	 * 
	 * @param none
	 * @return String
	 */
	public String getAttackName() {
		return attackName;
	}

	/**
	 * Purpose: getter method for attack power
	 * 
	 * @param none
	 * @return int
	 */
	public int getAttackPower() {
		return attackPower;
	}
}
