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
	import org.junit.experimental.categories.Category;

import jacob.casestudy.DAO.PolicyDAO;
import jacob.casestudy.models.Policy;

	public class PolicyDAOTest {

		@Test
		public void testGetAllPolicies() throws SQLException, IOException {
			PolicyDAO p_dao = new PolicyDAO();
			List<Policy> p_list = new ArrayList<Policy>();
			p_list= p_dao.getAllPolicy();
			assertThat(p_dao, is(notNullValue()));

		}

		@Test()
		public void assignPolicy() throws ClassNotFoundException, IOException, SQLException {
			PolicyDAO p_dao = new PolicyDAO();
			Policy p = new Policy();
			assertThat(p_dao, is(notNullValue()));
			int testResult = p_dao.registerPolicy(p);
			assertThat(testResult, is(-1));

	}
	}





