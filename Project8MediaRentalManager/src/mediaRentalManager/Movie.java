package mediaRentalManager;

public class Movie implements Media {

	private final String title, rating;
	private int copiesAvailable;

	public Movie(String title, int copiesAvailable, String rating) {
		this.title = title;
		this.copiesAvailable = copiesAvailable;
		this.rating = rating;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setCopiesAvailable(int copiesAvailable) {
		this.copiesAvailable = copiesAvailable;
	}

	@Override
	public int getCopiesAvailable() {
		return copiesAvailable;
	}

	public String getRating() {
		return rating;
	}

	public String toString() {
		return "Title: " + title + ", Copies Available: " + copiesAvailable + ", Rating: " + rating;
	}

}
