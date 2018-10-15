package jacob.casestudy.DAOTest;



	import static org.hamcrest.CoreMatchers.is;
	import static org.hamcrest.CoreMatchers.not;
	import static org.hamcrest.CoreMatchers.notNullValue;
	import static org.hamcrest.MatcherAssert.assertThat;
	import static org.junit.Assert.*;

	import java.io.IOException;
	import java.sql.SQLException;
	import java.sql.SQLIntegrityConstraintViolationException;
	import java.util.ArrayList;
	import java.util.List;

	import org.junit.Test;

import jacob.casestudy.DAO.HomeOwnerDAO;
import jacob.casestudy.models.Homeowner;



	public class HomeOwnerDAOTest {

		@Test
		public void testGetAllHomeowners() throws SQLException, IOException {
			HomeOwnerDAO h_dao = new HomeOwnerDAO();
			List<Homeowner> h_list = new ArrayList<Homeowner>();
			h_list = h_dao.getAllHomeOwners();
			assertThat(h_dao, is(notNullValue()));

		}

		@Test()
		public void assignHomeowner() throws ClassNotFoundException, IOException, SQLException {
			HomeOwnerDAO h_dao = new HomeOwnerDAO();
			Homeowner h = new Homeowner();
			assertThat(h_dao, is(notNullValue()));
			int testResult = h_dao.registerHomeowner(h);
			assertThat(testResult, is(-1));

	}
		
		
	}

