enum ProductType {
    CHOCOLATE, 
    SNACKS, 
    BEVERAGE, 
    OTHER
}

//State is an interface and the NoMoneyInsertedState, MoneyInsertedState, and DispenseState classes implement the State interface. The definition of these classes is provided below:

public interface State {

    public void insertMoney(VendingMachine machine, double amount);
    public void pressButton(VendingMachine machine, int rackNumber);
    public void returnChange(double amount);
    public void updateInventory(VendingMachine machine, int rackNumber);
    public void dispenseProduct(VendingMachine, int rackNumber);


}


public class NoMoneyInsertedState implements State {
    @override

    public void insertMoney(VendingMachine machine, double amount){
        // changes the State to MoneyInsertedState
    };
    public void pressButton(VendingMachine machine, int rackNumber);
    public void returnChange(double amount);
    public void updateInventory(VendingMachine machine, int rackNumber);
    public void dispenseProduct(VendingMachine, int rackNumber);

}


public class MoneyInsertedState implements State {
    
    @override
    public void insertMoney(VendingMachine machine, double amount);
    public void pressButton(VendingMachine machine, int rackNumber){
        //check if the Product is available
        // validate money
        // change the state to DispenseState
    };
    public void returnChange(double amount);
    public void updateInventory(VendingMachine machine, int rackNumber);
    public void dispenseProduct(VendingMachine, int rackNumber);
}


public class DispenseState implements State {
    
    @override
    public void insertMoney(VendingMachine machine, double amount);
    public void pressButton(VendingMachine machine, int rackNumber);
    public void returnChange(double amount);
    public void updateInventory(VendingMachine machine, int rackNumber);
    public void dispenseProduct(VendingMachine, int rackNumber);


    //dispense the product 
    // change state back to NoMoneyInsertedState
}

public class Product {
    private String name;
    private int id;
    private double price;
    private ProductType productType;

}

public class Rack {
    
    private int rackNumber;
    private List<int> productIds;
    private double price;
    

    public boolean isEmpty();

}

public class Inventory {
    
    private int noOfProducts;
    private List<int> productIds;
    private double price;
    

    public boolean isEmpty();
    public boolean addProdcuts(int rackNumber, int productId);
    public boolean removeProducts();

}
//The VendingMachine class is the final class of the system, and it will also be a Singleton class so that there will only be a single instance of this class in the whole system. The definition of this class is given below:

public class VendingMachine { 


    private State currentState;
    private double amount;
    private int noOfRacks;
    private List<Rack> racks; 
    private List<int> availableRacks; 

    private static VendingMachine vendingMachine = null;

    // Created a private constructor to add a restriction (due to Singleton)
    private VendingMachine();

    public static synchronized VendingMachine getInstance(){
        if(vendingMachine == null){
            vendingMachine = new VendingMachine();
        }

        return vendingMachine;
    }


    public void insertMoney(double amount) {}
    public void pressButton(int rackNumber) {}
    public void returnChange(double amount) {}
    public void updateInventory(int rackNumber) {}
    public void dispenseProduct(int rackNumber) {}
    public int getProductIdAtRack(int rackNumber) {}

}

//Demo main class 

public VendingMachineDemoSystem {

    public static void run (){

        VendingMachine vendingMachine = VendingMachine.getInstance();

        Product coke = new Product("Coke", 18);
        Product bhujia = new Product("Bhujia");
        Product pepsi = new Product("Pepsi");

        vendingMachine.addProdcuts(coke);
        vendingMachine.addProdcuts(pepsi);


        //select
        vendingMachine.selectProduct(coke);

        //
        vendingMachine.insertMoney(20);

        vendingMachine.dispenseProduct();

        VendingMachine.returnChange(); // 2 returned 
        


    }
}