
public interface Combat {
	/**
	 * Purpose: Methods purpose is to have player and mob enter a battle.
	 * 
	 * @param Hero and monster object
	 * @return No return
	 */
	public static void battle(Hero player, Monster mob) {
	}

	/**
	 * Purpose: Methods purpose is to figure out who won the round.
	 * 
	 * @param int, int, Hero object, and Monster object
	 * @return No return
	 */
	public static void battleDecider(int pSelection, int mSelection, Hero player, Monster mob) {
	}

	/**
	 * Purpose: Methods purpose is to give player options 1-3 to choose an attack.
	 * 
	 * @param Hero and monster object
	 * @return No return
	 */
	public static void battleOngoing(Hero player, Monster mob) {
	}

	/**
	 * Purpose: Method purpose is to print out damage done by mob to player, and
	 * prints out player's new hit point after taken mob attack points.
	 * 
	 * @param Hero object and Monster object.
	 * @return No return
	 */
	public static void damageTaken(Hero player, Monster mob) {
	}

	/**
	 * Purpose: Method purpose is to print out players attack points to mob's hit
	 * points.
	 * 
	 * @param Hero object and monster object
	 * @return No return
	 */
	public static void damageGiven(Hero player, Monster mob) {
	}

	/**
	 * Purpose:Methods purpose is to print out a death symbol for when player health
	 * is 0 or less.
	 * 
	 * @param Hero object
	 * @return No return
	 */
	public static void isPlayerDead(Hero player) {
	}
}
