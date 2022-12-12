//Defenceless IS-A entity
public class Defenceless extends Entity {

	/**
	 * Purpose: defenceless constructor
	 * 
	 * @param String, String
	 * @return none
	 */
	public Defenceless(String Name, String Type) {
		setName(Name);
		setType(Type);
	}

	/**
	 * Purpose: to string method that puts defenceless information into a string
	 * 
	 * @param none
	 * @return String
	 */
	public String toString() {
		return getName() + " the " + getType();
	}

}
