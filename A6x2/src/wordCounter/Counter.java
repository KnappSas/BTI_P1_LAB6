package wordCounter;

public class Counter {

	private int counter;
	
	public Counter() {
		counter = 0;
	}
	
	public void inc() {
		counter++;
	}

	@Override
	public String toString() {
		return Integer.toString(counter);
	}
}
