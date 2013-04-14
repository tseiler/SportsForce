/**
 * Travis D. Seiler
 * MIST 7570, Spring 2013
 * Dr. Dan Everett
 * @author tseiler
 *
 */

package jsportsreg.entity;

import java.math.BigDecimal;


/**
 * The persistent class for the Player_Registration database table.
 * 
 */

/**
 * @author tseiler
 *
 */
/**
 * @author tseiler
 *
 */
/**
 * @author tseiler
 *
 */
/**
 * @author tseiler
 *
 */
/**
 * @author tseiler
 *
 */
public class Player_Registration{

	
	/**
	 * The primary key of a Player_Registration object.
	 */
	private int registrationID;

	/**
	 * A string denoting an additional position a player would prefer to play.
	 */
	private String additionalPosition;

	/**
	 * The balance owed related to this Player Registration object.
	 */
	private BigDecimal balance;

	/**
	 * The base fee related to this Player Registration.
	 */
	private BigDecimal baseFee;

	/**
	 * Whether the By Laws have been agreed to.
	 */
	private boolean byLawsAgreement;

	/**
	 * A field denoting whether the Person associated with the player registration has catching experience.
	 */
	private boolean catchingExperience;

	/**
	 * A field denoting whether the Person associated with the player registration has access to catching gear.
	 */
	private boolean catchingGear;

	/**
	 * A field denoting whether the code of conduct has been accepted.
	 */
	private boolean codeOfConduct;

	/**
	 * A field specifying a discount associated to the player registration. 
	 */
	private BigDecimal discount;

	/**
	 * A field specifying a donation associated with the player registration. 
	 */
	private BigDecimal donation;

	/**
	 * The fundraising fee associated with the player registration.
	 */
	private BigDecimal fundraisingFee;

	/**
	 * The hat size of the person associated with the player registration.
	 */
	private String hatSize;

	/**
	 * The preferred jersey number associated with the player registration.
	 */
	private BigDecimal jersey1;

	/**
	 * The secondary preferred jersey number associated with the player registration. 
	 */
	private BigDecimal jersey2;

	/**
	 * The Jersey size associated with the player registration. 
	 */
	private String jerseySize;

	/**
	 * A field denoting a late fee associated with the player registration. 
	 */
	private BigDecimal lateFee;

	/**
	 * A field specifying whether the liability waiver has been accepted. 
	 */
	private byte liabilityWaiver;

	/**
	 * A fee related to whether the person associated with the player registration resides outside of the county. 
	 */
	private BigDecimal outOfCountyFee;

	/**
	 * A field specifying the pant size of the person associated with the player registration.
	 */
	private String pantSize;

	/**
	 * A field denoting whether the photo waiver has been accepted. 
	 */
	private byte photoWaiver;

	/**
	 * A field which specifies if the Person associated with the player registration has pitching experience. 
	 */
	private byte pitchingExperience;

	/**
	 * A field which denotes the primary position the player prefers.
	 */
	private String primaryPosition;

	/**
	 * A field specifying the amount of a refund.
	 */
	private BigDecimal refundAmount;

	/**
	 * A field which specifies if the player has accepted the refund policy.
	 */
	private byte refundPolicy;

	/**
	 * A field denoting how many seasons a player has participated. 
	 */
	private BigDecimal seasonsPlayeed;

	/**
	 * A field which specifies the secondary position a player would prefer to play. 
	 */
	private String secondaryPosition;

	/**
	 * A field specifying the sock size of the player.
	 */
	private String socksSize;

	/**
	 * A field specifying the total fees due per the player registration. 
	 */
	private BigDecimal totalFees;

	/**
	 * A field denoting the uniform or camp fees associated with the player registration. 
	 */
	private BigDecimal uniformCampFee;

	/**
	 * A field specifying the division the player registration is tied to. 
	 */
	private Division division;

	
	/**
	 * The person associated with the player registration (The player).  
	 */
	private Person person;

	/**
	 * Constructor to create an empty player registration object.
	 */
	public Player_Registration() {
	}
	
