import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

public class CitySim9005Test{
    CitySim9005 citySim;

    @Before
    public void setup(){
        citySim = new CitySim9005();
    }

    // Tests that the route description builder function works as expected when
    // provided a driver with a set of locations
    // TESTS: buildRouteDescription()
    @Test
    public void testRouteDescriptionBuilder(){
        City city = mock(City.class);
        Driver driver = mock(Driver.class);

        when(driver.getID()).thenReturn(123);
        when(driver.getPreviousLocation().toString()).thenReturn("Test");
        when(driver.getCurrentLocation().toString()).thenReturn("Successful");

        when(city.determineRoadTravelled(driver)).thenReturn("ThisTotallyWorks");


        String toEqual = "Driver 123 heading from Test to Successful via ThisTotallyWorks";
        assertEquals(toEqual, citySim.buildRouteDescription(city, driver));
    }

    // Tests that the route description builder function returns an empty string
    // when the city is null
    // TESTS: buildRouteDescription()
    @Test
    public void testRouteDescriptionBuilderNullCity(){
        City city = null;
        Driver driver = new Driver();

        assertEquals("", citySim.buildRouteDescription(city, driver));
    }

    // Tests that the route description builder function returns an empty string
    // when the city is null
    // TESTS: buildRouteDescription()
    @Test
    public void testRouteDescriptionBuilderNullDriver(){
        City city = new City();
        Driver driver = null;

        assertEquals("", citySim.buildRouteDescription(city, driver));
    }

    // Tests that the route description builder function returns an empty string
    // when the city is null
    // TESTS: buildRouteDescription()
    @Test
    public void testRouteDescriptionBuilderNullDriverAndCity(){
        City city = null;
        Driver driver = null;

        assertEquals("", citySim.buildRouteDescription(city, driver));
    }
}
