package model;

public class Lorry extends vehicle{
    int[] reservedSlotsCargoLorry = {5, 6, 7, 8, 9, 10, 11};
    String[] parked = {"null", "null", "null", "null", "null", "null", "null"};
    int slot;
    String passValue;

    @Override
    public void park(String vehicleNumber, String vehicleType) {
        if (parked[slot].equals("null")) {
            parked[slot] = vehicleNumber;
            System.out.println("add....");
        } else {
            System.out.println("allready parked");
        }
    }

    @Override
    public void leavePark(String vehicleNumber, String vehicleType) {

    }

    @Override
    public String setSlot(String vehicleNumber, String vehicleType) {
        for (int i = 0; i < reservedSlotsCargoLorry.length; i++) {
            if (parked[i].equals(vehicleNumber)) {
                passValue = "Parked";
                //System.out.println("Parked..");
                break;
            } else {
                if (parked[i].equals("null")) {
                    passValue = Integer.toString(reservedSlotsCargoLorry[slot]);
                    slot = i;
                    break;
                }
            }
        }
        return passValue;
    }
}
