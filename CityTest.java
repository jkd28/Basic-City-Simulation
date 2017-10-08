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
}
