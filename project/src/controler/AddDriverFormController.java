package controler;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Driver;

import java.util.ArrayList;

public class AddDriverFormController {
    public static ObservableList driversList = FXCollections.observableArrayList();
    public AnchorPane AddVehicleContext;
    public JFXTextField txtDrivingLicenseNo;
    public JFXTextField txtDriverName;
    public JFXTextField txtNic;
    public JFXTextField txtDriverAddress;
    public String name;
    public String driverNic;
    public String licenseNum;
    public String driverAddress;
    public int driverContactNum;
    public JFXTextField txtDriverContactNo;
    public Stage stage=null;

    void getStage(Stage stage){
        this.stage=stage;
    }




    public static ObservableList getDriversList() {
        return driversList;
    }



    public void btnAddDriverOnAction(ActionEvent actionEvent) {
        name = txtDriverName.getText();
        driverNic = txtNic.getText();
        licenseNum = txtDrivingLicenseNo.getText();
        driverAddress = txtDriverAddress.getText();


        try {
            driverContactNum = Integer.parseInt(txtDriverContactNo.getText());
        } catch (Exception e) {
            System.out.println("contact number not string");
        }
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        Driver drivers1 = new Driver(name, driverNic, licenseNum, driverAddress, driverContactNum);
        drivers.add(drivers1);

        clearField();

        for (Driver temp : drivers) {
            driversList.add(temp);
        }
    }



    public void clearField() {
        txtDriverName.clear();
        txtNic.clear();
        txtDrivingLicenseNo.clear();
        txtDriverAddress.clear();
        txtDriverContactNo.clear();

    }
}
