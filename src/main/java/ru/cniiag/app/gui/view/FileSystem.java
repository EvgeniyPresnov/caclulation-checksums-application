/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.cniiag.app.gui.view;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Evgeniy Presnov
 */
public class FileSystem {
    private TreeView<File> treeView;
    
    //private String fileName = "";
    //private String filePath = "";
    private static String initDir = "~";
    
    private final static int sizeWidth = 250;
    private final static int sizeHeight = 400;
    
    public FileSystem () {
        TreeItem<File> root = createNode (new File (initDir));
        treeView = new TreeView<> (root);
        treeView.setPrefSize (sizeWidth, sizeHeight);
    }
    
    public TreeView getTreeView () {
        return treeView;
    }
    
    
    // public void getFileBrowser () { treeView = buildFileSystemBrowser (); }
    
    /*
    private TreeView buildFileSystemBrowser () {
        TreeItem<File> root = createNode (new File (initDir));
        return 
    }
    */
    private TreeItem<File> createNode (File file) {
        return new TreeItem<File> (file) {

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
                        /*
                        final MultipleSelectionModel<TreeItem<File>> selection =
                                treeView.getSelectionModel ();
                        selection.setSelectionMode (SelectionMode.MULTIPLE);
                        
                        treeView.setOnMousePressed (new EventHandler<MouseEvent> () {                           
                            @Override
                            public void handle(MouseEvent event) {
                                String name = "";
                                String path = "";
                                
                                for (TreeItem<File> item: selection.getSelectedItems ()) {
                                    setFileName (name += item.getValue ().getName () + "\n");
                                    setFilePath (path += item.getValue().getPath () + "\n");
                                }
                            }
                        });
                    }
                    */
                return children;
                }
            }
            return FXCollections.emptyObservableList ();
        }
    };
    }
    /*
    public String getFileName () {
        return fileName;
    }
 
    public void setFileName (String name) {
        fileName = name;
    }

    public String getFilePath () {
        return filePath;
    }

    public void setFilePath (String path) {
        filePath = path;
    }
    */
}
