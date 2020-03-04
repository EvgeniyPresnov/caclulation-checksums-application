/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui.view;

import javafx.scene.control.Label;

/**
 * This class represents the labels for every widget.
 * 
 * @author Evgeniy Presnov
 */
public class SetterLabels {
    // The initialization of label for 'Open' button.
    private final Label labelForOpenInitButton = new Label ("Open the "
        + "directory /home/user_name/");
    // The initialization of label for RadioButton class.
    private final Label labelForRadioButtons = new Label ("The choice of "
        + "calculation of checking sum");
    
    /**
     * Returns the label for 'Open' button.
     * 
     * @return labelForOpenInitButton
     */
    public Label getLabelForOpenInitButton () {
        return labelForOpenInitButton;
    }
    
    /**
     * Returns the label for RadioButton class.
     * 
     * @return labelForRadioButtons
     */
    public Label getLabelForRadioButtons () {
        return labelForRadioButtons;
    }
}
