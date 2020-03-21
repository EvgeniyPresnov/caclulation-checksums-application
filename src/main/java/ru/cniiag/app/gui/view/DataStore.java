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

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.cniiag.app.gui.model.DataModel;

/**
 * This class describes the table for filling data.
 * 
 * @author Evgeniy Presnov
 */
public final class DataStore {
    /**
     * Creating the table.
     */
    private final TableView table = new TableView ();
    
    /**
     * Set the size for table.
     */
    private final static  int TABLE_SIZE_WIDTH = 400;
    private final static int TABLE_SIZE_HEIGHT = 400;
    
    /**
     * Set the directory where the user will select a
     * file from the file system.
     */
    private String initDir = "/home/";
    
    /**
     * Set the file format.
     */
    private String format = "TXT files";
    
    /**
     * Set the expansion for file.
     */
    private String expansion = "*.txt";
   
    /**
     * The constructor initializes the columns of table. 
     * 
     */
    public DataStore () {
        table.setPrefSize(TABLE_SIZE_WIDTH, TABLE_SIZE_HEIGHT);

        /**
         * Creating the scroll.
         */
        ScrollPane scroll = new ScrollPane ();
        
        /**
         * Set up the scroll. 
         */
        scroll.setVbarPolicy (ScrollPane.ScrollBarPolicy.ALWAYS);
        scroll.setHbarPolicy (ScrollPane.ScrollBarPolicy.ALWAYS);
        
        /**
         * Set the column for displaying the name.
         */
        TableColumn<DataModel, String> nameColumn 
            = new TableColumn<> ("File name");
        
        /**
         * Set the column for displaying the checking sum.
         */
        TableColumn<DataModel, String> sumColumn 
            = new TableColumn<> ("Checking sum");
        
        /**
         * Set the size for two columns.
         */
        final int  NAME_COLUMN_WIDTH = 150;
        final int SUM_COLUMN_WIDTH = 300;
        
        /**
         * Define how to fill data for each cell.
         */
        nameColumn.setCellValueFactory (new PropertyValueFactory<> ("Name"));
        sumColumn.setCellValueFactory (new PropertyValueFactory<> ("CheckSum"));
        
        nameColumn.setPrefWidth (NAME_COLUMN_WIDTH);
        sumColumn.setPrefWidth (SUM_COLUMN_WIDTH);
        
        table.getColumns ().addAll (nameColumn, sumColumn);
        scroll.setContent (table);
    }
    
    /**
     * Return the table.
     * 
     * @return table 
     */
    public TableView getTableView () {
        return table;
    }
    
    /**
     * Set the file format.
     * 
     * @param format 
     */
    public void setFormatForFile (String format) {
        this.format = format;
    }
    
    /**
     * Set the file expansion.
     * 
     * @param expansion 
     */
    public void setExpansionForFile (String expansion) {
        this.expansion = expansion;
    }
    
    /**
     * Set the directory.
     * 
     * @param initDir 
     */
    public void setInitDir (String initDir) {
        this.initDir = initDir;
    }
    
    /**
     * Return the file format.
     * 
     * @return 
     */
    public String getFormatForFile () {
        return format;
    }
    
    /**
     * Return the file expansion.
     * 
     * @return expansion
     */
    public String getExpansionForFile () {
        return expansion;
    }
    
    /**
     * Return the directory.
     * 
     * @return initDir
     */
    public String getInitDir () {
        return initDir;
    }
}
