package controler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.VehicleData;

import java.util.ArrayList;


public class AddVehicleFormController {
    public AnchorPane AddVehicleContext;
    public JFXComboBox cmbAddVehicleType;
    public JFXTextField txtNoOfPassengers;
    public JFXTextField txtVehicleNumber;
    public JFXTextField txtMaxWeight;

    private Stage stage=null;
    void getStage(Stage stage){
        this.stage=stage;
    }

    public String number;
    public String type;
    public int weight;
    public int noPassenger;

    public static ObservableList vehicleList = FXCollections.observableArrayList();
    public static ObservableList getVehicleList() {
        return vehicleList;
    }

    public void AddVehicleOnAction(ActionEvent actionEvent) {
        number = txtVehicleNumber.getText();
        type =(String) cmbAddVehicleType.getValue();
        weight = Integer.parseInt(txtMaxWeight.getText());
        noPassenger = Integer.parseInt(txtNoOfPassengers.getText());


        ArrayList<VehicleData> dataArrayList =new ArrayList<>();
        VehicleData vehicleData=new VehicleData(number,type,weight,noPassenger);
        dataArrayList.add(vehicleData);
        for (VehicleData temp : dataArrayList) {
            vehicleList.add(temp);
            clearField();
        }
    }
    public void clearField() {
        txtVehicleNumber.clear();
        txtMaxWeight.clear();
        txtNoOfPassengers.clear();

    }
    public void initialize(){

        cmbAddVehicleType.getItems().addAll(
                "Van","Cargo Lorry","Bus"
        );
    }
}

