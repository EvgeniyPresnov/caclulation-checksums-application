/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui.model;

/**
 * This class defines the data model.Based on this class, we will generate 
 * data for filling in the table.
 * 
 * @author Evgeniy Presnov
 */
public final class DataModel {
    /**
     *Storing the file name.
     */
    private String fileName = "";
    
    /**
     * Storing the checking sum.
     */
    private String checkSum = "";
    
    /**
     * The constructor accepts the parameters for initializing 
     * fields of this class.
     * 
     * @param fileName
     * @param checkSum 
     */
    public DataModel (String fileName, String checkSum) {
        this.fileName = fileName;
        this.checkSum = checkSum;
    }
    
    /**
     * Set the name for the file.
     * 
     * @param name 
     */
    public void setName (String name) {
        fileName = name;
    }
    
    /**
     * Set the checking sum for the file.
     * 
     * @param sum 
     */
    public void setCheckSum (String sum) {
        checkSum = sum;
    }
    
    /**
     * Return the name of file.
     * 
     * @return 
     */
    public String getName () {
        return fileName;
    }
    
    /**
     * Return the checking sum of file.
     * 
     * @return 
     */
    public String getCheckSum () {   
        return checkSum;
    }
}
