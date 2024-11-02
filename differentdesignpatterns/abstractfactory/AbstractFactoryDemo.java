package differentdesignpatterns.abstractfactory;

abstract class Company{
    public abstract Gpu createGpu();
    public abstract Monitor createMonitor();
}

class AsusManufacturer extends Company{
    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}

class MsiManufacturer extends Company{
    @Override
    public Gpu createGpu() {
        return new MsiGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}

interface Monitor {
    void assemble();
}

class MsiMonitor implements Monitor{
    @Override
    public void assemble() {

    }
}

class AsusMonitor implements Monitor{

    @Override
    public void assemble() {

    }
}



interface Gpu {
    void assemble();
}

class MsiGpu implements Gpu {
    @Override
    public void assemble(){

    }
}

class AsusGpu implements Gpu{
    @Override
    public void assemble(){

    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args){
        Company msi = new MsiManufacturer();
        Gpu msiGpu = msi.createGpu();
        Monitor msiMonitor = msi.createMonitor();

        Company asus = new AsusManufacturer();
        Gpu asusGpu = asus.createGpu();
        Monitor asusMonitor = asus.createMonitor();

        // Optionally, you can add print statements or further processing here
    }
}
