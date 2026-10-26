package Java_DesignPatterns.AbstractFactory;

interface Monitor{
    void assemble();
}

class MsiMonitor implements Monitor{

    @Override
    public void assemble(){
        System.out.println("Assembling MSI Monitor");
    }
}

class AsusMonitor implements Monitor{

    @Override
    public void assemble(){
        System.out.println("Assembling Asus Monitor");
    }
}

interface Gpu{
    void assemble();
}

class MsiGpu implements Gpu{

    @Override
    public void assemble(){
        System.out.println("Assembling MSI GPU");
    }
}

class AsusGpu implements Gpu{

    @Override
    public void assemble(){
        System.out.println("Assembling ASUS GPU");
    }
}

abstract class Company{

    public Gpu orderGpu(){
        Gpu gpu = createGpu();
        gpu.assemble();
        return gpu;
    }

    public Monitor orderMonitor(){
        Monitor monitor = createMonitor();
        monitor.assemble();
        return monitor;
    }

    public abstract Gpu createGpu();

    public abstract Monitor createMonitor();
}

class MsiManufacturer extends Company{

    public Gpu createGpu(){
        return new MsiGpu();
    }
    public Monitor createMonitor(){
        return new MsiMonitor();
    }
}

class AsusManufacturer extends Company{

    public Gpu createGpu(){
        return new AsusGpu();
    }
    public Monitor createMonitor(){
        return new AsusMonitor();
    }
}


public class Main2 {
    public static void main(String[] args) {

        MsiManufacturer msi = new MsiManufacturer();
        msi.orderGpu();
        msi.orderMonitor();

        AsusManufacturer asus = new AsusManufacturer();
        asus.orderGpu();
        asus.orderMonitor();

    }
}