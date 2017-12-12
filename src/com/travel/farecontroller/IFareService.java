package com.travel.farecontroller;

public interface IFareService {

	public abstract double calculateTaxiFares(long distance, int waitingTime,
			int numbOfSuiteCases, boolean regularClient, boolean night);

	public abstract double calculateHotelFare(int numberOfNights,
			boolean breakfast, int hotelRank, String discountCode);
	
	public abstract double calculateTravelFare(long distance, int waitingTime, int nubOfSuitCases, int nightNumber, boolean breakfastIncluded, boolean useTaxi,
			boolean regularClient, int hotelRank, String discountCode);

}