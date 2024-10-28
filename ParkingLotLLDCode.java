//Parking Lot Code for LLD 
//First of all, we will define all the enumerations required in the parking lot. 
//Enumerations : A special data type which contains a set of predefined constants.

enum PaymentStatus {
    COMPLETED, 
    PENDING, 
    FAILED, 
    UNPAID, 
    REFUNDED

}

enum AccountStatus {
  ACTIVE, 
  CLOSED, 
  CANCELED, 
  BLACKLISTED, 
  NONE
}

// Custom Person data type class Person
public class Person {

    private String name;
    private String email;
    private String phone; 

    //...


}

// Custom Address data type class

public class Address {
    private int zipCode;
    private String state;
    private String city; 
    private String country; 

}


// ParkingSpot is an abstract class

public abstract class ParkingSpot {
    private int spotId;
    private String name;
    private boolean isFree;
    private Vehicle vehicle;

    public boolean getIsFree();
    public boolean assignVehicle();
    public boolean removeVehicle();


}

public class Handicapped extends ParkingSpot {
  public boolean assignVehicle(Vehicle vehicle) {
    // definition
  }
}

public class Compact extends ParkingSpot {
  public boolean assignVehicle(Vehicle vehicle) {
    // definition
  }
}

public class Large extends ParkingSpot {
  public boolean assignVehicle(Vehicle vehicle) {
    // definition
  }
}

public class Motorcycle extends ParkingSpot {
  public boolean assignVehicle(Vehicle vehicle) {
    // definition
  }
}

// Vehicle is an abstract class

public abstract class Vehicle {
    private int id;
    private String vehicleNumber;
    private int licenseNo;


    public boolean assignTicket(ParkingTicket ticket);


}

public class Bike extends Vehicle {

    // own methods

}

public class Car extends Vehicle {
    
}

public class Truck extends Vehicle {
    
}


// Account is an abstract class

public abstract class Account {
    private int accountId;
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;


    public abstract boolean resetPassword();

}


public class Admin extends Account {
  // spot here refers to an instance of the ParkingSpot class
  public boolean addParkingSpot(ParkingSpot spot);
  // displayBoard here refers to an instance of the DisplayBoard class
  public boolean addDisplayBoard(DisplayBoard displayBoard);
  // entrance here refers to an instance of the Entrance class
  public boolean addEntrance(Entrance entrance);
  // exit here refers to an instance of the Exit class
  public boolean addExit(Exit exit);

  // Will implement the functionality in this class
  public boolean resetPassword() {
    // definition
  }
}

public class ParkingAgent extends Account {
  public boolean processTicket(String ticketNumber);

  // Will implement the functionality in this class
  public boolean resetPassword() {
    // definition
  }
}


public class DisplayBoard {
  // Data members
  private int id;
  private Map<String, List<ParkingSpot>> parkingSpots; //

  // Constructor
  public DisplayBoard(int id) {
    this.id = id;
    this.parkingSpots = new HashMap<>();
  }
  
  // Member function
  public void addParkingSpot(String spotType, List<ParkingSpot> spots);
  public void showFreeSlot();
}

public class ParkingRate {
  // Data members
  private double hours;
  private double rate;

  // Member function
  public void calculate();
}

//Entrance and Exit

public class Exit {
    private int gateId;

    public class getTicket();

}



public class Entrance {
    private int gateId;


    public void validateTicket(ParkingTicket ticket){

    }
    
}


public class ParkingTicket {
    private int ticketNo;
    private Date timestamp;
    private double amount;
    private boolean status;
    // Following are the instances of their respective classes for entrance and exits these are the weak associations
    private Vehicle vehicle;
    private Payment payment;
    private Entrance entrance;
    private Exit exitIns;


}

public class Payment{
    private double amount;
    private PaymentStatus paymentstatus;


    public abstract boolean initiateTransactions();

}


public class Cash extends Payment {
    public boolean initiateTransaction() {
        // definition
    }
}

public class CreditCard extends Payment {
    public boolean initiateTransaction() {
        // definition
    }
}


// Parking Lot class here we will use singleton class 


public class ParkingLot {

    private int id;
    private String name;
    private Address address;

    private HashMap<String, Entrance> entrance;
    private HashMap<String, Entrance> exit;

    private HashMap<String, ParkingTicket> tickets;



    // The ParkingLot is a singleton class that ensures it will have only one active instance at a time
    // Both the Entrance and Exit classes use this class to create and close parking tickets

    private static ParkingLot parkingLot = null;

   // Created a private constructor to add a restriction (due to Singleton)
    private ParkingLot() {
        // Call the name, address and parking_rate 
        // Create initial entrance and exit hashmaps respectively
    }


    public static ParkingLot getInstance(){
        if(parkingLot == null){
            parkingLot = new ParkingLot;
        }

        return parkingLot;
    }


            // This function allows parking tickets to be available at multiple entrances
    public ParkingTicket getParkingTicket(Vehicle vehicle) {}

    public boolean isFull(ParkingSpot type);
}