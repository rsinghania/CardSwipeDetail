package com.sapient.mscs;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MSCSSystem {
	private static final double MINIMUM_BALANCE_LIMIT = 5.5;
	private int swipedInCount = 0;
	private int swipedOutCount = 0;
	private Map<Long,List<TravelReport>> travelReport = new HashMap<Long, List<TravelReport>>();
	
	/**
	 * This method is being used to swipeIn card at MSCS Systems available at any Metro Station
	 * @param mscsCard
	 * @param swipeInStationId
	 */
	public void swipeIn(MSCSCard mscsCard, int swipeInStationId) {
		if(mscsCard.getAvailabaleBalance() >= MINIMUM_BALANCE_LIMIT) {
			mscsCard.setSwipeInStationId(swipeInStationId);
			mscsCard.setAllowedSwipeInAccess(true);
			swipedInCount++;
			System.out.println("Successfully Swiped In with Card Number "+ mscsCard.getCardNumber() +" Your available Balance is "+ mscsCard.getAvailabaleBalance());
		} else {
			System.out.println("You do not have sufficient Balance to travel, You available balance is "+ mscsCard.getAvailabaleBalance());
		}
	}
	/**
	 * This method is being used to swipeOut card at MSCS Systems available at any Metro Station
	 * @param mscsCard
	 * @param currentStationId
	 */
	public void swipeOut(MSCSCard mscsCard,int currentStationId) {
		double fare = calculateFare(mscsCard.getSwipeInStationId(), currentStationId);
		mscsCard.setRecentTripFare(fare);
		System.out.println("Total fare :" + fare);
		if(mscsCard.getAvailabaleBalance() >=fare) {
			mscsCard.setAvailabaleBalance(mscsCard.getAvailabaleBalance() - fare);
			mscsCard.setAllowedSwipeOutAccess(true);
			mscsCard.setSwipeOutStationId(currentStationId);
			System.out.println("Successfull Swiped Out with available Balance: " + mscsCard.getAvailabaleBalance());
			swipedOutCount++;
			auditTravel(mscsCard);
			
		}else {
			System.out.println("You don't have sufficient Balance to Exit. Please contact the Metro Customer Care ");
		}
	}
	/**
	 * This method is being used to calculate TotalTravelFare
	 * @param swipeInStationId
	 * @param currentStationId
	 * @return totalTravelFare
	 */
	private double calculateFare(int swipeInStationId, int currentStationId) {
		int totalNumberOfStationTravelled = Math.abs(currentStationId-swipeInStationId);
		double baseFare = getBaseFare(); 
		double totalTravelFare = baseFare*totalNumberOfStationTravelled;
		return totalTravelFare;
	}
	/**
	 * Returns the base Fare
	 * @return
	 */
	private double getBaseFare() {
		double baseFare = 7.0;
		int dayOfWeek = Calendar.DAY_OF_WEEK;
		if(dayOfWeek == 1 || dayOfWeek == 7) {
			baseFare = 5.5;
			return baseFare;
		}
		return baseFare;
	}
	/**
	 * This function is being used to calculate total number of swipeIn and swipedOut
	 * @return
	 */
	public int getTotalFootFall() {
		int totalFootFall = swipedInCount+swipedOutCount;
		System.out.println(totalFootFall);
		return swipedInCount+swipedOutCount;
	}
	/**
	 * This method is being used to perform auditing.
	 * @param card
	 */
	private void auditTravel (MSCSCard card) {
		List<TravelReport>travelLogs;
		if(travelReport.get(card.getCardNumber())!=null) {
			travelLogs = travelReport.get(card.getCardNumber());
		}else {
			travelLogs = new ArrayList<TravelReport>();
		}
		TravelReport travelLog = createTravelLog(card);
		travelLogs.add(travelLog);
		travelReport.put(card.getCardNumber(), travelLogs);
	}
	
	
	public void publishTravelReport(MSCSCard mscsCard) {
		List<TravelReport>travelLogs = travelReport.get(mscsCard.getCardNumber());
		if(!travelLogs.isEmpty()) {
			for (TravelReport travelReport : travelLogs) {
				System.out.println("Card Number: -"
						+ travelReport.getCardNumber()
						+ " used to travel from station "
						+ travelReport.getFromStation() + " to station "
						+ travelReport.getToStation() + " Fare is Rs. "
						+ travelReport.getTripFare()
						+ " and available Balance is  "
						+ travelReport.getAvailableBalance());
			}
		}
	}
	
	/**
	 * This method is being Used to create travel log for the card
	 * @param card
	 * @return
	 */
	private TravelReport createTravelLog(MSCSCard card) {
		String fromStation = getStationNameById(card.getSwipeInStationId());
		String toStation = getStationNameById(card.getSwipeOutStationId());
		TravelReport travelReport = new TravelReport();
		travelReport.setCardNumber(card.getCardNumber());
		travelReport.setFromStation(fromStation);
		travelReport.setToStation(toStation);
		travelReport.setTripFare(card.getRecentTripFare());
		travelReport.setAvailableBalance(card.getAvailabaleBalance());
		return travelReport;
	}
	
	
	/**
	 * This Method is being used to get Station Name by stationId.
	 * @param stationId
	 * @return
	 */
	private String getStationNameById(int stationId) {
		String station = "";
		if(stationId==1) {
			station = "A1";
		}else if(stationId==2) {
			station = "A2";
		}else if (stationId==3) {
			station = "A3";
		}else if(stationId==4) {
			station = "A4";
		}else if(stationId==5) {
			station = "A5";
		}else if(stationId==6) {
			station = "A6";
		}else if(stationId==7) {
			station = "A7";
		}else if(stationId==8) {
			station = "A8";
		}else if(stationId==9) {
			station = "A9";
		}else if(stationId==10) {
			station = "A10";
		}
		return station;
	}
}
