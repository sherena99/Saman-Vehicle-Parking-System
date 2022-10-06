package controler;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public Button btnCancel;
    public Button btnLogin;
    public AnchorPane loginContext;
    public JFXTextField txtNameId;
    public JFXPasswordField txtPasswordId;
    public Label lblWarning;


    private Stage stage=null;
    void getStage(Stage stage){
        this.stage=stage;
    }



public void cancelWindow() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddForm.fxml"));
    Parent parent = loader.load();
    AddFormController controller =(AddFormController) loader.getController();
    controller.clearWindow(stage);
}


    public void btnCancelOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if (txtPasswordId.getText().equals("1234") & txtNameId.getText().equals("1234")) {
            Parent parent = FXMLLoader.load(this.getClass().getResource("../view/AddForm.fxml"));
            Scene scene = new Scene(parent);
            Stage primaryStage = (Stage) this.loginContext.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
            cancelWindow();
        } else {
            lblWarning.setVisible(true);
            txtPasswordId.clear();
            txtNameId.requestFocus();
             }
    }


}
