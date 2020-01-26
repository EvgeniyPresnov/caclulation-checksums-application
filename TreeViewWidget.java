
package guifixone;

import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;


public class TreeViewWidget {
    private TreeView treeView = new TreeView();
    private String selectedFile, fileName, filePath, controlSum;

    public TreeView getInstance() {
        return treeView;
    }
    
    public void setTreeViewWidgetSize(int width, int height) {
        treeView.setPrefSize(width, height);
    }
    
    public TreeView<File> getFileBrowser() {
        treeView = buildFileSystemBrowser();
        return treeView;
    }
    
    
    private TreeView buildFileSystemBrowser() {
        TreeItem<File> root = createNode(new File("//"));
        return new TreeView<File>(root);
    }
    
    private TreeItem<File> createNode(File file) {
        return new TreeItem<File>(file) {
        
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
            File file = (File) getValue();
            isLeaf = file.isFile();
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
