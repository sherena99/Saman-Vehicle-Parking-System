package model;

abstract public class vehicle {
    String vehicleNumber;
    String vehicleType;
    int maximumWeight;
    int numberOfPassenger;
    String driverNic;

    abstract public void park(String vehicleNumber, String vehicleType);

    abstract public void leavePark(String vehicleNumber, String vehicleType);

    abstract public String setSlot(String vehicleNumber, String vehicleType);
}
