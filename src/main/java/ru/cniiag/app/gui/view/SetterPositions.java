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

/**
 * This class defines the distance from the application of window
 * to each widget located in this window.
 * 
 * @author Evgeniy Presnov
 */
public final class SetterPositions {
    /**
     * Set the size for the main application.
     */
    private final static int APP_SIZE_WIDTH = 1000;
    private final static int APP_SIZE_HEIGTH = 600;
    
    /**
     * Set the minimum size for the main application
     */
    private final static int MIN_APP_SIZE_WIDTH = 930;
    private final static int MIN_APP_SIZE_HEIGTH = 500;

    /**
     * Set the distance for the button that provides access to 
     * the file system. 
     */
    private final static double DISTANCE_FROM_TOP_FOR_OPEN_INIT_BUTTON = 10.0;
    private final static double DISTANCE_FROM_RIGHT_FOR_OPEN_INIT_BUTTON = 10.0;
    
    /**
     * Set the distance for label of button that provides an access to the file
     * system.
     */
    private final static double DISTANCE_FROM_RIGHT_FOR_LABEL_OPEN_INIT_BUTTON = 210.0;
    private final static double DISTANCE_FROM_TOP_FOR_LABEL_OPEN_INIT_BUTTON = 16.0;
    
    /**
     * Set the distance for the button that calculates the checking sum 
     * of file.
     */
    private final static double DISTANCE_FROM_LEFT_FOR_CALCULATE_BUTTON = 270.0;
    private final static double DISTANCE_FROM_TOP_FOR_CALCULATE_BUTTON = 45.0;
    
    /**
     * Set the distance for the radio buttons that provides a choice
     * of algorithm for calculating the checksum.
     */
    private final static double DISTANCE_FROM_LEFT_FOR_RADIO_BUTTONS = 270.0;
    private final static double DISTANCE_FROM_TOP_FOR_RADIO_BUTTONS = 200.0;

    /**
     * Set the distance of label for the radio buttons.
     */
    private final static double DISTANCE_FROM_LEFT_LABEL_RADIO_BUTTONS = 270.0;
    private final static double DISTANCE_FROM_TOP_LABEL_RADIO_BUTTONS = 160.0;

    /**
     * Set the distance for the table.
     */
    private final static double DISTANCE_FROM_RIGHT_FOR_TABLE = 10.0;
    private final static double DISTANCE_FROM_BOTTOM_FOR_TABLE = 30.0;
    private final static double DISTANCE_FROM_TOP_FOR_TABLE = 45.0;

    /**
     * Set the distance for the tree of file system.
     */
    private final static double DISTANCE_FROM_LEFT_FOR_FILE_SYSTEM = 10.0;
    private final static double DISTANCE_FROM_BOTTOM_FOR_FILE_SYSTEM = 30.0;
    private final static double DISTANCE_FROM_TOP_FOR_FILE_SYSTEM = 45.0;
    
    /**
     * Set the distance of label for the tree of file system.
     */
    private final static double DISTANCE_FROM_LEFT_FOR_LABEL_FILE_SYSTEM = 10.0;
    private final static double DISTANCE_FROM_TOP_FOR_LABEL_FILE_SYSTEM = 16.0;
    
    /**
     * Return the width of  window.
     * 
     * @return APP_SIZE_WIDTH
     */
    public int getSizeWidthForApp () {
        return APP_SIZE_WIDTH;
    }
    
    /**
     * Return the heigth of window.
     * 
     * @return APP_SIZE_HEIGTH
     */
    public int getSizeHeigthForApp () {
        return  APP_SIZE_HEIGTH;
    }
    
    /**
     * Return the minimum heigth size of window.
     * 
     * @return MIN_APP_SIZE_HEIGTH
     */
    public int getMinAppSizeHeigth () {
        return MIN_APP_SIZE_HEIGTH;
    }
   
    /**
     * Return the minimum width size of window.
     * 
     * @return MIN_APP_SIZE_WIDTH
     */
    public int getMinAppSizeWidth () {
        return MIN_APP_SIZE_WIDTH;
    }
    
    
    /**
     * Return the distance from the right size of application to the table.
     * 
     * @return DISTANCE_FROM_RIGHT_FOR_TABLE
     */
    public double getRightSizeForTable () { 
        return DISTANCE_FROM_RIGHT_FOR_TABLE; 
    }
    
    /**
     * Return the distance from the bottom size of application to the table.
     * 
     * @return DISTANCE_FROM_BOTTOM_FOR_TABLE
     */
    public double getBottomSizeForTable () { 
        return DISTANCE_FROM_BOTTOM_FOR_TABLE;
    }
    
    /**
     * Return the distance from the top size of application to the table.
     * 
     * @return DISTANCE_FROM_TOP_FOR_TABLE
     */
    public double getTopSizeForTable () { 
        return DISTANCE_FROM_TOP_FOR_TABLE; 
    }
    
    /**
     * Return the distance from the top size of application to 
     * the button that provides an access to the file system.
     * 
     * @return DISTANCE_FROM_TOP_FOR_OPEN_INIT_BUTTON
     */
    public double getTopSizeForOpenInitButton () { 
        return DISTANCE_FROM_TOP_FOR_OPEN_INIT_BUTTON; 
    }
    
