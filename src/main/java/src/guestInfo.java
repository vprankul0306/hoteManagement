package src;

public class guestInfo {
    String name;
    String contactNumber;
    String email;
    double totalPrice;

    int numberOfRooms;
    int numberOfDays;

    int goldRooms;
    int silverRooms;
    int bronzeRooms;

    guestInfo(String name, String contactNumber, String email, double totalPrice, int numberOfRooms, int numberOfDays, int goldRooms, int silverRooms, int bronzeRooms){
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.totalPrice = totalPrice;
        this.numberOfRooms = numberOfRooms;
        this.numberOfDays = numberOfDays;
        this.goldRooms = goldRooms;
        this.silverRooms = silverRooms;
        this.bronzeRooms = bronzeRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getGoldRooms() {
        return goldRooms;
    }

    public void setGoldRooms(int goldRooms) {
        this.goldRooms = goldRooms;
    }

    public int getSilverRooms() {
        return silverRooms;
    }

    public void setSilverRooms(int silverRooms) {
        this.silverRooms = silverRooms;
    }

    public int getBronzeRooms() {
        return bronzeRooms;
    }

    public void setBronzeRooms(int bronzeRooms) {
        this.bronzeRooms = bronzeRooms;
    }
}
