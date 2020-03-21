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

package ru.cniiag.app.gui.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class provides the ability to use the command line to invoke the 
 * command to calculate the checking sum for a file.
 * 
 * @author Evgeniy Presnov
 */
public final class CalculatorCheckSum {
    
    /**
     * This method uses the parameters to calculate the checking sum of file by 
     * invoking the command from the command line.
     * 
     * @param fileName
     * @param filePath
     * @param command
     * @return splitResult[0] 
     * @throws IOException 
     */
    public static String calculateFile (
        String fileName
        , String filePath 
        , String command) throws IOException{
        
        StringBuilder result = new StringBuilder ();

        /**
         * The run the command from prompt command.
         */
        Process process = Runtime.getRuntime ()
        . exec (command + " " + filePath + " " + fileName);
        
        
        try (BufferedReader reader = new BufferedReader (new InputStreamReader (
                process.getInputStream (), "UTF-8"))) {
            String line = "";
            /**
             * Read output from the command.
             */
            while ( (line = reader.readLine() ) != null) {
                result.append (line);
            }
        }
        
        /**
         * Set the template to searching for the 
         * first match in the resulting string.
         */
        String pattern = " ";
        
        /**
         * This line allows to split the string according to the pattern,
         * where the first element of the array is the checking sum.
         */
        String[] splitResult = result.toString ().split (pattern);
        return splitResult[0];
    }
}