	/**
	 * Constructor which accepts all fields associated with a player registration.
	 * @param registrationID
	 * @param additionalPosition
	 * @param balance
	 * @param baseFee
	 * @param byLawsAgreement
	 * @param catchingExperience
	 * @param catchingGear
	 * @param codeOfConduct
	 * @param discount
	 * @param donation
	 * @param fundraisingFee
	 * @param hatSize
	 * @param jersey1
	 * @param jersey2
	 * @param jerseySize
	 * @param lateFee
	 * @param liabilityWaiver
	 * @param outOfCountyFee
	 * @param pantSize
	 * @param photoWaiver
	 * @param pitchingExperience
	 * @param primaryPosition
	 * @param refundAmount
	 * @param refundPolicy
	 * @param seasonsPlayeed
	 * @param secondaryPosition
	 * @param socksSize
	 * @param totalFees
	 * @param uniformCampFee
	 * @param division
	 * @param person
	 */
	public Player_Registration(int registrationID, String additionalPosition,
			BigDecimal balance, BigDecimal baseFee, boolean byLawsAgreement,
			boolean catchingExperience, boolean catchingGear,
			boolean codeOfConduct, BigDecimal discount, BigDecimal donation,
			BigDecimal fundraisingFee, String hatSize, BigDecimal jersey1,
			BigDecimal jersey2, String jerseySize, BigDecimal lateFee,
			byte liabilityWaiver, BigDecimal outOfCountyFee, String pantSize,
			byte photoWaiver, byte pitchingExperience, String primaryPosition,
			BigDecimal refundAmount, byte refundPolicy,
			BigDecimal seasonsPlayeed, String secondaryPosition,
			String socksSize, BigDecimal totalFees, BigDecimal uniformCampFee,
			Division division, Person person) {
		this.registrationID = registrationID;
		this.additionalPosition = additionalPosition;
		this.balance = balance;
		this.baseFee = baseFee;
		this.byLawsAgreement = byLawsAgreement;
		this.catchingExperience = catchingExperience;
		this.catchingGear = catchingGear;
		this.codeOfConduct = codeOfConduct;
		this.discount = discount;
		this.donation = donation;
		this.fundraisingFee = fundraisingFee;
		this.hatSize = hatSize;
		this.jersey1 = jersey1;
		this.jersey2 = jersey2;
		this.jerseySize = jerseySize;
		this.lateFee = lateFee;
		this.liabilityWaiver = liabilityWaiver;
		this.outOfCountyFee = outOfCountyFee;
		this.pantSize = pantSize;
		this.photoWaiver = photoWaiver;
		this.pitchingExperience = pitchingExperience;
		this.primaryPosition = primaryPosition;
		this.refundAmount = refundAmount;
		this.refundPolicy = refundPolicy;
		this.seasonsPlayeed = seasonsPlayeed;
		this.secondaryPosition = secondaryPosition;
		this.socksSize = socksSize;
		this.totalFees = totalFees;
		this.uniformCampFee = uniformCampFee;
		this.division = division;
		this.person = person;
	}

	/**
	 * Returns the registrationID of the player registration object.
	 * @return registrationID	This is the primary key of the player registration object.
	 */
	public int getRegistrationID() {
		return this.registrationID;
	}

	/**
	 * Sets the registrationID.
	 * @param registrationID
	 */
	public void setRegistrationID(int registrationID) {
		this.registrationID = registrationID;
	}

	/**
	 * Returns the preferred additional position. 
	 * @return additionalPosition	The players preferred additional position.
	 */
	public String getAdditionalPosition() {
		return this.additionalPosition;
	}

	/**
	 * Sets the players preferred additional position.
	 * @param additionalPosition	The players preferred additional position.
	 */
	public void setAdditionalPosition(String additionalPosition) {
		this.additionalPosition = additionalPosition;
	}

	/**
	 * Returns the balance owed due to the player registration.
	 * @return balance		The amount owed.
	 */
	public BigDecimal getBalance() {
		return this.balance;
	}

	/**
	 * Sets the balance owed due to the player registration.
	 * @param balance		The amount owed.
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * Returns the base fees associated to the player registration.
	 * @return baseFee		The base fee amount.
	 */
	public BigDecimal getBaseFee() {
		return this.baseFee;
	}

	/**
	 * Sets the base fees associated with the player registration.
	 * @param baseFee		The base fee amount.
	 */
	public void setBaseFee(BigDecimal baseFee) {
		this.baseFee = baseFee;
	}

	/**
	 * Returns the By Laws Agreement field value.
	 * @return byLawsAgreement	A boolean value denoting whether the by laws agreement as been accepted.
	 */
	public boolean getByLawsAgreement() {
		return this.byLawsAgreement;
	}

	/**
	 * Sets the By Laws Agreement field value.
	 * @param byLawsAgreement
	 */
	public void setByLawsAgreement(boolean byLawsAgreement) {
		this.byLawsAgreement = byLawsAgreement;
	}

	/**
	 * Returns a field associated with whether the player has catching experience.
	 * @return catchingExperience	A boolean value denoting if the player has experience playing catcher.
	 */
	public boolean getCatchingExperience() {
		return this.catchingExperience;
	}

