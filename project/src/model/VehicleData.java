package model;

public class VehicleData {


    private String vehicleNumber;
    private String vehicleType;
    private int maximumWeight;
    private int numOfPassengers;

    public VehicleData() {
    }

    public VehicleData(String vehicleNumber, String vehicleType, int maximumWeight, int numOfPassengers) {
        this.setVehicleNumber(vehicleNumber);
        this.setVehicleType(vehicleType);
        this.setMaximumWeight(maximumWeight);
        this.setNumOfPassengers(numOfPassengers);
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(int maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    @Override
    public String toString() {
        return vehicleNumber;
    }
}
