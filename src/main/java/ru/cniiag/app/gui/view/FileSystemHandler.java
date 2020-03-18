/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui.view;

import java.io.File;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

/**
 * This class allows to select a file from the file system
 * tree to calculate its checking sum.
 * 
 * @author Evgeniy Presnov
 */
public final class FileSystemHandler {
    private final TreeView<File> treeView;
    
    private String fileName = null;
    private String filePath = null;
    
    /**
     * Set the size for TreeView object.
     */
    private final static int TREE_SIZE_WIDTH = 250;
    private final static int TREE_SIZE_HEIGTH = 400;

    /**
     * Get the items selected in TreeView.
     */
    final MultipleSelectionModel<TreeItem<File>> selection;
    
    /**
     * Set the root directory.
     */
    private final static String ROOT_DIR = "~";
    
    public FileSystemHandler () {
        treeView = new TreeView<> (new FileSystem (new File (ROOT_DIR)));
        treeView.setPrefSize (TREE_SIZE_WIDTH, TREE_SIZE_HEIGTH);
        
        selection = treeView.getSelectionModel ();
        selection.setSelectionMode (SelectionMode.SINGLE);
        
        /**
         * This method allows to select an element from the file system
         * to its checksum.
         */
        treeView.setOnMousePressed ( (MouseEvent event) -> {
            String name = null;
            String path = null;
            
            for (TreeItem<File> item: selection.getSelectedItems ()) {
                setFileName (name += item.getValue ().getName () + "\n");
                setFilePath (path += item.getValue().getPath () + "\n");
            }
        });
    }

    /**
     * Return the file of name.
     * 
     * @return fileName
     */
    public String getFileName () { 
        return fileName;
    }
 
    /**
     * Set the file name.
     * 
     * @param name 
     */
    public void setFileName (String name) { 
        fileName = name;
    }
    
    /**
     * Return the file path.
     * 
     * @return filePath
     */
    public String getFilePath () { 
        return filePath;
    }

    /**
     * Set the path file.
     * 
     * @param path 
     */
    public void setFilePath (String path) { 
        filePath = path;
    }

    /**
     * Return the treeView object.
     * 
     * @return treeView
     */
    public TreeView getTreeView () {
        return treeView;
    }
}
