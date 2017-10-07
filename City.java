// This class will manage the map and
// the movement of Drivers between Locations

import java.util.Random;

public class City{
    private final int NUM_LOCATIONS = 6;
    public City(){

    }

    // Convert the integer value to a location, and return it
    private Location intToLocation(int num){
        Location loc = null;
        switch(num){
            case 0:
                loc = new Location("Cleveland", true);
                break;
            case 1:
                loc = new Location("Library", false);
                break;
            case 2:
                loc = new Location("Coffee", false);
                break;
            case 3:
                loc = new Location("Hotel", false);
                break;
            case 4:
                loc = new Location("Diner", false);
                break;
            case 5:
                loc = new Location("Philadelphia", true);
                break;
        }
        return loc;
    }

    // Given a seeded random generator, determine the first location for the Driver
    public Location getDriverFirstLocation(Random generator){
        Location firstLocation = intToLocation(generator.nextInt(NUM_LOCATIONS));
        // Ensure a driver cannot start outside of the city
        while (((firstLocation.getName()).equals("Philadelphia")) || ((firstLocation.getName()).equals("Cleveland"))){
            firstLocation = intToLocation(generator.nextInt(NUM_LOCATIONS));
        }

        return firstLocation;
    }

    // Based on a Driver's previous location, determine the next location
    // by random generation and possible locations
    public Location getNextDriverLocation(Random generator, Driver driver){
        Location currentLocation = driver.getCurrentLocation();
        return null;
    }
}
