/**
 * Travis D. Seiler
 * MIST 7570, Spring 2013
 * Dr. Dan Everett
 * @author tseiler
 *
 */

package jsportsreg.entity;



/**
 * The persistent class for the Player_Registration database table.
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
	private double balance;

	/**
	 * The base fee related to this Player Registration.
	 */
	private double baseFee;

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
	private double discount;

	/**
	 * A field specifying a donation associated with the player registration. 
	 */
	private double donation;

	/**
	 * The fundraising fee associated with the player registration.
	 */
	private double fundraisingFee;

	/**
	 * The hat size of the person associated with the player registration.
	 */
	private String hatSize;

	/**
	 * The preferred jersey number associated with the player registration.
	 */
	private int jersey1;

	/**
	 * The secondary preferred jersey number associated with the player registration. 
	 */
	private int jersey2;

	/**
	 * The Jersey size associated with the player registration. 
	 */
	private String jerseySize;

	/**
	 * A field denoting a late fee associated with the player registration. 
	 */
	private double lateFee;

	/**
	 * A field specifying whether the liability waiver has been accepted. 
	 */
	private boolean liabilityWaiver;

	/**
	 * A fee related to whether the person associated with the player registration resides outside of the county. 
	 */
	private double outOfCountyFee;

	/**
	 * A field specifying the pant size of the person associated with the player registration.
	 */
	private String pantSize;

	/**
	 * A field denoting whether the photo waiver has been accepted. 
	 */
	private boolean photoWaiver;

	/**
	 * A field which specifies if the Person associated with the player registration has pitching experience. 
	 */
	private boolean pitchingExperience;

	/**
	 * A field which denotes the primary position the player prefers.
	 */
	private String primaryPosition;

	/**
	 * A field specifying the amount of a refund.
	 */
	private double refundAmount;

	/**
	 * A field which specifies if the player has accepted the refund policy.
	 */
	private boolean refundPolicy;

	/**
	 * A field denoting how many seasons a player has participated. 
	 */
	private int seasonsPlayed;

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
	private double totalFees;

	/**
	 * A field denoting the uniform or camp fees associated with the player registration. 
	 */
	private double uniformCampFee;

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
		
		this.registrationID = -1;
		this.additionalPosition = "";
		this.balance = 0.00;
		this.baseFee = 0.00;
		this.byLawsAgreement = false;
		this.catchingExperience = false;
		this.catchingGear = false;
		this.codeOfConduct = false;
		this.discount = 0.00;
		this.donation = 0.00;
		this.fundraisingFee = 0.00;
		this.hatSize = "";
		this.jersey1 = -1;
		this.jersey2 = -1;
		this.jerseySize = "";
		this.lateFee = 0.00;
		this.liabilityWaiver = false;
		this.outOfCountyFee = 0.00;
		this.pantSize = "";
		this.photoWaiver = false;
		this.pitchingExperience = false;
		this.primaryPosition = "";
		this.refundAmount = 0.00;
		this.refundPolicy = false;
		this.seasonsPlayed = -1;
		this.secondaryPosition = "";
		this.socksSize = "";
		this.totalFees = 0.00;
		this.uniformCampFee = 0.00;
		this.division = new Division();
		this.person = new Person();
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
	 * @param seasonsPlayed
	 * @param secondaryPosition
	 * @param socksSize
	 * @param totalFees
	 * @param uniformCampFee
	 * @param division
	 * @param person
	 */
	public Player_Registration(int registrationID, String additionalPosition,
			double balance, double baseFee, boolean byLawsAgreement,
			boolean catchingExperience, boolean catchingGear,
			boolean codeOfConduct, double discount, double donation,
			double fundraisingFee, String hatSize, int jersey1,
			int jersey2, String jerseySize, double lateFee,
			boolean liabilityWaiver, double outOfCountyFee, String pantSize,
			boolean photoWaiver, boolean pitchingExperience, String primaryPosition,
			double refundAmount, boolean refundPolicy,
			int seasonsPlayed, String secondaryPosition,
			String socksSize, double totalFees, double uniformCampFee,
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
		this.seasonsPlayed = seasonsPlayed;
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
	public double getBalance() {
		return this.balance;
	}

	/**
	 * Sets the balance owed due to the player registration.
	 * @param balance		The amount owed.
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Returns the base fees associated to the player registration.
	 * @return baseFee		The base fee amount.
	 */
	public double getBaseFee() {
		return this.baseFee;
	}

	/**
	 * Sets the base fees associated with the player registration.
	 * @param baseFee		The base fee amount.
	 */
	public void setBaseFee(double baseFee) {
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
	public double getDiscount() {
		return this.discount;
	}

	/**
	 * Sets the discount amount.
	 * @param discount			Currency amount associated with the discount of the player registration.
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	/**
	 * Returns the donation amount associated with the player registration. 
	 * @return donation			A currency amount associated with the player registration
	 */
	public double getDonation() {
		return this.donation;
	}

	/**
	 * Sets the donation amount
	 * @param donation		A currency amount associated with the player registration
	 */
	public void setDonation(double donation) {
		this.donation = donation;
	}

	/**
	 * Returns the Fund Raising Fee
	 * @return fundraisingFee	A currency amount denoting the fundraising fee.
	 */
	public double getFundraisingFee() {
		return this.fundraisingFee;
	}

	/**
	 * Sets the Fund Raising Fee.
	 * @param fundraisingFee	A currency amount denoting the fundraising fee.
	 */
	public void setFundraisingFee(double fundraisingFee) {
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
	public int getJersey1() {
		return this.jersey1;
	}

	/** Sets the players preferred jersey number.
	 * @param jersey1
	 */
	public void setJersey1(int jersey1) {
		this.jersey1 = jersey1;
	}

	/** Returns the players secondary preferred jersey number.
	 * @return
	 */
	public int getJersey2() {
		return this.jersey2;
	}

	/** Sets the players secondary preferred jersey number.
	 * @param jersey2
	 */
	public void setJersey2(int jersey2) {
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
	public double getLateFee() {
		return this.lateFee;
	}

	/** Sets the late fee associated with the player registration.
	 * @param lateFee
	 */
	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	/** Returns whether the liability waiver has been accepted.
	 * @return
	 */
	public boolean getLiabilityWaiver() {
		return this.liabilityWaiver;
	}

	/** Sets whether the liability waiver has been accepted.
	 * @param liabilityWaiver
	 */
	public void setLiabilityWaiver(boolean liabilityWaiver) {
		this.liabilityWaiver = liabilityWaiver;
	}

	/** Returns the fee associated with whether the player lives outside the county.
	 * @return
	 */
	public double getOutOfCountyFee() {
		return this.outOfCountyFee;
	}

	/** Sets the fee associated with whether the player lives outside the county.
	 * @param outOfCountyFee
	 */
	public void setOutOfCountyFee(double outOfCountyFee) {
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
	public boolean getPhotoWaiver() {
		return this.photoWaiver;
	}

	/** Sets whether the photo waiver has been accepted
	 * @param photoWaiver
	 */
	public void setPhotoWaiver(boolean photoWaiver) {
		this.photoWaiver = photoWaiver;
	}

	/**
	 * Returns whether the player has pitching experience
	 * @return
	 */
	public boolean getPitchingExperience() {
		return this.pitchingExperience;
	}

	/** Sets whether the player has pitching experience.
	 * @param pitchingExperience
	 */
	public void setPitchingExperience(boolean pitchingExperience) {
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
	public double getRefundAmount() {
		return this.refundAmount;
	}

	/** Sets the refund amount.
	 * @param refundAmount
	 */
	public void setRefundAmount(double refundAmount) {
		this.refundAmount = refundAmount;
	}

	/** Returns whether the player has accepted the refund policy.
	 * @return
	 */
	public boolean getRefundPolicy() {
		return this.refundPolicy;
	}

	/** Sets whether the player has accepted the refund policy.
	 * @param refundPolicy
	 */
	public void setRefundPolicy(boolean refundPolicy) {
		this.refundPolicy = refundPolicy;
	}

	/** Returns the number of seasons a player has participated in.
	 * @return
	 */
	public int getSeasonsPlayed() {
		return this.seasonsPlayed;
	}

	/** Sets the number of seasons a players has participated in.
	 * @param seasonsPlayed
	 */
	public void setSeasonsPlayed(int seasonsPlayed) {
		this.seasonsPlayed = seasonsPlayed;
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
	public double getTotalFees() {
		return this.totalFees;
	}

	/** Sets the total fees associated with the player registration.
	 * @param totalFees
	 */
	public void setTotalFees(double totalFees) {
		this.totalFees = totalFees;
	}

	/** Returns the camp and uniform fees.
	 * @return
	 */
	public double getUniformCampFee() {
		return this.uniformCampFee;
	}

	/** Sets the fees associated with camp or uniforms.
	 * @param uniformCampFee
	 */
	public void setUniformCampFee(double uniformCampFee) {
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