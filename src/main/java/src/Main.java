package src;

import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class Main {

    public static Connection createConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/hotel";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established");
            return connection;
        } catch (Exception e) {
            System.out.println("Error in connection");
            return null;
        }
    }

    public static void getRoomsAvailable(int numberOfRooms, int numberOfGoldRooms, int numberOfSilverRooms, int numberOfBronzeRooms){
        System.out.println("======================================");
        System.out.println("Rooms available");
        System.out.println("======================================");
        System.out.println("Gold rooms: " + "\t" +numberOfGoldRooms);
        System.out.println("Silver rooms: " + "\t" +numberOfSilverRooms);
        System.out.println("Bronze rooms: " + "\t" +numberOfBronzeRooms);
        System.out.println("======================================");
    }

    public static void getAllDetails(ArrayList<guestInfo> guestList){
        for(guestInfo guest : guestList) {
            System.out.println("======================================");
            System.out.println("Name: " + "\t" + guest.getName());
            System.out.println("Contact: " + "\t" +guest.getContactNumber());
            System.out.println("Email: " + "\t" +guest.getEmail());
            System.out.println("Amount: " + "\t" +guest.getTotalPrice());
            System.out.println("Number of rooms: " + "\t" +guest.getNumberOfRooms());
            System.out.println("Number of days: " + "\t" +guest.getNumberOfDays());
            System.out.println("Gold rooms: " + "\t" +guest.getGoldRooms());
            System.out.println("Silver rooms: " + "\t" +guest.getSilverRooms());
            System.out.println("Bronze rooms: " + "\t" +guest.getBronzeRooms());
            System.out.println("======================================");
        }
    }

    public static int getTotalPrice(int[] roomTiers, int numberOfRooms, int numberOfDays){
        double totalPrice = 0;
        int goldPrice = 3000;
        int silverPrice = 2000;
        int bronzePrice = 1000;

        for(int i = 0; i < numberOfRooms; i++) {
            switch(roomTiers[i]) {
                case 1:
                    totalPrice += goldPrice;
                    break;
                case 2:
                    totalPrice += silverPrice;
                    break;
                case 3:
                    totalPrice += bronzePrice;
                    break;
            }
        }

        totalPrice = totalPrice * numberOfDays;

        return (int) totalPrice;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<guestInfo> guestList = new ArrayList<>();

        int numberOfGoldRooms = 5;
        int numberOfSilverRooms = 10;
        int numberOfBronzeRooms = 15;

        System.out.println("Welcome to Hotel Management System");

        System.out.println("======================================");

        boolean systemRunning = true;

        while (systemRunning) {

            System.out.print("Enter the number of rooms you want to book:");
            int numberOfRooms = sc.nextInt();

            System.out.print("Enter the number of days you want to stay:");
            int numberOfDays = sc.nextInt();

            System.out.println("Choose from different room tiers:");
            System.out.println("1. Gold");
            System.out.println("2. Silver");
            System.out.println("3. Bronze");

            int[] roomTiers = new int[numberOfRooms];

            for (int i = 0; i < numberOfRooms; i++) {
                System.out.print("Enter the room tier for room " + (i + 1) + ":");
                roomTiers[i] = sc.nextInt();
            }

            double totalPrice = 0;

            totalPrice = getTotalPrice(roomTiers, numberOfRooms, numberOfDays);

            System.out.println("Total price for " + numberOfDays + " days is " + totalPrice);

            System.out.print("Do you want to proceed with the booking? (Y/N)");
            String answer = sc.next();

            int goldRooms = 0;
            int silverRooms = 0;
            int bronzeRooms = 0;

            for (int i = 0; i < numberOfRooms; i++) {
                switch (roomTiers[i]) {
                    case 1:
                        goldRooms++;
                        break;
                    case 2:
                        silverRooms++;
                        break;
                    case 3:
                        bronzeRooms++;
                        break;
                }
            }

            if (answer.equalsIgnoreCase("Y")) {
                for (int i = 0; i < numberOfRooms; i++) {
                    switch (roomTiers[i]) {
                        case 1:
                            if (numberOfGoldRooms > 0) {
                                numberOfGoldRooms--;
                            } else {
                                System.out.println("Sorry, no more gold rooms available");
                            }
                            break;
                        case 2:
                            if (numberOfSilverRooms > 0) {
                                numberOfSilverRooms--;
                            } else {
                                System.out.println("Sorry, no more silver rooms available");
                            }
                            break;
                        case 3:
                            if (numberOfBronzeRooms > 0) {
                                numberOfBronzeRooms--;
                            } else {
                                System.out.println("Sorry, no more bronze rooms available");
                            }
                            break;
                    }
                }

                System.out.println("Proceeding with the booking...");

                System.out.print("Enter the name of the person who is booking the room:");
                String name = sc.next();

                System.out.print("Enter the contact number of the person who is booking the room:");
                String contactNumber = sc.next();

                System.out.print("Enter the email id of the person who is booking the room:");
                String email = sc.next();

                guestInfo guest = new guestInfo(name, contactNumber, email, totalPrice, numberOfRooms, numberOfDays, goldRooms, silverRooms, bronzeRooms);
                guestList.add(guest);

                System.out.println("Booking successful");
                getAllDetails(guestList);
            } else {
                System.out.println("Booking cancelled");
            }

            getRoomsAvailable(numberOfRooms, numberOfGoldRooms, numberOfSilverRooms, numberOfBronzeRooms);

            System.out.println("Next Customer?");
            systemRunning = sc.next().equals("Y");
        }
        System.out.println("Thank you for using the hotel management system");
        sc.close();
    }
}