
package featurewithfilebrowsertotableview;


public class FillTable {
    private String fileName;
    private String filePath;
    private String controlSum;
    //private String dataCreation;
    
    public FillTable() {}
    
    public FillTable(String name, String path, String sum/*, String data*/) {
        fileName = name;
        filePath = path;
        controlSum = sum;
        //dataCreation = data;
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
    /*
    void add(FillTable fillTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
    
    public String getSum() {
        return controlSum;
    }
    
    public void setSum(String sum) {
        controlSum = sum;
    }
    /*
    public String getDataCreation() {
        return dataCreation;
    }
    
    public void setDataCreation(String data) {
        data = dataCreation;
    }
*/
}
