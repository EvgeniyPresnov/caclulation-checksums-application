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
 * This class describes the table for filling data.
 * 
 * @author Evgeniy Presnov
 */
public final class DataStore {
    /**
     * Creating the table.
     */
    private final TableView table = new TableView ();
    
    /**
     * Set the size for table.
     */
    private final int TABLE_SIZE_WIDTH = 400;
    private final int TABLE_SIZE_HEIGHT = 400;
    
    /**
     * Set the directory where the user will select a
     * file from the file system.
     */
    private String initDir = "/home/";
    
    /**
     * Set the file format.
     */
    private String format = "TXT files";
    
    /**
     * Set the expansion for file.
     */
    private String expansion = "*.txt";
   
    /**
     * The constructor initializes the columns of table. 
     * 
     */
    public DataStore () {
        table.setPrefSize(TABLE_SIZE_WIDTH, TABLE_SIZE_HEIGHT);

        /**
         * Creating the scroll.
         */
        ScrollPane scroll = new ScrollPane ();
        
        /**
         * Set up the scroll. 
         */
        scroll.setVbarPolicy (ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.setHbarPolicy (ScrollPane.ScrollBarPolicy.ALWAYS);
        
        /**
         * Set the column for displaying the name.
         */
        TableColumn<DataModel, String> nameColumn 
            = new TableColumn<> ("File name");
        
        /**
         * Set the column for displaying the checking sum.
         */
        TableColumn<DataModel, String> sumColumn 
            = new TableColumn<> ("Checking sum");
        
        /**
         * Set the size for two columns.
         */
        final int NAME_COLUMN_WIDTH = 150;
        final int SUM_COLUMN_WIDTH = 300;
        
        /**
         * Define how to fill data for each cell.
         */
        nameColumn.setCellValueFactory (new PropertyValueFactory<DataModel, 
            String> ("Name"));
        sumColumn.setCellValueFactory (new PropertyValueFactory<DataModel, 
            String> ("CheckSum"));
        
        nameColumn.setPrefWidth (NAME_COLUMN_WIDTH);
        sumColumn.setPrefWidth (SUM_COLUMN_WIDTH);
        
        table.getColumns ().addAll (nameColumn, sumColumn);
        scroll.setContent (table);
    }
    
    /**
     * Return the table.
     * 
     * @return table 
     */
    public TableView getTableView () {
        return table;
    }
    
    /**
     * Set the file format.
     * 
     * @param format 
     */
    public void setFormatForFile (String format) {
        this.format = format;
    }
    
    /**
     * Set the file expansion.
     * 
     * @param expansion 
     */
    public void setExpansionForFile (String expansion) {
        this.expansion = expansion;
    }
    
    /**
     * Set the directory.
     * 
     * @param initDir 
     */
    public void setInitDir (String initDir) {
        this.initDir = initDir;
    }
    
    /**
     * Return the file format.
     * 
     * @return 
     */
    public String getFormatForFile () {
        return format;
    }
    
    /**
     * Return the file expansion.
     * 
     * @return expansion
     */
    public String getExpansionForFile () {
        return expansion;
    }
    
    /**
     * Return the directory.
     * 
     * @return initDir
     */
    public String getInitDir () {
        return initDir;
    }
}
