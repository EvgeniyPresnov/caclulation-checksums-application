
package guifixone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ControlSum {

    private String algorithm, command;
    
    public ControlSum() {}

    public String checkSum(String fileName, String filePath, 
        String command) throws IOException {

        Process process = Runtime.getRuntime().exec(
            command + " " + filePath + " " + fileName);
        
        BufferedReader reader = new BufferedReader(
        new InputStreamReader(process.getInputStream()));
        
        String line;
        StringBuilder out = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        reader.close();
        return out.toString();
    }

    public void setAlgorithm(String algorithm) {
       
        this.algorithm = algorithm;
         System.out.println("setAlgorithm is " + this.algorithm);
    }

    public String chooseAlgorithm(String fileName, String filePath) throws IOException {
        System.out.println("chooseAlgorithm() " );
        if (algorithm == "MD5") {
            command = "md5sum"; 
        }
        
        else if (algorithm == "SHA-1") {
            command = "sha1sum";
        }
        
        else if (algorithm == "SHA-224") {
            command = "sha224sum"; 
        }
        
        else if (algorithm == "SHA-256") {
            command = "sha256sum";
        }
        
        else if (algorithm == "SHA-384") {
            command = "sha384sum";   
        }
        
        else if (algorithm == "SHA-512") {
            command = "sha512sum";
        }
        
        return checkSum(fileName, filePath, command);
    } 
    
}
