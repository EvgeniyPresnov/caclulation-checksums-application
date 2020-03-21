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

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * This class allows the user to select the algorithm calculation of checking 
 * sum where each radio button corresponds to a specific algorithm of
 * calculation checking sum.
 * 
 * @author Evgeniy Presnov
 */
public final class RadioButtonsPanel extends ToggleButton {
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
    
    Map<String, String> map;
    
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
        
        map = new HashMap<String, String> () { {
            put (btnMD5.getText (), "md5sum");
            put (btnSHA1.getText (), "sha1sum");
            put (btnSHA224.getText (), "sha224sum");
            put (btnSHA256.getText (), "sha256sum");
            put (btnSHA384.getText (), "sha384sum");
            put (btnSHA512.getText (), "sha512sum");
        } };
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
        RadioButton btn = (RadioButton) group.getSelectedToggle ();
        algorithm = map.get(btn.getText ());
        return algorithm;
    }
    
}
