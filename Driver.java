// A simple class to act as an identifier for movement
// between each location in the City

public class Driver{
    private Location currentLocation;
    private int identifier;

    // Constructors
    public Driver(){
        currentLocation = null;
        identifier = -1;
    }
    
    public Driver(int id){
        identifier = id;
    }

    public Driver(int id, Location loc){
        identifier = id;
        currentLocation = loc;
    }

    // Modifiers
    public void setLocation(Location newLoc){
        currentLocation = newLoc;
    }

    // Accessors
    public Location getCurrentLocation(){
        return currentLocation;
    }
}
