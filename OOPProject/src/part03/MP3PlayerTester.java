package part03;

import part01.*;

public class MP3PlayerTester {
	public static void main(String args[]) {
		testCase26();
		System.out.println("\n");
		testCase27();
		System.out.println("\n");
		testCase28();
		System.out.println("\n");
		testCase29();
		System.out.println("\n");
		testCase30();
		System.out.println("\n");
		testCase31();
		System.out.println("\n");
		testCase32();
		System.out.println("\n");
		testCase33();
		System.out.println("\n");
		testCase34();
		System.out.println("\n");
		testCase35();
		System.out.println("\n");
		testCase36();
		System.out.println("\n");
		testCase37();
		System.out.println("\n");
		testCase38();
		System.out.println("\n");

		
		

	}
	/**
	 * Test Case 26 : Adding a tune with valid data
	 */
	public static void testCase26() {
		MP3Player myPlayer = new MP3Player(); // Initialize MP3Player object
		String title = "Brave New World";
		String artist = "Iron Maiden";
		int duration = 380;
		Genre gen = Genre.ROCK;
		System.out.println("Test Case 26: Adding a tune with valid data");
		try {
		System.out.println("Expected Result : false" );
		System.out.println("Actual result : " + myPlayer.addTune(title, artist, duration, gen));
		
		}
		catch (Exception ex) {
			System.out.println("Encountered an exception." + ex + "This should not happen for valid data");
		}
		
		
		}
	/**
	 * Test Case 27 : Adding a tune with invalid data
	 */
	public static void testCase27() {
		MP3Player myPlayer = new MP3Player(); // Initialize MP3Player object
		String title = "";
		String artist = "";
		int duration = 0;
		Genre gen = null;
		System.out.println("Test Case 27: Adding a tune with invalid data");
		try {
			System.out.println("Expected Result : true" );
			System.out.println("Actual result : " + myPlayer.addTune(title, artist, duration, gen));
		}
		catch (Exception ex) {
			System.out.println("Encountered an exception." + ex + "This should not happen for valid data");
		}
	}
	/**
	 * Test Case 28 : Adding a tune which already exists
	 */
	public static void testCase28() {
		MP3Player myPlayer = new MP3Player(); // Initialize MP3Player object
		String title = "Brave New World";
		String artist = "Iron Maiden";
		int duration = 380;
		Genre gen = Genre.ROCK;
		myPlayer.addTune(title, artist, duration, gen);
		System.out.println("Test Case 28: Adding a tune which already exists");
		try {
			System.out.println("Expected Result: true");
			System.out.println("Actual result : " + myPlayer.addTune(title, artist, duration, gen));
		}
		catch (Exception ex) {
			System.out.println("Encountered an exception." + ex + "This should not happen for valid data");
		}
	}
	/**
	 * Test Case 29 : Testing the sorting of getTuneInfo
	 */
	public static void testCase29() {
		MP3Player myPlayer = new MP3Player(); // Initialize MP3Player object
		System.out.println("Test Case 29: Testing the sorting of getTuneInfo");
		String title = "Brave New World";
		String artist = "Iron Maiden";
		int duration = 380;
		Genre gen = Genre.ROCK;
		
		myPlayer.addTune(title, artist, duration, gen);
		String title1 = "Firestone";
		String artist1 = "Kygo";
		int duration1 = 200;
		Genre gen1 = Genre.POP;
		myPlayer.addTune(title1, artist1, duration1, gen1);
		
		String title2 = "Stay";
		String artist2 = "Kygo";
		int duration2 = 210;
		Genre gen2 = Genre.POP;
		myPlayer.addTune(title2, artist2, duration2, gen2);
		
		String title3 = "Levitating";
		String artist3 = "Dua Lipa";
		int duration3 = 380;
		Genre gen3 = Genre.ROCK;
		myPlayer.addTune(title3, artist3, duration3, gen3);
		
		String result[] = myPlayer.getTuneInfo();
		for(int i = 0; i < result.length;i++) {
			if (result[1] != null) {
			System.out.println(result[i]);
			}
		}
		
	}
	/**
	 * Test Case 30 : Testing the sorting of getTuneInfo(String artist)
	 */
	public static void testCase30() {
		MP3Player myPlayer = new MP3Player(); // Initialize MP3Player object
		System.out.println("Test Case 30: Testing the sorting of getTuneInfo(String artist)");
		String title = "Brave New World";
		String artist = "Iron Maiden";
		int duration = 380;
		Genre gen = Genre.ROCK;
		
		myPlayer.addTune(title, artist, duration, gen);
		String title1 = "Firestone";
		String artist1 = "Kygo";
		int duration1 = 200;
		Genre gen1 = Genre.POP;
		myPlayer.addTune(title1, artist1, duration1, gen1);
		
		String title2 = "Stay";
		String artist2 = "Kygo";
		int duration2 = 210;
		Genre gen2 = Genre.POP;
		myPlayer.addTune(title2, artist2, duration2, gen2);
		
		String title3 = "Levitating";
		String artist3 = "Dua Lipa";
		int duration3 = 380;
		Genre gen3 = Genre.ROCK;
		myPlayer.addTune(title3, artist3, duration3, gen3);
		
		String result[] = myPlayer.getTuneInfo("Kygo");
		for(int i = 0; i < result.length;i++) {
			if (result[i] != null ) {
			System.out.println(result[i]);
		}
		}
		
		
	}
	/**
	 * Test Case 31 : Testing getTuneInfo(String artist) for null data
	 */
	public static void testCase31() {
		MP3Player myPlayer = new MP3Player(); // Initialize MP3Player object
		System.out.println("Test Case 31: Testing getTuneInfo(String artist) for null data");
		String title = "Brave New World";
		String artist = "Iron Maiden";
		int duration = 380;
		Genre gen = Genre.ROCK;
		
		myPlayer.addTune(title, artist, duration, gen);
		String title1 = "Firestone";
		String artist1 = "Kygo";
		int duration1 = 200;
		Genre gen1 = Genre.POP;
		myPlayer.addTune(title1, artist1, duration1, gen1);
		
		String title2 = "Stay";
		String artist2 = "Kygo";
		int duration2 = 210;
		Genre gen2 = Genre.POP;
		myPlayer.addTune(title2, artist2, duration2, gen2);
		
		String title3 = "Levitating";
		String artist3 = "Dua Lipa";
		int duration3 = 380;
		Genre gen3 = Genre.ROCK;
		myPlayer.addTune(title3, artist3, duration3, gen3);
		
		String result[] = myPlayer.getTuneInfo("abc");
		System.out.println("Expected result : null" );
		if (result == null) {
			System.out.println("Actual result : null");
		}
		else {
			System.out.println("Actual result: not null. Test failed");
		}
		
		
	}
	/**
	 * Test Case 32 : Testing getTuneInfo(Genre gen) for null data
	 */
	public static void testCase32() {
		MP3Player myPlayer = new MP3Player(); // Initialize MP3Player object
		System.out.println("Test Case 32: Testing getTuneInfo(Genre gen) for null data");
		String title = "Brave New World";
		String artist = "Iron Maiden";
		int duration = 380;
		Genre gen = Genre.ROCK;
		
		myPlayer.addTune(title, artist, duration, gen);
		String title1 = "Firestone";
		String artist1 = "Kygo";
		int duration1 = 200;
		Genre gen1 = Genre.POP;
		myPlayer.addTune(title1, artist1, duration1, gen1);
		
		String title2 = "Stay";
		String artist2 = "Kygo";
		int duration2 = 210;
		Genre gen2 = Genre.POP;
		myPlayer.addTune(title2, artist2, duration2, gen2);
		
		String title3 = "Levitating";
		String artist3 = "Dua Lipa";
		int duration3 = 380;
		Genre gen3 = Genre.ROCK;
		myPlayer.addTune(title3, artist3, duration3, gen3);
		
		String result[] = myPlayer.getTuneInfo(Genre.OTHER);
		System.out.println("Expected Result: null");
		if (result == null) {
			System.out.println("Actual Result: null");
		}
		else {
			System.out.println("Actual Result: not null. Test failed");
		}
		
		
	}
	/**
	 * Test Case 33 : Testing play method for valid data
	 */
	public static void testCase33() {
		MP3Player myPlayer = new MP3Player(); // Initialize MP3Player object
		String title = "Brave New World";
		String artist = "Iron Maiden";
		int duration = 380;
		Genre gen = Genre.ROCK;
		myPlayer.addTune(title, artist, duration, gen);
		System.out.println("Test Case 33: Testing play method for valid data");
		System.out.println("Expected result: Now playing ... Brave New World by Iron Maiden");
		System.out.println("Actual Result: " + myPlayer.play(1));
		
		
	}
	/**
	 * Test Case 34 : Testing play method for invalid tuneId
	 */
	public static void testCase34() {
		MP3Player myPlayer = new MP3Player(); // Initialize MP3Player object
		String title = "Brave New World";
		String artist = "Iron Maiden";
		int duration = 380;
		Genre gen = Genre.ROCK;
		myPlayer.addTune(title, artist, duration, gen);
		System.out.println("Test Case 34: Testing play method for invalid tuneId(out of range)");
		System.out.println("Expected result: Error message");
		System.out.println("Actual result: " + myPlayer.play(2));
		
		
	}
	/**
	 * Test Case 35 : Testing switchOff method when MP3Player is on
	 */
	public static void testCase35() {
		MP3Player myPlayer = new MP3Player();
		System.out.println("Test Case 35: Testing switchOff method when MP3Player is on");
		System.out.println("Expected result : true");
		System.out.println("Actual result : " +  myPlayer.switchOff());
	}
	/**
	 * Test Case 36 : Testing switchOff method when MP3Player is already switched off
	 */
	public static void testCase36() {
		MP3Player myPlayer = new MP3Player();
		myPlayer.switchOff();
		System.out.println("Test Case 36: Testing switchOff method when MP3Player is already switched off");
		System.out.println("Expected result : false");
		System.out.println("Actual result : " +  myPlayer.switchOff());
	}
	/**
	 * Test Case 37 : Testing switchOn method when MP3Player is off
	 */
	public static void testCase37() {
		MP3Player myPlayer = new MP3Player();
		myPlayer.switchOff();
		System.out.println("Test Case 37: Testing switchOn method when MP3Player is off");
		System.out.println("Expected result : true");
		System.out.println("Actual result : " +  myPlayer.switchOn());
	}
	/**
	 * Test Case 37 : Testing switchOn method when MP3Player is already switched on
	 */
	public static void testCase38() {
		MP3Player myPlayer = new MP3Player();
		System.out.println("Test Case 38: Testing switchOn method when MP3Player is already switched on");
		System.out.println("Expected result : false");
		System.out.println("Actual result : " +  myPlayer.switchOn());
	}

	
	
	
	}

