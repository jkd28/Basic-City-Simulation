import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Random;

public class CityTest{
    City testCity;
    final int NUM_LOCATIONS = 5;

    @Before
    public void setup(){
        testCity = new City();
    }

    // Using a DOUBLE of Random with a STUB of the nextInt() method,
    // test the functionality of the function to get the initial Location of a Driver
    // TESTS: getDriverFirstLocation()
    @Test
    public void testFirstLocationWithValidNum(){
        Random testGenerator = mock(Random.class);
        // Stub the nextInt method when called with 6 = Number of Possible locations
        when(testGenerator.nextInt(NUM_LOCATIONS-1)).thenReturn(3);

        Location testReturn = testCity.getDriverFirstLocation(testGenerator);
        assertEquals("Diner", testReturn.getName());
    }

    // Using a DOUBLE of Random with a STUB of the nextInt() method yielding an invalid number
    // for that method, test the that the initial location function will not return a null Location.
    // TESTS: getDriverFirstLocation()
    @Test
    public void testFirstLocationWithInvalidNum(){
        Random testGenerator = mock(Random.class);
        // Stub the nextInt method when called with 6 = Number of Possible locations
        when(testGenerator.nextInt(NUM_LOCATIONS-1)).thenReturn(1231);

        Location testReturn = testCity.getDriverFirstLocation(testGenerator);
        assertNotNull(testReturn);
    }

    // Test that the proper list of possible next locations is returned when
    // the function is sent a DOUBLED Location with a STUB of the getName method.
    // TESTS: getPossibleLocations()
    @Test
    public void testGetPossibleLocationsFromHotel(){
        Location currentTest = mock(Location.class);
        when(currentTest.getName()).thenReturn("Hotel");

        ArrayList<Location> testReturn = testCity.getPossibleLocations(currentTest);

        // Use 3 assertions here, but they are all very closely related
        assertEquals(testReturn.size(), 2);
        assertEquals("Diner",   testReturn.get(0).getName());
        assertEquals("Library", testReturn.get(1).getName());
    }

    // Test that the proper list of possible next locations is returned when
    // the function is sent a DOUBLED Location with a STUB of the getName method.
    // TESTS: getPossibleLocations()
    @Test
    public void testGetPossibleLocationsFromLibrary(){
        Location currentTest = mock(Location.class);
        when(currentTest.getName()).thenReturn("Library");

        ArrayList<Location> testReturn = testCity.getPossibleLocations(currentTest);

        // Use 3 assertions here, but they are all very closely related
        assertEquals(testReturn.size(), 2);
        assertEquals("Outside City", testReturn.get(0).getName());
        assertEquals("Hotel",     testReturn.get(1).getName());
    }

    // Test that a list of one is returned when the possible locations function is called
    // for a current location that is outside of the city.
    // TESTS: getPossibleLocations()
    @Test
    public void testGetPossibleLocationsOutOfCity(){
        Location currentTest = mock(Location.class);
        when(currentTest.getName()).thenReturn("Outside City");

        ArrayList<Location> testReturn = testCity.getPossibleLocations(currentTest);

        // Use 3 assertions here, but they are all very closely related
        assertEquals(testReturn.size(), 1);
        assertEquals(currentTest, currentTest);
    }

    // Test that the function to determine the next locaiton properly returns a location
    // when given a list of possible locations and a Random generator.
    // TESTS: chooseNextLocation()
    @Test
    public void testNextLocation(){
        Location test1 = new Location("Test Location",   false);
        Location test2 = new Location("Won't be Picked", false);

        ArrayList<Location> possibles = new ArrayList<Location>();
        possibles.add(test1);
        possibles.add(test2);

        // Double the random generator
        Random testGen = mock(Random.class);
        when(testGen.nextInt(2)).thenReturn(0);

        Location result = testCity.chooseNextLocation(testGen, possibles);
        assertEquals(test1, result);
    }

    // Test that the function to determine the next locaiton returns null
    // when given an empty list of possible locations.
    // TESTS: chooseNextLocation()
    @Test
    public void testNextLocationEmptyArray(){
        ArrayList<Location> possibles = new ArrayList<Location>();

        // Double the random generator
        Random testGen = mock(Random.class);
        when(testGen.nextInt(0)).thenReturn(0);

        Location result = testCity.chooseNextLocation(testGen, possibles);
        assertNull(result);
    }

