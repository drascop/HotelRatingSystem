package edu.ilstu; 
import java.util.ArrayList;

public class HotelDriver {
	private static ArrayList<Hotel> hotelData = new ArrayList<>();
	
	public static void main(String[] args) {
		generateData();
		displayAllRatings();
		findBestHotels();
		findWorstHotels();
	}
	
	private static void generateData() {
		Hotel fourSeasons = new Hotel("Four Seasons");
		Hotel mariott = new Hotel("Mariott");
		Hotel holidayInn = new Hotel("Holiday Inn");
		Hotel motelSix = new Hotel("Motel 6");
		Hotel bellagio = new Hotel("Bellagio");
		Hotel caesarsPalace = new Hotel("Caesars Palace");
		Hotel sheraton = new Hotel("Sheraton Grand");
		Hotel hyatt = new Hotel("Hyatt Place");
		hotelData.add(hyatt);
		hotelData.add(sheraton);
		hotelData.add(caesarsPalace);
		hotelData.add(bellagio);
		hotelData.add(fourSeasons);
		hotelData.add(motelSix);
		hotelData.add(holidayInn);
		hotelData.add(mariott);
		
	}
	
	private static void displayBanner() {
		System.out.println("Hotel         2023    2022    2021    2020    2019    2018    2017    2016    2015    2014");
		System.out.println("___________________________________________________________________________________________");
	}
	
	private static void displayAllRatings() {
		System.out.println("All Hotel Ratings: \n");
		displayBanner();
		for(int i=0; i<hotelData.size(); i++) { //Traverses through hotelData ArrayList
			System.out.print(hotelData.get(i).getName());
			
			for(int x=hotelData.get(i).getName().length(); x<16; x++) //Makes sure data lines up evenly despite different name lengths
				System.out.print(" ");
			
			System.out.println(hotelData.get(i).toString()); // Prints ratings for each hotel
		}
		System.out.println();
	}
	
	private static void findBestHotels() {
		boolean foundNone = true;
		System.out.println("The Top Rated Hotels: \n");
		displayBanner();
		for(int i=0; i<hotelData.size(); i++) { //Traverses through each Hotel object in hotelData
			for(int x = 0; x < hotelData.get(i).getRatings().length; x++) { //Traverses through ratings array
				
				if(hotelData.get(i).getRatings()[x] > 94) { //If the Hotel has a 95+ rating, print the name and ratings
					System.out.print(hotelData.get(i).getName());
					
					for(int y=hotelData.get(i).getName().length(); y<16; y++) //Makes sure data lines up evenly despite different name lengths
						System.out.print(" ");
					
					System.out.println(hotelData.get(i).toString());
					foundNone = false;
					x = hotelData.get(i).getRatings().length; //Stops for loop so the same hotel isn't printed twice
				}
			}
		}
		if(foundNone) // Runs if no 95+ ratings were found
			System.out.println("Sorry, we could not find any hotels with a 95+ rating in their history.");
		System.out.println();
	}
	
	public static void findWorstHotels() {
		int lowestRating = 101;
		int worstHotelIndex = 0;
		for(int i=0; i<hotelData.size(); i++) { //Traverses through each Hotel object in hotelData
			
			for(int x=0; x<hotelData.get(i).getRatings().length; x++) { //Traverses through ratings array
				
				if(hotelData.get(i).getRatings()[x] < lowestRating) { //Checks if rating is lower than the current low
					lowestRating = hotelData.get(i).getRatings()[x];
					worstHotelIndex = i; //Saves the index of the hotel with new lowest rating
				}
			}
		}
		System.out.println("The Worst Hotel(Received Lowest Score of " + lowestRating + "): \n");
		displayBanner();
		System.out.print(hotelData.get(worstHotelIndex).getName());
		for(int y=hotelData.get(worstHotelIndex).getName().length(); y<16; y++) //Makes sure data lines up evenly despite different name lengths
			System.out.print(" ");
		System.out.println(hotelData.get(worstHotelIndex).toString());
		
	}

}
