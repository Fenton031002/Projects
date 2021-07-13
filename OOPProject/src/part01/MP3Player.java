package part01;

import java.util.ArrayList;
import java.util.Collections;

public class MP3Player implements iPlayer {
	private ArrayList<Tune> soundData = new ArrayList<Tune>(); // Initializes arraylist for storing tunes
	private boolean isOff = false;
	private boolean isOn = true;
	

	public MP3Player() {
		String title = null;
		String artist = null;
		int duration = -1;
		Genre gen = null;
		this.soundData = soundData;
	}
	
/**
 * This method adds a tune into soundData if it does not exist in soundData.
 * @param title - The name of the tune
 * @param artist - The artist of the tune
 * @param duration - The duration of the tune(In seconds)
 * @param gen - The genre of the tune(pop,rock etc)
 * @return - isThere - returns true if the tune does exists in the MP3 Player and returns false if it does not exist in the MP3 Player
 */
	public boolean addTune(String title, String artist, int duration, Genre gen) {
		boolean isThere = false;
		if(soundData.size() != 0) {
			for(Tune Tunes:soundData) {
				if (title.equals(Tunes.getTitle()) && artist.equals(Tunes.getArtist()) && duration == Tunes.getDuration() && gen.equals(Tunes.getStyle())) { // Checks if tune exists in arrayList
					isThere = true;
				}
			}
			if(isThere == false) { // Adds the tune to the arrayList if it does not exist
				Tune t1 = new Tune(title,artist,duration,gen);
				soundData.add(t1);
			}
		}
		if(soundData.size() == 0) { // Checks if this is the first tune in the MP3 Player
			Tune t1 = new Tune(title,artist,duration,gen);
			soundData.add(t1); // The first entered tune will never exist in the MP3 Player
			isThere = false;
		}
		return isThere;
	}
	
/**
 * This method gets the tune info of all the tunes using the toString method in tune
 */
	public String[] getTuneInfo() {
		int swaps;
		int count = 0;
		String result[] = new String[soundData.size()];
		do {
			swaps = 0;
			for(int i = 0; i < soundData.size() - 1; i++) {
				if (soundData.get(i).getTitle().compareTo(soundData.get(i+1).getTitle())>0) {
				Tune temp = soundData.get(i);
			    soundData.set(i, soundData.get(i+1));
			    soundData.set(i+1, temp);
				swaps ++;
			}
		}
		}while(swaps > 0);
		for(int i = 0; i < soundData.size();i++) {
			String resultString = "";
			resultString += soundData.get(i).toString();
			result[i] = resultString;
		}
		return result;
		
		
		
		
		
		// add your implementation
	}
	/**
	 * This method gets the tune info of all the tunes using the toString method in tune
	 */
	public String[] getTuneInfo(Genre gen) {
		int swaps;
		int count = 0;
		String result[] = new String[soundData.size()];
		do {
			swaps = 0;
			for(int i = 0; i < soundData.size() - 1; i++) {
				if (soundData.get(i).getTitle().compareTo(soundData.get(i+1).getTitle())>0) {
				Tune temp = soundData.get(i);
			    soundData.set(i, soundData.get(i+1));
			    soundData.set(i+1, temp);
				swaps ++;
			}
		}
		}while(swaps > 0);
		for(int i = 0; i < soundData.size(); i++) {
			if (soundData.get(i).getStyle() == gen) {
				String resultString = "";
				resultString += soundData.get(i).toString();
				result[i] = resultString;
			}
		}
		return result;
	}
	/**
	 * This method gets the tune info of all the tunes using the toString method in tune
	 */
	public String[] getTuneInfo(String artist) {
		int swaps;
		int count = 0;
		String result[] = new String[soundData.size()];
		do {
			swaps = 0;
			for(int i = 0; i < soundData.size() - 1; i++) {
				if (soundData.get(i).getTitle().compareTo(soundData.get(i+1).getTitle())>0) {
				Tune temp = soundData.get(i);
			    soundData.set(i, soundData.get(i+1));
			    soundData.set(i+1, temp);
				swaps ++;
			}
		}
		}while(swaps > 0);
		for(int i = 0; i < soundData.size(); i++) {
			if (soundData.get(i).getArtist().equals(artist)) {
				String resultString = "";
				resultString += soundData.get(i).toString();
				result[i] = resultString;
				count ++;
			}
		}
		if (count == 0) {
			result = null;
		}
		
		return result;
		// add your implementation
	}
	/**
	 * 
	 * @param tuneId - the id of the tune
	 * @return - The string in the tune play function(Now playing ... + "title")
	 */
	public String play(int tuneId) {
		String result = null;

	    for(int i = 0; i < soundData.size(); i++) {
	        if(tuneId == soundData.get(i).getId()) {
	            result = soundData.get(i).play();
	        }
	    }
	    return result;

	        // complete this implementation
	    }
	/**
	 * This method switches off the MP3 Player
	 * @return returns false if it cannot be switched off(Its already off) and returns true otherwise
	 */
	public boolean switchOff() {
		if (isOn == true) {
		isOn = false;
		return true;
		}
		else {
			return false;
		}
	}
	/**
	 * This method switches on the MP3 Player
	 * @return returns false if it cannot be switched on(Its already on) and returns true otherwise
	 */
	public boolean switchOn() {
		if (isOn == false) {
			isOn = true;
			return true;
		}
		else {
			return false;
		}
	}
}
