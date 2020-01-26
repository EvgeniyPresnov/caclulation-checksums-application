
package guifixone;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class TableViewWidget {
    private TableView table = new TableView();

    public TableViewWidget() {
        ScrollPane scroll = new ScrollPane();
        scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scroll.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        
        TableColumn<FillTable, String> nameColumn 
            = new TableColumn<FillTable, String>("File name");

        TableColumn<FillTable, String> sumColumn 
            = new TableColumn<FillTable, String>("Control sum");
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setPrefWidth(100);

        sumColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));
        sumColumn.setPrefWidth(400);
        
        table.getColumns().addAll(nameColumn, sumColumn);
        scroll.setContent(table);
    }
    

    public void setTableViewWidgetSize(int width, int height) {
        table.setPrefSize(width, height);
    }
    
    public TableView getInstance() {
        return table;
    }

     public void addRowsToTable(TableView table, List<File> files, ControlSum sum) throws IOException {
        try {
            if (files == null || files.isEmpty()) {
                return;
            }
            for (File file: files) {
                table.getItems().add(new FillTable(file.getName(),
                        sum.chooseAlgorithm(file.getName(), file.getPath()))); 
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(ClassButtons.class.getName()).log(Level.SEVERE, 
                "Cannot add the file to table because it is empty", ex);
        }
    }
}
