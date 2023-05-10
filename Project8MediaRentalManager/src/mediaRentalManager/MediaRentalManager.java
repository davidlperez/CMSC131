package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import tests.PublicTests;

public class MediaRentalManager implements MediaRentalManagerInt {

	private final ArrayList<Customer> customers = new ArrayList<>();
	private final ArrayList<Media> mediaList = new ArrayList<>();
	private int limitedPlanLimit = 2;

	public void addCustomer(String name, String address, String plan) {
		customers.add(new Customer(name, address, plan));
	}

	public void addMovie(String title, int copiesAvailable, String rating) {
		mediaList.add(new Movie(title, copiesAvailable, rating));

	}

	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		mediaList.add(new Album(title, copiesAvailable, artist, songs));

	}

	public void setLimitedPlanLimit(int value) {
		this.limitedPlanLimit = value;
	}

	public String getAllCustomersInfo() {
		Collections.sort(customers);
		String custStr = "***** Customers' Information *****\n";
		for (Customer customer : customers) {
			custStr += customer.toString() + "\n";
			custStr += "Rented: " + customer.getRented() + "\n";
			custStr += "Queue: " + customer.getQueue() + "\n";
		}
		return custStr;
	}

	public String getAllMediaInfo() {
		Collections.sort(mediaList);
		String mediaStr = "***** Media Information *****\n";
		for (Media media : mediaList) {
			mediaStr += media.toString() + "\n";
		}
		return mediaStr;
	}

	public boolean addToQueue(String customerName, String mediaTitle) {
		Customer customer = stringToCustomer(customerName);
		if (!customer.getQueue().contains(mediaTitle)) {
			customers.remove(customer);
			customer.getQueue().add(mediaTitle);
			customers.add(customer);
			return true;
		}
		return false;
	}

	public boolean removeFromQueue(String customerName, String mediaTitle) {
		Customer customer = stringToCustomer(customerName);
		customers.remove(customer);

		boolean success = customer.getQueue().remove(mediaTitle);

		customers.add(customer);

		return success;
	}

	public String processRequests() {
		Collections.sort(customers);

		String text = "";
		for (Customer customer : customers) {
			ArrayList<String> queueCopy = new ArrayList<>(customer.getQueue());
			for (int i = 0; i < queueCopy.size(); i++) {
				if (customer.getRentalPlan().equals("LIMITED")) {
					if (i >= limitedPlanLimit) {
						break;
					}
				}

				String title = queueCopy.get(i);
				Media media = stringToMedia(title);

				if (!(media == null || media.getCopiesAvailable() <= 0)) {
					text += "Sending " + title + " to " + customer.getName() + "\n";
					customer.getQueue().remove(title);
					customer.getRented().add(title);
					takeMediaCopies(media, 1);
				}
			}

		}
		return text;
	}

	public boolean returnMedia(String customerName, String mediaTitle) {
		Collections.sort(customers);
		Customer customer = stringToCustomer(customerName);
		Media media = stringToMedia(mediaTitle);
		customers.remove(customer);
		customer.getRented().remove(mediaTitle);
		customers.add(customer);
		media.setCopiesAvailable(media.getCopiesAvailable() + 1);
		return true;
	}

	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		ArrayList<String> results = new ArrayList<>();
		Collections.sort(mediaList);
		if (title == null && rating == null && artist == null && songs == null) {
			return new ArrayList<>(mediaToString(mediaList));
		}

		for (Media media : mediaList) {
			if (media instanceof Movie) {
				Movie movie = (Movie) media;
				if (title == null && rating == null) {
					continue;
				} else if (title != null && rating == null && artist == null && songs == null) {
					if (movie.getTitle().equals(title)) {
						results.add(movie.getTitle());
					}
				} else if (title == null && rating != null && artist == null && songs == null) {
					if (movie.getRating().equals(rating)) {
						results.add(movie.getTitle());
					}
				} else if (title != null && rating != null && artist == null && songs == null) {
					if (movie.getTitle().equals(title) && movie.getRating().equals(rating)) {
						results.add(movie.getTitle());
					}
				}
			} else if (media instanceof Album) {
				Album album = (Album) media;
				if (title == null && artist == null && songs == null) {
					continue;
				} else if (title != null && rating == null && artist == null && songs == null) {
					if (album.getTitle().equals(title)) {
						results.add(album.getTitle());
					}
				} else if (title == null && rating == null && artist != null && songs == null) {
					if (album.getArtist().equals(artist)) {
						results.add(album.getTitle());
					}
				} else if (title == null && rating == null && artist == null && songs != null) {
					if (album.searchSong(songs)) {
						results.add(album.getTitle());
					}
				} else if (title != null && rating == null && artist != null && songs == null) {
					if (album.getTitle().equals(title) && album.getArtist().equals(artist)) {
						results.add(album.getTitle());
					}
				} else if (title == null && rating == null && artist != null && songs != null) {
					if (album.getArtist().equals(artist) && album.searchSong(songs)) {
						results.add(album.getTitle());
					}
				} else if (title != null && rating == null && artist == null && songs != null) {
					if (album.getTitle().equals(title) && album.searchSong(songs)) {
						results.add(album.getTitle());
					}
				} else if (title != null && rating == null && artist != null && songs != null) {
					if (album.getTitle().equals(title) && album.getArtist().equals(artist) && album.searchSong(songs)) {
						results.add(album.getTitle());
					}
				}
			}

		}
		return results;
	}

	private ArrayList<String> mediaToString(ArrayList<Media> mediaList) {
		ArrayList<String> titles = new ArrayList<>();

		for (Media media : mediaList)
			titles.add(media.getTitle());

		return titles;
	}

	private void takeMediaCopies(Media media, int copies) {
		mediaList.remove(media);
		int copiesAvailable = media.getCopiesAvailable() - copies;

		if (copiesAvailable <= 0) {
			copiesAvailable = 0;
		}

		media.setCopiesAvailable(copiesAvailable);
		mediaList.add(media);

	}

	private Media stringToMedia(String mediaTitle) {
		for (Media media : mediaList) {
			if (media.getTitle().equals(mediaTitle)) {
				return media;
			}
		}

		return null;
	}

	private Customer stringToCustomer(String custName) {
		for (Customer customer : customers) {
			if (customer.getName().equals(custName)) {
				return customer;
			}
		}
		return null;
	}
}