    // Test that the fucntion determines the proper route of travel for a given
    // final destination when the Driver is moving from the Hotel to that location
    // TESTS: determineRoadTravelled()
    @Test
    public void testRoadTravelledFromHotel(){
        Location hotel = new Location("Hotel", false);
        Location diner = new Location("Diner", false);
        Location library = new Location("Library", false);

        Driver hotelToDiner = new Driver(0, hotel);
        Driver hotelToLibrary = new Driver(1, hotel);

        hotelToDiner.nextLocation(diner);
        hotelToLibrary.nextLocation(library);

        assertEquals("Fourth Ave.", testCity.determineRoadTravelled(hotelToDiner));
        assertEquals("Bill St.", testCity.determineRoadTravelled(hotelToLibrary));
    }

    // Test that the fucntion determines the proper route of travel for a given
    // final destination when the Driver is moving from the Diner to that location
    // TESTS: determineRoadTravelled()
    @Test
    public void testRoadTravelledFromDiner(){
        Location diner = new Location("Diner", false);
        Location out = new Location("Outside City", true);
        Location coffee  = new Location("Coffee", false);

        Driver dinerToOut = new Driver(0, diner);
        Driver dinerToCoffee = new Driver(1, diner);

        dinerToOut.nextLocation(out);
        dinerToCoffee.nextLocation(coffee);

        assertEquals("Fourth Ave.", testCity.determineRoadTravelled(dinerToOut));
        assertEquals("Phil St.", testCity.determineRoadTravelled(dinerToCoffee));
    }

    // Test that the fucntion determines the proper route of travel for a given
    // final destination when the Driver is moving from the Coffee to that location
    // TESTS: determineRoadTravelled()
    @Test
    public void testRoadTravelledFromCoffee(){
        Location coffee   = new Location("Coffee", false);
        Location diner   = new Location("Diner", false);
        Location library = new Location("Library", false);

        Driver coffeeToDiner   = new Driver(0, coffee);
        Driver coffeeToLibrary = new Driver(1, coffee);

        coffeeToDiner.nextLocation(diner);
        coffeeToLibrary.nextLocation(library);

        assertEquals("Phil St.", testCity.determineRoadTravelled(coffeeToDiner));
        assertEquals("Fifth Ave.", testCity.determineRoadTravelled(coffeeToLibrary));
    }

    // Test that the fucntion determines the proper route of travel for a given
    // final destination when the Driver is moving from the Library to that location
    // TESTS: determineRoadTravelled()
    @Test
    public void testRoadTravelledFromLibrary(){
        Location library = new Location("Library", false);
        Location out = new Location("Outside City", true);
        Location hotel = new Location("Hotel", false);

        Driver libraryToOut = new Driver(0, library);
        Driver libraryToHotel = new Driver(1, library);

        libraryToOut.nextLocation(out);
        libraryToHotel.nextLocation(hotel);

        assertEquals("Fifth Ave.", testCity.determineRoadTravelled(libraryToOut));
        assertEquals("Bill St.", testCity.determineRoadTravelled(libraryToHotel));
    }

    // This test gives a couple of paths that could/should not exist.  The function should
    // return an empty string when the path is invalid.
    // TESTS: determineRoadTravelled()
    @Test
    public void testRoadTravelledInvalidPath(){
        Location coffee = new Location("Coffee", false);
        Location out = new Location("Outside City", false);
        Location hotel = new Location("Hotel", false);

        Driver coffeeToOut = new Driver(0, coffee);
        Driver hotelToCoffee = new Driver(1, hotel);

        coffeeToOut.nextLocation(out);
        hotelToCoffee.nextLocation(coffee);

        assertEquals("", testCity.determineRoadTravelled(coffeeToOut));
        assertEquals("", testCity.determineRoadTravelled(hotelToCoffee));
    }

    // Test that the getDestination function properly works when provided the pair
    // of paths that it is designed for (Library->Outside, Diner->Outside)
    // TESTS: getDestination()
    @Test
    public void testGetDestination(){
        Location library = new Location("Library", false);
        Location diner = new Location("Diner", false);
        Location out = new Location("Outside City", true);

        Driver testCleveland = new Driver(0, library);
        testCleveland.nextLocation(out);

        Driver testPhilly = new Driver(1, diner);
        testPhilly.nextLocation(out);

        assertEquals("Cleveland", testCity.getDestination(testCleveland));
        assertEquals("Philadelphia", testCity.getDestination(testPhilly));
    }

    // Test that the getDestination function properly works when provided a null driver
    // TESTS: getDestination()
    @Test
    public void testGetDestinationNullDriver(){
        Driver testNull = null;
        assertEquals("", testCity.getDestination(testNull));
    }

    // Test that the getDestination function properly works when provided an improper
    // location pair
    // TESTS: getDestination()
    @Test
    public void testGetDestinationInvalidLocations(){
        Location library = new Location("Library", false);
        Location diner = new Location("Diner", false);

        Driver testInvalid = new Driver(0, library);
        testInvalid.nextLocation(diner);

        assertEquals("", testCity.getDestination(testInvalid));
    }
}
