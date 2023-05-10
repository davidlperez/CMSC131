package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import mediaRentalManager.MediaRentalManager;

public class StudentTests {
	@Test
	public void testSearchMedia1() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		StringBuffer resultsBuffer = new StringBuffer();
		MediaRentalManager manager = new MediaRentalManager();
		loadMediaData(manager);

		ArrayList<String> searchResults = manager.searchMedia(null, "PG", null, null);
		resultsBuffer.append("PG Search: " + searchResults);

		searchResults = manager.searchMedia("Rocky", "PG", null, null);
		resultsBuffer.append("\nTitle Search: " + searchResults);

		searchResults = manager.searchMedia(null, null, null, "Smooth Criminal, Mirror, Remember the Time, Far Away");
		resultsBuffer.append("\nSong Search: " + searchResults);
		
		searchResults = manager.searchMedia("Bad", "PG", "Mike J", "Mirror");
		resultsBuffer.append("\nAlbum Search: " + searchResults);
		
		searchResults = manager.searchMedia(null, null, null, null);
		resultsBuffer.append("\nNull Search: " + searchResults);

		assertTrue(TestingSupport.isResultCorrect(testName, resultsBuffer.toString(), true));
	}

	@Test
	public void testSearchMedia2() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();

		StringBuffer resultsBuffer = new StringBuffer();
		MediaRentalManager manager = new MediaRentalManager();
		loadMediaData(manager);

		ArrayList<String> searchResults = manager.searchMedia("Good", null, null, null);
		resultsBuffer.append("Invalid Search: " + searchResults);
		
		searchResults = manager.searchMedia("Rocky", "R", null, "Mirror");
		resultsBuffer.append("\nInvalid Search: " + searchResults);
		
		assertTrue(TestingSupport.isResultCorrect(testName, resultsBuffer.toString(), true));
	}
	/* Private support methods */
	private static void loadCustomersData(MediaRentalManager manager) {
		String limited = "LIMITED", unlimited = "UNLIMITED";

		String[] names = { "Smith, John", "Albert, Mike", "Park, Laura" };
		String[] addresses = { "354 South J Ave MD", "11 Apple Mount VA", "227 Park Lane DC" };
		String[] plans = { unlimited, limited, unlimited };
		if ((names.length != addresses.length) && (addresses.length != plans.length)) {
			System.err.println("Invalid data in loadCustomerData");
			System.exit(0);
		}

		for (int i = 0; i < names.length; i++) {
			manager.addCustomer(names[i], addresses[i], plans[i]);
		}
	}

	private static void loadMediaData(MediaRentalManager manager) {

		/* Loading movies */
		String title[] = { "Rocky", "Jaws", "Mickey", "Gone with the Wind" };
		int[] copiesAvailable = { 3, 4, 1, 2 };
		String[] rating = { "PG", "R", "PG", "PG" };

		if ((title.length != copiesAvailable.length) && (copiesAvailable.length != rating.length)) {
			System.err.println("Invalid data in loadMedia (loading movies)");
			System.exit(0);
		}

		for (int i = 0; i < title.length; i++) {
			manager.addMovie(title[i], copiesAvailable[i], rating[i]);
		}

		/* Loading Albums */
		String albumTitle[] = { "Bad", "Journey" };
		int[] albumCopiesAvailable = { 2, 1 };
		String[] albumArtist = { "Mike J", "ABBA" };
		String[] albumSongs = { "Mirror, Far Away, Remember the Time, Smooth Criminal", "Yesterday, Hello" };

		if ((albumTitle.length != albumCopiesAvailable.length) && (albumCopiesAvailable.length != albumArtist.length)
				&& (albumArtist.length != albumSongs.length)) {
			System.err.println("Invalid data in loadMedia (loading albums)");
			System.exit(0);
		}

		for (int i = 0; i < albumTitle.length; i++) {
			manager.addAlbum(albumTitle[i], albumCopiesAvailable[i], albumArtist[i], albumSongs[i]);
		}
	}
}
