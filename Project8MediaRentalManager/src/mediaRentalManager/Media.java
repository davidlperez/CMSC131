package mediaRentalManager;

public interface Media extends Comparable<Media> {

	public String getTitle();

	public void setCopiesAvailable(int copiesAvailable);

	public int getCopiesAvailable();

	public default int compareTo(Media media) {
		return this.getTitle().compareTo(media.getTitle());
	}

}
