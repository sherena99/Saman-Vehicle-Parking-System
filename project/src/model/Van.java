package model;

public class Van extends vehicle{
    int[] reservedSlotsVan = {1, 2, 3, 4, 12, 13};
    String[] parked = {"null","null","null","null","null","null"};
    int slot;
    String passValue;

    @Override
    public void park(String vehicleNumber, String vehicleType) {

        if (parked[slot].equals("null")) {
            parked[slot] = vehicleNumber;
        } else {
        }
    }

    @Override
    public String setSlot(String vehicleNumber, String vehicleType) {
        for (int i=0; i<reservedSlotsVan.length; i++){
            if (parked[i].equals(vehicleNumber)){
                passValue="Parked";
                System.out.println("Parked..slot");
                break;
            }
            else{
                if (parked[i].equals("null")){
                    System.out.println("view "+reservedSlotsVan[i]);
                    slot=i;
                    passValue=Integer.toString(reservedSlotsVan[slot]);
                    break;
                }
            }
        }
        return passValue;
    }


    @Override
    public void leavePark(String vehicleNumber, String vehicleType) {
        for (int i=0; i < parked.length; i++){
            if (vehicleNumber.equals(parked[i])){
                System.out.println("Delivery : "+parked[i]);
                parked[i]="null";
                slot=i;
                break;
            }else{
                System.out.println("not leave");
            }
        }
    }


}
