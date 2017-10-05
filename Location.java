// This class will act as an identifier for locations in the City
// Each location can be occupied by a Driver

public class Location{
    private String name;

    public Location(String id){
        name = id;
    }

    // Modifiers
    public void setName(String newName){
        name = newName;
    }

    // Accessors
    public String getName(){
        return name;
    }
}
