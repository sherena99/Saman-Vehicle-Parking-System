package model;

public class Bus extends vehicle{
    int[] reservedSlotsBus = {14};
    String[] parked = {"null"};
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
        for (int i = 0; i < reservedSlotsBus.length; i++) {
            if (parked[i].equals(vehicleNumber)) {
                passValue = "Parked";
                break;
            } else {
                if (parked[i].equals("null")) {
                    passValue = Integer.toString(reservedSlotsBus[slot]);
                    slot = i;
                    break;
                }
            }
        }
        return passValue;
    }
}
