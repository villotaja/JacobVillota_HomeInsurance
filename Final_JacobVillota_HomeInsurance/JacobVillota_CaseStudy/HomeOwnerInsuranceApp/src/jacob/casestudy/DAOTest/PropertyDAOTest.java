package jacob.casestudy.DAOTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jacob.casestudy.DAO.PropertyDAO;
import jacob.casestudy.models.Property;


public class PropertyDAOTest {
	@Test
	public void testGetAllProperties() throws SQLException, IOException {
		PropertyDAO p_dao = new PropertyDAO();
		List<Property> p_list = new ArrayList<Property>();
		p_list= p_dao.getProperties();
		assertThat(p_dao, is(notNullValue()));

	}

	@Test()
	public void assignProperty() throws ClassNotFoundException, IOException, SQLException {
		PropertyDAO p_dao = new PropertyDAO();
		Property p = new Property();
		assertThat(p_dao, is(notNullValue()));
		int testResult = p_dao.registerProperty(p);
		assertThat(testResult, is(-1));

}
}


