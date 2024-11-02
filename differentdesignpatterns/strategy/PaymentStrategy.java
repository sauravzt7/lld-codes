package differentdesignpatterns.strategy;

public interface PaymentStrategy {
    void collectPayment();
    boolean vaidatePaymentDetails();
    void pay(double amount);
}

class PaymentByUpi implements PaymentStrategy{
    public PaymentByUpi(){
        super();
    }

    @Override
    public void collectPayment() {

    }

    @Override
    public boolean vaidatePaymentDetails() {

        return false;
    }

    @Override
    public void pay(double amount) {

    }
}

class PaymentByCredit implements PaymentStrategy {

//    private CreditCard creditCard;
    @Override
    public void collectPayment() {

    }

    @Override
    public boolean vaidatePaymentDetails() {

        return false;
    }

    @Override
    public void pay(double amount) {

    }
}


class PaymentService {

    private PaymentStrategy paymentStrategy;

    private double cost;
    private boolean includeDelivery;

    public void processOrder(){
        paymentStrategy.collectPayment();
        if(paymentStrategy.vaidatePaymentDetails()){
            paymentStrategy.pay(89.0);
        }
    }
}

