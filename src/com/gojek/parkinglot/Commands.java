package com.gojek.parkinglot;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

public class Commands {
    public Map<String, Method> commandsMap;

    public Commands() {
        commandsMap = new HashMap<String, Method>();
        try {
        	 commandsMap.put("create_parking_lot", ParkingLot.class.getMethod("getParkingLot", String.class));
             commandsMap.put("park", ParkingLot.class.getMethod("parkCar", String.class, String.class));
             commandsMap.put("leave", ParkingLot.class.getMethod("leaveParking", String.class));
             commandsMap.put("status", ParkingLot.class.getMethod("getStatus"));
             commandsMap.put("registration_numbers_for_cars_with_colour", ParkingLot.class.getMethod("getRegNoFromColor", String.class));
             commandsMap.put("slot_numbers_for_cars_with_colour", ParkingLot.class.getMethod("getSlotNoFromColor", String.class));
             commandsMap.put("slot_number_for_registration_number", ParkingLot.class.getMethod("getSlotNoFromRegNo", String.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
   
}
