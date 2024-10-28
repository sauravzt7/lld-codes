//Car Rental System Code for LLD


// definition of enumerations used in the car rental system
enum VehicleStatus {
  AVAILABLE,
  RESERVED, 
  LOST, 
  BEING_SERVICED
}

enum AccountStatus {
  ACTIVE, 
  CLOSED, 
  CANCELED, 
  BLACKLISTED, 
  BLOCKED
}

enum ReservationStatus {
  ACTIVE, 
  PENDING, 
  CONFIRMED, 
  COMPLETED, 
  CANCELED
}

enum PaymentStatus {
  UNPAID, 
  PENDING, 
  COMPLETED,  
  CANCELED,  
  REFUNDED
}

enum VanType {
  PASSENGER, 
  CARGO
}

enum CarType {
  ECONOMY, 
  COMPACT, 
  INTERMEDIATE, 
  STANDARD, 
  FULL_SIZE, 
  PREMIUM, 
  LUXURY
}

enum MotorcycleType {
  STANDARD,
  CRUISER,
  TOURING,
  SPORTS,
  OFF_ROAD,
  DUAL_PURPOSE
}

enum TruckType {
  LIGHT_DUTY,
  MEDIUM_DUTY,
  HEAVY_DUTY
}

enum VehicleLogType {
  ACCIDENT, 
  FUELING, 
  CLEANING_SERVICE, 
  OIL_CHANGE, 
  REPAIR, 
  OTHER
}

public class Address {

    private int zipCode; 
    private String state;
    private String province;
    private String country;



}

public class Person {
    private int id;
    private int age;
    private String emailId;
    private String phone;
    private String name;
    private String gender;
    private String race;


}

public class Driver extends Person {


}

public class Account extends Person {

    private String loginId;
    private String password;
    private AccountStatus status;

}


public class Receptionist extends Account {
    private String receptionId;
    private Date dateJoined;

    public addReservation();
    public cancelReservation();
    public resetPassword();
}

public class Customer extends Account {
    private String customerId;
    

    public bookReservation();
    public cancelReservation();
    public List<VehicleReservation> getReservations();
    public resetPassword();
}


//Vehicle

public abstract class Vehicle {
    private String vehicleId;
    private String licenseNo;
    private String passengerCapacity;
    private String model;
    private String manufacturingYear;
    private String vehicleId;
    private int mileage;
    private VehicleStatus status;
    private List<VehicleLog> log;

    public boolean reserveVehicle();
    public boolean returnVehicle();
}

public Car extends Vehicle {
  private CarType carType;
}



public Van extends Vehicle {
      private VanType vanType;
}


public Motorcycle extends Vehicle {
      private MotorcycleType motorcycleType;
}


public Truck extends Vehicle {
      private CarType carType;
}



// Equipment is an abstract class
public abstract class Equipment {
    private int equipmentId;
    private int price;
}

public class Navigation extends Equipment {
}

public class ChildSeat extends Equipment {
}

public class SkiRack extends Equipment {
}


public abstract class Services {
    private int serviceId;
    private int price;
}

public class Wifi extends Equipment {
}

public class RoadsideAssit extends Equipment {
}

public class DriverService extends Equipment {
}


public abstract Payment {
    private double amount;
    private Date timestamp;
    private PaymentStatus status;


    public boolean makePayment();

}

public class Cash extends Payment {

}


public class CreditCard extends Payment {

    private String nameOnCard;
    private String cardNumber;
    private String billingAddress;
    private int code;

    public boolean makePayment() {

    }
}

//VehicleLog is a class responsible for keeping track of all the events related to a vehicle. VehicleReservation is a class responsible for managing the reservation of vehicles

public class VehicleLog {
    private String log;
    private String description;
    private int logID;
    private Date creationDate;


}

public class VehicleReservation {
    private String reservationId;
    private String customerId;
    private String vehicleId;
    private String creationDate;
    private String pickupLocation;
    private String dropLocation;
    private ReservationStatus status;

    private List<Services> services;
    private List<Equipment> equipments;


    public VehicleReservation getReservationsDetails() {

    }

    public boolean addService() {

    }

    public boolean addEquipments() {

}
    
}

public class Notifications {
    private String notificationId;
    private String content;
    private String subject;
    private Time createdOn;


    public boolean sendNotifications();
}

public EmailNotification extends Notifications {

}


public SMSNotification extends Notifications {
    
}


//ParkingStall is a class used to locate vehicles in the car rental branch while the Fine class represents the fine applied on payment. The implementation of these classes is given below:

public class ParkingStall {
  private int stallId;
  private String locationIdentifier;
}

public class Fine {
  private double amount;
  private String reason;
  public double calculateFine();
}

public interface Search {
    public List<Vehicle> searchByType;
    public List<Vehicle> searchByModel;
}

public class VehicleCatalog implements Search {
    private HashMap<String, List<Vehicle>> vehicleTypes;
    private HashMap<String, List<Vehicle>> vehicleModels;


  // to return all vehicles of the given type.
  public List<Vehicle> searchByType(String type) {
    // functionality
  }

  // to return all vehicles of the given model.
  public List<Vehicle> searchByModel(String model) {
    // functionality
  }
}


//The CarRentalSystem class is the base class of the system that is used to represent the whole car rental system (or the top-level classes of the system). 
//CarRentalBranch represents the single branch of the system.


public class CarRentalBranch {
    private String name;
    private Address address;

    private List<ParkingStall> stalls;

    public Address getLocation();

}

public class CarRentalSystem {
    private String name;
    private List<CarRentalBranch> branches;

    public void addNewBranch();

    private static CarRentalSystem carRentalsystem  = null;


    public static getInstance() {
        if(carRentalsystem == null){
            carRentalsystem = new CarRentalSystem();
        }
        return carRentalsystem;
    }
    

}