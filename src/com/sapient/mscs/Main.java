package com.sapient.mscs;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		MSCSSystem mscsSystem = new MSCSSystem();
		
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please insert balance in double- ");
			System.out.println("Purchase a Metro Card with some balance");
			double inputBalance = scanner.nextDouble();
			MSCSCard mscsCard = new MSCSCard(728_123, inputBalance);
			System.out.println("Swipe in At station with id - ");
			int swipeInStationId = scanner.nextInt();
			mscsSystem.swipeIn(mscsCard, swipeInStationId);
			System.out.println("Swipe Out At station with id -" );
			int currentStationId = scanner.nextInt();
			mscsSystem.swipeOut(mscsCard, currentStationId);
			mscsSystem.getTotalFootFall();
			mscsSystem.publishTravelReport(mscsCard);
			scanner.close();
		}

}
