
package guifixone;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GuiFixOne extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 600, 400);
        
        VBox vBox = new VBox();
        
        ControlSum sum = new ControlSum();
        
        TableViewWidget table = new TableViewWidget();
        table.setTableViewWidgetSize(600, 400);
        
        TreeViewWidget treeFileSystem = new TreeViewWidget();
        treeFileSystem.setTreeViewWidgetSize(500, 400);
        treeFileSystem.getFileBrowser();
        
        ClassButtons buttons = new ClassButtons();
        buttons.openFileSystem(table, sum);
        buttons.deleteRowFromTable(table);
        buttons.setAlgorithCheckSum(sum);
        buttons.addFileFromTreeToTable(treeFileSystem, table, sum);
        
        vBox.getChildren().addAll(buttons.getOpenButton(),
            buttons.getAddButton(),buttons.getDelButton(), 
            buttons.getLayoutForRadioButtons());
        
        root.setLeft(treeFileSystem.getInstance());
        root.setRight(table.getInstance());
        root.setCenter(vBox);
        
 
        primaryStage.setTitle("Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
