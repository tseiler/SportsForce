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
 * The persistent class for the Sports database table.
 * 
 */

public class Sport{


	private int sportID;

	private String sportDescription;

	private String sportName;

	//bi-directional many-to-one association to Division
	private List<Division> divisions;

	public Sport() {
	}

	public int getSportID() {
		return this.sportID;
	}

	public void setSportID(int sportID) {
		this.sportID = sportID;
	}

	public String getSportDescription() {
		return this.sportDescription;
	}

	public void setSportDescription(String sportDescription) {
		this.sportDescription = sportDescription;
	}

	public String getSportName() {
		return this.sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public List<Division> getDivisions() {
		return this.divisions;
	}

	public void setDivisions(List<Division> divisions) {
		this.divisions = divisions;
	}

	public Division addDivision(Division division) {
		getDivisions().add(division);
		division.setSport(this);

		return division;
	}

	public Division removeDivision(Division division) {
		getDivisions().remove(division);
		division.setSport(null);

		return division;
	}

}