    /**
     * Return the distance from the right size of application to
     * the button that provides an access to the file system.
     * 
     * @return DISTANCE_FROM_RIGHT_FOR_OPEN_INIT_BUTTON
     */
    public double getRightSizeForOpenInitButton () { 
        return DISTANCE_FROM_RIGHT_FOR_OPEN_INIT_BUTTON; 
    }
    
    /**
     * Return the distance from the right size of application to the label 
     * of the button that provides an access to the file system.
     * 
     * @return DISTANCE_FROM_RIGHT_FOR_LABEL_OPEN_INIT_BUTTON
     */
    public double getRightSizeForLabelOpenInitButton () { 
        return DISTANCE_FROM_RIGHT_FOR_LABEL_OPEN_INIT_BUTTON; 
    }
    
    /**
     * Return the distance from the top size of application to the label 
     * of the button that provides an access to the file system.
     * 
     * @return DISTANCE_FROM_TOP_FOR_LABEL_OPEN_INIT_BUTTON
     */
    public double getTopSizeForLabelOpenInitButton () { 
        return DISTANCE_FROM_TOP_FOR_LABEL_OPEN_INIT_BUTTON; 
    }
    
    /**
     * Return the distance from left size of application to the
     * radio buttons 
     * 
     * @return DISTANCE_FROM_LEFT_FOR_RADIO_BUTTONS
     */
    public double getLeftSizeForRadioButtons () { 
        return DISTANCE_FROM_LEFT_FOR_RADIO_BUTTONS;
    }
    
    /**
     * Return the distance from top size of application to the
     * radio buttons 
     * 
     * @return DISTANCE_FROM_TOP_FOR_RADIO_BUTTONS
     */
    public double getTopSizeForRadioButtons () { 
        return DISTANCE_FROM_TOP_FOR_RADIO_BUTTONS;
    }
    
    /**
     * Return the distance from the left size of application to the label 
     * of the radio buttons.
     * 
     * @return DISTANCE_FROM_LEFT_LABEL_RADIO_BUTTONS
     */
    public double getLeftSizeForLabelRadioButtons () { 
        return DISTANCE_FROM_LEFT_LABEL_RADIO_BUTTONS;
    }
    
    /**
     * Return the distance from the top size of application to the label 
     * of the radio buttons.
     * 
     * @return DISTANCE_FROM_TOP_LABEL_RADIO_BUTTONS
     */
    public double getTopSizeForLabelRadioButtons () { 
        return DISTANCE_FROM_TOP_LABEL_RADIO_BUTTONS;
    }
    
    /**
     * Return the distance from the left size of application to the
     * file system.
     * 
     * @return DISTANCE_FROM_LEFT_FOR_FILE_SYSTEM
     */
    public double getLeftSizeForFileSystem () { 
        return DISTANCE_FROM_LEFT_FOR_FILE_SYSTEM; 
    }

    /**
     * Return the distance from the bottom size of application to the
     * file system.
     * 
     * @return DISTANCE_FROM_BOTTOM_FOR_FILE_SYSTEM
     */
    public double getBottomSizeForFileSystem () { 
        return DISTANCE_FROM_BOTTOM_FOR_FILE_SYSTEM; 
    }
    
    /**
     * Return the distance from the top size of application to the
     * file system.
     * 
     * @return DISTANCE_FROM_TOP_FOR_FILE_SYSTEM
     */
    public double getTopSizeFileSystem () { 
        return DISTANCE_FROM_TOP_FOR_FILE_SYSTEM;
    }
    
    /**
     * Return the distance from the left size of application to the label 
     * of the file system.
     * 
     * @return DISTANCE_FROM_LEFT_FOR_LABEL_FILE_SYSTEM
     */
    public double getLeftSizeForLabelFileSystem () { 
        return DISTANCE_FROM_LEFT_FOR_LABEL_FILE_SYSTEM;
    }
    
    /**
     * Return the distance from the top size of application to the label 
     * of the file system.
     * 
     * @return DISTANCE_FROM_TOP_FOR_LABEL_FILE_SYSTEM
     */
    public double getTopSizeForLabelFileSystem () { 
        return DISTANCE_FROM_TOP_FOR_LABEL_FILE_SYSTEM;
    }
    
    /**
     * Return the distance from the left size of application to 
     * the button that that calculates the checking sum of file.
     * 
     * @return DISTANCE_FROM_LEFT_FOR_CALCULATE_BUTTON
     */
    public double getLeftSizeForCalculateButton () { 
        return DISTANCE_FROM_LEFT_FOR_CALCULATE_BUTTON; 
    }
    
    /**
     * Return the distance from the top size of application to 
     * the button that that calculates the checking sum of file.
     * 
     * @return DISTANCE_FROM_TOP_FOR_CALCULATE_BUTTON
     */
    public double getTotSizeForCalculateButton () { 
        return DISTANCE_FROM_TOP_FOR_CALCULATE_BUTTON;
    }
}
