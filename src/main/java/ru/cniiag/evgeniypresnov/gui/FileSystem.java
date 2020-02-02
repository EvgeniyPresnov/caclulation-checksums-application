/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.evgeniypresnov.gui;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

/**
 *  This class is a simple implementation of a TreeItem for
 *  displaying a file system tree.
 * 
 * @author Evgeniy Presnov
 */
public class FileSystem {
    // The initialization the tree of file system.
    private TreeView treeView = new TreeView ();
    
    // Creation a label for file system.
    private final Label label = new Label("Representation of file system");
    
    // The Initialization the fields of class. 
    private String  fileName = "";
    private String filePath = "";
    private String controlSum = "";
    
    // The initialization a size the tree.
    private final int sizeWidth = 500;
    private final int sizeHeight = 400;
    
    /**
     * The constructor initialize a size of treeView widget
     * (file system)
     * 
     */
    public FileSystem() {
        treeView.setPrefSize (sizeWidth, sizeHeight);
    }
    
    /**
     * Returns an instance of TreeView.
     * 
     * @return 
     */
    public TreeView getInstance () {
        return treeView;
    }
    
    /**
     * Returns an instance of Label class.
     * 
     * @return 
     */
    public Label getLabelFileSystem() {
        return label;
    }
    
    /**
     * This method return the file system, which represents as tree.
     * 
     * @return 
     */
    public void getFileBrowser () {
        treeView = buildFileSystemBrowser ();
    }
    
    /**
     * This initialization a parent node
     * 
     * @return 
     */
    private TreeView buildFileSystemBrowser () {
        TreeItem<File> root = createNode (new File ("//"));
        return new TreeView<File> (root);
    }
    
    /**
     * This method creates a item to represent the given File.
     * 
     * @param file
     * @return 
     */
    private TreeItem<File> createNode (File file) {
        return new TreeItem<File> (file) {
        // We cahce whether the file is a leaf or not. A file is a leaf if isn't
        // directory and doesn't have any files contained within it.
        private boolean isLeaf;
        private boolean isFirstTimeChildren = true;
        private boolean isFirstTimeLeaf = true;

        @Override
        public ObservableList<TreeItem<File>> getChildren () {
          if (isFirstTimeChildren) {
            isFirstTimeChildren = false;
            
            super.getChildren ().setAll (buildChildren (this));
          }
          return super.getChildren();
        }

        @Override
        public boolean isLeaf() {
          if (isFirstTimeLeaf) {
            isFirstTimeLeaf = false;
            File file = (File) getValue ();
            isLeaf = file.isFile ();
          }
          return isLeaf;
        }
        
        /**
         * Returning a collection of type ObservableList containing TreeItems, 
         * which represent all children available in handed TreeItem.
         * 
         * @param TreeItem the root node from which children a collection of
         * TreeItem should be created.
         * @return an ObservableList<TreeItem<File>> containing TreeItems, which
	 * represent all children available in handed TreeItem. If the
	 * handed TreeItem is a leaf, an empty list is returned
         */
        private ObservableList<TreeItem<File>> buildChildren(
            TreeItem<File> TreeItem) {
            File f = TreeItem.getValue ();
            if (f != null && f.isDirectory ()) {
                File[] files = f.listFiles ();
                if (files != null) {
                    ObservableList<TreeItem<File>> children =
                            FXCollections.observableArrayList ();
                    for (File childFile : files) {
                        children.add (createNode (childFile)); 
                        final MultipleSelectionModel<TreeItem<File>> selection =
                                treeView.getSelectionModel ();
                        selection.setSelectionMode (SelectionMode.MULTIPLE);
                        
                        treeView.setOnMousePressed (new EventHandler<MouseEvent> () {                           
                            @Override
                            public void handle(MouseEvent event) {
                                String name = "";
                                String path = "";
                                String sum = "";
                                
                                for (TreeItem<File> item: selection.getSelectedItems ()) {
                                    setFileName (name += item.getValue ().getName () + "\n");
                                    setFilePath (path += item.getValue().getPath () + "\n");
                                    setCheckSum (sum += item.getValue ().getAbsolutePath ());
                                }
                            }
                        });
                    }
                return children;
                }
            }
            return FXCollections.emptyObservableList ();
        }
    };
    }
    
    /***
     * Returns the name of file.
     * 
     * @return 
     */
    public String getFileName () {
        return fileName;
    }
    
    /**
     * Set a value the name of file.
     * 
     * @param file 
     */
    public void setFileName (String file) {
        fileName = file;
    }
    
    /**
     * Returns the path of file.
     * 
     * @return 
     */
    public String getFilePath () {
        return filePath;
    }
    
    /**
     * Set a value of path of file.
     * 
     * @param file 
     */
    public void setFilePath (String file) {
        filePath = file;
    }
    
    /**
     * Returns the value of checking sum.
     * 
     * @return 
     */
    public String getCheckSum () {
        return controlSum;
    }
    
    /**
     * Set a value of checking sum.
     * 
     * @param file 
     */
    public void setCheckSum (String file) {
        controlSum = file;
    }
}

