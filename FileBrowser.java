
package featurewithfilebrowsertotableview;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
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
    //private ObservableList<FillTable> list;
    private String fileName, filePath;
    
    /*
    private int w, h;
    
    public FileBrowser() {
        treeView.setPrefSize(300, 400);
    }
    
    public FileBrowser(int width, int heigth) {
        w = width; h = heigth;
        treeView = null;
        treeView.setPrefSize(w, h);
    }
    */
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
                                
                                String name = ""; String path = "";
                                for (TreeItem<File> item: selection.getSelectedItems()) {
                                    //tmp += item.getValue().getName() + "\n";
                                    //setListFile(tmp);
                                    
                                    setFileName(/*tmp += */ name += item.getValue().getName() + "\n");
                                    setFilePath(/*tmp += */ path += item.getValue().getPath() + "\n");
                                    //getTableList(childFile);
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
    /*
    public String getListFile() {
        return selectedFile;
    }
   
    public void setListFile(String file) {
        this.selectedFile = file;
        //System.out.println("set() is " + this.selectedFile);
    }
    */
    /*
    public void setTableList(File file) {
        //System.out.println("setTableList() name: " + file.getName().toString());
        //System.out.println("setTableList() path: " + file.getPath().toString());
        FillTable a = new FillTable(file.getName().toString(), 
                file.getPath().toString());
        System.out.println("My class is " + a.getName());
        ObservableList<FillTable> list = FXCollections.observableArrayList(a);
      // System.out.println("list.size() " + list.size());
        
    }
    */
    
    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String file) {
        fileName = file;
    }
    
    public String getFilePath() {
        return filePath;
    }
    
    public void setFilePath(String path) {
        filePath = path;
    }
    
}
