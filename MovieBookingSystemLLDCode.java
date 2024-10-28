//Enumerations 
enum PaymentStatus {
    PENDING, 
    CONFIRMED, 
    DECLINED, 
    REFUNDED
}

enum BookingStatus {
    PENDING, 
    CONFIRMED,
    CANCELLED,
    DENIED, 
    REFUNDED
}

enum SeatStatus {
    AVAILABLE, 
    BOOKED, 
    RESERVED
}

// Person is an abstract class as we dont want to show the sensitive data to the outside world 

public abstract class Person {
    private String name; 
    private String address;
    private String Age;
    private String email;
    private String phone;
}
/* C++ equivalent */

// class Person {
//   private:
//     string name;
//     string address;
//     string phone;
//     string email;
// };

public class Customer extends Person {

    private List<Bookings> bookings;
    public boolean createBooking(Booking booking);
    public boolean updateBooking(Booking booking);
    public boolean deleteBooking(Booking booking);
    

}

public class Admin extends Person {

    public boolean addShow(Booking booking);
    public boolean updateShow(Booking booking);
    public boolean deleteShow(Booking booking);
    public boolean addMovie(Booking booking);
    public boolean deleteMovie(Booking booking);
    
}

public class TicketAgent extends Person {

    public boolean createBooking(Booking booking);
    
}


// Seat is an abstract class and we are trying to use the strategy pattern to set a price to the seat 
public abstract Seat {
    private String seatType;
    private String seatNo;
    private String seatStatus;

    public boolean isAvailable();
    public abstract void setSeat();
    public abstract void setRate();
}

public class Platinum extends Seat {

    private double rate;
    public void setSeat() {
        // definition
    }
    public void setRate() {

    }

}


public class Silver extends Seat {

    private double rate;
    public void setSeat() {
        // definition
    }
    public void setRate() {
        
    }
    
}


public class Gold extends Seat {

    private double rate;
    public void setSeat() {
        // definition
    }
    public void setRate() {
        
    }
    
}

// Movie, ShowTime, MovieTicket class 

public class Movie {
    private String genre;
    private String title;
    private String language;
    private Date releaseDate;
    private Time duration;
    private List<ShowTime> shows;

}

public class ShowTime {
    private int showId;

    private Date startTime; 
    private Date date;
    private int duration;
    private List<Seat> seats;

    public void showAvailableSeats();

}

public class MovieTicket {
    private int ticketId;
    private Seat seat;
    private Movie movie;
    private ShowTime show;

}

// City Cinema Hall 

public class City {
  private String name;
  private String state;
  private int zipCode;
  private List<Cinema> cinemas;
}

public class Cinema {
  private int cinemaId;
  private List<Hall> halls;
  private City city;
}

public class Hall {
  private int hallId;
  private List<ShowTime> shows;

  public List<ShowTime> findCurrentShows();
}


// Payment is an abstract class 

public abstract class Payment {

    private double amount; 

    private Date timestamp;
    private PaymentStatus status;

    private abstract boolean makePayment();
}

public class Cash extends Payment {
    public boolean makePayment() {
        //  own functionality

    }
}

public class CreditCard extends Payment {
    // Data members
    private String nameOnCard;
    private String cardNumber;
    private String billingAddress;
    private int code;

    public boolean makePayment() {
        // own functionality
    }
}

// Notification class is an abstract class that is responsible for sending notifications via email or phone/SMS after actions performed by either the admin and/or customer.

public abstract class Notification {
    private int notificationId;

    private Date createdOn;
    private String content;

    private abstract void sendNotification(Person person);
}


public class EmailNotification extends Notification {
  
  public void sendNotification(Person person) {
    // functionality 
  }
}

public class PhoneNotification extends Notification {
  
  public void sendNotification(Person person) {
    // functionality 
  }
}


// The Booking class is the main class of our movie ticket booking system and will display the information relating to a particular customer's booking.  

public class Booking {
    private int bookingId;
    private int amount;

    private BookingStatus status;

    private Payment payment;
    private List<MovieTicket> tickets;
    private List<Seat> seats;

}


// Catalog class contains the movie information and implements the Search interface class to enable the search functionality based on the given criteria (title, language, genre, and release date).

public interface Search {
    public List<Movie> searchMovieTitle(String title);
    public List<Movie> searchMovieGenre(String genre);
    public List<Movie> searchMovieLanguage(String language);
    public List<Movie> searchMovieReleaseDate(Date date);
}

public class Catalog extends Search {

    HashMap<String, List<Movie>> movieTitiles;
    HashMap<String, List<Movie>> movieGenres;
    HashMap<String, List<Movie>> movieLanguages;

    public List<Movie> searchMovieTitle {
        
    }
    public List<Movie> searchMovieGenre {
        
    }
    public List<Movie> searchMovieTitle {
        
    }
    public List<Movie> searchMovieReleaseDate {
        
    }

}
