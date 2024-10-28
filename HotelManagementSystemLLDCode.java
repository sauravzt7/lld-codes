//LLD code for Hotel Management system 
// Design Approach : Bottom Up 


// definition of enumerations used in hotel management system
enum RoomStyle {
    STANDARD, 
    DELUXE, 
    FAMILY_SUITE, 
    BUSINESS_SUITE
}

enum RoomStatus {
    AVAILABLE, 
    RESERVED, 
    OCCUPIED, 
    NOT_AVAILABLE, 
    BEING_SERVICED, 
    OTHER
}

enum BookingStatus {
    REQUESTED, 
    PENDING, 
    CONFIRMED,
    CANCELLED, 
    ABANDONED
}

enum AccountStatus {
    ACTIVE, 
    CLOSED, 
    CANCELED, 
    BLACKLISTED, 
    BLOCKED
}

enum AccountType {
    MEMBER, 
    GUEST, 
    MANAGER, 
    RECEPTIONIST
}

enum PaymentStatus {
    UNPAID, 
    PENDING, 
    COMPLETED, 
    FILLED, 
    DECLINED, 
    CANCELLED, 
    ABANDONED, 
    SETTLING, 
    SETTLED, 
    REFUNDED
}


public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private int zipCode;
    private String country;
}

public class Account {

    private String logIn;
    private String password;
    private AccountStatus status;

    public boolean resetPassword();
}
public abstract class Person{

    private String name; 
    private String emailId;
    private String phone;


}

public class Guest extends Person {
    private int totalRoomsCheckedIn;

    public List<RoomBooking> getBookings();
}

public class Receptionist extends Person {
    public List<Member> searchMember(String name);
    public boolean createBooking();
}

public class Housekeeper extends Person {
    public boolean assignToRoom();
}

// Service Class 

public abstract Service { 
    private String serviceId;
    private Date issuedAt;

    public boolean addInvoiceItem();
}

public class RoomService extends Service { 
    private boolean isChargeable;
    private Date requestTime;
}


public class Amenity extends Service { 
    private String description;
    private String name; 

}

public class KitchenService extends Service { 
    private String description; 
    
}

//Invoice class to create a bill 

public class Invoice {
    private double amount;
    
    public boolean createBill();
}


//RoomBooking is a class responsible for managing the bookings for a room.

public class RoomBooking {
    private String reservationNumber;
    private Date startDate;
    private int durationInDays;
    private BookingStatus status;
    private Date checkin;
    private Date checkout;

    private int guestId;
    private Room room;
    private Invoice invoice;
    private List<Notification> notifications;

    public static RoomBooking fectchDetails(String reservationNumber);
}

//BillTransaction class is required to store the information of bill payment.

public abstract class BillTransaction { 
    private Date createdOn; 
    private double amount; 
    private PaymentStatus paymentstatus;

    public abstract void initiateTransactions();
}

class CreditCardTransaction extends BillTransaction {

}

class CashTransaction extends BillTransaction {

}

class ChequeTransaction extends BillTransaction { 

}

//Notification Class 

public abstract class Notification {
    private int notificationId;
    // The Date data type represents and deals with both date and time.
    private Date createdOn;      
    private String content;

    public abstract void sendNotification(Person person);
}

class SMSNotification extends Notification {

    public void sendNotification(Person person) {
        // functionality 
    }
}

class EmailNotification extends Notification {

    public void sendNotification(Person person) {
        // functionality 
    }
}


// The Room class represents a room in the hotel. RoomKey is a class used to express the electronic key card and the RoomHousekeeping is a class used to keep track of all the housekeeping records for the rooms.

public class Room {

    private String roomNumber; 
    private RoomStyle style;
    private RoomStatus roomstatus;
    private double roomPrice; 
    private boolean isSmoking; 
    private List<RoomKey> keys;
    private List<RoomHousekeeping> housekeeping;

    public boolean isRoomAvailable();
    public boolean checkIn();
    public boolean checkOut();

}

public class RoomKey {

    private String keyId;
    private String barCode;


    private boolean assignRoom();

}

public class RoomHousekeeping {

    private String description;
    private Date startDatetime;
    private int duration;
    private Housekeeper housekeeper;

    public boolean addHousekeeping(Room room);

}

//Search is an interface our Catalog is going to implement it 

public interface Search {
    public static List<Room> search(RoomStyle style, Date date, int duration);
}

public class Catalog implements Search {
    private List<Room> rooms;

    public List<Room> search(RoomStyle style, Date date, int duration);
}

//HotelBranch and Hotel 

public class HotelBranch {
    private String name;
    private Address address;

    public List<Room> getRoomList();

}

public class Hotel {
    private String name;

    private List<HotelBranch> locations;

    public boolean addLocation(HotelBranch location);

}