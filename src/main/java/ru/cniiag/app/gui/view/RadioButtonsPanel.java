/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui.view;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * This class allows the user to select the algorithm calculation of checking 
 * sum where each radio button corresponds to a specific algorithm of
 * calculation checking sum.
 * 
 * @author Evgeniy Presnov
 */
public final class RadioButtonsPanel {
    /**
     * Creating the vertical box.
     */
    private final VBox boxRadioButton = new VBox ();
    
    /**
     * Creating the toggle group where all RadioButtons will be placed. 
     */
    private final ToggleGroup group = new ToggleGroup ();
    
    /**
     * Storing the algorithm of calculation checking sum.
     */
    private String algorithm = "";
    
    /**
     * Creating the radio buttons.
     */
    private final RadioButton btnMD5 = new RadioButton ("MD5");
    private final RadioButton btnSHA1 = new RadioButton ("SHA-1");
    private final RadioButton btnSHA224 = new RadioButton ("SHA-224");
    private final RadioButton btnSHA256 = new RadioButton ("SHA-256");
    private final RadioButton btnSHA384 = new RadioButton ("SHA-384");
    private final RadioButton btnSHA512 = new RadioButton ("SHA-512");
    
    /**
     * The constructor sets up the radio buttons on the toggle group
     * where they can be selected.
     */
    public RadioButtonsPanel () {
        btnMD5.setToggleGroup (group);
        btnMD5.setSelected (true);
        btnSHA1.setToggleGroup (group);
        btnSHA224.setToggleGroup (group);
        btnSHA256.setToggleGroup (group);
        btnSHA384.setToggleGroup (group);
        btnSHA512.setToggleGroup (group); 
    }
    
    /**
     * Return the vertical box that holds all the radio buttons.
     * 
     * @return boxRadioButton
     */
    public VBox getLayoutForRadioButtons () {
        boxRadioButton.getChildren ().addAll (
            btnMD5
            , btnSHA1
            , btnSHA224
            , btnSHA256
            , btnSHA384
            , btnSHA512
        );
        return boxRadioButton;
    }
    
    /**
     * Return the algorithm of calculation checking sum.
     * 
     * @return algorithm
     */
    public String getAlgorithmCheckSum () {  
        if (group.getSelectedToggle ().equals (btnMD5) || btnMD5.isSelected ()) {
            algorithm = "md5sum";
        }
        else if (group.getSelectedToggle ().equals (btnSHA1)) {
            algorithm = "sha1sum";
        }
        else if (group.getSelectedToggle ().equals (btnSHA224)) {
            algorithm = "sha224sum";
        }
        else if (group.getSelectedToggle ().equals (btnSHA256)) {
            algorithm = "sha256sum";
        }
        else if (group.getSelectedToggle ().equals (btnSHA384)) {
            algorithm =  "sha384sum";
        }
        else if (group.getSelectedToggle ().equals (btnSHA512)) {
            algorithm =  "sha512sum";
        }
        return algorithm;
    }
}
