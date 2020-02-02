/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.evgeniypresnov.gui;

/**
 * This class defines the data model. Based on this class, we will generate 
 * data for filling in the table.
 * 
 * @author Evgeniy Presnov
 */
public class Data {
    /**The initialization a name of the file.*/
    private String fileName = "";

     /**The initialization a checking sum of file.*/
    private String checkSum = "";
    
    /**
     * The initialization the object.
     * 
     * @param fileName
     * @param checkSum
     */
    public Data (String fileName, String checkSum) {
        this.fileName = fileName;
        this.checkSum = checkSum;
    }
    
    /**
     * Set a value of the name.
     * 
     * @param name 
     */
    public void setName (String name) {
        fileName = name;
    }
    
    /**
     * Set a value of checking sum.
     *
     * @param sum 
     */
    public void setCheckSum(String sum) {
        checkSum = sum;
    }
    
    /**
     * Returns the name of file.
     * 
     * @return
     */
    public String getName () {
        return fileName;
    }
    
    /**
     * Returns the checking sum of file.
     * 
     * @return 
     */
    public String getCheckSum () {   
        return checkSum;
    }
}

