/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.evgeniypresnov.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class consists the fields and methods for calculating checking sum
 * invoking shell console for it. It provides a choice the several algorithm of
 * calculation checking sum, when user clicks the RadionButton.
 * 
 * @author Evgeniy Presnov
 */
public class CalculatorCheckSum {
    /**The Initialization the fields of class.*/
    private String algorithm = "";
    private String command = "";
    
    /**
     * This method invokes from shell commands to calculate the
     * checking sum for file.
     * 
     * @param fileName
     * @param filePath
     * @param command
     * @return string thats has checking sum of file
     * @throws IOException, if problem input/output appears.
     */
    public String checkSum (String fileName, String filePath, 
        String command) throws IOException {

        Process process = Runtime.getRuntime ().exec (
            command + " " + filePath + " " + fileName);
        
        BufferedReader reader = new BufferedReader (
        new InputStreamReader (process.getInputStream ()));
        
        String line = "";
        String pattern = " ";
        StringBuilder resultString = new StringBuilder ();
        
        while ( (line = reader.readLine () ) != null) {
            resultString.append (line);
        }
        reader.close ();
        
        String[] splitResult = resultString.toString ().split (pattern);
        return splitResult[0];
    }
    
    /**
     * Set a algorithm of checking sum.
     * 
     * @param algorithm 
     */
    public void setAlgorithm (String algorithm) {
        this.algorithm = algorithm;
    }
    
    /**
     * This method provides the choice of algorithm of checking sum. User clicks
     * on the RadioButton and will be invoke appropriate a shell command for 
     * checking sum.
     * 
     * @param fileName
     * @param filePath
     * @return
     * @throws IOException, if problem input/output appears.
     */
    public String chooseAlgorithm (String fileName, String filePath) throws IOException {
        if (algorithm == "MD5") {
            command = "md5sum"; 
        }
        else if (algorithm == "SHA-1") {
            command = "sha1sum";
        }
        else if (algorithm == "SHA-224") {
            command = "sha224sum"; 
        }
        else if (algorithm == "SHA-256") {
            command = "sha256sum";
        }
        else if (algorithm == "SHA-384") {
            command = "sha384sum";   
        }  
        else if (algorithm == "SHA-512") {
            command = "sha512sum";
        } 
        return checkSum (fileName, filePath, command);
    }   
}

