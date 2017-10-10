// A simple class to act as an identifier for movement
// between each location in the City

public class Driver{
    private Location previousLocation;
    private Location currentLocation;
    private int identifier;

    // Constructors
    public Driver(){
        currentLocation = null;
        identifier = -1;
    }

    public Driver(int id, Location loc){
        identifier = id;
        currentLocation = loc;
        previousLocation = null;
    }

    // Modifiers
    public void nextLocation(Location newLoc){
        previousLocation = currentLocation;
        currentLocation = newLoc;
    }

    // Accessors
    public int getID(){
        return identifier;
    }

    public Location getCurrentLocation(){
        return currentLocation;
    }

    public Location getPreviousLocation(){
        return previousLocation;
    }
}
