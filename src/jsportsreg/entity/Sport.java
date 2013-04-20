/**
 * Travis D. Seiler
 * MIST 7570, Spring 2013
 * Dr. Dan Everett
 * @author tseiler
 *
 */

package jsportsreg.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * The class for Sports database table.
 * 
 */

public class Sport{


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((sportDescription == null) ? 0 : sportDescription.hashCode());
		result = prime * result + sportID;
		result = prime * result
				+ ((sportName == null) ? 0 : sportName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Sport))
			return false;
		Sport other = (Sport) obj;
		if (sportDescription == null) {
			if (other.sportDescription != null)
				return false;
		} else if (!sportDescription.equals(other.sportDescription))
			return false;
		if (sportID != other.sportID)
			return false;
		if (sportName == null) {
			if (other.sportName != null)
				return false;
		} else if (!sportName.equals(other.sportName))
			return false;
		return true;
	}

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
		this.sportID = -1;
		this.sportName = "";
		this.sportDescription = "";
		this.divisions = new ArrayList<Division>();
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
	 * @return divisions		List of divisions associated with the sport.
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
	 * @return division
	 */
	public Division addDivision(Division division) {
		getDivisions().add(division);
		division.setSport(this);

		return division;
	}

	/** Removes a division to the list of divisions associated with the sport.
	 * @param division
	 * @return division
	 */
	public Division removeDivision(Division division) {
		getDivisions().remove(division);
		division.setSport(null);

		return division;
	}

}