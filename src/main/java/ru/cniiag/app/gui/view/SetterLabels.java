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
