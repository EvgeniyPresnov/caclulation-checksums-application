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
 * This class implementations the actions, when user clicks on radio buttons.
 *
 * @author Evgeniy Presnov
 */
public class RadioButtonsPanel {
    /**The field creates and initializes a layout, where all buttons 
    * will be placed.
    */
    private final VBox boxRadioButton = new VBox ();
    
    // This field create a group, where all RadioButtons will be placed. 
    private final ToggleGroup group = new ToggleGroup ();
    
    //These fields create and initialize class RadioButton.
    private final RadioButton btnMD5 = new RadioButton ("MD5");
    private final RadioButton btnSHA1 = new RadioButton ("SHA-1");
    private final RadioButton btnSHA224 = new RadioButton ("SHA-224");
    private final RadioButton btnSHA256 = new RadioButton ("SHA-256");
    private final RadioButton btnSHA384 = new RadioButton ("SHA-384");
    private final RadioButton btnSHA512 = new RadioButton ("SHA-512");
    
    /***
     * The placement of the buttons on the group.
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
     * Returns the layout, where RadioButtons are placed.
     * 
     * @return boxRadioButton
     */
    public VBox getLayoutForRadioButtons () {
        boxRadioButton.getChildren ().addAll (btnMD5, btnSHA1, btnSHA224, 
            btnSHA256, btnSHA384, btnSHA512);
        return boxRadioButton;
    }
    
    /**
     * This method provides the choice of algorithm of checking sum. User clicks
     * on the RadioButton and will be invoke appropriate a shell command for 
     * checking sum.
     * 
     * @return 
     */
    public String setAlgorithmCheckSum () {
        if (group.getSelectedToggle ().equals (btnMD5) || btnMD5.isSelected () )
        {
            return "md5sum";
        }
        else if (group.getSelectedToggle ().equals (btnSHA1) ) {
            return "sha1sum";
        }
        else if (group.getSelectedToggle ().equals (btnSHA1) ) {
            return "sha1sum";
        }
        else if (group.getSelectedToggle ().equals (btnSHA224) ) {
            return "sha224sum";
        }
        else if (group.getSelectedToggle ().equals (btnSHA256) ) {
            return "sha256sum";
        }
        else if (group.getSelectedToggle ().equals (btnSHA384) ) {
            return "sha384sum";
        }
        else if (group.getSelectedToggle ().equals (btnSHA512) ) {
            return "sha512sum";
        }
        System.out.println ("The algorithm for calculation of checking sum + "
            + "is not choosen");
        return null;
    }
}
