
package macbeth;
import java.util.*;
/**
 *
 * @author Michael
 */
public class WordCounter {

    private Map<String, Integer> wordMap;
    
    public WordCounter(){
        wordMap = new HashMap<String, Integer>();
    }
    
    public void parseString(String input){
    	if (input.isEmpty()) {return;}
        String[] words = input.split("[^a-zA-Z']+");                                        //split the string into words, divided by any non alpha character or '
        for (int wordCounter=0; wordCounter<words.length; wordCounter++){
        	if (!wordMap.isEmpty() && wordMap.containsKey(words[wordCounter])) {
        		wordMap.put(words[wordCounter], wordMap.get(words[wordCounter]) + 1);
        	}
        	else { wordMap.put(words[wordCounter], 1); }
        }
    }
    
    public String secondMostCommon(){
    	String maxKey = Collections.max(wordMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    	wordMap.remove(maxKey);
    	maxKey = Collections.max(wordMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    	return maxKey + " which appeared " + wordMap.get(maxKey) + " times.";
    }
    
}
