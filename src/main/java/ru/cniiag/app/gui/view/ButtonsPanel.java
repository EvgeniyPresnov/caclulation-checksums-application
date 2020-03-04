/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui.view;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import ru.cniiag.app.gui.model.DataModel;

/**
 * This class implementations the actions, when user clicks on buttons.
 *
 * @author Evgeniy Presnov
 */
public class ButtonsPanel {
    /**These fields create and initialize class Button .*/
    private Button toCalculate = new Button ("Calculate the file");
    private Button toOpenInitDir = new Button ("Open the initial directory");

    /**
     * This method implements an another way to navigate in file system.
     * 
     * @param table
     * @param files
     * @param checkSum
     * @param radioButtons
     * @throws IOException
     * @throws Exception 
     */
    private void addRowsToTable (TableView table, List<File> files,
        CalculatorCheckSum checkSum, RadioButtonsPanel radioButtons) 
        throws IOException, Exception {
        
        try {
            if (files == null || files.isEmpty () ) {
                System.out.println ("This file is empty");
                return; 
            }
            for (File file: files) {
                table.getItems ().add (new DataModel (file.getName (), 
                checkSum.calculateFile(file.getName (), file.getPath (), 
                radioButtons.setAlgorithmCheckSum () )));
            }
        }
        catch (IOException ex) {
            Logger.getLogger (ButtonsPanel.class.getName()). log(Level.SEVERE, 
                "Exception: ", ex);
        }
    }
    
    /**
     * This method allows navigating in file system, when user clicks 
     * on "Open" button. In the set up the /home directory initializes by
     * default.
     * 
     * @param table
     * @param checkSum
     * @param radioButtons
     * @throws IOException 
     */
    public void openInitDir (final DataStore table, final CalculatorCheckSum checkSum, 
        final RadioButtonsPanel radioButtons) throws IOException {
        
        toOpenInitDir.setOnAction (new EventHandler<ActionEvent> () {
            @Override
            public void handle (ActionEvent event) {
                FileChooser fileChooser = new FileChooser ();
                fileChooser.setInitialDirectory (new File (table.getInitDir()));
                FileChooser.ExtensionFilter filter = 
                    new FileChooser.ExtensionFilter(table.getFormatForFile(), 
                        table.getExpansionForFile());
                fileChooser.getExtensionFilters().addAll(filter);
                
                List<File> files = fileChooser.showOpenMultipleDialog(null);
                
                try {
                    addRowsToTable (table.getInstance(), files, checkSum, 
                        radioButtons);
                }
                catch (Exception ex) {
                    Logger.getLogger (ButtonsPanel.class.getName() ).log 
                        (Level.SEVERE, "Exception: ", ex);
                }
            }
        });
    }
    
    /**
     * Returns the Button that on push
     * 
     * @return toOpenInitDir
     */
    public Button getOpenInitDir () {
        return toOpenInitDir;
    }
    
    /**
     * Returns the Button thats on pushing calculate checking sum of file.
     * 
     * @return toCalculate
     */
    public Button getCalculateFile () {
        return toCalculate;
    }
    
}
