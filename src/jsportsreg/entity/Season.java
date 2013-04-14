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


/**
 * The class Season database table.
 * 
 */

public class Season{
	
	/** Primary key for the Season table in the database, season identifier.
	 * 
	 */
	private int seasonID;

	/** the 
	 * 
	 */
	private Date seasonEndDate;

	private String seasonName;
	
	private Date seasonStartDate;

	//bi-directional many-to-one association to Division
	private List<Division> divisions;

	public Season() {
	}

	public int getSeasonID() {
		return this.seasonID;
	}

	public void setSeasonID(int seasonID) {
		this.seasonID = seasonID;
	}

	public Date getSeasonEndDate() {
		return this.seasonEndDate;
	}

	public void setSeasonEndDate(Date seasonEndDate) {
		this.seasonEndDate = seasonEndDate;
	}

	public String getSeasonName() {
		return this.seasonName;
	}

	public void setSeasonName(String seasonName) {
		this.seasonName = seasonName;
	}

	public Date getSeasonStartDate() {
		return this.seasonStartDate;
	}

	public void setSeasonStartDate(Date seasonStartDate) {
		this.seasonStartDate = seasonStartDate;
	}

	public List<Division> getDivisions() {
		return this.divisions;
	}

	public void setDivisions(List<Division> divisions) {
		this.divisions = divisions;
	}

	public Division addDivision(Division division) {
		getDivisions().add(division);
		division.setSeason(this);

		return division;
	}

	public Division removeDivision(Division division) {
		getDivisions().remove(division);
		division.setSeason(null);

		return division;
	}

}