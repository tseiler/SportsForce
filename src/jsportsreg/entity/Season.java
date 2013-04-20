/**
 * Travis D. Seiler
 * MIST 7570, Spring 2013
 * Dr. Dan Everett
 * @author tseiler
 *
 */

package jsportsreg.entity;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * The class Season database table.
 * 
 */

public class Season{

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((seasonEndDate == null) ? 0 : seasonEndDate.hashCode());
		result = prime * result
				+ ((seasonName == null) ? 0 : seasonName.hashCode());
		result = prime * result
				+ ((seasonStartDate == null) ? 0 : seasonStartDate.hashCode());
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
		if (!(obj instanceof Season))
			return false;
		Season other = (Season) obj;
		if (seasonEndDate == null) {
			if (other.seasonEndDate != null)
				return false;
		} else if (!seasonEndDate.equals(other.seasonEndDate))
			return false;
		if (seasonName == null) {
			if (other.seasonName != null)
				return false;
		} else if (!seasonName.equals(other.seasonName))
			return false;
		if (seasonStartDate == null) {
			if (other.seasonStartDate != null)
				return false;
		} else if (!seasonStartDate.equals(other.seasonStartDate))
			return false;
		return true;
	}

	/** Primary key for the Season table in the database, season identifier.
	 * 
	 */
	private int seasonID;

	/** The date the season ends.
	 * 
	 */
	private Date seasonEndDate;

	/** The general name of the season.
	 * 
	 */
	private String seasonName;

	/** The date the season starts.
	 * 
	 */
	private Date seasonStartDate;

	/** A list of all divisions that participate during the season. 
	 * 
	 */
	private List<Division> divisions;

	/** Basic constructor to create empty object.
	 * 
	 */
	public Season() {
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); 
		this.seasonID = -1;
		try{
			this.seasonStartDate = df.parse("1-1-1900");
			this.seasonEndDate = df.parse("1-1-1900");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		this.seasonName = "";
		this.divisions = new ArrayList<Division>();
	}

	/** Constructor that creates a fully populated Season object.
	 * @param seasonID
	 * @param seasonEndDate
	 * @param seasonName
	 * @param seasonStartDate
	 * @param divisions
	 */
	public Season(int seasonID, Date seasonEndDate, String seasonName,
			Date seasonStartDate, List<Division> divisions) {
		this.seasonID = seasonID;
		this.seasonEndDate = seasonEndDate;
		this.seasonName = seasonName;
		this.seasonStartDate = seasonStartDate;
		this.divisions = divisions;
	}

	/** Returns the season ID, this is the primary key of the database table.
	 * @return
	 */
	public int getSeasonID() {
		return this.seasonID;
	}

	/** Sets the season ID.
	 * @param seasonID
	 */
	public void setSeasonID(int seasonID) {
		this.seasonID = seasonID;
	}

	/** Returns the end date of the season.
	 * @return
	 */
	public Date getSeasonEndDate() {
		return this.seasonEndDate;
	}

	/** Sets the end date of the season.
	 * @param seasonEndDate
	 */
	public void setSeasonEndDate(Date seasonEndDate) {
		this.seasonEndDate = seasonEndDate;
	}

	/** Returns the general name of the season.
	 * @return
	 */
	public String getSeasonName() {
		return this.seasonName;
	}

	/** Sets the general name of the season.
	 * @param seasonName
	 */
	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}

	/** Returns the seasons start date.
	 * @return
	 */
	public Date getSeasonStartDate() {
		return this.seasonStartDate;
	}

	/** Sets the seasons start date.
	 * @param seasonStartDate
	 */
	public void setSeasonStartDate(Date seasonStartDate) {
		this.seasonStartDate = seasonStartDate;
	}

	/** Returns the list of divisions participating during the season.
	 * @return
	 */
	public List<Division> getDivisions() {
		return this.divisions;
	}

	/** Sets the list of divisions that participate during the season.
	 * @param divisions
	 */
	public void setDivisions(List<Division> divisions) {
		this.divisions = divisions;
	}

	/** Adds a division to the list participating during the season.
	 * @param division
	 * @return
	 */
	public Division addDivision(Division division) {
		getDivisions().add(division);
		division.setSeason(this);

		return division;
	}

	/** Removes a division to the list participating during the season.
	 * @param division
	 * @return
	 */
	public Division removeDivision(Division division) {
		getDivisions().remove(division);
		division.setSeason(null);

		return division;
	}

}