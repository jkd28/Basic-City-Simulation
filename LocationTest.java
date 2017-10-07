import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

public class LocationTest{
    Location testLoc;

    // Test the getName method of Location class by creating a location
    // with a given name, and checking the output of the method.
    // TESTS: getName()
    @Test
    public void testGetName(){
        testLoc = new Location("TestLocation", false);
        assertEquals("TestLocation", testLoc.getName());
    }

    // Test that setName() will appropriately change the value of the Location.
    // First, create the location with a default name, use the setName method,
    // ensure the name has updated properly.
    // TESTS: setName()
    @Test
    public void testSetName(){
        testLoc = new Location("TestLocation", false);
        testLoc.setName("SecondaryName");
        assertEquals("SecondaryName", testLoc.getName());
    }

    // Test that the isOutOfCity method fucntions properly.  Create a location with
    // a true value for the isOutOfCity variable and check that it is properly returned
    // when isOutOfCity is called.
    // TESTS: isOutOfCity()
    @Test
    public void testIsOutOfCity(){
        testLoc = new Location("TestLocation", true);
        assertTrue(testLoc.isOutOfCity());
    }
}
