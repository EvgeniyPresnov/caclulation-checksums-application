
package featurewithfilebrowsertotableview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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
        
        TableColumn<FillTable, String> sumColumn = 
                new TableColumn<FillTable, String>("Control Sum");
        
        //TableColumn<FillTable, String> creationColumn = 
        //        new TableColumn<FillTable, String>("Data of creation");
        
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setPrefWidth(100);
        
        pathColumn.setCellValueFactory(new PropertyValueFactory<>("path"));
        pathColumn.setPrefWidth(250);
        
        sumColumn.setCellValueFactory(new PropertyValueFactory<>("sum"));
        sumColumn.setPrefWidth(300);
        
        //creationColumn.setCellValueFactory(new PropertyValueFactory<>("dataCreation"));
        //creationColumn.setPrefWidth(100);
        
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
                try {
                    table.getItems().add(new FillTable(browser.getFileName(),
                            browser.getFilePath(), 
                            controlSum(new File(browser.getFileFromBrowser()))));
                } catch (IOException ex) {
                    Logger.getLogger(FeatureWithFileBrowserToTableView.class.getName()).log(Level.SEVERE, null, ex);
                }  
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
        
        table.getColumns().addAll(nameColumn, pathColumn, sumColumn);
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
    
    private String controlSum(File file) throws FileNotFoundException, IOException {
        try {
            InputStream fin = new FileInputStream(file);
            //System.out.println("fin is " + fin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int read = 0;
            do {
                read = fin.read(buffer);
                if (read > 0) 
                    md.update(buffer, 0, read);
            } while (read != -1);
            fin.close();
            byte[] digest = md.digest();
            if (digest == null)
                return null;
            String strDigest = "";
            for (int i = 0; i < digest.length; i++) {
                strDigest += Integer.toString((digest[i] & 0xff)
                    +0x100, 16).substring(1);
            }
            return strDigest.toLowerCase();
        }
        catch (Exception e) {
            return null;
        }
    }
    
    private void addRows(TableView table, List<File> files) throws IOException {
        if (files == null || files.isEmpty()) {
            System.out.println("Error: no files");
            return;
        }
        for (File file: files) {
            Path filePath = file.toPath();
            BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
            table.getItems().add(new FillTable(file.getName(), file.getPath(),
                    controlSum(file))); 
                    /*, attr.lastModifiedTime().toString() */
        }
    }
}
