import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Random;

public class CityTest{
    City testCity;

    @Before
    public void setup(){
        testCity = new City();
    }

    // Using a DOUBLE of Random with a STUB of the nextInt() method,
    // test the functionality of the function to get the initial Location of a Driver
    // TESTS: getDriverFirstLocation()
    @Test
    public void testFirstLocationInitializeWithValidNum(){
        Random testGenerator = mock(Random.class);
        // Stub the nextInt method when called with 6 = Number of Possible locations
        when(testGenerator.nextInt(6)).thenReturn(3);

        Location testReturn = testCity.getDriverFirstLocation(testGenerator);
        assertEquals("Hotel", testReturn.getName());
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
        assertEquals("Cleveland", testReturn.get(0).getName());
        assertEquals("Hotel",     testReturn.get(1).getName());
    }

    // Test that a list of one is returned when the possible locations function is called
    // for a current location that is outside of the city.
    // TESTS: getPossibleLocations()
    @Test
    public void testGetPossibleLocationsOutOfCity(){
        Location currentTest = mock(Location.class);
        when(currentTest.getName()).thenReturn("Philadelphia");

        ArrayList<Location> testReturn = testCity.getPossibleLocations(currentTest);

        // Use 3 assertions here, but they are all very closely related
        assertEquals(testReturn.size(), 1);
        assertEquals(currentTest, currentTest);
    }
}
