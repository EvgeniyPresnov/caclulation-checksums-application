
package featurewithfilebrowsertotableview;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;

public class FileBrowser {
    
    private TreeView treeView;
    private String selectedFile = "";
    private String fileName, filePath, controlSum;
        
    private TreeView buildFileSystemBrowser() {
        TreeItem<File> root = createNode(new File("//"));
        return new TreeView<File>(root);
    }
    
    private TreeItem<File> createNode(File f) { 
        return new TreeItem<File>(f) {
        
        private boolean isLeaf;
        private boolean isFirstTimeChildren = true;
        private boolean isFirstTimeLeaf = true;

        @Override
        public ObservableList<TreeItem<File>> getChildren() {
          if (isFirstTimeChildren) {
            isFirstTimeChildren = false;
            super.getChildren().setAll(buildChildren(this));
          }
          return super.getChildren();
        }

        @Override
        public boolean isLeaf() {
          if (isFirstTimeLeaf) {
            isFirstTimeLeaf = false;
            File f = (File) getValue();
            isLeaf = f.isFile();
          }
          return isLeaf;
        }

        private ObservableList<TreeItem<File>> buildChildren(
            TreeItem<File> TreeItem) {
              
            File f = TreeItem.getValue();
            if (f != null && f.isDirectory()) {
                File[] files = f.listFiles();
                if (files != null) {
                    ObservableList<TreeItem<File>> children =
                            FXCollections.observableArrayList();
                    for (File childFile : files) {
                        children.add(createNode(childFile)); 
                        MultipleSelectionModel<TreeItem<File>> selection =
                                treeView.getSelectionModel();
                        selection.setSelectionMode(SelectionMode.MULTIPLE);
                        
                        treeView.setOnMousePressed(new EventHandler<MouseEvent>() {                           
                            @Override
                            public void handle(MouseEvent event) {
                                
                                String name = ""; String path = ""; String sum = "";
                                for (TreeItem<File> item: selection.getSelectedItems()) {
                                    setFileName(name += item.getValue().getName() + "\n");
                                    setFilePath(path += item.getValue().getPath() + "\n");
                                    setFileFromBrowser(sum += item.getValue().getAbsolutePath());
                                }
                            }
                        });
                    }
                return children;
                }
            }
            return FXCollections.emptyObservableList();
        }
    };
    }
    
    public TreeView<File> getFileBrowser() {
        treeView = buildFileSystemBrowser();
        treeView.setPrefSize(400, 500);
        return treeView;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String file) {
        fileName = file;
    }
    
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String file) {
        filePath = file;
    }
    
    public String getFileFromBrowser() {
        return controlSum;
    }
    
    public void setFileFromBrowser(String file) {
        controlSum = file;
    }
    
}
