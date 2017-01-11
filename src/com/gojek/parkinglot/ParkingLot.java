package com.gojek.parkinglot;

import java.util.*;

public class ParkingLot {

	private int MAX_SIZE = 0;
	private Map<String, Car> slotToCarMap;  
	private Map<String, String> regNoToSlot;
	private Map<String, ArrayList<String>> colorToRegNoList;

	private ArrayList<Integer> availableSlotList;

	public ArrayList<Integer> getAvailableSlotList(){
		return availableSlotList;
	}
	public int getMaxSize(){
		return MAX_SIZE;
	}

	public Map<String, Car> getSlotToCarMap(){
		return slotToCarMap;
	}

	public Map<String, String> getRegNoToSlot(){
		return regNoToSlot;
	}

	public Map<String, ArrayList<String>> getColorToRegNoList(){
		return colorToRegNoList;
	}
	
	
	public void getParkingLot(String lotCount) {
		try {
			this.MAX_SIZE = Integer.parseInt(lotCount);
		} catch (Exception e) {
			System.out.println("Invalid lot count");
			
		}
		this.availableSlotList = new ArrayList<Integer>() {};
		for (int i=1; i<= this.MAX_SIZE; i++) {
			availableSlotList.add(i);
		}
		this.slotToCarMap = new HashMap<String, Car>();
		this.regNoToSlot = new HashMap<String, String>();
		this.colorToRegNoList = new HashMap<String, ArrayList<String>>();
		System.out.println("Car parking created with " + lotCount + " slots");
		
	}

	public void parkCar(String regNo, String color) {

		if (this.MAX_SIZE == 0) {
			System.out.println("Parking lot not yet created !");
			
		} else if (this.slotToCarMap.size() == this.MAX_SIZE) {
			System.out.println("Parking lot is full !");
			
		} else {

			Collections.sort(availableSlotList);
			String slot = availableSlotList.get(0).toString();

			Car car = new Car(regNo, color);
			this.slotToCarMap.put(slot, car);
			this.regNoToSlot.put(regNo, slot);

			if (this.colorToRegNoList.containsKey(color)) {
				ArrayList<String> regNoList = this.colorToRegNoList.get(color);
				this.colorToRegNoList.remove(color);
				regNoList.add(regNo);
				this.colorToRegNoList.put(color, regNoList);
			} else {
				ArrayList<String> regNoList = new ArrayList<String>();
				regNoList.add(regNo);
				this.colorToRegNoList.put(color, regNoList);
			}
			System.out.println("Allocated slot: " + slot);
			
			availableSlotList.remove(0);
		}
	}

	public void leaveParking(String slotNo) {
		if (this.MAX_SIZE == 0) {
			System.out.println("Parking lot not yet created !");
			
		} else if (this.slotToCarMap.size() > 0) {
			Car carToLeave = this.slotToCarMap.get(slotNo);
			if (carToLeave != null) {

				this.slotToCarMap.remove(slotNo);
				this.regNoToSlot.remove(carToLeave.getRegNo());
				ArrayList<String> regNoList = this.colorToRegNoList.get(carToLeave.getColor());
				if (regNoList.contains(carToLeave.getRegNo())) {
					regNoList.remove(carToLeave.getRegNo());
				}
				this.availableSlotList.add(Integer.parseInt(slotNo));
				System.out.println("Slot number " + slotNo + " is now free");
				
			} else {
				System.out.println("Slot number " + slotNo + " is already free");
				
			}
		} else {
			System.out.println("Parking lot is empty");
			
		}
	}

	public void getStatus() {
		if (this.MAX_SIZE == 0) {

			System.out.println("Parking lot not yet created !");

		} else if (this.slotToCarMap.size() > 0) {

			Car car;
			for (int i = 1; i <= this.MAX_SIZE; i++) {
				String key = Integer.toString(i);
				if (this.slotToCarMap.containsKey(key)) {
					car = this.slotToCarMap.get(key);
					System.out.println(i + "\t" + car.getRegNo() + "\t" + car.getColor());
				}
			}
			
		} else {
			System.out.println("Parking lot is empty");
			
		}
	}


	public void getRegNoFromColor(String color) {
		if (this.MAX_SIZE == 0) {
			System.out.println("Parking lot not yet created !");
			
		} else if (this.colorToRegNoList.containsKey(color)) {
			ArrayList<String> regNoList = this.colorToRegNoList.get(color);
			
			for (int i=0; i < regNoList.size(); i++) {
				if (!(i==regNoList.size() - 1)){
					System.out.print(regNoList.get(i) + ",");
				} else {
					System.out.print(regNoList.get(i));
				}
			}
		} else {
			System.out.println("Not found");
			
		}
	}

	public void getSlotNoFromColor(String color) {
		if (this.MAX_SIZE == 0) {
			System.out.println("Parking lot not yet created !");
			
		} else if (this.colorToRegNoList.containsKey(color)) {
			ArrayList<String> regNoList = this.colorToRegNoList.get(color);
			ArrayList<Integer> slotList = new ArrayList<Integer>();
			
			for (int i=0; i < regNoList.size(); i++) {
				slotList.add(Integer.valueOf(this.regNoToSlot.get(regNoList.get(i))));
			}
			Collections.sort(slotList);
			for (int j=0; j < slotList.size(); j++) {
				if (!(j == slotList.size() - 1)) {
					System.out.print(slotList.get(j) + ",");
				} else {
					System.out.print(slotList.get(j));
				}
			}
			
		} else {
			System.out.println("Not found");
			
		}
	}


	public void getSlotNoFromRegNo(String regNo) {
		if (this.MAX_SIZE == 0) {
			System.out.println("Parking lot not yet created !");
			
		} else if (this.regNoToSlot.containsKey(regNo)) {
			System.out.println(this.regNoToSlot.get(regNo));
		} else {
			System.out.println("Not found");
			
		}
	}
}
