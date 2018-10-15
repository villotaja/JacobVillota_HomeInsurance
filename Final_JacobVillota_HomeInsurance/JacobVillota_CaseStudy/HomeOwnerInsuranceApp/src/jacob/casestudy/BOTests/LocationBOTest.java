package jacob.casestudy.BOTests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jacob.casestudy.BO.LocationBO;
import jacob.casestudy.models.Location;


public class LocationBOTest {
	@Test
	public void testGetAllLocations() throws SQLException, IOException {
		LocationBO l_BO = new LocationBO();
		List<Location> l_list = new ArrayList<Location>();
		l_list = l_BO.getLocation();
		assertThat(l_BO, is(notNullValue()));

	}

	@Test()
	public void assignLocation() throws ClassNotFoundException, IOException, SQLException {
		LocationBO l_BO = new LocationBO();
		Location L = new Location();
		assertThat(l_BO, is(notNullValue()));
		int testResult = l_BO.registerLocation("1234", "pls", "hi", "hi", "saodi", "9999", "home", 1);
		assertThat(testResult, is(-1));

}
	}
