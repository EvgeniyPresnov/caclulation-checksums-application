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

package ru.cniiag.app.gui.model;

/**
 * This class defines the data model.Based on this class, we will generate 
 * data for filling in the table.
 * 
 * @author Evgeniy Presnov
 */
public final class DataModel {
    /**
     *Storing the file name.
     */
    private String fileName = "";
    
    /**
     * Storing the checking sum.
     */
    private String checkSum = "";
    
    /**
     * The constructor accepts the parameters for initializing 
     * fields of this class.
     * 
     * @param fileName
     * @param checkSum 
     */
    public DataModel (String fileName, String checkSum) {
        this.fileName = fileName;
        this.checkSum = checkSum;
    }
    
    /**
     * Set the name for the file.
     * 
     * @param name 
     */
    public void setName (String name) {
        fileName = name;
    }
    
    /**
     * Set the checking sum for the file.
     * 
     * @param sum 
     */
    public void setCheckSum (String sum) {
        checkSum = sum;
    }
    
    /**
     * Return the name of file.
     * 
     * @return 
     */
    public String getName () {
        return fileName;
    }
    
    /**
     * Return the checking sum of file.
     * 
     * @return 
     */
    public String getCheckSum () {   
        return checkSum;
    }
}
