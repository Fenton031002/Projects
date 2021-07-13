package part03;
import part01.*;
public class TuneTester {
	public static void main(String args[]) {
		testCase21();
		System.out.println("\n");
		testCase22();
		System.out.println("\n");
		testCase23();
		System.out.println("\n");
		testCase24();
		System.out.println("\n");
		testCase25();
		System.out.println("\n");
	}
	/**
	 * Test Case 21 : Valid Construction
	 */
	public static void testCase21() {
	String title = "Brave New World";
	String artist = "Iron Maiden";
	int duration = 380;
	Genre gen = Genre.ROCK;
	Tune tune;
	System.out.println("Test Case 21: Valid data");
	try {
	tune = new Tune(title,artist,duration,gen);
	System.out.println("Constructed tune successfully");
	System.out.println("-->Expected title     : " + title);
	System.out.println("-->Actual title       : " + tune.getTitle());
	System.out.println("-->Expected artist     : " + artist);
	System.out.println("-->Actual artist       : " + tune.getArtist());
	System.out.println("-->Expected duration     : " + duration);
	System.out.println("-->Actual duration       : " + tune.getDuration());
	System.out.println("-->Expected genre     : " + gen);
	System.out.println("-->Actual genre       : " + tune.getStyle());
	System.out.println("-->Expected play count     :  0" );
	System.out.println("-->Actual play count       : " + tune.getplayCount());
	
	System.out.println("Constructed tune successfully");
	}
	catch (Exception ex) {
		System.out.println("Encountered an exception." + ex + "This should not happen for valid data");
	}
	
	
	}
	/**
	 * Test Case 22 : Invalid Construction(null or "" or " " title)
	 */
	public static void testCase22() {
		String title = null;
		String artist = "Iron Maiden";
		int duration = 380;
		Genre gen = Genre.ROCK;
		Tune tune;
		System.out.println("Test Case 22: Invalid data(invalid title)");
		tune = new Tune(title,artist,duration,gen);
		if (tune != null) {
			System.out.println("Tune has been constructed. However, it should not have been added since title is null");
			tune.toString();
		}
	}
	/**
	 * Test Case 23 : Invalid Construction(null or "" or " " artist)
	 */
	public static void testCase23() {
		String title = "Brave New World";
		String artist = null;
		int duration = 380;
		Genre gen = Genre.ROCK;
		Tune tune;
		System.out.println("Test Case 23: Invalid data(invalid artist)");
		tune = new Tune(title,artist,duration,gen);
		if (tune != null) {
			System.out.println("Tune has been constructed. However, it should not have been added since artist is null");
			tune.toString();
		}
	}
	/**
	 * Test Case 24 : Invalid Construction(0 duration)
	 */
	public static void testCase24() {
		String title = "Brave New World";
		String artist = "Iron Maiden";
		int duration = 0;
		Genre gen = Genre.ROCK;
		Tune tune;
		System.out.println("Test Case 24: Invalid data(0 duration)");
		tune = new Tune(title,artist,duration,gen);
		if (tune != null) {
			System.out.println("Tune has been constructed. However, it should not have been added since duration is 0");
			tune.toString();
		}
	}
	/**
	 * Test Case 24 : Invalid Construction(null genre)
	 */
	public static void testCase25() {
		String title = "Brave New World";
		String artist = "Iron Maiden";
		int duration = 380;
		Genre gen = null;
		Tune tune;
		System.out.println("Test Case 25: Invalid data(null genre)");
		tune = new Tune(title,artist,duration,gen);
		if (tune != null) {
			System.out.println("Tune has been constructed. However, it should not have been constructed because genre is null");
			tune.toString();
		}
	}
}