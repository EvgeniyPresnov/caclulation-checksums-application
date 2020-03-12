/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui.view;

import javafx.scene.control.Label;

/**
 * This class represents the labels for every widget on the window of
 * application.
 * 
 * @author Evgeniy Presnov
 */
public final class SetterLabels {
    /**
     * The initialization the label for button that provides an access to 
     * the file system.
     */
    private final Label labelForOpenInitButton = new Label (
        "Open the directory /home/user_name/"
    );
    
    /**
     * The initialization the label for the radio buttons that provides a choice
     * of algorithm for calculating the checksum.
     */
    private final Label labelForRadioButtons = new Label (
        "The choice of algorithm of calculation  " + "\n" + " of checking sum"
    );
    
    /**
     * The initialization the label for tree of file system.
     */
    private final Label labelForFileSystem = new Label (
        "Representation of file system"
    );
    
    /**
     * Return the label for button that provides an access to 
     * the file system.
     * 
     * @return labelForOpenInitButton
     */
    public Label getLabelForOpenInitButton () {
        return labelForOpenInitButton;
    }
    
    /**
     * Return the label for the radio buttons.
     * 
     * @return labelForRadioButtons
     */
    public Label getLabelForRadioButtons () {
        return labelForRadioButtons;
    }
    
    /**
     * Return the label for tree of file system.
     * 
     * @return labelForFileSystem
     */
    public Label getLabelForFileSystem () {
        return labelForFileSystem;
    }
}
