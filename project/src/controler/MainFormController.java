package controler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Bus;
import model.Lorry;
import model.Van;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

    public class MainFormController {
    public AnchorPane MainContext;
    public JFXTextField txtVehicleType;
    public JFXComboBox cmbSelectVehicle;
    public JFXComboBox cmbDriver;
    public Label lblSlotNumber;
    public Label lblDate;
    public Label lblTime;
    public static String no;
    public static String type;
    public JFXButton btnParkVehicleId;
    public JFXButton btnOnDeliveryShiftId;
    public String slotNo;
    public String dateTime;
    public String name;

    Van v1 = new Van();
    Bus b1 = new Bus();
    Lorry l1 = new Lorry();
    String[][] Vehicle = {
            {"NA-3434", "Bus"},
            {"KA-4563", "Van"},
            {"58-3567", "Van"},
            {"GF-4358", "Van"},
            {"CCB-3568", "Van"},
            {"LM-6679", "Van"},
            {"QA-3369", "Van"},
            {"KB-3668", "Cargo Lorry"},
            {"JJ-9878", "Cargo Lorry"},
            {"GH-5772", "Cargo Lorry"},
            {"XY-4456", "Cargo Lorry"},
            {"YQ-3536", "Cargo Lorry"},
            {"CBB-3566", "Cargo Lorry"},
            {"QH-3444", "Cargo Lorry"}
        };
        private ObservableList parentDriversList = FXCollections.observableArrayList();

        private ObservableList parentVehiclesList = FXCollections.observableArrayList();


        public String getDataAndTime() {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date date = new Date();
            return formatter.format(date);
        }

        public void btnparkVehicleOnAction(ActionEvent actionEvent) throws InterruptedException, IOException {
        if (type.equals("Van")) {
            v1.park(no, type);
        } else if (type.equals("Bus")) {
            b1.park(no, type);
        } else if (type.equals("Cargo Lorry")) {
            l1.park(no, type);
        }
        slotNo = lblSlotNumber.getText();
        dateTime= getDataAndTime();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddForm.fxml"));
            Parent parent = loader.load();
            AddFormController controller = loader.getController();
            controller.setData(no,type,slotNo,dateTime);
            controller.trigger();
        }

        public void btnOnDeliveryOnAction(ActionEvent actionEvent) throws IOException {
            v1.leavePark(no, type);
            b1.leavePark(no,type);
            l1.leavePark(no,type);

            name = String.valueOf(cmbDriver.getValue());
            dateTime = getDataAndTime();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddForm.fxml"));
            Parent parent = loader.load();
            AddFormController controller = loader.getController();
            controller.setDataOnDeliver(no,type,name,dateTime);
            controller.triggerOnDeliver();

        }

        private void LocalTime() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }),
                new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
        public void LocalDate() throws InterruptedException {
            SimpleDateFormat DateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            lblDate.setText(DateFormatter.format(date));
            Thread.sleep(1000);
        }

        public void btnManagementLogOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LogInForm.fxml"));
        Parent parent = loader.load();
        LoginFormController controller = (LoginFormController) loader.getController();
        Stage stage = new Stage();
        controller.getStage((Stage)MainContext.getScene().getWindow());
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Vehicle Parking System(v-1.0.0)");
        stage.show();
    }


        public void setParkingNo() {
        if (type.equals("Van")) {
                lblSlotNumber.setText(v1.setSlot(no, type));

                if (v1.setSlot(no, type).equals("Parked")) {
                    btnParkVehicleId.setDisable(true);
                    btnOnDeliveryShiftId.setDisable(false);
                } else {
                    btnOnDeliveryShiftId.setDisable(true);
                    btnParkVehicleId.setDisable(false);
                }

            } else if (type.equals("Bus")) {
            lblSlotNumber.setText(b1.setSlot(no, type));

                if (b1.setSlot(no, type).equals("Parked")) {
                    btnParkVehicleId.setDisable(true);
                    btnOnDeliveryShiftId.setDisable(false);
                } else {
                    btnOnDeliveryShiftId.setDisable(true);
                    btnParkVehicleId.setDisable(false);
                }

            } else if (type.equals("Cargo Lorry")) {
            lblSlotNumber.setText(l1.setSlot(no, type));

                if (l1.setSlot(no, type).equals("Parked")) {
                    btnParkVehicleId.setDisable(true);
                    btnOnDeliveryShiftId.setDisable(false);
                } else {
                    btnOnDeliveryShiftId.setDisable(true);
                    btnParkVehicleId.setDisable(false);
                }
            }
        }


        public void cmbSelectVehicleOnAction(ActionEvent actionEvent) {
            cmbDriver.requestFocus();
            for (int i = 0; i < Vehicle.length; i++) {
                for (int j = 0; j < Vehicle[1].length; j++) {
                    if (Vehicle[i][0].equals(String.valueOf(cmbSelectVehicle.getValue()))) {
                        txtVehicleType.setText(Vehicle[i][1]);
                        break;
                    }
                    no = String.valueOf(cmbSelectVehicle.getValue());
                    type = txtVehicleType.getText();
                    setParkingNo();
                    break;
                }
            }
        }

        public void initialize() throws InterruptedException {
        LocalDate();
        LocalTime();


            cmbDriver.setItems(parentDriversList);
            Bindings.bindContentBidirectional(parentDriversList, AddDriverFormController.getDriversList());

            cmbSelectVehicle.setItems(parentVehiclesList);
            Bindings.bindContentBidirectional(parentVehiclesList, AddVehicleFormController.getVehicleList());
        }


    }


