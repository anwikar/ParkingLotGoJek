package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.parkinglot.ParkingLot;

public class ParkingLotTest {
	ParkingLot parkingLot = new ParkingLot();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

	 @Test
	    public void createParkingLot() throws Exception {
	        parkingLot.getParkingLot("6");
	        assertEquals(6, parkingLot.getMaxSize());
	        assertEquals(6, parkingLot.getAvailableSlotList().size());
	        assertTrue("Carparkingcreatedwith6slots".equalsIgnoreCase(outContent.toString().trim().replace(" ", "")));
	    }
	 
	 @Test
	    public void parkCar() throws Exception {
	        
	        parkingLot.getParkingLot("6");
	        parkingLot.parkCar("KA-01-HH-1234", "White");
	        parkingLot.parkCar("KA-01-HH-9999", "White");
	        assertEquals(4, parkingLot.getAvailableSlotList().size());
	    }
	 
	 @Test
	    public void leaveParking() throws Exception {
	       
	        parkingLot.getParkingLot("6");
	        //parkingLot.leaveParking("4");
	        parkingLot.parkCar("KA-01-HH-1234", "White");
	        parkingLot.parkCar("KA-01-HH-9999", "White");
	        
	        assertEquals("Carparkingcreatedwith6slots\n"+
	        "Allocatedslot:1\n"+
	        "Allocatedslot:2" ,outContent.toString().trim().replace(" ", ""));
	        }
	 
	 
}
