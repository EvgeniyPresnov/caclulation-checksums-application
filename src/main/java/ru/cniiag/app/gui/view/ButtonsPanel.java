/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package ru.cniiag.app.gui.view;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import ru.cniiag.app.gui.model.DataModel;
import ru.cniiag.app.gui.utility.CalculatorCheckSum;

/**
 * This class describes the actions when the certain button is clicked.
 * 
 * @author Evgeniy Presnov
 */
public final class ButtonsPanel {
    /**
     * Creating the button that provides an access to 
     * the file system.
     */
    private final Button btnOpenInitDir = new Button (
        "Open the initial directory"
    );
    
    /**
     * Creating the of button that calculates the checking sum.
     */
    private final Button btnCalculateFile = new Button ("Calculate the file");

    /**
     * This method allows to write the selected file from the file system to
     * the table.
     * 
     * @param table
     * @param files
     * @param radioButtons
     * @throws IOException 
     */
    private void addRowsToTable (
        TableView table
        , List<File> files
        , RadioButtonsPanel radioButtons
    ) throws IllegalArgumentException, IOException {
        
        try {
            for (File file: files) {
                table.getItems ().add (new DataModel (
                    file.getName ()
                    , CalculatorCheckSum.calculateFile (
                        file.getName ()
                        , file.getPath ()
                        , radioButtons.getAlgorithmCheckSum ())));
            }
        } catch (IllegalArgumentException ex) {
            Alert alert = new Alert (Alert.AlertType.WARNING);
            alert.setTitle ("Warning message box");
            alert.setHeaderText ("The invalid data");
            alert.showAndWait ();

            Logger.getLogger (ButtonsPanel.class.getName ())
            .log (Level.SEVERE, null, ex.getMessage ());
        }
    }
        

    
    /**
     * This method allows navigating in file system, when the user clicks 
     * on "Open the initial directory" button.After the user selects a file
     * the checking sum will be written to the table.
     * 
     * @param table
     * @param initDir
     * @param format
     * @param expansion
     * @param radioButtons
     * @throws IOException 
     */
    public void openInitDir (
        final TableView table
        , final String initDir
        , final String format
        , final String expansion
        , final RadioButtonsPanel radioButtons
    ) throws IOException, IllegalArgumentException {
        
        btnOpenInitDir.setOnAction ( (ActionEvent event) -> {
            FileChooser fileChooser = new FileChooser ();
            /**
             * Set initial directory.
             */
            fileChooser.setInitialDirectory (new File (initDir));
            /**
             * Add extension filters.
             */
            FileChooser.ExtensionFilter filter = 
                    new FileChooser.ExtensionFilter (format, expansion);
            fileChooser.getExtensionFilters ().addAll (filter);
            
            List<File> files = fileChooser.showOpenMultipleDialog (null);
            
            try {
                addRowsToTable (table, files, radioButtons);
            } catch (IOException ex) { 
                Alert alert = new Alert (AlertType.WARNING);
                alert.setTitle ("Warninig message box");
                alert.setHeaderText ("This file is empty");
                alert.showAndWait();
                
                Logger.getLogger (ButtonsPanel.class.getName ())
                .log (Level.SEVERE, null, ex.getMessage ());
            }     
        });
    }
    
    /**
     * This method allows you to calculate the checking sum of a file when
     * the user is selecting the file from the tree of file system after 
     * clicking "Calculate the file" button.The result will be written 
     * to the table.
     * 
     * @param tree
     * @param table
     * @param radioButtons
     * @throws IOException 
     */
    public void calculateFile (
        final FileSystemHandler tree
        , final DataStore table
        , final RadioButtonsPanel radioButtons
    ) throws IOException, IllegalArgumentException {
        
        btnCalculateFile.setOnAction ( (ActionEvent event) -> {
            try {
                table.getTableView ().getItems ().add (new DataModel (
                    tree.getFileName ()
                    , CalculatorCheckSum.calculateFile (
                        tree.getFileName ()
                        , tree.getFilePath ()
                        , radioButtons.getAlgorithmCheckSum ()
                    )
                ));
            } catch (IllegalArgumentException ex) {
                Alert alert = new Alert (Alert.AlertType.WARNING);
                alert.setTitle ("Warning message box");
                alert.setHeaderText (
                    "The checking sum couldn't be calculate for this file"
                );
                alert.showAndWait ();
            
                Logger.getLogger (ButtonsPanel.class.getName ())
                .log (Level.SEVERE, null, ex.getMessage ());
            } catch (IOException ex) {
                Alert alert = new Alert (Alert.AlertType.WARNING);
                alert.setTitle ("Warning message box");
                alert.setHeaderText ("This file is empty");
                alert.showAndWait ();
            
                Logger.getLogger (ButtonsPanel.class.getName ())
                .log (Level.SEVERE, null, ex.getMessage ());
            }
        });
    }
    
    /**
     * Return the button for displaying the file system.
     * 
     * @return btnOpenInitDir
     */
    public Button getOpenInitDir () {
        return btnOpenInitDir;
    }
    
    /**
     * Return the button for calculation of checking sum.
     * 
     * @return btnCalculateFile
     */
    public Button getCalculateFile () {
        return btnCalculateFile;
    }
}
