
package featurewithfilebrowsertotableview;

import java.io.File;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class FeatureWithFileBrowserToTableView extends Application {
    
    TableView<FillTable> table = new TableView<FillTable>();
    ObservableList<FillTable> l;
    
    @Override
    public void start(Stage primaryStage) {
        
        TableColumn<FillTable, String> nameColumn = new 
            TableColumn<FillTable, String>("File Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setPrefWidth(100);
        
        TableColumn<FillTable, String> pathColumn = new 
            TableColumn<FillTable, String>("Path of the file");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("path"));
        pathColumn.setPrefWidth(100);
        
        
        BorderPane root = new BorderPane();
        table.setPrefSize(700, 500);
        root.setRight(table);
        
        FileBrowser browser = new FileBrowser();
        TreeView<File> tree = browser.getFileBrowser();
        
        
        
        tree.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                    //OK: System.out.println("get() is = " + browser.getListFile());
                    //l = browser.getTableList();
                    //l = FXCollections.observableArrayList(browser.());
                    //System.out.println("getTablelist() is " + browser.getTableList());
            }
        });
        
        table.setItems(l);
        table.getColumns().addAll(nameColumn, pathColumn);
        root.setLeft(tree);
        
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
  
    public static void main(String[] args) {
        launch(args);
    }
    
}
