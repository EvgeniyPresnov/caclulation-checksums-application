/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui.view;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.cniiag.app.gui.model.DataModel;

/**
 * This class describes the table for filling data about the file after 
 * calculation checking sum.
 * 
 * @author Evgeniy Presnov
 */
public class DataStore {
    /** The initialization a table.*/
    private final TableView table = new TableView ();
    
     /**The initialization a size the table.*/
    private final int sizeWidth = 400;
    private final int sizeHeight = 400;
    
     /**Set the size for every column of the table.*/
    private final int widthColumnName = 150;
    private final int widthColumnSum = 300;
    
    /*Set the default data for the file.*/
    private String initDir = "/home/";
    private String formatFile = "TXT files";
    private String expansionFile = "*.txt";
    
    /**
     * The construct initializes the columns of table, sets the scroll
     * and fill table using class Data. 
     */
    public DataStore () {
        table.setPrefSize (sizeWidth, sizeHeight);
        
        /*The initialization a scroll and set the set up for this object.*/
        ScrollPane scroll = new ScrollPane ();
        scroll.setVbarPolicy (ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.setHbarPolicy (ScrollPane.ScrollBarPolicy.ALWAYS);
        
        /**Initialize the columns of table.*/
        TableColumn <DataModel, String> nameColumn = 
            new TableColumn<> ("File name");
        
        TableColumn <DataModel, String> sumColumn = 
            new TableColumn<> ("Checking sum");
        
         /**Fill the table of data from ClassFillTable.*/
        nameColumn.setCellValueFactory (new PropertyValueFactory <DataModel, 
            String> ("Name") );
        sumColumn.setCellValueFactory (new PropertyValueFactory <DataModel, 
            String> ("CheckSum") );
        
        nameColumn.setPrefWidth (widthColumnName);
        sumColumn.setPrefWidth (widthColumnSum);
        
        table.getColumns ().addAll (nameColumn, sumColumn);
        scroll.setContent (table);
    }
    
    /** 
     * Returns an instance of TableView.
     * 
     * @return table
     */
    public TableView getInstance () {
        return table;
    }
    
    /**
     * Set the format for the file.
     * 
     * @param format 
     */
    public void setFormatForFile (String format) {
        formatFile = format;
    }
    
    /**
     * Set the expansion for the file.
     * 
     * @param expansion 
     */
    public void setExpansionForFile (String expansion) {
        expansionFile = expansion;
    }
    
    /**
     * Set the directory by default for file.
     * 
     * @param dir 
     */
    public void setInitDir (String dir) {
        initDir = dir;
    }
    
    /**
     * Returns the format of file.
     * 
     * @return formatFile
     */
    public String getFormatForFile () {
        return formatFile;
    }
    
    /**
     * Returns the expansion of file.
     * 
     * @return expansionFile 
     */
    public String getExpansionForFile () {
        return expansionFile;
    }
    
    /**
     * Returns the directory.
     * 
     * @return initDir
     */
    public String getInitDir () {
        return initDir;
    }
}
