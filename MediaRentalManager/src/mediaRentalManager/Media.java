package mediaRentalManager;

public class Media implements Comparable<Media>{
	private String title, rating, artist, songs;
	private int copiesAvailable;

	public Media(String title, int copiesAvailable, String rating) {
		this.title = title;
		this.rating = rating;
		this.copiesAvailable = copiesAvailable;
	}
	
	public Media(String title, int copiesAvailable, String artist, String songs) {
		this.title = title;
		this.artist = artist;
		this.songs = songs;
		this.copiesAvailable = copiesAvailable;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getRating() {
		return rating;
	}
	
	public int getCopiesAvailable() {
		return copiesAvailable;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getSongs() {
		return songs;
	}
	public void changeCopies(int number) {
		copiesAvailable += number;
	}
	@Override
	public int compareTo(Media media) {
		return getTitle().compareTo(media.getTitle());
	}
}
