/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui.view;

import javafx.scene.layout.AnchorPane;

/**
  * This class defines the distance from the main application window 
  * to each widget located in this window.
  * 
  * @author Evgeniy Presnov
  * 
  */
public class SetterPositions {
    // The creation a layout.
    private static final AnchorPane anchorPane = new AnchorPane ();
    
     // The initialization the sizes for window of application.
    private final int sizeWidth = 1000;
    private final int sizeHeight = 600;
    
    /**
     * The declaration the fields of this class.
     */
    private final double distanceFromTopForOpenInitButton;
    private final double distanceFromRightForOpenInitButton;
    
    private final double distanceFromRightForLabelOpenButton;
    private final double distanceFromTopForLabelOpenButton;
    
    private final int distanceFromLeftForRadioButtons;
    private final int distanceFromTopForRadioButtons;
        
    private final double distanceFromLeftForLabelRadioButtons;
    private final double distanceFromTopForLabelRadioButtons;
    
    private final double distanceFromRightForTable;
    private final double distanceFromBottomForTable;
    private final double distanceFromTopForTable;
    
    /**
    * The constructor initializes the values for fields this class.
    * 
    */
    public SetterPositions () {
        distanceFromTopForOpenInitButton = 10.0;
        distanceFromRightForOpenInitButton = 10.0;
                
        distanceFromRightForLabelOpenButton = 210.0;
        distanceFromTopForLabelOpenButton = 16.0;
        
        distanceFromLeftForRadioButtons = 270;
        distanceFromTopForRadioButtons = 200;
    
        
        distanceFromLeftForLabelRadioButtons = 270;
        distanceFromTopForLabelRadioButtons = 160;
    
        distanceFromRightForTable = 10.0;
        distanceFromBottomForTable = 30.0;
        distanceFromTopForTable = 45.0;
    }
    
    /**
     * Returns an instance of AnchorPane class.
     * 
     * @return anchorPane
     */
    public AnchorPane getInstance () {
        return anchorPane;
    }
    
    /***
     * Returns a value of width for application.
     * 
     * @return sizeWidth
     */
    public int getWidthForApp () {
        return sizeWidth;
    }
    
        /**
     * Returns a value of height for application. 
     * 
     * @return sizeHeight
     */
    public int getHeightForApp () {
        return sizeHeight;
    }
    
     /**
     * Returns a value for table from right size.
     * 
     * @return distanceFromRightForTable
     */
    public double getRightSizeForTable () {
        return distanceFromRightForTable;
    }
    
    /**
     * Returns a value for table from bottom size.
     * 
     * @return 
     */
    public double getBottomSizeForTable () {
        return distanceFromBottomForTable;
    }
    
    /**
     * Returns a value for table from top size.
     * 
     * @return distanceFromTopForTable
     */
    public double getTopSizeForTable () {
        return distanceFromTopForTable;
    }
    
     /**
     * Returns a value for 'Open' button from top side.
     * 
     * @return distanceFromTopForOpenInitButton
     */
    public double getTopSizeForOpenInitButton () {
        return distanceFromTopForOpenInitButton;
    }
    
     /**
     * Returns a value for 'Open' button right side.
     * 
     * @return distanceFromRightForOpenInitButton
     */
    public double getRightSizeForOpenInitButton () {
        return distanceFromRightForOpenInitButton;
    }
    
    /**
     * Returns a value for label of 'Open' button from right side.
     * 
     * @return distanceFromRightForLabelOpenButton
     */
    public double getRightSizeForLabelOpenInitButton () {
        return distanceFromRightForLabelOpenButton;
    }
    
    /**
     * Returns a value for label of 'Open' button from top side. 
     * 
     * @return distanceFromTopForLabelOpenButton
     */
    public double getTopSizeForLabelOpenInitButton () {
        return distanceFromTopForLabelOpenButton;
    }
    
    /**
     * Returns a value for RadioButtons from left side.
     * 
     * @return distanceFromLeftForRadioButtons
     */
    public double getLeftSizeForRadioButtons () {
        return distanceFromLeftForRadioButtons;
    }
    
    /**
     * Returns a value for RadioButtons from top side.
     * 
     * @return distanceFromTopForRadioButtons
     */
    public double getTopSizeForRadioButtons () {
        return distanceFromTopForRadioButtons;
    }
    
    /**
     * Returns a value for label of RadioButtons from left side. 
     * 
     * @return distanceFromLeftForLabelRadioButtons
     */
    public double getLeftSizeForLabelRadioButtons () {
        return distanceFromLeftForLabelRadioButtons;
    }
    
     /**
     * Returns a value for label of RadioButtons from top side.
     * 
     * @return distanceFromTopForLabelRadioButtons
     */
    public double getTopSizeForLabelRadioButtons () {
        return distanceFromTopForLabelRadioButtons;
    }    
}
