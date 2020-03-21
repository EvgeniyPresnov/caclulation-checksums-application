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
public final class FileSystem extends TreeItem<File> {
    
    private boolean isFirstTimeChildren = true;
    private boolean isFirstTimeLeaf = true;
    private boolean isLeaf;

    /**
     * The constructor of super class in order to create
     * a new TreeItem<File>.
     * @param file 
     */
    
    public FileSystem (File file) {
        super (file);
    }
    
    /**
     * 
     * @see javafx.scene.control.TreeItem#isLeaf()
     */
    @Override
    public boolean isLeaf () {
        if (isFirstTimeLeaf) {
            isFirstTimeLeaf = false;
            /**
             * First getChildren() call, so we actually go off and determine
             * the children of the File contained in this TreeItem.
             */
            File file = (File) getValue ();
            isLeaf = file.isFile ();
        }
        return isLeaf;
    }
    
    /**
     * 
     * @see javafx.scene.control.TreeItem#getChildren() 
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
            
        File f = TreeItem.getValue ();
        if (f != null && f.isDirectory ()) {
            File[] files = f.listFiles ();
            if (files != null) {
                ObservableList<TreeItem<File>> children = 
                FXCollections.observableArrayList();
                
                for (File childFile : files) {
                    children.add (new FileSystem (childFile));
                }
                return children;
            }
            else {
                Alert alert = new Alert (Alert.AlertType.WARNING);
                alert.setTitle ("Warning message box");
                alert.setHeaderText ("The invalid data");
                alert.showAndWait ();
            }
        }
        return FXCollections.emptyObservableList();
    }
}
