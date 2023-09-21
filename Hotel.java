package edu.ilstu; 
import java.util.Random;

public class Hotel {
	private String name;
	private int[] ratings;
	
	public Hotel(String name) {
		this.name = name;
		Random numGen = new Random();
		int yearsOfRatings = numGen.nextInt(5,11);
		ratings = new int[yearsOfRatings];
		for(int i=0; i<yearsOfRatings; i++) {
			ratings[i] = numGen.nextInt(1,101);
		}
		
	}
	
	public int[] getRatings() {
		return ratings;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() { // Returns hotel rating data
		String description = "";
		for(int i=0; i<10; i++) {
			if(i<ratings.length) // Makes sure that there is still more data
				
				if(ratings[i] == 100) // Makes sure spacing is even despite different integer lengths
					description += ratings[i] + "     ";
				else if(ratings[i] >= 10)
					description += ratings[i] + "      ";
				else
					description += ratings[i] + "       ";
			
			else // Runs when there are no more ratings left
				description += "N/A     ";
		}
		return description + "\n";

	}
	
}
