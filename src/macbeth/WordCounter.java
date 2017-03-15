/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macbeth;
import java.util.*;
/**
 *
 * @author Michael
 */
public class WordCounter {
    private List<String> wordList;
    private List<Integer> wordCount;
    
    public WordCounter(){
        wordList = new ArrayList<String>();
        wordCount = new ArrayList<Integer>();
    }
    
    public void parseString(String input){
        String[] words = input.split("[^a-zA-Z']+");                                        //split the string into words, divided by any non alpha character or '
        for (int wordCounter=0; wordCounter<words.length; wordCounter++){
            if (words[wordCounter] == "") {continue;}                                       //Ignore empty strings
            int index = wordList.indexOf(words[wordCounter]);                               //Search the wordList for the next word and record its index
            if (index == -1) {wordList.add(words[wordCounter]); wordCount.add(1);}          //If the word isn't found, add it to the wordList and instatiate its count at 1
            else {wordCount.set(index, wordCount.get(index)+1);}                            //If the word is found, increment the corrisponding count by 1
        }
    }
    
    public String secondMostCommon(){
        int finalResultIndex = 0;
        int macbethIndex = wordList.indexOf("macbeth");                                                                 //Find and remove macbeth from the wordList and wordCount
        wordList.remove(macbethIndex);
        wordCount.remove(macbethIndex);
        for (int resultCounter=0; resultCounter<wordList.size(); resultCounter++){
            if (wordCount.get(resultCounter) > wordCount.get(finalResultIndex)){finalResultIndex=resultCounter;}        //Iteritavely compare the word counts and record the highest found.
        }
        return wordList.get(finalResultIndex) + " which appeared " + wordCount.get(finalResultIndex) + " times.";       //Return the values of wordList and wordCount at the recorded index
    }
    
}
