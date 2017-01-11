package com.gojek.parkinglot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
    	ParkingLot pl = new ParkingLot();
        TextParser parser = new TextParser(pl);
        
        switch (args.length) {
            case 0:
                System.out.println("Please enter 'exit' to quit");
                System.out.println("Waiting for input...");
                
                while(true) {
                    try {
                        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                        String inputString = bufferRead.readLine();
                        if (inputString.equalsIgnoreCase("exit")) {
                            break;
                        } else if ((inputString == null) || (inputString.isEmpty())) {
                            
                        } else {
                            parser.parseInput(inputString.trim());
                        }
                    } catch(IOException e) {
                        System.out.println("Oops! Error in reading the input from console.");
                        e.printStackTrace();
                    }
                }
                break;
            case 1:
                parser.parseFile(args[0]);
                break;
            default:
                System.out.println("Invalid input. Usage: java -jar <jar_file_path> <input_file_path>");
        }
    }
}
