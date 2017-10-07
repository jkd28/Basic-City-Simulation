// This class will act as an identifier for locations in the City

public class Location{
    private String name;
    private boolean outOfCity;

    public Location(String id, boolean isOC){
        name = id;
        outOfCity = isOC;
    }

    // MODIFIERS
    public void setName(String newName){
        name = newName;
    }

    // ACCESSORS
    public String getName(){
        return name;
    }

    public boolean isOutOfCity(){
        return outOfCity;
    }

    // ACTION METHODS
    // A Location will be defined by its name, therefore its
    // toString() method will print the name.
    public String toString(){
        return name;
    }
}
