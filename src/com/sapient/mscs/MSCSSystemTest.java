package com.sapient.mscs;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MSCSSystemTest {
	
	private MSCSCard card;
	private MSCSSystem mscsSystem ;
	@Before
	public void setup() {
		mscsSystem = new MSCSSystem(); 
		card = new MSCSCard(723_456_789, 100.00);
	}
	
	@Test
	public void testSwipeIn() {
		mscsSystem.swipeIn(card, 2);
		assertEquals(723_456_789, card.getCardNumber());
		assertEquals(2, card.getSwipeInStationId());
	}
	
	@Test
	public void testSwipeOut() {
		card.setSwipeInStationId(2);
		mscsSystem.swipeOut(card, 9);
		assertEquals(723_456_789, card.getCardNumber());
		assertEquals(9, card.getSwipeOutStationId());
		assertEquals(38.5, card.getRecentTripFare(),0.0);
	}
	
}
