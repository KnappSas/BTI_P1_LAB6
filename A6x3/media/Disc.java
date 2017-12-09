package media;

public abstract class Disc {
	private String title;
	private MediaType type;

	protected Disc(String title, MediaType type) {
		this.title = title;
		this.type = type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disc other = (Disc) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("[<%s>: Title=%s, MediaType=%s]", Disc.class.getSimpleName(), title, type);
	}
}
