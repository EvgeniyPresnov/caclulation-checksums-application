/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.evgeniypresnov.gui;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This class describes the table for filling data about the file after 
 * calculation checking sum.
 * 
 * @author Evgeniy Presnov
 */
public class DataStore {
    /** The initialization a table.*/
    private TableView table = new TableView ();
    
    /**The initialization a size the table.*/
    private final int sizeWidth = 400;
    private final int sizeHeight = 400;
   
    /**
     * The construct initializes the columns of table, sets the scroll
     * and fill table using class Data 
     */
    public DataStore () {
        table.setPrefSize(sizeWidth, sizeHeight);
        /**Set a scroll*/
        ScrollPane scroll = new ScrollPane ();
        /**The set up of the scroll*/
        scroll.setVbarPolicy (ScrollBarPolicy.ALWAYS);
        scroll.setHbarPolicy (ScrollBarPolicy.ALWAYS);
        
        /**Initialize the columns of table*/
        TableColumn<Data, String> nameColumn 
            = new TableColumn<> ("File name");

        TableColumn<Data, String> sumColumn 
            = new TableColumn<> ("Checking sum");
        
        final int widthColumnName = 150;
        final int widthColumnSum = 300;
        
        /**Fill the table of data from ClassFillTable*/
        nameColumn.setCellValueFactory (new PropertyValueFactory<Data, 
            String> ("Name"));
        sumColumn.setCellValueFactory (new PropertyValueFactory<Data, 
            String> ("CheckSum"));
        
        /**Set the size for every column of the table*/
        nameColumn.setPrefWidth (widthColumnName);
        sumColumn.setPrefWidth (widthColumnSum);
        
        table.getColumns ().addAll (nameColumn, sumColumn);
        scroll.setContent (table);
    }
    
    /** 
     * Returns an instance of TableView.
     * 
     * @return 
     */
    public TableView getInstance () {
        return table;
    }
    
    /***
     * This method allows fill table, when user clicks "Open" Button. Then open 
     * the directory (/home by default), where user can choose a file or several
     * files.
     * 
     * @param table
     * @param files
     * @param sum
     * @throws IOException, if user forget to chose the algorithm for checking sum 
     * and in log will output INFO message.
     */
    public void addRowsToTable (TableView table, List<File> files, 
        CalculatorCheckSum sum) throws IOException {
        try {
            if (files == null || files.isEmpty ()) {
                return;
            }
            for (File file: files) {
                table.getItems ().add (new Data (file.getName (),
                        sum.chooseAlgorithm (file.getName (), file.getPath ()))); 
            }
        }
        catch (IOException ex) {
            ex.printStackTrace ();
            Logger.getLogger (PanelButton.class.getName ()).log (Level.SEVERE, 
                "Cannot add the file to table because it is empty", ex);
        }
    }
}
