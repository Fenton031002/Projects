package part01;

public class Tune {
	private int id;
	private static int nextId = 1;
	private String title;
	private String artist;
	private int duration;
	private int playcount;
	private Genre style;
	public Tune(String title, String artist, int duration, Genre style) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.style = style;
        this.id = nextId++;
        this.playcount = 0;
    }
	public String getTitle() {
		return this.title;
	}
	public String getArtist() {
		return this.artist;
	}
	public int getId() {
		return this.id;
	}
	public int getDuration() {
		return this.duration;
	}
	public void setId() {
		this.id = id;
	}
	public Genre getStyle() {
		return this.style;
	}
	public int getplayCount() {
		return this.playcount;
	}
	public String toString() {
		String result = getId() + "," + getTitle() +"," + getArtist() +"," + getDuration() + "," + getStyle() + "," + getplayCount();
		return result;
	}
	public String play() { 
		String result = "Now Playing ... " +getTitle() +", by " + getArtist();
		playcount ++;
		return result;
	}

}
