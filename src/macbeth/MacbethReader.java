package macbeth;
import java.util.*;
import java.io.*;
import java.nio.*;
/**
 *
 * @author Michael
 */
public class MacbethReader {
    List<String> fullText = new ArrayList<String>();
    
    public MacbethReader() throws FileNotFoundException {
        this.storeText();
    } 
 
    private void storeText() throws FileNotFoundException{
        try{
            File macbethText = new File("macbeth.txt"); 
            Scanner scanner = new Scanner(macbethText);
            try{
                while (scanner.hasNextLine()) {
                    fullText.add(scanner.nextLine());
                }
            } finally {scanner.close();}
        } catch (FileNotFoundException e) {System.exit(1);}
        this.prune();
    }
    
    public String getLine(int lineNumber){
        return fullText.get(lineNumber);
    }
    
    public boolean hasNextLine(int line){
        return fullText.size() > line+1;
    }
    
    private void prune(){
        for (int lineCounter=0; lineCounter < fullText.size(); lineCounter++ ){
            String[] words = fullText.get(lineCounter).split("[^a-zA-Z']+");               //Pull next line from the script
            String finalString = "";
            for (int wordCounter=0; wordCounter<words.length; wordCounter++ ){
                if (words[wordCounter].length() > 4) {finalString+=words[wordCounter].toLowerCase()+" ";}         //If word is large enough add it back to the script, else continue
            }
            fullText.set(lineCounter, finalString);
        }
    }
}
    
