package jsportsreg.entity;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class Player_RegistrationTest {

	@Test
	public void testPlayer_Registration() {
		
		Player_Registration instance0 = new Player_Registration();
		
		assertEquals("Player_Registration Test 1: additionalPosition", "", instance0.getAdditionalPosition() );
		assertEquals("Player_Registration Test 1: balance", 0.00, instance0.getBalance(), 2);
		assertEquals("Player_Registration Test 1: baseFee", 0.00, instance0.getBaseFee(), 0.001 );
		assertEquals("Player_Registration Test 1: byLawsAgreement", false, instance0.getByLawsAgreement() );
		assertEquals("Player_Registration Test 1: catchingExperience", false, instance0.getCatchingExperience() );
		assertEquals("Player_Registration Test 1: catchingGear", false, instance0.getCatchingGear());
		assertEquals("Player_Registration Test 1: codeOfConduct", false, instance0.getCodeOfConduct() );
		assertEquals("Player_Registration Test 1: discount", 0.00, instance0.getDiscount(), 0.001 );
		// Don't test the division creation, separate tests for Division class.
		assertEquals("Player_Registration Test 1: donation", 0.00, instance0.getDonation(), 0.001 );
		assertEquals("Player_Registration Test 1: fundraisingFee", 0.00, instance0.getFundraisingFee(), 0.001 );
		assertEquals("Player_Registration Test 1: hatSize", "", instance0.getHatSize() );
		assertEquals("Player_Registration Test 1: jersey1", -1, instance0.getJersey1() );
		assertEquals("Player_Registration Test 1: jersey2", -1, instance0.getJersey2() );
		assertEquals("Player_Registration Test 1: jerseySize", "", instance0.getJerseySize() );
		assertEquals("Player_Registration Test 1: lateFee", 0.00, instance0.getLateFee(), 0.001 );
		assertEquals("Player_Registration Test 1: liabilityWaiver", false, instance0.getLiabilityWaiver() );
		assertEquals("Player_Registration Test 1: outOfCountyFee", 0.00, instance0.getOutOfCountyFee(), 0.001 );
		assertEquals("Player_Registration Test 1: pantSize", "", instance0.getPantSize() );
		// Don't test the person creation, as there will be a separate test for the person.
		assertEquals("Player_Registration Test 1: photoWaiver", false, instance0.getPhotoWaiver() );
		assertEquals("Player_Registration Test 1: pitchingExperience", false, instance0.getPitchingExperience() );
		assertEquals("Player_Registration Test 1: primaryPosition", "", instance0.getPrimaryPosition() );
		assertEquals("Player_Registration Test 1: refundAmount", 0.00, instance0.getRefundAmount(), 0.001 );
		assertEquals("Player_Registration Test 1: refundPolicy", false, instance0.getRefundPolicy() );
		assertEquals("Player_Registration Test 1: registrationID", -1, instance0.getRegistrationID() );
		assertEquals("Player_Registration Test 1: seasonsPlayed", -1, instance0.getSeasonsPlayed() );
		assertEquals("Player_Registration Test 1: secondaryPosition", "", instance0.getSecondaryPosition() );
		assertEquals("Player_Registration Test 1: socksSize", "", instance0.getSocksSize() );
		assertEquals("Player_Registration Test 1: totalFees", 0.00, instance0.getTotalFees(), 0.001 );
		assertEquals("Player_Registration Test 1: uniformCampFee", 0.00, instance0.getUniformCampFee(), 0.001 );
		
		Person person0 = new Person();
		Division division0 = new Division();
		
		Player_Registration instance1 = new Player_Registration(200, "3B",
				200.00, 100.00, true,
				false, false,
				true, 10.00, 15.00,
				20.00, "Youth Small", 22,
				21, "Youth Small", 5.00,
				true, 0.00, "Youth Medium",
				true, true, "P",
				0.00, true,
				2, "SS",
				"Youth Medium", 250.00, 75.00,
				 division0, person0 );
		
		assertEquals("Player_Registration Test 1: additionalPosition", "3B", instance1.getAdditionalPosition() );
		assertEquals("Player_Registration Test 1: balance", 200.00, instance1.getBalance(), 2);
		assertEquals("Player_Registration Test 1: baseFee", 100.00, instance1.getBaseFee(), 0.001 );
		assertEquals("Player_Registration Test 1: byLawsAgreement", true, instance1.getByLawsAgreement() );
		assertEquals("Player_Registration Test 1: catchingExperience", false, instance1.getCatchingExperience() );
		assertEquals("Player_Registration Test 1: catchingGear", false, instance1.getCatchingGear());
		assertEquals("Player_Registration Test 1: codeOfConduct", true, instance1.getCodeOfConduct() );
		assertEquals("Player_Registration Test 1: discount", 10.00, instance1.getDiscount(), 0.001 );
		assertEquals("Player_Registration Test 1: donation", 15.00, instance1.getDonation(), 0.001 );
		assertEquals("Player_Registration Test 1: division", division0, instance1.getDivision() );
		assertEquals("Player_Registration Test 1: fundraisingFee", 20.00, instance1.getFundraisingFee(), 0.001 );
		assertEquals("Player_Registration Test 1: hatSize", "Youth Small", instance1.getHatSize() );
		assertEquals("Player_Registration Test 1: jersey1", 22, instance1.getJersey1() );
		assertEquals("Player_Registration Test 1: jersey2", 21, instance1.getJersey2() );
		assertEquals("Player_Registration Test 1: jerseySize", "Youth Small", instance1.getJerseySize() );
		assertEquals("Player_Registration Test 1: lateFee", 5.00, instance1.getLateFee(), 0.001 );
		assertEquals("Player_Registration Test 1: liabilityWaiver", true, instance1.getLiabilityWaiver() );
		assertEquals("Player_Registration Test 1: outOfCountyFee", 0.00, instance1.getOutOfCountyFee(), 0.001 );
		assertEquals("Player_Registration Test 1: pantSize", "Youth Medium", instance1.getPantSize() );
		assertEquals("Player_Registration Test 1: person", person0, instance1.getPerson() );
		assertEquals("Player_Registration Test 1: photoWaiver", true, instance1.getPhotoWaiver() );
		assertEquals("Player_Registration Test 1: pitchingExperience", true, instance1.getPitchingExperience() );
		assertEquals("Player_Registration Test 1: primaryPosition", "P", instance1.getPrimaryPosition() );
		assertEquals("Player_Registration Test 1: refundAmount", 0.00, instance1.getRefundAmount(), 0.001 );
		assertEquals("Player_Registration Test 1: refundPolicy", true, instance1.getRefundPolicy() );
		assertEquals("Player_Registration Test 1: registrationID", 200, instance1.getRegistrationID() );
		assertEquals("Player_Registration Test 1: seasonsPlayed", 2, instance1.getSeasonsPlayed() );
		assertEquals("Player_Registration Test 1: secondaryPosition", "SS", instance1.getSecondaryPosition() );
		assertEquals("Player_Registration Test 1: socksSize", "Youth Medium", instance1.getSocksSize() );
		assertEquals("Player_Registration Test 1: totalFees", 250.00, instance1.getTotalFees(), 0.001 );
		assertEquals("Player_Registration Test 1: uniformCampFee", 75.00, instance1.getUniformCampFee(), 0.001 );
		
		instance0.setRegistrationID(300);
		instance0.setAdditionalPosition("LF");
		instance0.setBalance(500.00);
		instance0.setBaseFee(200.00);
		instance0.setByLawsAgreement(false);
		instance0.setCatchingExperience(true);
		instance0.setCatchingGear(true);
		instance0.setCodeOfConduct(true);
		instance0.setDiscount(15.00);
		instance0.setDivision(division0);
		instance0.setDonation(55.00);
		instance0.setFundraisingFee(35.00);
		instance0.setHatSize("Youth Large");
		instance0.setJersey1(15);
		instance0.setJersey2(12);
		instance0.setJerseySize("Youth Large");
		instance0.setLateFee(2.00);
		instance0.setLiabilityWaiver(true);
		instance0.setOutOfCountyFee(20.00);
		instance0.setPantSize("Youth Large");
		Person person1 = new Person();
		instance0.setPerson(person1);
		instance0.setPhotoWaiver(true);
		instance0.setPitchingExperience(true);
		instance0.setPrimaryPosition("P");
		instance0.setRefundAmount(0.00);
		instance0.setRefundPolicy(true);
		instance0.setSeasonsPlayed(3);
		instance0.setSecondaryPosition("CF");
		instance0.setSocksSize("Youth Large");
		instance0.setTotalFees(325.00);
		instance0.setUniformCampFee(25.50);
		
		assertEquals("Player_Registration Test 3: additionalPosition", "LF", instance0.getAdditionalPosition() );
		assertEquals("Player_Registration Test 3: balance", 500.00, instance0.getBalance(), 2);
		assertEquals("Player_Registration Test 3: baseFee", 200.00, instance0.getBaseFee(), 0.001 );
		assertEquals("Player_Registration Test 3: byLawsAgreement", false, instance0.getByLawsAgreement() );
		assertEquals("Player_Registration Test 3: catchingExperience", true, instance0.getCatchingExperience() );
		assertEquals("Player_Registration Test 3: catchingGear", true, instance0.getCatchingGear());
		assertEquals("Player_Registration Test 3: codeOfConduct", true, instance0.getCodeOfConduct() );
		assertEquals("Player_Registration Test 3: discount", 15.00, instance0.getDiscount(), 0.001 );
		assertEquals("Player_Registration Test 3: donation", 55.00, instance0.getDonation(), 0.001 );
		assertEquals("Player_Registration Test 3: division", division0, instance0.getDivision() );
		assertEquals("Player_Registration Test 3: fundraisingFee", 35.00, instance0.getFundraisingFee(), 0.001 );
		assertEquals("Player_Registration Test 3: hatSize", "Youth Large", instance0.getHatSize() );
		assertEquals("Player_Registration Test 3: jersey1", 15, instance0.getJersey1() );
		assertEquals("Player_Registration Test 3: jersey2", 12, instance0.getJersey2() );
		assertEquals("Player_Registration Test 3: jerseySize", "Youth Large", instance0.getJerseySize() );
		assertEquals("Player_Registration Test 3: lateFee", 2.00, instance0.getLateFee(), 0.001 );
		assertEquals("Player_Registration Test 3: liabilityWaiver", true, instance0.getLiabilityWaiver() );
		assertEquals("Player_Registration Test 3: outOfCountyFee", 20.00, instance0.getOutOfCountyFee(), 0.001 );
		assertEquals("Player_Registration Test 3: pantSize", "Youth Large", instance0.getPantSize() );
		assertEquals("Player_Registration Test 3: person", person1, instance0.getPerson() );
		assertEquals("Player_Registration Test 3: photoWaiver", true, instance0.getPhotoWaiver() );
		assertEquals("Player_Registration Test 3: pitchingExperience", true, instance0.getPitchingExperience() );
		assertEquals("Player_Registration Test 3: primaryPosition", "P", instance0.getPrimaryPosition() );
		assertEquals("Player_Registration Test 3: refundAmount", 0.00, instance0.getRefundAmount(), 0.001 );
		assertEquals("Player_Registration Test 3: refundPolicy", true, instance0.getRefundPolicy() );
		assertEquals("Player_Registration Test 3: registrationID", 300, instance0.getRegistrationID() );
		assertEquals("Player_Registration Test 3: seasonsPlayed", 3, instance0.getSeasonsPlayed() );
		assertEquals("Player_Registration Test 3: secondaryPosition", "CF", instance0.getSecondaryPosition() );
		assertEquals("Player_Registration Test 3: socksSize", "Youth Large", instance0.getSocksSize() );
		assertEquals("Player_Registration Test 3: totalFees", 325.00, instance0.getTotalFees(), 0.001 );
		assertEquals("Player_Registration Test 3: uniformCampFee", 25.50, instance0.getUniformCampFee(), 0.001 );
		
	}

}
