package media;

public class CD extends Disc {

	private String artist;

	public CD(String title, MediaType type, String artist) {
		super(title, type);
		this.artist = artist;
	}

	@Override
	public boolean equals(Object other) {
		boolean equal = super.equals(other);
		if (getClass() != other.getClass())
			return false;
		return ((CD) other).artist.equals(this.artist) && equal;
	}

	@Override
	public String toString() {
		return String.format("[<%s>: Artist=%s %s]", CD.class.getSimpleName(), artist, super.toString());
	}
}
