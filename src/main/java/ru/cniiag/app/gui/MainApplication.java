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
package ru.cniiag.app.gui;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.cniiag.app.gui.view.ButtonsPanel;
import ru.cniiag.app.gui.view.FileSystemHandler;
import ru.cniiag.app.gui.view.DataStore;
import ru.cniiag.app.gui.view.RadioButtonsPanel;
import ru.cniiag.app.gui.view.SetterLabels;
import ru.cniiag.app.gui.view.SetterPositions;

/**
 *
 * @author Evgeniy Presnov
 */
public final class MainApplication extends Application {
    /**
     * This method is the main entry point for JavaFX applications.
     * 
     * @param primaryStage
     * @throws IOException 
     */
    @Override
    public void start (Stage primaryStage) throws IOException {
        /**
         * The initialization the user's classes.
         */
        AnchorPane root = new AnchorPane ();
        SetterPositions pane = new SetterPositions ();
        ButtonsPanel buttons = new ButtonsPanel ();
        SetterLabels labels = new SetterLabels ();
        RadioButtonsPanel radioButtons = new RadioButtonsPanel ();
        FileSystemHandler fileSystem = new FileSystemHandler ();
        DataStore table = new DataStore ();
        
        VBox vBox = new VBox ();

        /**
         * Set the radio buttons on the vertical box.
         */
        vBox.getChildren ().add (radioButtons.getLayoutForRadioButtons ());
        
        /**
         * When the user clicks on this button a windows appears with the
         * initialized directory where he selects a file to calculate its
         * checking sum.
         */
        buttons.openInitDir (
            table.getTableView ()
            , table.getInitDir ()
            , table.getFormatForFile ()
            , table.getExpansionForFile ()
            , radioButtons
        );
        
        /**
         * When the user clicks on this button the file is selected for 
         * calculation of checking sum from the tree of file system.
         */
        buttons.calculateFile (fileSystem
            , table
            , radioButtons
        );
        

        setPositions (root
            , pane
            , table.getTableView ()
            , buttons
            , labels
            , vBox
            , fileSystem.getTreeView ()
        );
     
        /**
         * Creating a Scene by passing the pane object, width and height.
         */
        Scene scene = new Scene (
            root
            , pane.getWidthForApp ()
            , pane.getHeightForApp ()
        );
        /**
         * Setting the title to Stage.
         */
        primaryStage.setTitle ("Application for calculation of checking sum");
        
        /**
         * Adding the scene to Stage.
         */
        primaryStage.setScene (scene);
        
        /**
         * Displaying the contents of the stage.
         */
        primaryStage.show ();
    }

    /**
     * 
     * @param args the command line arguments.
     */
    public static void run (String[] args) {
        launch (args);
    }
    
    /**
     * This method takes the widgets as arguments and sets the distance
     * from the application of window to each they.
     * 
     * @param root
     * @param pane
     * @param table
     * @param buttons
     * @param labels
     * @param vBox
     * @param fileSystem 
     */
    private void setPositions (
        AnchorPane root
        , SetterPositions pane
        , TableView table
        , ButtonsPanel buttons
        , SetterLabels labels
        , VBox vBox
        , TreeView fileSystem
    ) {
       
        /**
         * Set the distance for the table from the right size of pane. 
         */
        AnchorPane.setRightAnchor (
            table
            , pane.getRightSizeForTable ()
        );
        
        /**
         * Set the distance for the table from the bottom size of pane. 
         */
        AnchorPane.setBottomAnchor (
            table
            , pane.getBottomSizeForTable ()
        );
        
        /**
         * Set the distance for the table from the top size of pane. 
         */
        AnchorPane.setTopAnchor (
            table
            , pane.getTopSizeForTable ()
        );
        
        /**
         * Set the distance for the button thats provides an access to 
         * the file system from the right size of pane. 
         */
        AnchorPane.setRightAnchor (
            buttons.getOpenInitDir ()
            , pane.getRightSizeForOpenInitButton ()
        );
        
        /**
         * Set the distance for the button thats provides an access to 
         * the file system from the top size of pane. 
         */
        AnchorPane.setTopAnchor (
            buttons.getOpenInitDir ()
            , pane.getTopSizeForOpenInitButton ()
        );
        
        /**
         * Set the distance for the button of label thats provides an access 
         * to the file system from the right size of pane.
         */
        AnchorPane.setRightAnchor (
            labels.getLabelForOpenInitButton ()
            , pane.getRightSizeForLabelOpenInitButton ()
        );
        
        /**
         * Set the distance for the button of label thats provides an access 
         * to the file system from the top size of pane. 
         */
        AnchorPane.setTopAnchor (
            labels.getLabelForOpenInitButton ()
            , pane.getTopSizeForLabelOpenInitButton ()
        );
        
        /**
         * Set the distance for the radio buttons of label from the 
         * left size of pane.
         */
        AnchorPane.setLeftAnchor (
            labels.getLabelForRadioButtons ()
            , pane.getLeftSizeForLabelRadioButtons ()
        );
        
        /**
         * Set the distance for the radio buttons of label 
         * from the top size of pane. 
         */
        AnchorPane.setTopAnchor (
            labels.getLabelForRadioButtons ()
            , pane.getTopSizeForLabelRadioButtons ()
        );
        
        /**
         * Set the distance for the radio buttons from the 
         * left size of pane.
         */
        AnchorPane.setLeftAnchor (
            vBox
            , pane.getLeftSizeForRadioButtons ()
        );
        
        /**
         * Set the distance for the radio buttons from the 
         * top size of pane.
         */
        AnchorPane.setTopAnchor (
            vBox
            , pane.getTopSizeForRadioButtons ()
        );
        
        /**
         * Set the distance for the file system of label from the 
         * left size of pane. 
         */
        AnchorPane.setLeftAnchor (
            labels.getLabelForFileSystem ()
            , pane.getLeftSizeForLabelFileSystem ()
        );
        
        /**
         * Set the distance for the file system of label from the 
         * top size of pane. 
         */
        AnchorPane.setTopAnchor (
            labels.getLabelForFileSystem ()
            , pane.getTopSizeForLabelFileSystem ()
        );
        
        /**
         * Set the distance for the file system from the 
         * left size of pane.
         */
        
        AnchorPane.setLeftAnchor (
            fileSystem
            , pane.getLeftSizeForFileSystem ()
        );
        
        /**
         * Set the distance for the file system from the 
         * top size of pane.
         */
        
        AnchorPane.setTopAnchor (
            fileSystem 
            , pane.getTopSizeFileSystem ()
        );
        
        /**
         * Set the distance for the file system from the 
         * bottom size of pane.
         */
        
        AnchorPane.setBottomAnchor (
            fileSystem
            , pane.getBottomSizeForFileSystem ()
        );
        
        /**
         * Set the distance for the file system from the 
         * bottom size of pane.
         */
        AnchorPane.setLeftAnchor (
            buttons.getCalculateFile()
            , pane.getLeftSizeForCalculateButton ()
        );
        
        /**
         * Set the distance for the button thats calculates the checking sum
         * from top size of pane.
         */
        AnchorPane.setTopAnchor (
            buttons.getCalculateFile()
            , pane.getTotSizeForCalculateButton ()
        );
        
        /**
         * Set the all widget on the pane.
         */
        root.getChildren ().addAll (
            table
            , buttons.getOpenInitDir ()
            , buttons.getCalculateFile ()
            , labels.getLabelForOpenInitButton ()
            , vBox, fileSystem
            , labels.getLabelForRadioButtons ()
            , labels.getLabelForFileSystem ()
        );
    }
}
