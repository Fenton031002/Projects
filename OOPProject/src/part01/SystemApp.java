package part01;
import java.util.Scanner;
import java.util.ArrayList;
public class SystemApp {

	static MP3Player myPlayer = new MP3Player(); // Initialize MP3Player object
	static final String options[] = {"Select from Full List","Select Tune by Artist","Select Tune by Genre","Add New Tune","Display the Top 10","Switch Off","Switch On","Exit"}; // Options for creating the menu
	static String title = "MP3 Player"; // Title of the menu
	static Menu myMenu = new Menu(title, options); // Creating menu object for displaying and processing choice
	static Scanner input = new Scanner(System.in); // Scanner class for accepting user input
	static final int QUIT = options.length; // The integer option to quit
	static boolean isOn = true; // Checks if the MP3 Player is on. The first time the user starts the MP3Player, it is on
	static boolean isOff = false; // Checks if the MP3 Player is off
	
	/**
	 * The main method for basically adding the first 5 tunes and giving the user a robust menu
	 */
	public static void main(String[] args) {
		addSomeTunes();
		int choice;
		do {
			myMenu.display();
			choice = myMenu.getUserChoice();
			if (choice != QUIT) {
				processChoice(choice);
				input.nextLine();
			}
		}
		while( choice != QUIT ); // Or while (quit == false)
		System.out.println("\nGoodbye!");
	}
	/**
	 * Processes the users choice and performs functions based on the users choosing
	 * @param choice - This is passed from the main method and does functions based on the users choosing
	 */
	private static void processChoice(int choice) {
		/*
		 * Processing users choices depending on what the user wants 
		 * All options - Select from full list,Select Tune by Artist,Select Tune by Genre,Add New Tune,Display the Top 10,Switch Off,Switch On
		 */
		if(choice == 1)	{	
			if (isOn == true) {	// Checks if the MP3 Player is on
			selectFullList();

			}
			else {
			System.out.println("MP3 Player is off");
			}
		}
		else if(choice == 2)	{
			if (isOn == true) {// Checks if the MP3 Player is on
			String artists1[] = getArtistList();
			String artist = null;
			Menu m3 = new Menu("Select Artist - ",artists1);
			m3.display();
			System.out.println("Enter artist to select by(Menu choice)");
			choice = m3.getUserChoice();
			for(int index = 0;index < artists1.length;index++) {
				if ((choice-1) == index) {
					artist = artists1[index];
				}
				
			}
			SelectArtist(artist);

			}
			else {
				System.out.println("MP3 Player is off");
			}
		}
		else if(choice == 3)	{
			if (isOn == true) {
			Genre gen = null;
            String options[] = {"Classical", "Rock", "Dance", "Jazz", "Pop", "Unknown Genre"}; // Hardcoded menu for genre
            Menu myMenu = new Menu("Select Tune by Genre", options); // Initialized a menu for the list of genres
            System.out.println();
            myMenu.display(); // Displays the menu for list of genres

            System.out.print("Enter selection for Genre: ");
            int choice1 = myMenu.getUserChoice(); // User input for genre
            System.out.println();
            /*
             * Using switch cases, gen is assigned to a genre depending on what the user enters
             */
            switch (choice1) {
            case 1: 
                System.out.println("You have selected: Classical");
                gen = Genre.CLASSICAL;
            break;
            case 2: 
                System.out.println("You have selected: Rock");
                gen = Genre.ROCK;
            break;
            case 3: 
                System.out.println("You have selected: Dance");
                gen = Genre.DANCE;
            break;
            case 4: 
                System.out.println("You have selected: Jazz");
                gen = Genre.JAZZ;
            break;
            case 5: 
                System.out.println("You have selected: Pop");
                gen = Genre.POP;
            break;
            case 6: 
                System.out.println("You have selected: Unknown Genre");
                gen = Genre.OTHER;
            break;
            default:
                System.out.println("Option " + choice + " is invalid.");
            }
            selectGenre(gen);
		}
			else {
				System.out.println("MP3 Player is off");
			}
		}
		else if (choice == 4)	{
			if (isOn == true) {// Checks if the MP3 Player is on
		
					AddNewTune();

					}
					else {
						System.out.println("MP3 Player is off");
						}
		}
		else if(choice == 5)	{
			if (isOn == true) {// Checks if the MP3 Player is on
		
					ViewTopTen();
					}
					else {
						System.out.println("MP3 Player is off");
						}
		}

		else if(choice == 6)	{	
			switchOff();

		}
		else if(choice == 7)  { 
			switchOn();

		}
		else {	
			System.out.println("Option "+choice+" is invalid.");
		}
		System.out.println();
		}
		
		

