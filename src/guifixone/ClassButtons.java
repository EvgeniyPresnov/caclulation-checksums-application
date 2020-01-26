
package guifixone;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;


public class ClassButtons {
    private Button openButton = new Button("Open");
    private Button delButton = new Button("Remove row from table");
    private Button addButton = new Button("Add file to table");
    
    private ToggleGroup group = new ToggleGroup();
    private RadioButton btnMD5 = new RadioButton("MD5");
    private RadioButton btnSHA1 = new RadioButton("SHA-1");
    private RadioButton btnSHA224 = new RadioButton("SHA-224");
    private RadioButton btnSHA256 = new RadioButton("SHA-256");
    private RadioButton btnSHA384 = new RadioButton("SHA-384");
    private RadioButton btnSHA512 = new RadioButton("SHA-512");
    
    private VBox boxRadioButton = new VBox();
    
    public ClassButtons() {
        btnMD5.setToggleGroup(group);
        btnSHA1.setToggleGroup(group);
        btnSHA224.setToggleGroup(group);
        btnSHA256.setToggleGroup(group);
        btnSHA384.setToggleGroup(group);
        btnSHA512.setToggleGroup(group);   
    }
    
    public void openFileSystem(TableViewWidget table, ControlSum sum) {
        openButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               
                FileChooser fileChooser = new FileChooser();
                fileChooser.setInitialDirectory(new File("/home/"));
                FileChooser.ExtensionFilter filterOne = 
                    new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                FileChooser.ExtensionFilter filterTwo = 
                    new FileChooser.ExtensionFilter("All files", "*.");
                fileChooser.getExtensionFilters().addAll(filterOne, filterTwo);
                
                List<File>files = fileChooser.showOpenMultipleDialog(null);
                
                try {
                    
                    table.addRowsToTable(table.getInstance(), files, sum);
                } 
                catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(ClassButtons.class.getName()).log(Level.SEVERE, "Cannot to invoke into initial directory", ex);
                }
            }     
        });
        
    }
    
    public void deleteRowFromTable(TableViewWidget table) {
        delButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                int selectedRow = table.getInstance().getSelectionModel().getSelectedIndex();
                if (selectedRow >= 0) {
                    table.getInstance().getItems().remove(selectedRow);
                }
            }
        });
    }
    
    public void addFileFromTreeToTable(TreeViewWidget tree, 
        TableViewWidget table, ControlSum sum) {
        addButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                try {
                    table.getInstance().getItems().add(new FillTable(tree.getFileName(),
                        sum.chooseAlgorithm(tree.getFileName(), tree.getFileFromBrowser())));
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(ClassButtons.class.getName()).log(Level.SEVERE, "You have to choose one of the methods of checking sum", ex);
                }   
            }
        });
    }
    
    public Button getOpenButton() {
        return openButton;
    }
    
    public Button getAddButton() {
        return addButton;
    }
    
    public Button getDelButton() {
        return delButton;
    }
    
    public VBox getLayoutForRadioButtons() {
        boxRadioButton.getChildren().addAll(btnMD5, btnSHA1, btnSHA224, btnSHA256,
            btnSHA384, btnSHA512);
        return boxRadioButton;
    }

    public void setAlgorithCheckSum(ControlSum sum) {
        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            @Override
            public void changed(ObservableValue<? extends Toggle> ov,  Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {
                    RadioButton chooseCheckSumAlgorithm = (RadioButton) group.getSelectedToggle();
                    sum.setAlgorithm(chooseCheckSumAlgorithm.getText());
                }
                else {
                    Logger.getLogger(ClassButtons.class.getName()).log(Level.INFO, "No choose the method of checking sum");
                }
            }
        
        });
    }
   
}
