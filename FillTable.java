
package featurewithfilebrowsertotableview;


public class FillTable {
    private String fileName;
    private String filePath;
    
    public FillTable() {}
    
    public FillTable(String name, String path) {
        fileName = name;
        filePath = path;
    }
    
    public void setName(String name) {
        fileName = name;
    }
    
    public void setPath(String path) {
        filePath = path;
    }
    
    public String getName() {
        return fileName;
    }
    
    public String getPath() {
        return filePath;
    }

    void add(FillTable fillTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
