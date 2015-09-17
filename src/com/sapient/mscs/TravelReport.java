package com.sapient.mscs;

public class TravelReport {
	
	private long cardNumber;
	
	private String fromStation;
	
	private String  toStation;
		
	private double availableBalance;
	
	private double tripFare;
	
	

	/**
	 * @return the cardNumber
	 */
	public long getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the fromStation
	 */
	public String getFromStation() {
		return fromStation;
	}

	/**
	 * @param fromStation the fromStation to set
	 */
	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

	/**
	 * @return the toStation
	 */
	public String getToStation() {
		return toStation;
	}

	/**
	 * @param toStation the toStation to set
	 */
	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	/**
	 * @return the availableBalance
	 */
	public double getAvailableBalance() {
		return availableBalance;
	}

	/**
	 * @param availableBalance the availableBalance to set
	 */
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	/**
	 * @return the tripFare
	 */
	public double getTripFare() {
		return tripFare;
	}

	/**
	 * @param tripFare the tripFare to set
	 */
	public void setTripFare(double tripFare) {
		this.tripFare = tripFare;
	}
}
