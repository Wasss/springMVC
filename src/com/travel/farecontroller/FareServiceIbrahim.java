package com.travel.farecontroller;

public class FareServiceIbrahim implements IFareService{

	@Override
	public double calculateTaxiFares(long distance, int waiting, int suitcase, boolean previousclient, boolean night) {
		double answer=0.0;
		if (distance<=0 || waiting <0 ||suitcase<0) {
			return -1;
		}
		
		else {
			answer+=2;
			if (distance>=1000) {
				int remainingdistance=(int) ((distance-1000)/250);
				System.out.println(remainingdistance);
				answer+=0.25*remainingdistance;
				
			}
			if (waiting>3) {
				int remainingwaiting=(waiting-3)/2;
				answer+=remainingwaiting*0.2;
				
			}
			if (suitcase>1) {
				answer+=suitcase-1;
			}
			if (!night&&previousclient) {
				answer=answer*0.1;
			}
			else if (night &&!previousclient) {
				answer=answer*1.25;
			}
		}
		return answer;
	}

	@Override
	public double calculateHotelFare(int numberOfNights, boolean breakfast, int hotelRank, String discountCode) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateTravelFare(long distance, int waitingTime, int nubOfSuitCases, int nightNumber,
			boolean breakfastIncluded, boolean useTaxi, boolean regularClient, int hotelRank, String discountCode) {
		// TODO Auto-generated method stub
		return 0;
	}

}
