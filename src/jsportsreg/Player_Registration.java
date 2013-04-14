package jsportsreg;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the Player_Registration database table.
 * 
 */
@Entity
public class Player_Registration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int registrationID;

	@Column(name="additional_position")
	private String additionalPosition;

	private BigDecimal balance;

	@Column(name="base_fee")
	private BigDecimal baseFee;

	@Column(name="by_laws_agreement")
	private byte byLawsAgreement;

	@Column(name="catching_experience")
	private byte catchingExperience;

	@Column(name="catching_gear")
	private byte catchingGear;

	@Column(name="code_of_conduct")
	private byte codeOfConduct;

	private BigDecimal discount;

	private BigDecimal donation;

	@Column(name="fundraising_fee")
	private BigDecimal fundraisingFee;

	@Column(name="hat_size")
	private String hatSize;

	@Column(name="jersey_1")
	private BigDecimal jersey1;

	@Column(name="jersey_2")
	private BigDecimal jersey2;

	@Column(name="jersey_size")
	private String jerseySize;

	@Column(name="late_fee")
	private BigDecimal lateFee;

	@Column(name="liability_waiver")
	private byte liabilityWaiver;

	@Column(name="out_of_county_fee")
	private BigDecimal outOfCountyFee;

	@Column(name="pant_size")
	private String pantSize;

	@Column(name="photo_waiver")
	private byte photoWaiver;

	@Column(name="pitching_experience")
	private byte pitchingExperience;

	@Column(name="primary_position")
	private String primaryPosition;

	@Column(name="refund_amount")
	private BigDecimal refundAmount;

	@Column(name="refund_policy")
	private byte refundPolicy;

	@Column(name="seasons_playeed")
	private BigDecimal seasonsPlayeed;

	@Column(name="secondary_position")
	private String secondaryPosition;

	@Column(name="socks_size")
	private String socksSize;

	@Column(name="total_fees")
	private BigDecimal totalFees;

	@Column(name="uniform_camp_fee")
	private BigDecimal uniformCampFee;

	//bi-directional many-to-one association to Division
	@ManyToOne
	@JoinColumn(name="divisionID")
	private Division division;

	//bi-directional many-to-one association to People
	@ManyToOne
	@JoinColumn(name="personID")
	private People people;

	public Player_Registration() {
	}

	public int getRegistrationID() {
		return this.registrationID;
	}

	public void setRegistrationID(int registrationID) {
		this.registrationID = registrationID;
	}

	public String getAdditionalPosition() {
		return this.additionalPosition;
	}

	public void setAdditionalPosition(String additionalPosition) {
		this.additionalPosition = additionalPosition;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getBaseFee() {
		return this.baseFee;
	}

	public void setBaseFee(BigDecimal baseFee) {
		this.baseFee = baseFee;
	}

	public byte getByLawsAgreement() {
		return this.byLawsAgreement;
	}

	public void setByLawsAgreement(byte byLawsAgreement) {
		this.byLawsAgreement = byLawsAgreement;
	}

	public byte getCatchingExperience() {
		return this.catchingExperience;
	}

	public void setCatchingExperience(byte catchingExperience) {
		this.catchingExperience = catchingExperience;
	}

	public byte getCatchingGear() {
		return this.catchingGear;
	}

	public void setCatchingGear(byte catchingGear) {
		this.catchingGear = catchingGear;
	}

	public byte getCodeOfConduct() {
		return this.codeOfConduct;
	}

	public void setCodeOfConduct(byte codeOfConduct) {
		this.codeOfConduct = codeOfConduct;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getDonation() {
		return this.donation;
	}

	public void setDonation(BigDecimal donation) {
		this.donation = donation;
	}

	public BigDecimal getFundraisingFee() {
		return this.fundraisingFee;
	}

	public void setFundraisingFee(BigDecimal fundraisingFee) {
		this.fundraisingFee = fundraisingFee;
	}

	public String getHatSize() {
		return this.hatSize;
	}

	public void setHatSize(String hatSize) {
		this.hatSize = hatSize;
	}

	public BigDecimal getJersey1() {
		return this.jersey1;
	}

	public void setJersey1(BigDecimal jersey1) {
		this.jersey1 = jersey1;
	}

	public BigDecimal getJersey2() {
		return this.jersey2;
	}

	public void setJersey2(BigDecimal jersey2) {
		this.jersey2 = jersey2;
	}

	public String getJerseySize() {
		return this.jerseySize;
	}

	public void setJerseySize(String jerseySize) {
		this.jerseySize = jerseySize;
	}

	public BigDecimal getLateFee() {
		return this.lateFee;
	}

	public void setLateFee(BigDecimal lateFee) {
		this.lateFee = lateFee;
	}

	public byte getLiabilityWaiver() {
		return this.liabilityWaiver;
	}

	public void setLiabilityWaiver(byte liabilityWaiver) {
		this.liabilityWaiver = liabilityWaiver;
	}

	public BigDecimal getOutOfCountyFee() {
		return this.outOfCountyFee;
	}

	public void setOutOfCountyFee(BigDecimal outOfCountyFee) {
		this.outOfCountyFee = outOfCountyFee;
	}

	public String getPantSize() {
		return this.pantSize;
	}

	public void setPantSize(String pantSize) {
		this.pantSize = pantSize;
	}

	public byte getPhotoWaiver() {
		return this.photoWaiver;
	}

	public void setPhotoWaiver(byte photoWaiver) {
		this.photoWaiver = photoWaiver;
	}

	public byte getPitchingExperience() {
		return this.pitchingExperience;
	}

	public void setPitchingExperience(byte pitchingExperience) {
		this.pitchingExperience = pitchingExperience;
	}

	public String getPrimaryPosition() {
		return this.primaryPosition;
	}

	public void setPrimaryPosition(String primaryPosition) {
		this.primaryPosition = primaryPosition;
	}

	public BigDecimal getRefundAmount() {
		return this.refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public byte getRefundPolicy() {
		return this.refundPolicy;
	}

	public void setRefundPolicy(byte refundPolicy) {
		this.refundPolicy = refundPolicy;
	}

	public BigDecimal getSeasonsPlayeed() {
		return this.seasonsPlayeed;
	}

	public void setSeasonsPlayeed(BigDecimal seasonsPlayeed) {
		this.seasonsPlayeed = seasonsPlayeed;
	}

	public String getSecondaryPosition() {
		return this.secondaryPosition;
	}

	public void setSecondaryPosition(String secondaryPosition) {
		this.secondaryPosition = secondaryPosition;
	}

	public String getSocksSize() {
		return this.socksSize;
	}

	public void setSocksSize(String socksSize) {
		this.socksSize = socksSize;
	}

	public BigDecimal getTotalFees() {
		return this.totalFees;
	}

	public void setTotalFees(BigDecimal totalFees) {
		this.totalFees = totalFees;
	}

	public BigDecimal getUniformCampFee() {
		return this.uniformCampFee;
	}

	public void setUniformCampFee(BigDecimal uniformCampFee) {
		this.uniformCampFee = uniformCampFee;
	}

	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public People getPeople() {
		return this.people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

}