package com.travel.farecontroller;

import org.springframework.stereotype.Service;

@Service
public class FareService implements IFareService{
	
	public double calculateTaxiFares(Long distance, int waitingTime,
			int numbOfSuiteCases, boolean regularClient, boolean night) {
		double fare = 2;
		if (distance > 1000) {
			fare = fare + 0.25 * (distance - 1000) / 250;
		}
		if (waitingTime > 3) {
			fare = fare + 0.2 * (waitingTime - 3) / 2;
		}
		if (numbOfSuiteCases > 1) {
			fare = fare + numbOfSuiteCases * 2;
		} else {
			fare = fare + 1;
		}
		if (regularClient) {
			if (night) {
				fare = fare + fare * 0.25;
			}
			fare = fare * 0.9;
		}
		return fare;
	}

	/**
	 * This method calculates the hotel fare. It is calculated as follows: 
	 * (1) Minimal fare:50$.This fare covers one night cost in a 1 star hotel
	 * (2) One night: no discount; each additional night: 10% discount.
	 * (3) one star hotel, no additional charge; for each additional star: 20% supplement from the minimal fare.
	 * (4) Client that has a discount code are entitled to a 15% discount (breakfast not included)
	 * (5) Breakfast costs 5$
	 * 
	 * @param numberOfNights: the number of nights booked
	 * @param breakfast: true if the client choose to take a breakfast during his journey
	 * @param hotelRank: 1, 2, 3, 4 or 5 stars hotel
	 * @param discountCode: the discount code that the client have (if any)
	 * @return
	 */
	public double calculateHotelFare(int numberOfNights, boolean breakfast,
			int hotelRank, String discountCode) {

		String code = "12345";
		double fare = 50;

		if (numberOfNights != 0) {
			fare = fare + fare * (numberOfNights-1)*0.8;
		}

		fare = fare + hotelRank * fare * 20 / 100;

		if (breakfast) {
			fare = fare + numberOfNights * 5;
		}

		if (code.equals(discountCode)) {
			fare = fare * 15 / 100;
		}
		return fare;
	}

	@Override
	public double calculateTaxiFares(long distance, int waitingTime, int numbOfSuiteCases, boolean regularClient,
			boolean night) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public double calculateTravelFare(long distance, int waitingTime, int nubOfSuitCases, int nightNumber, boolean breakfastIncluded, boolean useTaxi,
			boolean regularClient, int hotelRank, String discountCode) {
		double fare = 0;

		if (useTaxi) {
			fare = calculateTaxiFares(distance, waitingTime, nubOfSuitCases, regularClient, false);
		}
		double hotelPrice = calculateHotelFare(nightNumber, true,
				hotelRank, discountCode);

		fare = fare + hotelPrice;

		return fare;
	}
}