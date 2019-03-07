
public class CompactDisc {
	private String artist;
	private String album;
	private String language;
	
	public CompactDisc() {
		artist = "";
		album = "";
		language = "";
	}
	
	public CompactDisc(String artist, String album, String language) {
		this.artist = artist;
		this.album = album;
		this.language = language;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public void setAlbum(String album) {
		this.album = album;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public String toString() {
		return "Artist : " + artist + " Album : " + album + " Language : " + language;
	}
}
