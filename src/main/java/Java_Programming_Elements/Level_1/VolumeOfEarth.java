/*
A program to calculate the volume of Earth
in cubic kilometers and cubic miles.
 */

package Java_Programming_Elements.Level_1;

public class VolumeOfEarth {
    public static void main(String[] args){

        //Store the radius of Earth in kilometers
        double radiusKm = 6378;

        //Convert radius from kilometers to miles
        double radiusMiles = radiusKm / 1.6;

        //Calculate volume of Earth in cubic kilometers
        double volumeKm = (4.0 / 3.0) * Math.PI * radiusKm * radiusKm * radiusKm;

        //Calculate volume of Earth in cubic miles
        double volumeMiles = (4.0 / 3.0) * Math.PI * radiusMiles * radiusMiles * radiusMiles;

        //Print both volumes
        System.out.printf("The volume of earth in cubic kilometers is %.2f and cubic miles is %.2f",
                volumeKm, volumeMiles);
    }
}