	/**
	 * Sets a field specifying whether the player has experience playing catcher.
	 * @param catchingExperience
	 */
	public void setCatchingExperience(boolean catchingExperience) {
		this.catchingExperience = catchingExperience;
	}

	/**
	 * Returns a value which denotes whether the player has access to catching gear.
	 * @return catchingGear		A boolean field which denotes the players access to personal catching gear.
	 */
	public boolean getCatchingGear() {
		return this.catchingGear;
	}


	/**
	 * Sets the value which specifies whether the player has access to catching gear.
	 * @param catchingGear		A boolean field which denotes the players access to personal catching gear.
	 */
	public void setCatchingGear(boolean catchingGear) {
		this.catchingGear = catchingGear;
	}

	/**
	 * Returns a field denoting the code of conduct has been agreed to.
	 * @return codeOfConduct	A boolean field which specifies that the code of conduct has been agreed to.
	 */
	public boolean getCodeOfConduct() {
		return this.codeOfConduct;
	}

	/**
	 * Sets the code of conduct field.
	 * @param codeOfConduct		A boolean field which specifies that the code of conduct has been agreed to.
	 */
	public void setCodeOfConduct(boolean codeOfConduct) {
		this.codeOfConduct = codeOfConduct;
	}

	/**
	 * Returns the discount associated with the player registration
	 * @return discount			Currency amount associated with the discount of the player registration.
	 */
	public BigDecimal getDiscount() {
		return this.discount;
	}

	/**
	 * Sets the discount amount.
	 * @param discount			Currency amount associated with the discount of the player registration.
	 */
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	/**
	 * Returns the donation amount associated with the player registration. 
	 * @return donation			A currency amount associated with the player registration
	 */
	public BigDecimal getDonation() {
		return this.donation;
	}

	/**
	 * Sets the donation amount
	 * @param donation		A currency amount associated with the player registration
	 */
	public void setDonation(BigDecimal donation) {
		this.donation = donation;
	}

	/**
	 * Returns the Fund Raising Fee
	 * @return fundraisingFee	A currency amount denoting the fundraising fee.
	 */
	public BigDecimal getFundraisingFee() {
		return this.fundraisingFee;
	}

	/**
	 * Sets the Fund Raising Fee.
	 * @param fundraisingFee	A currency amount denoting the fundraising fee.
	 */
	public void setFundraisingFee(BigDecimal fundraisingFee) {
		this.fundraisingFee = fundraisingFee;
	}

	/**
	 * Returns the hat size of the player.
	 * @return hatSize		The hat size of the player.
	 */
	public String getHatSize() {
		return this.hatSize;
	}

	/**
	 * Sets the hat size of the player.
	 * @param hatSize 	The hat size of the player.
	 */
	public void setHatSize(String hatSize) {
		this.hatSize = hatSize;
	}

	/** Returns the players preferred jersey number.
	 * @return
	 */
	public BigDecimal getJersey1() {
		return this.jersey1;
	}

	/** Sets the players preferred jersey number.
	 * @param jersey1
	 */
	public void setJersey1(BigDecimal jersey1) {
		this.jersey1 = jersey1;
	}

	/** Returns the players secondary preferred jersey number.
	 * @return
	 */
	public BigDecimal getJersey2() {
		return this.jersey2;
	}

	/** Sets the players secondary preferred jersey number.
	 * @param jersey2
	 */
	public void setJersey2(BigDecimal jersey2) {
		this.jersey2 = jersey2;
	}

	/** Returns the players jersey size.
	 * @return
	 */
	public String getJerseySize() {
		return this.jerseySize;
	}

	/** Sets the players jersey size.
	 * @param jerseySize  The players jersey size.
	 */
	public void setJerseySize(String jerseySize) {
		this.jerseySize = jerseySize;
	}

	/** Returns the late fee associated with the player registration.
	 * @return
	 */
	public BigDecimal getLateFee() {
		return this.lateFee;
	}

	/** Sets the late fee associated with the player registration.
	 * @param lateFee
	 */
	public void setLateFee(BigDecimal lateFee) {
		this.lateFee = lateFee;
	}

	/** Returns whether the liability waiver has been accepted.
	 * @return
	 */
	public byte getLiabilityWaiver() {
		return this.liabilityWaiver;
	}

	/** Sets whether the liability waiver has been accepted.
	 * @param liabilityWaiver
	 */
	public void setLiabilityWaiver(byte liabilityWaiver) {
		this.liabilityWaiver = liabilityWaiver;
	}