	/**
	 * A 'freebie' - just to get you started
	 */
	private static void addSomeTunes() {
		myPlayer.addTune("One", "U2", 380, Genre.ROCK);
		myPlayer.addTune("Four Seasons - Winter", "Vivaldi", 5500, Genre.CLASSICAL);
		myPlayer.addTune("The Chain", "Fleetwood Mac", 750, Genre.ROCK);
		myPlayer.addTune("Graceland", "Paul Simon", 350, Genre.POP);
		myPlayer.addTune("Help", "The Beatles", 300, Genre.POP);
	}
	/**
	 * This method asks the user to enter a title,artist,duration and genre and then adds a tune to the MP3 Player if it doesnt already exist
	 */
	private static void AddNewTune() {
		Genre gen = null;
		System.out.println("Enter title");
		String title = input.nextLine(); // User input for title
		System.out.println("Enter artist");
		String artist = input.nextLine(); // User input for artist
		System.out.println("Enter duration");
		int duration = input.nextInt(); // User input for duration
		input.nextLine();
		do {
		System.out.println("Enter genre");
		String genreString = input.nextLine(); // User input for genre
		/*
		 * Changes gen depending on what the user has entered for genreString
		 */
		if (genreString.equals("Classical")) {
			gen = Genre.CLASSICAL;
		}
		else if(genreString.equals("Rock")) {
			gen = Genre.ROCK;
		}
		else if (genreString.equals("Dance")) {
			gen = Genre.DANCE;
		}
		else if (genreString.equals("Jazz")) {
			gen = Genre.JAZZ;
		}
		else if(genreString.equals("Pop")) {
			gen = Genre.POP;
		}
		else if(genreString.equals("Other")) {
			gen = Genre.OTHER;
		}
		else {
			System.out.println("Incorrect");
		}
		}
		while(gen == null);
		if (myPlayer.addTune(title,artist,duration,gen) == false) { // Checks if the user has inputted a tune which already exists in the MP3 Player
			System.out.println("Successfully added!");
		}
		else {
			System.out.println("The exact same tune is already in the MP3Player");
		}
		}
	/**
	 * This method gives all the songs ordered alphabetically by title
	 */
	private static void selectFullList() {
		String items[] = myPlayer.getTuneInfo();
		ArrayList<String> cleanTune = new ArrayList<String>();// Creates an array to copy the "toString" part of the tune
		ArrayList<String> fullTune = new ArrayList<String>();// Creates an array to copy the cleaner part of the tune(format string - title + "by " + artist)
		int itemsLength = myPlayer.getTuneInfo().length;
		for(int i = 0; i < itemsLength;i++) {// Iterates through each tune basically
			if (items[i] != null) {
				String resultString = "";
				resultString += items[i];// Appends all the tune info
				String newResultString = "";
				String words[] = resultString.split(",");// Since every word is seperated by a comma , we use the split method
				for(int j = 0;j < words.length;j++) {// Iterates through each word in the tune to basically "trim" the tune info to make it cleaner and user friendly
					if (j == 1) {// words[1] is title
						newResultString += words[j] + " by ";
					}
					if (j == 2) {// words[2] is artist
						newResultString += words[j];
					}
				}
				cleanTune.add(newResultString);
				fullTune.add(resultString);
				
			}
			
		}
		String newItems[] = new String[fullTune.size()];// Creating a new array to copy the elements of the arraylist containing the full tune info to the array
		String newItems1[] = new String[cleanTune.size()];// Creating a new array to copy the elements of the arraylist containing the filtered tune info to the array
		for(int i = 0;i < newItems.length;i++) {
			newItems[i] = fullTune.get(i);
		}
		for(int i = 0;i < newItems.length;i++) {
			newItems1[i] = cleanTune.get(i);
		}
		Menu m2 = new Menu("QUB MUSIC",newItems1);// Initializes a new menu for all the tunes
		m2.display();// Displays the menu containing list of all tunes
		System.out.println("Select tune id");
		int choice = m2.getUserChoice();
		for(int index = 0;index < newItems.length;index++) {// Iterates through every tune
			if ((choice-1) == index) {
				String finalString = newItems[index];
				String finalItems[] = finalString.split(",");
				for(int j = 0;j<finalItems.length;j++) {
					if (j == 0) {// finalItems[0] is the tuneId
						int IDtune = Integer.parseInt(finalItems[j]);
						System.out.println(myPlayer.play(IDtune));// Calls the MP3Player "play" method for the choice that the user has picked
					}
				}
			}
			
		}
		}
	/**
	 * This method gives all the songs ordered alphabetically by title of a particular artist the user chooses(from another menu)
	 */
	private static void SelectArtist(String artist) {
		int itemsLength = myPlayer.getTuneInfo(artist).length;
		String items[] = myPlayer.getTuneInfo(artist);
		ArrayList<String> artists = new ArrayList<String>(); // Creates an array to copy the "toString" part of the tune
		ArrayList<String> cleanArtists = new ArrayList<String>(); // Creates an array to copy the cleaner part of the tune(format string - title + "by " + artist)
		
		for(int i = 0; i < itemsLength;i++) { // Iterates through each tune basically
			if (items[i] != null) {
				String resultString = "";
				resultString += items[i]; // Appends all the tune info
				String newResultString = "";
				String words[] = resultString.split(","); // Since every word is seperated by a comma , we use the split method
				for(int j = 0; j < words.length;j++) { // Iterates through each word in the tune to basically "trim" the tune info to make it cleaner and user friendly
					if (j == 1) { // words[1] is title
						newResultString += words[j] + " by ";
						
					}
					if (j == 2) { // words[2] is artist
						newResultString += words[j];
					}
				}
				cleanArtists.add(newResultString);
				artists.add(resultString);
				
			}
			
		}
		String newItems[] = new String[artists.size()]; // Creating a new array to copy the elements of the arraylist containing the full tune info to the array
		String newItems1[] = new String[cleanArtists.size()]; // Creating a new array to copy the elements of the arraylist containing the filtered tune info to the array
		for(int i = 0;i < newItems.length;i++) {
			newItems[i] = artists.get(i);
		}
		for(int i = 0;i < newItems.length;i++) {
			newItems1[i] = cleanArtists.get(i);
		}
		Menu m2 = new Menu("QUB MUSIC: " + artist,newItems1); // Initializes a new menu for creating a list of tunes by the particular artist the user chose
		m2.display(); // Displays the menu containing list of tunes by the particular artist the user chose
		System.out.println("Select artist by choice");
		int choice = m2.getUserChoice();
		for(int index = 0;index < newItems.length;index++) { // Iterates through every tune
			if ((choice-1) == index) {
				String finalString = newItems[index];
				String finalItems[] = finalString.split(",");
				for(int j = 0;j<finalItems.length;j++) {
					if (j == 0) { // finalItems[0] is the tuneId
						int IDtune = Integer.parseInt(finalItems[j]);
						System.out.println(myPlayer.play(IDtune)); // Calls the MP3Player "play" method for the choice that the user has picked
					}
				}
			}
			
		}
		
		
		}
	/**
	 * This method gets a list of all the artists whose tunes are present in the MP3 Player
	 * @return the list of artists in the MP3 Player
	 */
	private static String[] getArtistList() {
		int itemsLength = myPlayer.getTuneInfo().length;
		ArrayList<String> artists = new ArrayList<String>();
		String items[] = myPlayer.getTuneInfo();
		for(int i = 0; i < itemsLength;i++) { // Iterates through every tune 
			if (items[i] != null) {
				String resultString = "";
				resultString += items[i];
				String words[] = resultString.split(","); // Splits the toString into seperate components to extract artist
				for(int j = 0; j < words.length;j++) {
					boolean isThere = false;
					if (j == 2) { // words[2] is artists name
						for (String artistItems:artists) { // Iterates through every artist in arrayList
							if (words[j].equals(artistItems)) { // Checks if artist exists in arrayList then it wont add the artist to the arrayList
								isThere = true;
							}
						}
						if (isThere == true) {
							continue;
						}
						else { // if isThere = false
							artists.add(words[j]); // Adds the artist to arrayList
						}
					}
				}
				
				
			}
		}
		String[] newArtists = new String[artists.size()];
		for(int i = 0;i < newArtists.length;i++) { // Copying the elements of the arrayList to an array
			newArtists[i] = artists.get(i);
		}
		return newArtists;
	}
	/**
	* selectGenre method which allows the user to select a list of tunes by genre by calling getTuneInfo(genre gen) method
	* @param - gen - This will call the getTuneInfo method passing this as a parameter and return a menu of songs with said genre
	*/
	private static void selectGenre(Genre gen) {	
		int itemsLength = myPlayer.getTuneInfo(gen).length;
		String items[] = myPlayer.getTuneInfo(gen);
		ArrayList<String> artists = new ArrayList<String>();// Creates an array to copy the "toString" part of the tune
		ArrayList<String> artists1 = new ArrayList<String>();// Creates an array to copy the cleaner part of the tune(format string - title + "by " + artist)
		for(int i = 0; i < itemsLength;i++) {// Iterates through each tune basically
				String resultString = "";
				resultString += items[i];// Appends all the tune info
				String newResultString = "";
				String words[] = resultString.split(",");// Since every word is seperated by a comma , we use the split method
				for(int j = 0; j < words.length;j++) {// Iterates through each word in the tune to basically "trim" the tune info to make it cleaner and user friendly
					if (j == 1) {
						newResultString += words[j] + " by ";// words[1] is title
						
					}
					if (j == 2) {
						newResultString += words[j];// words[2] is artist
					}
				}
				if (resultString.equals("null") == false) {
					artists1.add(resultString);
				}
				if (newResultString.equals("") == false) {
					artists.add(newResultString);
				}
						
		}
		String newItems[] = new String[artists1.size()];// Creating a new array to copy the elements of the arraylist containing the full tune info to the array
		String newItems1[] = new String[artists.size()];// Creating a new array to copy the elements of the arraylist containing the filtered tune info to the array
		for(int i = 0;i < newItems.length;i++) {
			newItems[i] = artists.get(i);
		}
		for(int i = 0;i < newItems.length;i++) {
			newItems1[i] = artists1.get(i);
		}
		if (newItems1.length == 0) {
			System.out.println("Sorry, there are no songs in the " + gen + " category");
		}
		else {
			Menu m2 = new Menu("QUB MUSIC: " + gen ,newItems);// Initializes a new menu for creating a list of tunes by the particular genre the user chose
			m2.display();// Displays the menu containing list of tunes by the particular genre the user chose
			System.out.println("Select genre by choice");
			int choice = m2.getUserChoice();
			for(int index = 0;index < newItems1.length;index++) {// Iterates through every tune
				if ((choice-1) == index) {
					String finalString = newItems1[choice-1];
					String finalItems[] = finalString.split(",");
					for(int j = 0;j<finalItems.length;j++) {
						if (j == 0) {// finalItems[0] is the tuneId
							int IDtune = Integer.parseInt(finalItems[j]);
							System.out.println(myPlayer.play(IDtune));// Calls the MP3Player "play" method for the choice that the user has picked
						}
					}
				}
				
		}
		}
	}
	/**
	 * This method lists the top 10 songs ordered by number of plays(or up to how many ever if there are less than 10 songs)
	 */
	private static void ViewTopTen() {
		int swaps = 0;
        int count = 0;
        String items[] = myPlayer.getTuneInfo();
        /*
         * This part of the method sorts the tunes based on number of plays
         */
        do {
            swaps = 0;
            for (int index = 0; index < items.length - 1; index++) {
                String getPC[] = items[index].split(","); // String of current index without the commas
                String getPCnext[] = items[index + 1].split(","); // String of next index without the commas
                int intplayCount = Integer.parseInt(getPC[5]); // getPC[5] is the playCount of the current tune index in string format. This is why we use Integer.parseInt
                int intplayCountNext = Integer.parseInt(getPCnext[5]); // getPCnext[5] is the playcount of the next tune index in string format. This is why we use Integer.parseInt
                for (int i = 0; i < items.length - 1; i++) {
                    if (intplayCount < intplayCountNext) { // Compares between the playcount of the current tune index and the next tune index
                    	/*
                    	 * Swapping operation for arrays if condition is true
                    	 */
                        String temp = items[index];
                        items[index] = items[index + 1];
                        items[index + 1] = temp;
                        swaps++;
                        break;
                    }
                }
            }
        } while (swaps > 0);
        /*
         * This part of the method displays the top 10 tunes after sorting
         */
        if (items.length >= 10) { // If length of items array is greater than 10, it will only display top 10 tunes
        for (int index = 0; index < 10; index++) {
            String resultString = items[index];
            String words[] = resultString.split(",");

            System.out.println(count + ": " +  words[1] + ": Number of plays: " + words[5]); // words[1] is title, words[5] is playcount
            count ++;
            }
        }
        else { // If length of items array is less than 10, it will display all of the tunes
        	for (int index = 0; index < items.length; index++) {
                String resultString = items[index];
                String words[] = resultString.split(",");

                System.out.println(count + ": " +  words[1] + ": Number of plays: " + words[5]);// words[1] is title, words[5] is playcount
                count ++;
                }
            }
        }
	/**
	 * This method switches the MP3Player off(If its not already off)
	 * This prohibits the user from performing any other method besides switching it on
	 */
	private static void switchOff() {
		if (myPlayer.switchOff() == false) { // Checks if the MP3Player is not already off
			System.out.println("MP3Player already off");
		}
		else { // If its not already off, switches it off
			System.out.println("MP3Player switched off");
			isOff = true;
			isOn = false;
		}
	}
	/**
	 * This method switches the MP3Player on(If its not already on)
	 * This allows the user to perform any method
	 */
	private static void switchOn() {
		if (myPlayer.switchOn() == false) { // Checks if the MP3Player is not already on
			System.out.println("MP3Player already on");
		}
		else { // If its not already on , switches it on
			System.out.println("MP3Player switched on");
			isOn = true;
			isOff = false;
		}
	}
	
}