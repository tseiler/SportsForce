package jsportsreg;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Season database table.
 * 
 */
@Entity
public class Season implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int seasonID;

	@Temporal(TemporalType.DATE)
	private Date seasonEndDate;

	private String seasonName;

	@Temporal(TemporalType.DATE)
	private Date seasonStartDate;

	//bi-directional many-to-one association to Division
	@OneToMany(mappedBy="season")
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