//LLD code for the meeting scheduler

//User class it can either accept or reject a meeting invitation

public class User{ 
    private String name; 
    private String email;

    public boolean respondInvitation(Notification invite);
}

//Interval class refers to just meeting interval (startTime and endTime)

public class Interval{
    private Date startTime;
    private Date endTime;
}

// MeetingRoom class represent a meeting room 
public class MeetingRoom { 
    private int id; 
    private int capacity; 
    private boolean isAvailable;
    private List<Interval> bookedIntervals; // what bookings intervals this meeting room is booked 
}

// Calendar class contains list of meeting 

public class Calendar { 
    private List<meeting> Meeting;
}

//Meeting class outlines the meeting details such as the number and list of participants, meeting time interval, and meeting room. It also has the option to add more participants.

public class Meeting {
    private int id;
    private int participantsCount;
    private List<User> participants;
    private Interval interval;
    private MeetingRoom room;
    private String subject;

    public void addParticipants(List<User> participants);
}

/*The MeetingScheduler class is the main class of the meeting scheduler and contains the organizer, which is responsible for scheduling and canceling a meeting as well as booking or releasing a room. It also checks if any meeting rooms are available for a meeting. In addition, there will be only one instance of the scheduler in the meeting scheduler. */

public class MeetingScheduler { 
    private User organiser;
    private  Calendar calendar;
    private List<MeetingRoom> rooms;

    private static MeetingScheduler scheduler = null;

    public static MeetingScheduler getInstance() {
        if(scheduler == null){
            scheduler = new MeetingScheduler();
        }

        return scheduler;
    }

    public boolean scheduleMeeting(List<User> users, Interval interval);
    public boolean cancelMeeting(List<User> users, Interval interval);
    public boolean bookRoom(MeetingRoom room, int numberOfPersons, Interval interval);
    public boolean releaseRoom(MeetingRoom room, Interval interval);
    public MeetingRoom checkRoomsAvailability(int numberOfPersons, Interval interval);
}

// Notification class for sending notifications

public class Notification {
    private int notificationId;
    private String content;
    private Date creationDate;

    public boolean sendNotification(User user);
    public boolean cancelNotification(User user);
    
}
