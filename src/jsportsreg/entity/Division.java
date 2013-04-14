/**
 * Travis D. Seiler
 * MIST 7570, Spring 2013
 * Dr. Dan Everett
 * @author tseiler
 *
 */

package jsportsreg.entity;

import java.util.List;


/**
 * The class for the Divisions database table.
 * 
 */

public class Division{


	/** The primary key for the Division class.
	 * 
	 */
	private int divisionID;
	
	/** The description for the Division object.
	 * 
	 */
	private String divisionDescription;
	
	/** The name of the division.
	 * 
	 */
	private String divisionName;

	/** The Season the Division competes during.
	 * 
	 */
	private Season season;

	/** The sport the Division is associated with.
	 * 
	 */
	private Sport sport;

	/** The list of Players participating in the associated division.
	 * 
	 */
	private List<Player_Registration> playerRegistrations;

	/** Constructor to create a basic empty Division object.
	 * 
	 */
	public Division() {
	}

	/** Constructor to create a fully populated Division object.
	 * @param divisionID
	 * @param divisionDescription
	 * @param divisionName
	 * @param season
	 * @param sport
	 * @param playerRegistrations
	 */
	public Division(int divisionID, String divisionDescription,
			String divisionName, Season season, Sport sport,
			List<Player_Registration> playerRegistrations) {
		this.divisionID = divisionID;
		this.divisionDescription = divisionDescription;
		this.divisionName = divisionName;
		this.season = season;
		this.sport = sport;
		this.playerRegistrations = playerRegistrations;
	}


	/** Returns the division identifier, which is the primary key of the division table in the database.
	 * This field is not needed during general use of the class.
	 * @return
	 */
	public int getDivisionID() {
		return this.divisionID;
	}

	/** Sets the division identifier.
	 * @param divisionID
	 */
	public void setDivisionID(int divisionID) {
		this.divisionID = divisionID;
	}

	/** Returns the description of the Division.
	 * @return
	 */
	public String getDivisionDescription() {
		return this.divisionDescription;
	}

	/** Sets the division description.
	 * @param divisionDescription
	 */
	public void setDivisionDescription(String divisionDescription) {
		this.divisionDescription = divisionDescription;
	}

	/** Returns the name of the division.
	 * @return
	 */
	public String getDivisionName() {
		return this.divisionName;
	}

	/** Sets the name of the division.
	 * @param divisionName
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	/** Returns the season associated with the division.
	 * @return
	 */
	public Season getSeason() {
		return this.season;
	}

	/** Sets the season the division competes during.
	 * @param season
	 */
	public void setSeason(Season season) {
		this.season = season;
	}

	/** Returns the sport associated with the division.
	 * @return
	 */
	public Sport getSport() {
		return this.sport;
	}

	/** Sets the sport associated with the division.
	 * @param sport
	 */
	public void setSport(Sport sport) {
		this.sport = sport;
	}

	/** Returns the list of players registered for this division.
	 * @return
	 */
	public List<Player_Registration> getPlayerRegistrations() {
		return this.playerRegistrations;
	}

	/** Sets the list of players registered for this division.
	 * @param playerRegistrations
	 */
	public void setPlayerRegistrations(List<Player_Registration> playerRegistrations) {
		this.playerRegistrations = playerRegistrations;
	}

	/** Adds a player to the list of registered players.
	 * @param playerRegistration
	 * @return
	 */
	public Player_Registration addPlayerRegistration(Player_Registration playerRegistration) {
		getPlayerRegistrations().add(playerRegistration);
		playerRegistration.setDivision(this);

		return playerRegistration;
	}

	/** Removes a player from the list of registered players.
	 * @param playerRegistration
	 * @return
	 */
	public Player_Registration removePlayerRegistration(Player_Registration playerRegistration) {
		getPlayerRegistrations().remove(playerRegistration);
		playerRegistration.setDivision(null);

		return playerRegistration;
	}

}