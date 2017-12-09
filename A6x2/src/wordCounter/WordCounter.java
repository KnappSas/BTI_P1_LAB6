package wordCounter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCounter {

	final Map<Word, Counter> wordCountMap = new HashMap<>();

	/**
	 * @param path path to testfile to count words from
	 */
	public void printStatistic(String path) {
		WordGrabber wg = new WordGrabber(path);
		while (wg.hasNext()) {
			Word word = new Word(wg.next());
			Counter counter = wordCountMap.get(word);
			if (!wordCountMap.containsKey(word)) {
				counter = new Counter();
				wordCountMap.put(word, counter);
			}
			
			counter.inc();
		}
		
		final List<Word> words = new ArrayList<>(wordCountMap.keySet());
		Collections.sort(words);
		for (Word w : words) {
			System.out.println("[" + w + "] : " + wordCountMap.get(w));
		}
	}
}