	/** Returns the fee associated with whether the player lives outside the county.
	 * @return
	 */
	public BigDecimal getOutOfCountyFee() {
		return this.outOfCountyFee;
	}

	/** Sets the fee associated with whether the player lives outside the county.
	 * @param outOfCountyFee
	 */
	public void setOutOfCountyFee(BigDecimal outOfCountyFee) {
		this.outOfCountyFee = outOfCountyFee;
	}

	/** Returns the players pant size.
	 * @return
	 */
	public String getPantSize() {
		return this.pantSize;
	}

	/** Sets the players pant size.
	 * @param pantSize
	 */
	public void setPantSize(String pantSize) {
		this.pantSize = pantSize;
	}

	/** Returns whether the photo waiver has been accepted.
	 * @return
	 */
	public byte getPhotoWaiver() {
		return this.photoWaiver;
	}

	/** Sets whether the photo waiver has been accepted
	 * @param photoWaiver
	 */
	public void setPhotoWaiver(byte photoWaiver) {
		this.photoWaiver = photoWaiver;
	}

	/**
	 * Returns whether the player has pitching experience
	 * @return
	 */
	public byte getPitchingExperience() {
		return this.pitchingExperience;
	}

	/** Sets whether the player has pitching experience.
	 * @param pitchingExperience
	 */
	public void setPitchingExperience(byte pitchingExperience) {
		this.pitchingExperience = pitchingExperience;
	}

	/** Returns the players preferred primary position.
	 * @return
	 */
	public String getPrimaryPosition() {
		return this.primaryPosition;
	}

	/** Sets the players primary position.
	 * @param primaryPosition
	 */
	public void setPrimaryPosition(String primaryPosition) {
		this.primaryPosition = primaryPosition;
	}
	
	/** Returns the refund amount.
	 * @return
	 */
	public BigDecimal getRefundAmount() {
		return this.refundAmount;
	}

	/** Sets the refund amount.
	 * @param refundAmount
	 */
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	/** Returns whether the player has accepted the refund policy.
	 * @return
	 */
	public byte getRefundPolicy() {
		return this.refundPolicy;
	}

	/** Sets whether the player has accepted the refund policy.
	 * @param refundPolicy
	 */
	public void setRefundPolicy(byte refundPolicy) {
		this.refundPolicy = refundPolicy;
	}

	/** Returns the number of seasons a player has participated in.
	 * @return
	 */
	public BigDecimal getSeasonsPlayed() {
		return this.seasonsPlayeed;
	}

	/** Sets the number of seasons a players has participated in.
	 * @param seasonsPlayeed
	 */
	public void setSeasonsPlayeed(BigDecimal seasonsPlayeed) {
		this.seasonsPlayeed = seasonsPlayeed;
	}

	/** Returns the secondary position a player prefers.
	 * @return
	 */
	public String getSecondaryPosition() {
		return this.secondaryPosition;
	}

	/** Sets the secondary position a player prefers.
	 * @param secondaryPosition
	 */
	public void setSecondaryPosition(String secondaryPosition) {
		this.secondaryPosition = secondaryPosition;
	}

	/** Returns the sock size of the player
	 * @return
	 */
	public String getSocksSize() {
		return this.socksSize;
	}

	/** Set the sock size of the player.
	 * @param socksSize
	 */
	public void setSocksSize(String socksSize) {
		this.socksSize = socksSize;
	}

	/** Returns the total fees associated with the player registration.
	 * @return
	 */
	public BigDecimal getTotalFees() {
		return this.totalFees;
	}

	/** Sets the total fees associated with the player registration.
	 * @param totalFees
	 */
	public void setTotalFees(BigDecimal totalFees) {
		this.totalFees = totalFees;
	}

	/** Returns the camp and uniform fees.
	 * @return
	 */
	public BigDecimal getUniformCampFee() {
		return this.uniformCampFee;
	}

	/** Sets the fees associated with camp or uniforms.
	 * @param uniformCampFee
	 */
	public void setUniformCampFee(BigDecimal uniformCampFee) {
		this.uniformCampFee = uniformCampFee;
	}

	/** Returns the division associated with the player registration.
	 * @return
	 */
	public Division getDivision() {
		return this.division;
	}

	/** Sets the division associated with the player registration.
	 * @param division
	 */
	public void setDivision(Division division) {
		this.division = division;
	}

	/** Returns the Person associated with this player registration.
	 * @return
	 */
	public Person getPerson() {
		return this.person;
	}

	/** Sets the Person associated with this player registration.
	 * @param people
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

}