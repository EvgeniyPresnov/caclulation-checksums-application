/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui.view;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;

/**
 * This class is an implementation of displaying a
 * tree of file system
 * 
 * @author Evgeniy Presnov
 */
public class FileSystem extends TreeItem<File> {
    
    private boolean isFirstTimeChildren = true;
    private boolean isFirstTimeLeaf = true;
    private boolean isLeaf;
    
    /**
     * Create of the message box for displaying the warnings.
    */
    Alert alert = new Alert (Alert.AlertType.WARNING);
    
    /**
     * The constructor of super class in order to create
     * a new TreeItem<File>.
     * @param file 
     */
    public FileSystem (File file) {
        super (file);
    }

    /**
     * @see javafx.scene.control.TreeItem#isLeaf() 
     */
    @Override
    public ObservableList<TreeItem<File>> getChildren () {
      if (isFirstTimeChildren) {
        isFirstTimeChildren = false;
        super.getChildren ().setAll (buildChildren (this));
      }
      return super.getChildren ();
    }
    
    /**
     * @see javafx.scene.control.TreeItem#getChildren() 
     */
    @Override
    public boolean isLeaf () {
      if (isFirstTimeLeaf) {
        /**
         * First getChildren() call, so we actually go off and determine
         * the children of the File contained in this TreeItem.
         */
        isFirstTimeLeaf = false;
      }
      return isLeaf;
    }

    /**
     * Return a collection of type ObservableList containing TreeItem, 
     * which represents all children available in handed TreeItem.
     * 
     * @param TreeItem the root node from which children a collection of
     * TreeItem should be created.
     * @return an ObservableList<TreeItem<File>> containing TreeItems,
     * which represents all children available in handed TreeItem. If 
     * the handed TreeItem is a leaf, an empty list is returned.
     */
    private ObservableList<TreeItem<File>> buildChildren (
        TreeItem<File> TreeItem) {
            
        File f = TreeItem.getValue();
        if (f != null && f.isDirectory()) {
            File[] files = f.listFiles();
            if (files != null) {
                ObservableList<TreeItem<File>> children = 
                FXCollections.observableArrayList();
                
                for (File childFile : files) {
                    children.add (new FileSystem (childFile));
                }
                return children;
            }
            else {
                alert.setTitle ("Warning message box");
                alert.setHeaderText ("The file is empty");
                alert.showAndWait ();
            }
        }
        return FXCollections.emptyObservableList();
    }
}
