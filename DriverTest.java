import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

public class DriverTest{
    Driver driver;

    @Before
    public void setup(){
        driver = new Driver();
    }

    // Test the accessor for driver's location
    //   First set the location to a DOUBLE of the Location class,
    //   then check to ensure that the current location has properly changed.
    // TESTS: getCurrentLocation()
    @Test
    public void testGetCurrentLocation(){
        Location testLoc = mock(Location.class);
        testLoc.setName("SuccessfulTest");
        driver.nextLocation(testLoc);

        Location testResult = driver.getCurrentLocation();
        assertEquals(testResult, testLoc);
    }

    // Test that the accessor for the driver's current location returns
    // null immediately after instantiation
    // TESTS: getCurrentLocation()
    @Test
    public void testGetNullCurrentLocation(){
        Location testResult = driver.getCurrentLocation();
        assertNull(testResult);
    }

    // Test the accessor for driver's location
    //   First set the location to a DOUBLE of the Location class, then do it for a second location.
    //   Then check to ensure that the previous location has properly updated.
    // TESTS: getPreviousLocation()
    @Test
    public void testGetPreviousLocation(){
        Location testLoc1 = mock(Location.class);
        Location testLoc2 = mock(Location.class);

        testLoc1.setName("SuccessfulTest");
        testLoc2.setName("ShouldntMatter");

        driver.nextLocation(testLoc1);
        driver.nextLocation(testLoc2);

        Location testResult = driver.getPreviousLocation();
        assertEquals(testResult, testLoc1);
    }

    // Test the accessor for driver's location
    //   First set the location to a null Location, then add a location DOUBLE.
    //   Then check to ensure that the previous location has properly returned a null.
    // TESTS: getPreviousLocation()
    @Test
    public void testGetPreviousLocationNull(){
        Location testLoc1 = null;
        Location testLoc2 = mock(Location.class);

        testLoc2.setName("ShouldntMatter");

        driver.nextLocation(testLoc1);
        driver.nextLocation(testLoc2);

        Location testResult = driver.getPreviousLocation();
        assertEquals(testResult, null);
    }

    // Test that the Driver will return the correct ID after Intitialization with that ID
    // TESTS: getID()
    @Test
    public void testGetID(){
        driver = new Driver(123, new Location("Test Location", false));
        assertEquals(123, driver.getID());
    }

    // Test that the Driver will return an ID of -1 when the ID is not initialized
    // TESTS getID()
    @Test
    public void testGetUninitializedID(){
        assertEquals(-1, driver.getID());
    }
}
