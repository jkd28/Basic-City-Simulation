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
    @Test
    public void testGetLocation(){
        Location testLoc = mock(Location.class);
        testLoc.setName("SuccessfulTest");
        driver.setLocation(testLoc);

        Location testResult = driver.getCurrentLocation();
        assertEquals(testResult, testLoc);
    }
}
