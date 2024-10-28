// code for RMS
// Enumerations
enum PaymentStatus {
  Unpaid,
  Pending,
  Completed,
  Failed,
  Declined,
  Canceled,
  Abondoned,
  Settling,
  Refunded
}

enum TableStatus {
  Free,
  Reserved,
  Occupied,
  Other
}

enum SeatType {
  Regular,
  Kid,
  Accessible,
  Other
}

enum AccountStatus {
  Active,
  Closed,
  Canceled,
  Blacklisted
}

enum OrderStatus {
  Received,
  Preparing,
  Complete,
  Canceled,
  None
}

enum ReservationStatus {
  Requested,
  Pending,
  Confirmed,
  CheckedIn,
  Canceled,
  Abondoned
}

// Custom Address data type class
public class Address {
  private int zipCode;
  private String address;
  private String city;
  private String state;
  private String country;
}


//The Account class represents a user account that has an ID, address, status, and a password that can be reset and is validated using the resetPassword() function.

public class Account {
    private String accountId;
    private String password;
    private String Address;
    private AccountStatus status;


    public boolean resetPassword(){
        // definition;
    }
}


// Person class is going to be an abstract class 
public abstract class Person { 

    private String name;
    private int age; 
    private String emailId;
    private String phone;



}

public abstract Employess extends Person {

}

public class Customer extends Person {

}

public class Waiter extends Employess {
 public boolean takeOrder();
}

public class Receptionist extends Employess {
    public boolean addReservation();
}


public class Manager extends Employess {
    public boolean addEmployee();
}

public class Chef extends Employess {
    public boolean prepareOrder();
}


//The Table class has a unique ID. It stores the table status, table location, and maximum capacity. Reservations can be added to a table using the addReservation() method. It also maintains a list of all the seats it has, where each TableSeat is identified by a seat number and has a type

public class Table {
    private String tableID;
    private TableStatus status;
    private String tableLocation;
    private List<TableSeat> seats;


    public boolean isTableFree();
    public boolean addReservation();
    public static List<Table> search(int capacity, Date startTime);

}

public class TableSeat {
    private int seatNumber;
    private SeatType seatType;

    public boolean updateSeatType(seatType type);
}

//The MealItem class is identified by a unique ID and stores and updates the quantity of a menu item. It can be added to a Meal using the addMealItem() method, where the Meal class represents the meal ordered for a specific table

public class MealItem {
    private String mealItemId;
    private int quantity;


    public boolean updateQuantity();
}

public class Meal {
    private String mealId;
    private TableSeat seat;
    private MenuItem menuItem;

    
    public boolean addMealItem();
}

//The Menu class represents the menu of a restaurant. It is identified by a unique ID and maintains a list of MenuSection, where the MenuSection class is the representation of a menu's different sections. A MenuSection has a list of MenuItem in which an item's price can be updated. 

public class Menu {
    private String menuId;
    private String title;
    private String description;
    private String pageNo;

    private List<MenuSection> sections;

    public boolean addMenuSection();


}

private class MenuSection {

    private String title;
    private String description;
    private List<MenuItem> menuIteams;


    public boolean addMenuItem();
}


private class MenuItem {

  private int menuItemID;
  private String title;
  private String description;
  private double price;

  public boolean updatePrice(double price);
}


//An Order has a number of meals and is assigned to a waiter and chef for a specific table. Meals can be updated in an Order using the addMeal() and removeMeal() methods.

// A Kitchen has a number of chefs where new chefs can be assigned using the assignChef() method.

// The Reservation class represents the reservation of a table that stores the reservation time, people count, status, check-in time, and customer information. It also maintains a list of notifications for the customer.


public class Order {
    private String orderId;
    private OrderStatus status;
    private Meal[] meals;
    private Date creationTime;
    private Table table;
    private Waiter waiter;
    private Chef chef;


    public boolean addMeal(Meal meal);
    public boolean removeMeal(Meal meal);


}

public class Kitchen {
  private String name;
  private Chef[] chefs;

  public boolean assignChef();
}

public class Reservation{
    private int reservationId;
    private Date timeOfReservation;
    private int people;
    private String details;
    private ReservationStatus status;

    private Customer customer;
    private List<Notification> notifications;


      public boolean updatePeopleCount(int count);
}


// Payment is an abstract class
public abstract class Payment {
    private int paymentID;
    private Date creationDate;
    private double amount;      
    private PaymentStatus status;

    public abstract void initiateTransaction();
}

public class Check extends Payment {
    private String bankName;
    private String checkNumber;

    public void initiateTransaction() {
        // functionality 
    }
}

public class CreditCard extends Payment {
    private String nameOnCard;
    private int zipcode;

    public void initiateTransaction() {
        // functionality 
    }
}

public class Cash extends Payment {
    private double cashTendered;

    public void initiateTransaction() {
        // functionality 
    }
}


public class Bill {
    private int billId;
    private float amount;
    private float tip;
    private float tax;
    private boolean isPaid;

    public boolean generateBill();
}


//The Notification class is another abstract class responsible for sending notifications, with the SmsNotification and EmailNotification classes as its child.

// Notification is an abstract class
public abstract class Notification {
    private int notificationId;
    // The Date data type represents and deals with both date and time.
    private Date createdOn;      
    private String content;

    public abstract void send(Person person);
}

class SmsNotification extends Notification {
    private String phone;

    public void sendNotification(Person person) {
        // functionality 
    }
}

class EmailNotification extends Notification {
    private String email;

    public void sendNotification(Person person) {
        // functionality 
    }
}



// The SeatingChart class stores the seating plan for a Branch of the Restaurant, which can be printed. The Branch of a restaurant has a specific name, address, and kitchen.

public class Restaurant { 

    private List<Branch> branches;

    public boolean addNewBranch(Branch branch);
}

public class Branch { 
    private String branchId;
    private String name;
    private Address location;

    private Kitchen kitchens;
    private Address addSeatingChart();
}

public class SeatingChart {
  private int seatingChartID;
  private byte[] seatingChartImage;

  public boolean print();
}