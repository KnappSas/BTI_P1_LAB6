package wordCounter;

public class Word implements Comparable<Object> {
	final private String word;
	
	
	public Word(String word) {
		this.word = word;
	}

    @Override
    public boolean equals(Object other) {
        return word.toLowerCase().equals(((Word)other).word.toLowerCase());
    }
    
    @Override
    public int hashCode() {
        return word.hashCode();
}

	@Override
	public int compareTo(Object other) {
		return word.compareTo(((Word)other).word);
	}

	@Override
	public String toString() {
		return word;
	}
}
