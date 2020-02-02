/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.evgeniypresnov.gui;

import javafx.scene.layout.AnchorPane;

/**
  * This class defines the distance from the main application window 
  * to each widget located in this window.
  * 
  * @author Evgeniy Presnov
  * 
  */
public class SetterDistanceForWidgets {
    // The creation a layout.
    private final AnchorPane anchorPane = new AnchorPane ();
    
    // The initialization the sizes for window of application.
    private final int sizeWight = 1000;
    private final int sizeHeight = 600;

    /**
     * The declaration the fields of this class.
     */
    private final double distanceFromTopForOpenButton;
    private final double distanceFromRightForOpenButton ;

    private final double distanceFromRightForLabelOpenButton;
    private final double distanceFromTopForLabelOpenButton;

    private final double distanceFromLeftForAddButton;
    private final double distanceFromTopForAddButton;

    private final double distanceFromLeftForRadioButtons;
    private final double distanceFromTopForRadioButtons;

    private final double distanceFromLeftForLabelRadioButtons;
    private final double distanceFromTopForLabelRadioButtons;

    private final double distanceFromRightForTable;
    private final double distanceFromBottomForTable;
    private final double distanceFromTopForTable;

    private final double distanceFromLeftForFileSystem;
    private final double distanceFromBottomForFileSystem;
    private final double distanceFromTopForFileSystem;

    private final double distanceFromLeftForLabelFileSystem;
    private final double distanceFromTopForLabelFileSystem;
        
    /**
    * The constructor initializes the values for fields this class.
    * 
    */
    public SetterDistanceForWidgets () {
        distanceFromTopForOpenButton = 10.0;
        distanceFromRightForOpenButton = 10.0;

        distanceFromRightForLabelOpenButton = 70.0;
        distanceFromTopForLabelOpenButton = 10.0;

        distanceFromLeftForAddButton = 270.0;
        distanceFromTopForAddButton = 30.0;

        distanceFromLeftForRadioButtons = 270.0;
        distanceFromTopForRadioButtons = 200.0;

        distanceFromLeftForLabelRadioButtons = 270.0;
        distanceFromTopForLabelRadioButtons = 160.0;

        distanceFromRightForTable = 10.0;
        distanceFromBottomForTable = 30.0;
        distanceFromTopForTable = 45.0;

        distanceFromLeftForFileSystem = 10.0;
        distanceFromBottomForFileSystem = 30.0;
        distanceFromTopForFileSystem = 30.0;

        distanceFromLeftForLabelFileSystem = 10.0;
        distanceFromTopForLabelFileSystem = 10.0;
    }
        
    /**
     * Returns an instance of AnchorPane class.
     * 
     * @return 
     */
    public AnchorPane getInstance () {
        return anchorPane;
    }
    
    /***
     * Returns a value of width for application.
     * 
     * @return 
     */
    public int getWidthForApp () {
        return sizeWight;
    }
    
    /**
     * Returns a value of height for application. 
     * 
     * @return 
     */
    public int getHeightForApp () {
        return  sizeHeight;
    }

    /**
     * Returns a value for 'Open' button from top side.
     * 
     * @return 
     */
    public double getTopSizeForOpenButton () { 
        return distanceFromTopForOpenButton; 
    }

    /**
     * Returns a value for 'Open' button right side.
     * 
     * @return 
     */
    public double getRightSizeForOpenButton () { 
        return distanceFromRightForOpenButton; 
    }

    /**
     * Returns a value for label of 'Open' button from right side.
     * 
     * @return 
     */
    public double getRightSizeForLabelOpenButton () { 
        return distanceFromRightForLabelOpenButton; 
    }

    /**
     * Returns a value for label of 'Open' button from top side. 
     * 
     * @return 
     */
    public double getTotSizeForLabelOpenButton () { 
        return distanceFromTopForLabelOpenButton; 
    }

    /**
     * Returns a value for 'Add' button from left side.
     * 
     * @return 
     */
    public double getLeftSizeForAddButton () { 
        return distanceFromLeftForAddButton; 
    }

    /**
     * Returns a value for 'Add' button from top side.
     * 
     * @return 
     */
    public double getTotSizeForAddButton () { 
        return distanceFromTopForAddButton;
    }

    /**
     * Returns a value for RadioButtons from left side.
     * 
     * @return 
     */
    public double getLeftSizeForRadioButtons () { 
        return distanceFromLeftForRadioButtons;
    }

    /**
     * Returns a value for RadioButtons from top side.
     * 
     * @return 
     */
    public double getTopSizeForRadioButtons () { 
        return distanceFromTopForRadioButtons;
    }

    /**
     * Returns a value for label of RadioButtons from left side. 
     * 
     * @return 
     */
    public double getLeftSizeForLabelRadioButtons () { 
        return distanceFromLeftForLabelRadioButtons;
    }

    /**
     * Returns a value for label of RadioButtons from top side.
     * 
     * @return 
     */
    public double getTopSizeForLabelRadioButtons () { 
        return distanceFromTopForLabelRadioButtons;
    }

    /**
     * Returns a value for table from right size.
     * 
     * @return 
     */
    public double getRightSizeForTable () { 
        return distanceFromRightForTable; 
    }

    /**
     * Returns a value for table from top size.
     * 
     * @return 
     */
    public double getBottomSizeForTable () { 
        return distanceFromBottomForTable;
    }

    /**
     * Returns a value for table from top side.
     * 
     * @return 
     */
    public double getTopSizeForTable () { 
        return distanceFromTopForTable; 
    }

    /**
     * Returns a value for file system from left side.
     * 
     * @return 
     */
    public double getLeftSizeForFileSystem () { 
        return distanceFromLeftForFileSystem; 
    }

    /**
     * Returns a value for file system from bottom side.
     * 
     * @return 
     */
    public double getBottomSizeForFileSystem () { 
        return distanceFromBottomForFileSystem; 
    }

    /**
     * Returns a value for file system from top side.
     * 
     * @return 
     */
    public double getTopSizeFileSystem () { 
        return distanceFromTopForFileSystem;
    }

    /**
     * Returns a value for label of file system from left side.
     * 
     * @return 
     */
    public double getLeftSizeForLabelFileSystem () { 
        return distanceFromLeftForLabelFileSystem;
    }

    /**
     * Returns a value for label of file system from top side.
     * 
     * @return 
     */
    public double getTopSizeForLabelFileSystem () { 
        return distanceFromTopForLabelFileSystem;
    }
}

