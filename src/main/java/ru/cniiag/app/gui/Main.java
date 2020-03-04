/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.cniiag.app.gui.view.ButtonsPanel;
import ru.cniiag.app.gui.view.CalculatorCheckSum;
import ru.cniiag.app.gui.view.DataStore;
import ru.cniiag.app.gui.view.RadioButtonsPanel;
import ru.cniiag.app.gui.view.SetterLabels;
import ru.cniiag.app.gui.view.SetterPositions;

/**
 *
 * @author Evgeniy Presnov
 */
public class Main extends Application {
    
    @Override
    public void start (Stage primaryStage) throws IOException {
        AnchorPane root = new AnchorPane ();
        SetterPositions positions = new SetterPositions ();
        ButtonsPanel buttons = new ButtonsPanel ();
        SetterLabels labels = new SetterLabels ();
        CalculatorCheckSum checkSum = new CalculatorCheckSum ();
        RadioButtonsPanel radioButtons = new RadioButtonsPanel ();
        DataStore table = new DataStore ();
        VBox vBox = new VBox (); 
        
        vBox.getChildren ().addAll (radioButtons.getLayoutForRadioButtons ());
        
        buttons.openInitDir (table, checkSum, radioButtons);
        
        getPositions (root, positions, table.getInstance (), buttons, labels, 
            vBox);
        
        Scene scene = new Scene (root, positions.getWidthForApp (), 
            positions.getHeightForApp ());
        
        primaryStage.setTitle ("The application for calculate checking sum");
        primaryStage.setScene (scene);
        primaryStage.show ();
    }

    /**
     * Sets the distance from each widget located on the main layer to 
     * the borders 
     * 
     * 
     * @param root
     * @param pane
     * @param table
     * @param buttons
     * @param labels
     * @param vBox 
     */
    private void getPositions (AnchorPane root, SetterPositions pane, 
        TableView table, ButtonsPanel buttons, SetterLabels labels, VBox vBox) {
        
        AnchorPane.setRightAnchor (table, pane.getRightSizeForTable ());
        AnchorPane.setBottomAnchor (table, pane.getBottomSizeForTable ());
        AnchorPane.setTopAnchor (table, pane.getTopSizeForTable ());
        
        // The set up a distance for 'Open' button.
        AnchorPane.setRightAnchor (buttons.getOpenInitDir (), 
            pane.getRightSizeForOpenInitButton ());
        AnchorPane.setTopAnchor (buttons.getOpenInitDir (), 
            pane.getTopSizeForOpenInitButton ());
        
        // The set up a distance for label of 'Open' button.
        AnchorPane.setRightAnchor (labels.getLabelForOpenInitButton (), 
            pane.getRightSizeForLabelOpenInitButton ());
        AnchorPane.setTopAnchor (labels.getLabelForOpenInitButton (), 
            pane.getTopSizeForLabelOpenInitButton ());
        
        // The set up a distance for label of RadioButtons.
        AnchorPane.setLeftAnchor (labels.getLabelForRadioButtons (), 
            pane.getLeftSizeForLabelRadioButtons ());
        AnchorPane.setTopAnchor (labels.getLabelForRadioButtons (), 
            pane.getTopSizeForLabelRadioButtons ());
        
         // The set up a distance for RadioButtons.
        AnchorPane.setLeftAnchor (vBox, 
            pane.getLeftSizeForRadioButtons ());
        AnchorPane.setTopAnchor (vBox, 
            pane.getTopSizeForRadioButtons ());
        
        // Adds the all widget on layout of main apllication.
        root.getChildren ().addAll (table, buttons.getOpenInitDir (),
            labels.getLabelForOpenInitButton (), 
            labels.getLabelForRadioButtons (), vBox);
                
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        launch (args);
    }
    
}

