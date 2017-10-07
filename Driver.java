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

    public Driver(int id){
        identifier = id;
        currentLocation = null;
        previousLocation = null;
    }

    public Driver(int id, Location loc){
        identifier = id;
        currentLocation = loc;
        previousLocation = null;
    }

    // Modifiers
    public void setCurrentLocation(Location newLoc){
        previousLocation = currentLocation;
        currentLocation = newLoc;
    }

    // Accessors
    public Location getCurrentLocation(){
        return currentLocation;
    }

    public Location getPreviousLocation(){
        return previousLocation;
    }
}
