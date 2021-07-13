package part02;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import part01.MP3Player;
import part01.Tune;
import part01.Genre;
import java.io.File;


public class Jukebox extends MP3Player {

    private static int credits = 0;
    private static int costPerCredits = 0;

    public Jukebox() {
        this.costPerCredits = 0;
        this.credits = 0;

    }
    /*
     * The play method overridden with the MP3 Player play method
     * It does the same as MP3 Player 
     */
    @Override
    public String play(int tuneId) {
    	int newtuneId = tuneId;
    	String result = null;
        if (credits > 0 || costPerCredits == 0) {
        	if (costPerCredits == 0) {
        		result = super.play(newtuneId);
        		System.out.println("This tune is free since cost per credits is 0");
        	}
        	else {
        	credits --;
        	result = super.play(newtuneId);
        	System.out.println("You have " + credits + " credits remaining.");
        	}
            }
            else {
            	return "You have no credits";
            }
        return result;
        }

    public void setCostPerCredits(int costPerCredits) { // Setter to set costPerCredits for PrintWriter and SystemApp  
    	this.costPerCredits = costPerCredits;
    }
    public int getCostPerCredits() { // Getter for costPerCredits to check if it is 0 for the InsertCoin method and the play method
    	return this.costPerCredits;
    }
    public void setCredits(int credits) { // Setter to set Credits for PrintWriter
    	this.credits = credits;
    }
    @Override
    public boolean switchOff() {
    	if (super.switchOff() == true) {
    	String myDir = "src/jukebox.csv";
    	String result[] = super.getTuneInfo();
		try {
			PrintWriter myPw = new PrintWriter(myDir);
			for (int i = 0; i < result.length;i++) {
				myPw.println(result[i]);
			}
			myPw.println("Credits," + costPerCredits);
			myPw.println("No," + credits);
			myPw.close();
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}

        return true;
    	}
    	else {
    		return false;
    	}
    	
    }
    @Override
    public boolean switchOn() {
    	int count = 0;
    	int count1 = 1;
    	if (super.switchOn() == true) { // Checks if the MP3 Player is switched on
    	File myFile = new File("src/jukebox.csv"); // The file destination
		try {
			Scanner countLines = new Scanner(myFile); // To count the number of lines in the file
			Scanner mySc = new Scanner(myFile);
			while(countLines.hasNextLine()) { // Loop to count the number of lines in the file
				count ++;
				countLines.nextLine();
				
			}
			String lines[] = new String[count];
			while(mySc.hasNextLine()) {
				for(int i = 0; i < lines.length;i++) { // Loop to copy all of the data into a string array
					lines[i] = mySc.nextLine(); 
				}
				
			}
			while(count >= count1) { // While loop to make it such that tunes are added in ascending order of their tuneId
				for(String line : lines) {
					String words[] = line.split(","); // line splitting into words
					if (words[0].equals("Credits")) { // Checks if the first word is "Credits" for getting costPerCredits
						int intCost = Integer.parseInt(words[1]);
						setCostPerCredits(intCost);
						count --; // Count -- for the purpose of adding Tunes by int tuneId
						continue;
					}
					if (words[0].equals("No")) { // Checks if the first word is "No" for getting number of credits
						int intNo = Integer.parseInt(words[1]);
						setCredits(intNo);
						count --;
						continue;
						
					}
					else {
					int intId = Integer.parseInt(words[0]); // To get the tuneId
					if (intId == count1) {
						Genre gen = null;
						/*
						 * To get the genre. Words[4] is the genre in string format
						 */
						if (words[4].equals("Easy Listening Pop")) { // 
							gen = Genre.POP;
						}
						else if (words[4].equals("Classical")) {
							gen = Genre.CLASSICAL;
						}
						else if (words[4].equals("Rock and Roll")) {
							gen = Genre.ROCK;
						}
						else if (words[4].equals("Techno Dance")) {
							gen = Genre.DANCE;
						}
						else if (words[4].equals("Unknown Genre")) {
							gen = Genre.OTHER;
						}
						else if (words[4].equals("Smooth Jazz")) {
							gen = Genre.JAZZ;
						}
						int intDuration = Integer.parseInt(words[3]); // words[3] is intDuration
						int intPlayCount = Integer.parseInt(words[5]);// words[5] is intPlaycount
						super.addTune(words[1], words[2], intDuration, gen); // Adding the tune to soundData
						for(int index = 0;index < intPlayCount;index++ ) {
							super.play(count1); // Playing the number of times the playcount is to store the playCount
						}
						count1++;
					}
				}
				}
			}
			System.out.println("Jukebox successfully restored");
			mySc.close();
			countLines.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return true;
    	}
    	else {
    		return false;
    	}
    }

/**
 * This method takes the coin the user has inputed and converts it into a certain amount of credits depending on the costPerCredits
 * @param value - the denomination of the coin
 */
    public void insertCoin(int value) {

        if (value == 10 || value == 20 || value == 50 || value == 100 || value == 200) {

            credits += (value / costPerCredits);

        }


    }

}