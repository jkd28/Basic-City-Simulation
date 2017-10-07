// This class will manage the map and
// the movement of Drivers between Locations

import java.util.Random;
import java.util.ArrayList;

public class City{
    private final int NUM_LOCATIONS = 6;
    private final String CLEVELAND = "Cleveland";
    private final String LIBRARY = "Library";
    private final String COFFEE = "Coffee";
    private final String HOTEL = "Hotel";
    private final String DINER = "Diner";
    private final String PHILLY = "Philadelphia";
    private final boolean IN_CITY = false;
    private final boolean OUT_OF_CITY = true;

    // Constructor
    public City(){

    }

    // Convert the integer value to a location, and return it
    private Location intToLocation(int num){
        Location loc = null;
        switch(num){
            case 0:
                loc = new Location(CLEVELAND, OUT_OF_CITY);
                break;
            case 1:
                loc = new Location(LIBRARY, IN_CITY);
                break;
            case 2:
                loc = new Location(COFFEE, IN_CITY);
                break;
            case 3:
                loc = new Location(HOTEL, IN_CITY);
                break;
            case 4:
                loc = new Location(DINER, IN_CITY);
                break;
            case 5:
                loc = new Location(PHILLY, OUT_OF_CITY);
                break;
        }
        return loc;
    }

    // Given a seeded random generator, determine the first location for the Driver
    public Location getDriverFirstLocation(Random generator){
        Location firstLocation = intToLocation(generator.nextInt(NUM_LOCATIONS));
        // Ensure a driver cannot start outside of the city
        while (((firstLocation.getName()).equals(PHILLY)) || ((firstLocation.getName()).equals(CLEVELAND))){
            firstLocation = intToLocation(generator.nextInt(NUM_LOCATIONS));
        }

        return firstLocation;
    }

    // Given a Driver's current location, determine a list of possible next locations
    // Possible locations are determined based on the requirements/description of the assignment
    public ArrayList<Location> getPossibleLocations(Location currentLocation) {
        ArrayList<Location> possibleLocations = new ArrayList<Location>();

        String currentLocationName = currentLocation.getName();

        if (currentLocationName.equals(LIBRARY)) {
            possibleLocations.add(new Location(CLEVELAND, OUT_OF_CITY));
            possibleLocations.add(new Location(HOTEL,     IN_CITY));

        } else if (currentLocationName.equals(COFFEE)) {
            possibleLocations.add(new Location(LIBRARY, IN_CITY));
            possibleLocations.add(new Location(DINER,   IN_CITY));

        } else if (currentLocationName.equals(HOTEL)) {
            possibleLocations.add(new Location(DINER,   IN_CITY));
            possibleLocations.add(new Location(LIBRARY, IN_CITY));

        } else if (currentLocationName.equals(DINER)) {
            possibleLocations.add(new Location(PHILLY, OUT_OF_CITY));
            possibleLocations.add(new Location(COFFEE, IN_CITY));

        } else {
            // Assuming the program is functioning properly, this should never
            // happen, but just in case we get this function call while a driver
            // is out of the city, we will not move it
            possibleLocations.add(currentLocation);
        }
        return possibleLocations;
    }

    // Based on a Driver's previous location, determine the next location
    // by random generation and possible locations
    public Location getNextDriverLocation(Random generator, Driver driver){
        return null;
    }
}
