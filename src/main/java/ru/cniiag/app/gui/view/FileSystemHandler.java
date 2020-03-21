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

import java.io.File;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javax.swing.filechooser.FileSystemView;

/**
 * This class allows to select a file from the file system
 * tree to calculate its checking sum.
 * 
 * @author Evgeniy Presnov
 */
public final class FileSystemHandler {
    private final TreeView<File> treeView;
    
    private String fileName = "";
    private String filePath = "";
    
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
    private final File ROOT_DIR = 
        FileSystemView.getFileSystemView ().getRoots () [0];
    
    public FileSystemHandler () {
        treeView = new TreeView<> (new FileSystem (ROOT_DIR));
        treeView.setPrefSize (TREE_SIZE_WIDTH, TREE_SIZE_HEIGTH);
        
        selection = treeView.getSelectionModel ();
        selection.setSelectionMode (SelectionMode.SINGLE);
        
        /**
         * This method allows to select an element from the file system
         * to its checksum.
         */
        treeView.setOnMousePressed ( (MouseEvent event) -> {
            selection.getSelectedItems ().stream ().map( (item) ->{
                setFileName (item.getValue ().getName () );
                return item; 
            }).forEachOrdered((item) -> {
                setFilePath (item.getValue ().getPath () );
            });
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
