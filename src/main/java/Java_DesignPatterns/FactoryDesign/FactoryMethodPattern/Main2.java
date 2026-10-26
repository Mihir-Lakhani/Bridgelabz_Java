package Java_DesignPatterns.FactoryDesign.FactoryMethodPattern;

import java.util.*;


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

    public abstract Gpu createGpu();
}

class MsiManufacturer extends Company{

    public Gpu createGpu(){
        return new MsiGpu();
    }
}

class AsusManufacturer extends Company{

    public Gpu createGpu(){
        return new AsusGpu();
    }
}


public class Main2 {
    public static void main(String[] args) {

        MsiManufacturer msi = new MsiManufacturer();
        msi.orderGpu();

        AsusManufacturer asus = new AsusManufacturer();
        asus.orderGpu();

    }
}