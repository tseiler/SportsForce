/**
 * Travis D. Seiler
 * MIST 7570, Spring 2013
 * Dr. Dan Everett
 * @author tseiler
 *
 */

package jsportsreg;

import java.math.BigDecimal;


/**
 * The persistent class for the Player_Registration database table.
 * 
 */

public class Player_Registration{

	private int registrationID;

	private String additionalPosition;

	private BigDecimal balance;

	private BigDecimal baseFee;

	private byte byLawsAgreement;

	private byte catchingExperience;

	private byte catchingGear;

	private byte codeOfConduct;

	private BigDecimal discount;

	private BigDecimal donation;

	private BigDecimal fundraisingFee;

	private String hatSize;

	private BigDecimal jersey1;

	private BigDecimal jersey2;

	private String jerseySize;

	private BigDecimal lateFee;

	private byte liabilityWaiver;

	private BigDecimal outOfCountyFee;

	private String pantSize;

	private byte photoWaiver;

	private byte pitchingExperience;

	private String primaryPosition;

	private BigDecimal refundAmount;

	private byte refundPolicy;

	private BigDecimal seasonsPlayeed;

	private String secondaryPosition;

	private String socksSize;

	private BigDecimal totalFees;

	private BigDecimal uniformCampFee;

	//bi-directional many-to-one association to Division

	private Division division;

	//bi-directional many-to-one association to People
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