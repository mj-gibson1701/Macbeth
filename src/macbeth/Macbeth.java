/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macbeth;

import java.io.FileNotFoundException;

/**
 *
 * @author Michael
 */
public class Macbeth {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        MacbethReader script = new MacbethReader();
        WordCounter wc = new WordCounter();
        
        int count=0;
        while(script.hasNextLine(count)) {
            wc.parseString(script.getLine(count));
            count++;
        }
        System.out.println(wc.secondMostCommon());
    }
    
}
