package controler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tm.InParkingTm;
import tm.OnDeliverTm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AddFormController {
    public AnchorPane AddFormContext;
    public AnchorPane AddTableContext;
    public JFXButton btnLogOut;
    public JFXComboBox cmbId;
    public TableView<InParkingTm> tblInParking;
    public TableView tblOnDeliver;
    public TableColumn tblInParkVehicleNo;
    public TableColumn tblInParkVehicleType;
    public TableColumn tblInParkingSlot;
    public TableColumn tblInParkedTime;
    public TableColumn tblOnDeliverVehicleNo;
    public TableColumn tblOnDeliverVehicleType;
    public TableColumn tblDriverName;
    public TableColumn tblLeftTime;
    private String no;
    private String type;
    private String slotNo;
    private String dateTime;
    private String name;
    static ArrayList<InParkingTm> tmArrayList = new ArrayList<>();
    static ArrayList<OnDeliverTm> onDeliverTmArrayList = new ArrayList<>();


    public void  clearWindow(Stage stage)  {
        stage.close();
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MainForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window   = (Stage) AddFormContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    public void cmbOnAction(ActionEvent actionEvent) throws IOException {
        if (cmbId.getValue().equals("On Delivery")) {
            btnLogOut.setVisible(false);
            tblInParking.setVisible(false);
            tblOnDeliver.setVisible(true);

        } else {

            btnLogOut.setVisible(true);
            tblOnDeliver.setVisible(false);
            tblInParking.setVisible(true);
        }
    }


    public void initialize() {
        cmbId.getItems().addAll("In Parking", "On Delivery");
        cmbId.setValue("In Parking");

        tblInParking.setItems(FXCollections.observableArrayList(tmArrayList));

        tblInParkVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        tblInParkVehicleType.setCellValueFactory(new PropertyValueFactory<>("VehicleType"));
        tblInParkingSlot.setCellValueFactory(new PropertyValueFactory<>("parkingSlot"));
        tblInParkedTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));

        tblOnDeliver.setItems(FXCollections.observableArrayList(onDeliverTmArrayList));

        tblOnDeliverVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleNo"));
        tblOnDeliverVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        tblDriverName.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        tblLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));


    }
    public void setDataOnDeliver(String no, String type, String name, String dateTime) {
        this.no = no;
        this.type = type;
        this.name = name;
        this.dateTime = dateTime;
    }
    public void setData(String no, String type, String slotNo, String dateTime){
        this.no=no;
        this.type=type;
        this.slotNo=slotNo;
        this.dateTime=dateTime;
    }

    public void trigger (){
        tmArrayList.add(new InParkingTm(no,type,slotNo,dateTime));
    }

    public void triggerOnDeliver (){
        onDeliverTmArrayList.add(new OnDeliverTm(no,type,name,dateTime));
    }


    public void btnAddVehicleOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddVehicleForm.fxml"));
        Parent parent = loader.load();
        AddVehicleFormController controller = (AddVehicleFormController) loader.getController();
        Stage stage = new Stage();
        controller.getStage((Stage)AddFormContext.getScene().getWindow());
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

    public void btnAddDriverOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddDriverForm.fxml"));
        Parent parent = loader.load();
        AddDriverFormController controller = (AddDriverFormController) loader.getController();
        Stage stage = new Stage();
        controller.getStage((Stage)AddFormContext.getScene().getWindow());
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }

}
