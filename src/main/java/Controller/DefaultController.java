package Controller;

import Model.AnalysedFile;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class DefaultController {

    @FXML
    protected MenuBar menuBar;
    @FXML
    protected MenuItem save, open;
    protected AnalysedFile file = new AnalysedFile();

    protected boolean bHal = false;
    protected boolean bCyc = false;
    protected boolean bCom = false;

    @FXML
    protected void openUserManual() throws URISyntaxException {
        URI newUri = new URI("https://kunet.kingston.ac.uk/k1430996/depsys/UserManual.pdf");
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(newUri);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void goToResults() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClassLoader.getSystemResource("View/Results.fxml"));
        Parent root;
        try {
            root = loader.load();
            ResultsController controller = loader.getController();
            controller.setFile(this.file, bHal, bCyc, bCom);

            Stage stage = (Stage) this.menuBar.getScene().getWindow();
            stage.setScene(new Scene(root, 500, 720));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void singleAnalysis() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClassLoader.getSystemResource("View/Upload.fxml"));
        Parent root;
        try {
            root = loader.load();

            Stage stage = (Stage) this.menuBar.getScene().getWindow();
            stage.setScene(new Scene(root, 500, 600));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void goToHome() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ClassLoader.getSystemResource("View/Home.fxml"));
        Parent root;
        try {
            root = loader.load();

            Stage stage = (Stage) this.menuBar.getScene().getWindow();
            stage.setScene(new Scene(root, 500, 575));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Open saved (.atds) file,
     * pass to results page
     */
    @FXML
    private void open(){
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ATDS Files", "*.atds");
        fc.getExtensionFilters().add(extFilter);
        File openFile = fc.showOpenDialog(new Stage());

        this.file = AnalysedFile.getFromJSON(openFile);
        goToResults();
    }

    /*
     * Save analysis:
     * - choose save location
     * - convert AnalysedFile.java to '<saved_filename>.atds'
     * - save to user destination
     */
    @FXML
    protected void save() {
        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("ATDS Files", "*.atds");
        fc.getExtensionFilters().add(extFilter);
        File savedFile = fc.showSaveDialog(new Stage());
        if(savedFile != null) {
            try {
                this.file.setName(savedFile.getName());
                AnalysedFile.exportToJSON(this.file, savedFile);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void exit() {
        Platform.exit();
    }
}
