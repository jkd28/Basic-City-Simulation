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
}
