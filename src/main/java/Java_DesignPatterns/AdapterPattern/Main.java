package Java_DesignPatterns.AdapterPattern;

import java.util.*;

interface UsbCharger{
    void chargeWithUsbC();
}

class OldCharger{
    void chargeWithMicroUsb(){
        System.out.println("Charging with MicroUsb");
    }
}

class ChargerAdapter implements UsbCharger{

    private final OldCharger microUsb;

    ChargerAdapter(OldCharger microUsb){
        this.microUsb = microUsb;
    }

    public void chargeWithUsbC(){
        System.out.println("Adapter converts USB-C request...");
        microUsb.chargeWithMicroUsb();
    }
}

class Phone{

    public void charge(UsbCharger usbCharger){
        usbCharger.chargeWithUsbC();
    }
}

public class Main {
    public static void main(String[] args) {

        OldCharger oldCharger = new OldCharger();
        UsbCharger adapter = new ChargerAdapter(oldCharger);

        Phone phone = new Phone();
        phone.charge(adapter);
    }
}