package com.sapient.mscs;


/**
 * 
 * @author Indiahiring
 *
 */
public class MSCSCard {
	private long cardNumber;
	private boolean allowedSwipeInAccess ;
	private boolean allowedSwipeOutAccess ;
	private int swipeInStationId ;
	private int swipeOutStationId;
	private double availabaleBalance;
	private double recentTripFare ;
	

	/**
	 * 
	 * @param cardNumber
	 * @param inputBalance
	 */
	public MSCSCard(long cardNumber, double inputBalance) {
		this.cardNumber = cardNumber;
		this.availabaleBalance = inputBalance;
		this.allowedSwipeInAccess = false;
		this.allowedSwipeOutAccess = false;
		this.swipeInStationId = 0;
		this.swipeOutStationId = 0;
		this.recentTripFare = 0.0;
	}
	
	/**
	 * 
	 * @return cardNumber
	 */
	public long getCardNumber() {
		return cardNumber;
	}
	
	/**
	 * @return the allowedSwipeInAccess
	 */
	public boolean isAllowedSwipeInAccess() {
		return allowedSwipeInAccess;
	}


	/**
	 * @param allowedSwipeInAccess the allowedSwipeInAccess to set
	 */
	public void setAllowedSwipeInAccess(boolean allowedSwipeInAccess) {
		this.allowedSwipeInAccess = allowedSwipeInAccess;
	}


	/**
	 * @return the allowedSwipeOutAccess
	 */
	public boolean isAllowedSwipeOutAccess() {
		return allowedSwipeOutAccess;
	}


	/**
	 * @param allowedSwipeOutAccess the allowedSwipeOutAccess to set
	 */
	public void setAllowedSwipeOutAccess(boolean allowedSwipeOutAccess) {
		this.allowedSwipeOutAccess = allowedSwipeOutAccess;
	}


	/**
	 * @return the swipeInStationId
	 */
	public int getSwipeInStationId() {
		return swipeInStationId;
	}


	/**
	 * @param swipeInStationId the swipeInStationId to set
	 */
	public void setSwipeInStationId(int swipeInStationId) {
		this.swipeInStationId = swipeInStationId;
	}


	/**
	 * @return the availabaleBalance
	 */
	public double getAvailabaleBalance() {
		return availabaleBalance;
	}


	/**
	 * @param availabaleBalance the availabaleBalance to set
	 */
	public void setAvailabaleBalance(double availabaleBalance) {
		this.availabaleBalance = availabaleBalance;
	}

	/**
	 * @return the swipeOutStationId
	 */
	public int getSwipeOutStationId() {
		return swipeOutStationId;
	}

	/**
	 * @param swipeOutStationId the swipeOutStationId to set
	 */
	public void setSwipeOutStationId(int swipeOutStationId) {
		this.swipeOutStationId = swipeOutStationId;
	}

	/**
	 * @return the recentTripFare
	 */
	public double getRecentTripFare() {
		return recentTripFare;
	}

	/**
	 * @param recentTripFare the recentTripFare to set
	 */
	public void setRecentTripFare(double recentTripFare) {
		this.recentTripFare = recentTripFare;
	}
}
