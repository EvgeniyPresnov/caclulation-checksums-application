/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.evgeniypresnov.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Evgeniy Presnov
 */
public class Main extends Application {
       
    @Override
    public void start (Stage primaryStage) throws IOException {
        AnchorPane root = new AnchorPane();
        
        SetterDistanceForWidgets dist = new SetterDistanceForWidgets ();
        
        VBox vBox = new VBox ();
        
        CalculatorCheckSum sum = new CalculatorCheckSum ();
        
        DataStore table = new DataStore ();

        FileSystem treeFileSystem = new FileSystem ();
        treeFileSystem.getFileBrowser ();
        
        PanelButton buttons = new PanelButton ();
        buttons.openFileSystem (table, sum);
        buttons.setAlgorithCheckSum (sum); 
        buttons.addFileFromTreeToTable (treeFileSystem, table, sum);
        
        vBox.getChildren ().add (buttons.getLayoutForRadioButtons ());

        // The set up a distance for label of file system.
        AnchorPane.setLeftAnchor (treeFileSystem.getLabelFileSystem (),
            dist.getLeftSizeForLabelFileSystem ());
        AnchorPane.setLeftAnchor (treeFileSystem.getLabelFileSystem (),
            dist.getTopSizeForLabelFileSystem ());
        
        // The set up a distance for left widget.
        AnchorPane.setLeftAnchor (treeFileSystem.getInstance (), 
            dist.getLeftSizeForFileSystem ());
        AnchorPane.setTopAnchor (treeFileSystem.getInstance (), 
            dist.getTopSizeFileSystem ());
        AnchorPane.setBottomAnchor (treeFileSystem.getInstance (), 
            dist.getBottomSizeForFileSystem ());
 
        // The set up a distance for right widget.
        AnchorPane.setRightAnchor (table.getInstance (),
            dist.getRightSizeForTable ());
        AnchorPane.setBottomAnchor (table.getInstance (), 
            dist.getBottomSizeForTable ());
        AnchorPane.setTopAnchor (table.getInstance (), 
            dist.getTopSizeForTable ());

        // The set up a distance for 'Open' button.
        AnchorPane.setRightAnchor (buttons.getOpenButton (), 
            dist.getRightSizeForOpenButton ());
        AnchorPane.setTopAnchor (buttons.getOpenButton (), 
            dist.getTopSizeForOpenButton ());

        // The set up a distance for label of RadioButtons.
        AnchorPane.setLeftAnchor (vBox,
            dist.getLeftSizeForRadioButtons ());
        AnchorPane.setTopAnchor (vBox, 
            dist.getTopSizeForRadioButtons ());

        // The set up a distance for RadioButtons.
        AnchorPane.setLeftAnchor (buttons.getLabelForRadioButtons (), 
            dist.getLeftSizeForLabelRadioButtons ());
        AnchorPane.setTopAnchor (buttons.getLabelForRadioButtons (), 
            dist.getTopSizeForLabelRadioButtons ());

        // The set up a distance for 'Add' button.
        AnchorPane.setLeftAnchor (buttons.getAddButton (), 
            dist.getLeftSizeForAddButton ());
        AnchorPane.setTopAnchor (buttons.getAddButton (), 
            dist.getTotSizeForAddButton ());

        // The set up a distance for label 'Open' button
        AnchorPane.setRightAnchor (buttons.getLabelForOpenButton (), 
           dist.getRightSizeForLabelOpenButton ());
        AnchorPane.setTopAnchor (buttons.getLabelForOpenButton (), 
            dist.getTotSizeForLabelOpenButton ());
        
        // Adds the all widget on layout of main apllication
        root.getChildren ().addAll (treeFileSystem.getLabelFileSystem (),
            treeFileSystem.getInstance (), table.getInstance(), 
            buttons.getOpenButton (), vBox, buttons.getLabelForRadioButtons (),
            buttons.getAddButton (), buttons.getLabelForOpenButton ());
 

        Scene scene = new Scene (root, dist.getWidthForApp (), 
            dist.getHeightForApp ());

        primaryStage.setTitle ("Application of calculation of checking sum");
        primaryStage.setScene (scene);
        primaryStage.show ();
    }


    public static void main (String [] args) {
        launch (args);
    }
}

