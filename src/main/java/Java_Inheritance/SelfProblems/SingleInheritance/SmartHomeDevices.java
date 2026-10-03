/*
Program 2: Smart Home Devices
Create Device with an ID and status. Extend it with Thermostat,
which also stores a temperature setting.
 */

package Java_Inheritance.SelfProblems.SingleInheritance;

class Device {
    String deviceId;
    String status;

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

class Thermostat extends Device {
    double temperatureSetting;

    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + " C");
    }
}

public class SmartHomeDevices {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat("TH101", "On", 24.5);
        thermostat.displayStatus();
    }
}
