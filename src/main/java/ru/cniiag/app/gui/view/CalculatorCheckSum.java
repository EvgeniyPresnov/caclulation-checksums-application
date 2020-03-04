/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This class consists the fields and methods for calculating checking sum
 * invoking shell console for it. It provides a choice the several algorithm of
 * calculation checking sum, when user clicks the RadionButton.
 * 
 * @author Evgeniy Presnov
 */
public class CalculatorCheckSum {
    /**
     * This method invokes from shell commands to calculate the
     * checking sum for file
     * 
     * @param fileName
     * @param filePath
     * @param command
     * @return string thats has checking sum of file
     * @throws Exception 
     */
    public String calculateFile (String fileName, String filePath, 
        String command) throws Exception {
        
        String line = "";
        String pattern = " ";
        StringBuilder result = new StringBuilder ();
        
        Process process = Runtime.getRuntime (). exec (command + " " + filePath
            + " " + fileName);
        BufferedReader reader = new BufferedReader (new InputStreamReader (
            process.getInputStream ()));
        
        while ( (line = reader.readLine() ) != null) {
            result.append (line);
        }
        
        String[] splitResult = result.toString ().split (pattern);
        return splitResult [0];
    }
}
