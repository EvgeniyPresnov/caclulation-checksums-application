
package guifixone;


public class FillTable {
    private String fileName;
    private String filePath;
    private String controlSum;
    
    public FillTable() {}
    
    public FillTable(String name, String sum) {
        fileName = name;
        controlSum = sum;
    }
    
    public void setName(String name) {
        fileName = name;
    }
    
    public void setPath(String path) {
        filePath = path;
    }
    
    public void setSum(String sum) {
        controlSum = sum;
    }
    
    public String getName() {
        return fileName;
    }
    
    public String getPath() {
        return filePath;
    }

    public String getSum() {   
        return controlSum;
    }
}
