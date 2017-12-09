package media;

public class DVD extends Disc {

	DVDFormat format;

	public DVD(String title, MediaType type, DVDFormat format) {
		super(title, type);
		this.format = format;
	}

	@Override
	public boolean equals(Object other) {
		boolean equal = super.equals(other);
		if (getClass() != other.getClass())
			return false;
		return ((DVD) other).format.equals(this.format) && equal;
	}

	@Override
	public String toString() {
		return String.format("[<%s>: Format=%s %s]", DVD.class.getSimpleName(), format, super.toString());
	}
}
