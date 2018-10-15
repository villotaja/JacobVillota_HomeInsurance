package jacob.casestudy.DAOTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jacob.casestudy.DAO.LocationDAO;
import jacob.casestudy.models.Location;



public class LocationDAOTest {

	@Test
	public void testGetAllLocations() throws SQLException, IOException {
		LocationDAO l_dao = new LocationDAO();
		List<Location> l_list = new ArrayList<Location>();
		l_list = l_dao.getAllLocation();
		assertThat(l_dao, is(notNullValue()));

	}

	@Test()
	public void assignLocation() throws ClassNotFoundException, IOException, SQLException {
		LocationDAO l_dao = new LocationDAO();
		Location L = new Location();
		assertThat(l_dao, is(notNullValue()));
		int testResult = l_dao.registerLocation(L);
		assertThat(testResult, is(-1));

}
	
	
}