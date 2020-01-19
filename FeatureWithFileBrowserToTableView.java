
package featurewithfilebrowsertotableview;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class FeatureWithFileBrowserToTableView extends Application {
    
    TableView table = new TableView();
    
    
    ObservableList<FillTable> l;
    Button addToTable = new Button("Add file to table");
    Button delFromTable = new Button("Delete row from table");
    Button open = new Button("Open ...");
    
    @Override
    public void start(Stage primaryStage) {
        
        TableColumn<FillTable, String> nameColumn = 
                new TableColumn<FillTable, String>("File Name");
        
        TableColumn<FillTable, String> pathColumn = 
                new TableColumn<FillTable, String>("Path of the file");
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setPrefWidth(100);
        
        pathColumn.setCellValueFactory(new PropertyValueFactory<>("path"));
        pathColumn.setPrefWidth(100);
        
        
        BorderPane root = new BorderPane();
        table.setPrefSize(700, 500);
        root.setRight(table);
        
        FileBrowser browser = new FileBrowser();
        TreeView<File> tree = browser.getFileBrowser();
        
        VBox box = new VBox();
        addToTable.setAlignment(Pos.CENTER);
        delFromTable.setAlignment(Pos.CENTER);
        open.setAlignment(Pos.CENTER);
        box.getChildren().addAll(addToTable, delFromTable, open);
        
        root.setCenter(box);
        
        
        addToTable.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                table.getItems().add(new FillTable(browser.getFileName(),
                        browser.getFilePath()));
            }
        });
        
        open.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialDirectory(new File("/home/"));
                FileChooser.ExtensionFilter filterOne = 
                    new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                FileChooser.ExtensionFilter filterTwo = 
                    new FileChooser.ExtensionFilter("All files", "*.");
                fileChooser.getExtensionFilters().addAll(filterOne, filterTwo);
                
                List<File> files = fileChooser.showOpenMultipleDialog(primaryStage);
                try {
                    addRows(table, files);
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(FeatureWithFileBrowserToTableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });
        
        
        delFromTable.setOnAction(event -> deleteRow());
        
        table.getColumns().addAll(nameColumn, pathColumn);
        root.setLeft(tree);
        
        
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    private void deleteRow() {
        int selectedRow = table.getSelectionModel().getSelectedIndex();
        if (selectedRow >= 0) {
            table.getItems().remove(selectedRow);
        }
    }  
    
    private void addRows(TableView table, List<File> files) throws IOException {
        if (files == null || files.isEmpty()) {
            System.out.println("Error: no files");
            return;
        }
        for (File file: files) {
            Path filePAth = file.toPath();
            table.getItems().add(new FillTable(file.getName(), file.getPath()));
        }
    }
}
