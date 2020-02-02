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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * This class implementations the actions, when user clicks on buttons.
 *
 * @author Evgeniy Presnov
 */
public class PanelButton {
    /**These fields create and initialize class Button .*/
    private final Button openButton = new Button ("Open");
    private final Button delButton = new Button ("Remove row from table");
    private final Button addButton = new Button ("Add file to table");
    
    /**This field create a group, where all RadioButtons will be placed. */
    private final ToggleGroup group = new ToggleGroup ();
    
    /**These fields create and initialize class RadioButton.*/
    private final RadioButton btnMD5 = new RadioButton ("MD5");
    private final RadioButton btnSHA1 = new RadioButton ("SHA-1");
    private final RadioButton btnSHA224 = new RadioButton ("SHA-224");
    private final RadioButton btnSHA256 = new RadioButton ("SHA-256");
    private final RadioButton btnSHA384 = new RadioButton ("SHA-384");
    private final RadioButton btnSHA512 = new RadioButton ("SHA-512");
    
    private final Label labelForRadioButtons = new Label ("The choice of algorithm "
        + "of calculation  " + "\n" + " of checking sum");
    
    private final Label labelForOpenButton = new Label ("Open the directory "
        + "/home/user_name/");
    
    /**The field creates and initializes a layout, where all buttons 
    * will be placed.
    */
    private final VBox boxRadioButton = new VBox ();
    
    /***
     * The placement of the buttons on the group.
     */
    public PanelButton () {        
        btnMD5.setToggleGroup (group);
        btnSHA1.setToggleGroup (group);
        btnSHA224.setToggleGroup (group);
        btnSHA256.setToggleGroup (group);
        btnSHA384.setToggleGroup (group);
        btnSHA512.setToggleGroup (group);   
    }
    
    /**
     * Returns the label of RadioButtons.
     * 
     * @return 
     */
    public Label getLabelForRadioButtons () {
        return labelForRadioButtons;
    }
    
    /**
     * Returns the label of 'Open' Buttons.
     * 
     * @return 
     */
    public Label getLabelForOpenButton() {
        return labelForOpenButton;
    }
    
    /**
     * This method allows navigating in file system, when user clicks 
     * on "Open" button. In the set up the /home directory initializes by
     * default.
     * 
     * @throws IOException, If user forget to chose the algorithm for checking sum 
     * and in log will output INFO message.
     * @param table
     * @param sum 
     */
    public void openFileSystem (final DataStore table, 
        final CalculatorCheckSum sum) {
        
        openButton.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle (ActionEvent event) {
                FileChooser fileChooser = new FileChooser ();
                fileChooser.setInitialDirectory (new File ("/home/"));
                FileChooser.ExtensionFilter filterOne = 
                    new FileChooser.ExtensionFilter ("TXT files (*.txt)", "*.txt");
                FileChooser.ExtensionFilter filterTwo = 
                    new FileChooser.ExtensionFilter ("All files", "*.");
                fileChooser.getExtensionFilters ().addAll (filterOne, filterTwo);
                
                List<File> files = fileChooser.showOpenMultipleDialog (null);
                
                try {
                    table.addRowsToTable (table.getInstance (), files, sum);
                } 
                catch (IOException ex) {
                    ex.printStackTrace ();
                    Logger.getLogger (PanelButton.class.getName ()).
                       log (Level.SEVERE, "Cannot to invoke into initial directory", ex);
                }
            }     
        });
        
    }
    
    /**
     * This method give an possibility to delete unnecessary row from table, if 
     * user wishes it to do. It happens if user clicks "Delete row from table"
     * button.
     * 
     * @param table 
     */
    public void deleteRowFromTable (final DataStore table) {
        delButton.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle (ActionEvent event) {
                int selectedRow = table.getInstance ().getSelectionModel ().getSelectedIndex ();
                
                if (selectedRow >= 0) {
                    table.getInstance ().getItems ().remove (selectedRow);
                }
            }
        });
    }
    
    /**
     * This method implements an another way to navigate in file system.
     * 
     * @throws IOException, If user forget to choose the algorithm for checking sum 
     * and in log will output INFO message.
     * @param tree
     * @param table
     * @param sum 
     */
    public void addFileFromTreeToTable (final FileSystem tree, 
        final DataStore table, final CalculatorCheckSum sum) {
        addButton.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle (ActionEvent event) {
                try {
                    table.getInstance ().getItems ().add(new Data (tree.getFileName (),
                        sum.chooseAlgorithm (tree.getFileName (), tree.getCheckSum ())));
                } catch (IOException ex) {
                    ex.printStackTrace ();
                    Logger.getLogger (PanelButton.class.getName ()).log 
                    (Level.SEVERE, "You have to choose one of the methods of checking sum", ex);
                }   
            }
        });
    }
    
    /**
     * Returns the button, that opens the initialize directory.
     * 
     * @return
     */
    public Button getOpenButton () {
        return openButton;
    }
    
    /**
     * Returns the button, that adds row of data to table  
     * 
     * @return .
     */
    public Button getAddButton () {
        return addButton;
    }
    
    /**
     * Returns the button, that deletes the row from table
     * 
     * @return 
     */
    public Button getDelButton () {
        return delButton;
    }
    
    /**
     * Returns the layout, where RadioButtons are placed.
     * 
     * @return 
     */
    public VBox getLayoutForRadioButtons () {
        boxRadioButton.getChildren ().addAll (btnMD5, btnSHA1, btnSHA224, btnSHA256,
            btnSHA384, btnSHA512);
        return boxRadioButton;
    }
    
    /**
     * This method sets a algorithm for calculating the values of hash sums
     * (checksums).
     * 
     * @throws IOException, If user forget to chose the algorithm for checking sum 
     * and in log will output INFO message.
     * @param sum 
     */
    public void setAlgorithCheckSum (final CalculatorCheckSum sum) {
        group.selectedToggleProperty ().addListener (new ChangeListener<Toggle> () {
            @Override
            public void changed (ObservableValue<? extends Toggle> ov, 
                Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle () != null) {
                    RadioButton chooseCheckSumAlgorithm = (RadioButton) 
                        group.getSelectedToggle ();
                    sum.setAlgorithm (chooseCheckSumAlgorithm.getText ());
                }
                else {
                    Logger.getLogger (PanelButton.class.getName ()).
                        log (Level.SEVERE, "No choose the method of checking sum");
                }
            }
        
        });
    }
   
}

