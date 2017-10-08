import java.util.Random;
import java.util.ArrayList;

public class CitySim9005 {
    public static void main(String[] args){
        // Check format of arguments
        if (args.length != 1){
            System.out.println("Please enter one integer argument");
            System.exit(1);
        }
        // Intitialize the seed with unimportant value
        int seed = 0;

        // Get proper seed value from arguments
        try {
            seed = Integer.parseInt(args[0]);
        }
        catch (NumberFormatException e){
            System.out.println("Please enter one integer arguement.");
            System.exit(1);
        }

        Random generator = new Random((long)seed);

        City city = new City();

        for (int i = 0; i < 5; i++){
            // Generate first location and instantiate the driver
            Location firstLoc = city.getDriverFirstLocation(generator);
            Driver driver = new Driver(i+1, firstLoc);

            Location currentLocation = firstLoc;
            while (!currentLocation.isOutOfCity()){
                // Change Driver location
                ArrayList<Location> possibleLocations = city.getPossibleLocations(currentLocation);
                Location nextLoc = city.chooseNextLocation(generator, possibleLocations);
                driver.nextLocation(nextLoc);

                // Print message about route of travel
                currentLocation = driver.getCurrentLocation();
                System.out.println(driver.getPreviousLocation().toString() + " to " + currentLocation.toString());
            }
            System.out.println("---------------------");
        }
    }
}
