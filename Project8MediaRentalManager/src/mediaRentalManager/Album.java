package mediaRentalManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Album implements Media {

	private final String title, songs, artist;
	private int copiesAvailable;
	private final ArrayList<String> songsList = new ArrayList<>();

	public Album(String title, int copiesAvailable, String artist, String songs) {
		this.title = title;
		this.copiesAvailable = copiesAvailable;
		this.songs = songs;
		this.artist = artist;
	}

	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}

	public String getSongs() {
		return songs;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public String toString() {
		return "Title: " + title + ", Copies Available: " + copiesAvailable + ", Artist: " + artist + ", Songs: "
				+ songs;
	}
	
	private void songsToList(String songz) {
		int count = 0;
		int searchStart = 0;
		int strIndex = 0;
		for (int i = 0; i < songz.length(); i++) {
			if (songz.charAt(i) == ',') {
				count++;
			}
		}
		for (int i = 0; i < count; i++) {
			strIndex = songz.indexOf(',', searchStart);

			songsList.add(songz.substring(searchStart, strIndex));
			searchStart = strIndex + 2;
		}
		songsList.add(songz.substring(searchStart));
	}

	public boolean searchSong(String songz) {
		songsToList(songz);
		for (int i = 0; i < songsList.size(); i++) {
			String song = songsList.get(i);
			if (songs.contains(song) && songsList.contains(song)) {
				return true;
			}
		}
		return false;
	}

}
