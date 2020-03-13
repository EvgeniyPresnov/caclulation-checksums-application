/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class provides the ability to use the command line to invoke the 
 * command to calculate the checking sum for a file.
 * 
 * @author Evgeniy Presnov
 */
public final class CalculatorCheckSum {
    
    /**
     * This method uses the parameters to calculate the checking sum of file by 
     * invoking the command from the command line.
     * 
     * @param fileName
     * @param filePath
     * @param command
     * @return splitResult[0] 
     * @throws IOException 
     */
    public static String calculateFile (
        String fileName
        , String filePath 
        , String command) throws IOException {
        
        StringBuilder result = new StringBuilder ();
        
        /**
         * The run the command from prompt command.
         */
        Process process = Runtime.getRuntime ()
        . exec (command + " " + filePath + " " + fileName);
        
        BufferedReader reader = new BufferedReader (new InputStreamReader 
            (process.getInputStream ()));
        reader.close();
        
        String line = null;
        /**
         * Read the output from the command.
         */
        while ( (line = reader.readLine() ) != null) {
            result.append (line);
        }
        
        /**
         * Set the template to searching for the 
         * first match in the resulting string.
         */
        String pattern = " ";
        
        /**
         * This line allows to split the string according to the pattern,
         * where the first element of the array is the checking sum.
         */
        String[] splitResult = result.toString ().split (pattern);
        return splitResult[0];
    }
}
