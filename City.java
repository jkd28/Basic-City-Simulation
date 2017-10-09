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
    private final String PHIL = "Phil St.";
    private final String BILL = "Bill St.";
    private final String FOURTH = "Fourth Ave.";
    private final String FIFTH = "Fifth Ave.";
    private final boolean IN_CITY = false;
    private final boolean OUT_OF_CITY = true;

    // Constructor
    public City(){

    }

    // Convert the integer value to a location, and return it
    private Location intToLocation(int num){
        Location loc;
        switch(num){
            case 0:
                loc = new Location(LIBRARY, IN_CITY);
                break;
            case 1:
                loc = new Location(COFFEE, IN_CITY);
                break;
            case 2:
                loc = new Location(HOTEL, IN_CITY);
                break;
            case 3:
                loc = new Location(DINER, IN_CITY);
                break;
            case 4:
                loc = new Location(OUTSIDE, OUT_OF_CITY);
                break;
            // Should never receive a number that reaches this, but defensive programming and all
            default:
                loc = new Location(LIBRARY, IN_CITY);
        }
        return loc;
    }

    // Given a seeded random generator, determine the first location for the Driver
    public Location getDriverFirstLocation(Random generator){
        Location firstLocation = intToLocation(generator.nextInt(NUM_LOCATIONS-1));

        // Ensure a driver cannot start outside of the city, and a driver cannot have a null start location
        while ((firstLocation.getName().equals(OUTSIDE)) || (firstLocation == null)){
            // To ensure there is no null values,
            firstLocation = intToLocation(generator.nextInt(NUM_LOCATIONS-1));
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
        // If an empty array is passed, return a null
        if (possibleLocations.size() == 0) {
            return null;
        }
        int nextLocationIndex = generator.nextInt(possibleLocations.size());
        return possibleLocations.get(nextLocationIndex);
    }

    // Determine the road used by a Driver when moving from the previous Location
    // to the current Location
    public String determineRoadTravelled(Driver driver){
        String prevLoc = driver.getPreviousLocation().getName();
        String currLoc = driver.getCurrentLocation().getName();

        if (prevLoc.equals(LIBRARY)){
            if (currLoc.equals(HOTEL)) {
                return BILL;
            } else if (currLoc.equals(OUTSIDE)) {
                return FIFTH;
            }

        } else if (prevLoc.equals(COFFEE)) {
            if (currLoc.equals(LIBRARY)) {
                return FIFTH;
            } else if (currLoc.equals(DINER)) {
                return PHIL;
            }

        } else if (prevLoc.equals(DINER)) {
            if (currLoc.equals(COFFEE)) {
                return PHIL;
            } else if (currLoc.equals(OUTSIDE)) {
                return FOURTH;
            }

        } else if (prevLoc.equals(HOTEL)) {
            if (currLoc.equals(DINER)) {
                return FOURTH;
            } else if (currLoc.equals(LIBRARY)) {
                return BILL;
            }
        }
        // If we reach here, there's not a valid path
        return "";
    }

    // Determine the final location (Philadelphia/Cleveland)for a diver
    // based on the previous location.  Returns an empty string if the driver
    // has not left the city, or if the previous location is not reachable from Outside City,
    // or if the driver supplied is null
    public String getDestination(Driver driver) {
        if (driver == null) {
            return "";
        }

        if (driver.getCurrentLocation().getName().equals(OUTSIDE)) {
            String prevLoc = driver.getPreviousLocation().getName();

            if (prevLoc.equals(LIBRARY)){
                return "Cleveland";
            } else if (prevLoc.equals(DINER)) {
                return "Philadelphia";
            } else {
                return "";
            }
        } else {
            return "";
        }
    }
}
