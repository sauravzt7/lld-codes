package differentdesignpatterns.state;

abstract class State {
    protected Phone phone;
    public State(Phone phone){
        this.phone = phone;
    }

    public abstract String onHome();
    public abstract String onOffOn();
}

class OffState extends State{

    public OffState(Phone phone){
        super(phone);
    }

    @Override
    public String onHome() {
        phone.setState(new LockedState(phone));
        return phone.turnOn();
    }

    @Override
    public String onOffOn() {
        phone.setState(new LockedState(phone));
        return phone.turnOn();
    }
}

class ReadyState extends State {
    public ReadyState(Phone phone){
        super(phone);
    }
    @Override
    public String onHome(){
        return phone.home();
    }
    @Override
    public String onOffOn(){
        phone.setState(new LockedState(phone));
        return phone.lock();
    }
}

class LockedState extends State {
    public LockedState(Phone phone){
        super(phone);
    }
    @Override
    public String onHome(){
        phone.setState(new ReadyState(phone));
        return phone.unlock();
    }
    @Override
    public String onOffOn(){
        phone.setState(new OffState(phone));
        return phone.lock();
    }
}



class Phone {

    private State state;

    public Phone(State state){
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public String lock() {
        return " Locking Phone ";
    }

    public String home() {
        return "Home Screen";
    }
    public String unlock() {
        return "Unlocking the phone to home";
    }
    public String turnOn() {
        return "Turning screen On";
    }


}
