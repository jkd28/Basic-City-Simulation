// This class will manage the map and
// the movement of Drivers between Locations

import java.util.Random;
import java.util.ArrayList;

public class City{
    private final int NUM_LOCATIONS = 5;
    private final String LIBRARY = "Library";
    private final String COFFEE = "Coffee";
    private final String HOTEL = "Hotel";
    private final String DINER = "Diner";
    private final String OUTSIDE = "Outside City";
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
                loc = new Location(OUTSIDE, OUT_OF_CITY);
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
        }
        return loc;
    }

    // Given a seeded random generator, determine the first location for the Driver
    public Location getDriverFirstLocation(Random generator){
        Location firstLocation = intToLocation(generator.nextInt(NUM_LOCATIONS));
        // Ensure a driver cannot start outside of the city
        while (firstLocation.getName().equals(OUTSIDE)) {
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
            possibleLocations.add(new Location(OUTSIDE, OUT_OF_CITY));
            possibleLocations.add(new Location(HOTEL,     IN_CITY));

        } else if (currentLocationName.equals(COFFEE)) {
            possibleLocations.add(new Location(LIBRARY, IN_CITY));
            possibleLocations.add(new Location(DINER,   IN_CITY));

        } else if (currentLocationName.equals(HOTEL)) {
            possibleLocations.add(new Location(DINER,   IN_CITY));
            possibleLocations.add(new Location(LIBRARY, IN_CITY));

        } else if (currentLocationName.equals(DINER)) {
            possibleLocations.add(new Location(OUTSIDE, OUT_OF_CITY));
            possibleLocations.add(new Location(COFFEE, IN_CITY));

        } else {
            // Assuming the program is functioning properly, this should never
            // happen, but just in case we get this function call while a driver
            // is out of the city, we will not move it
            possibleLocations.add(currentLocation);
        }
        return possibleLocations;
    }

    // Determine the next location using random generation and a list of potential locations locations
    public Location chooseNextLocation(Random generator, ArrayList<Location> possibleLocations){
        int nextLocationIndex = generator.nextInt(possibleLocations.size());
        return possibleLocations.get(nextLocationIndex);
    }
}
