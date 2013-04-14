/**
 * Travis D. Seiler
 * MIST 7570, Spring 2013
 * Dr. Dan Everett
 * @author tseiler
 *
 */

package jsportsreg;

import java.util.List;


/**
 * The persistent class for the Divisions database table.
 * 
 */

public class Division{


	private int divisionID;
	private String divisionDescription;
	private String divisionName;

	//bi-directional many-to-one association to Season

	private Season season;

	//bi-directional many-to-one association to Sport
	private Sport sport;

	//bi-directional many-to-one association to Player_Registration
	private List<Player_Registration> playerRegistrations;

	public Division() {
	}

	public int getDivisionID() {
		return this.divisionID;
	}

	public void setDivisionID(int divisionID) {
		this.divisionID = divisionID;
	}

	public String getDivisionDescription() {
		return this.divisionDescription;
	}

	public void setDivisionDescription(String divisionDescription) {
		this.divisionDescription = divisionDescription;
	}

	public String getDivisionName() {
		return this.divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public Season getSeason() {
		return this.season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public Sport getSport() {
		return this.sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

	public List<Player_Registration> getPlayerRegistrations() {
		return this.playerRegistrations;
	}

	public void setPlayerRegistrations(List<Player_Registration> playerRegistrations) {
		this.playerRegistrations = playerRegistrations;
	}

	public Player_Registration addPlayerRegistration(Player_Registration playerRegistration) {
		getPlayerRegistrations().add(playerRegistration);
		playerRegistration.setDivision(this);

		return playerRegistration;
	}

	public Player_Registration removePlayerRegistration(Player_Registration playerRegistration) {
		getPlayerRegistrations().remove(playerRegistration);
		playerRegistration.setDivision(null);

		return playerRegistration;
	}

}