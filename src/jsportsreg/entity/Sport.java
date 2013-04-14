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
 * The class for Sports database table.
 * 
 */

public class Sport{


	/** The primary key associated with the Sport.
	 * 
	 */
	private int sportID;

	/** The description of the sport.
	 * 
	 */
	private String sportDescription;

	/** The sport name.
	 * 
	 */
	private String sportName;

	/** A list of divisions associated with the sport.
	 * 
	 */
	private List<Division> divisions;

	/** Basic constructor to create an empty sport object.
	 * 
	 */
	public Sport() {
	}

	/** Constructor to create a fully populated sport object.
	 * @param sportID
	 * @param sportDescription
	 * @param sportName
	 * @param divisions
	 */
	public Sport(int sportID, String sportDescription, String sportName,
			List<Division> divisions) {
		this.sportID = sportID;
		this.sportDescription = sportDescription;
		this.sportName = sportName;
		this.divisions = divisions;
	}

	/** Returns the sportID of the sport.  The sportID is the primary key of this entity in the database.
	 * @return
	 */
	public int getSportID() {
		return this.sportID;
	}

	/** Sets the sportID of the sport.
	 * @param sportID
	 */
	public void setSportID(int sportID) {
		this.sportID = sportID;
	}

	/** Returns the description of the sport.
	 * @return
	 */
	public String getSportDescription() {
		return this.sportDescription;
	}

	/** Sets the description of the sport.
	 * @param sportDescription
	 */
	public void setSportDescription(String sportDescription) {
		this.sportDescription = sportDescription;
	}

	/** Returns the sport's name.
	 * @return
	 */
	public String getSportName() {
		return this.sportName;
	}

	/** Sets the sport's name.
	 * @param sportName
	 */
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	/** Returns the list of divisions associated with the sport.
	 * @return
	 */
	public List<Division> getDivisions() {
		return this.divisions;
	}

	/** Sets the list of divisions associated with the sport.
	 * @param divisions
	 */
	public void setDivisions(List<Division> divisions) {
		this.divisions = divisions;
	}

	/**  Adds a division to the list of divisions associated with the sport.
	 * @param division
	 * @return
	 */
	public Division addDivision(Division division) {
		getDivisions().add(division);
		division.setSport(this);

		return division;
	}

	/** Removes a division to the list of divisions associated with the sport.
	 * @param division
	 * @return
	 */
	public Division removeDivision(Division division) {
		getDivisions().remove(division);
		division.setSport(null);

		return division;
	}

}