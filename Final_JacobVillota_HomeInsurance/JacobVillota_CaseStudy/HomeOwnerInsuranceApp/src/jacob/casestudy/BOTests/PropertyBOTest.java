package jacob.casestudy.BOTests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jacob.casestudy.BO.PropertyBO;
import jacob.casestudy.models.Property;



public class PropertyBOTest {
	@Test
	public void testGetAllProperties() throws SQLException, IOException {
		PropertyBO p_BO = new PropertyBO();
		List<Property> p_list = new ArrayList<Property>();
		p_list= p_BO.getProperty();
		assertThat(p_BO, is(notNullValue()));

	}

	@Test()
	public void assignProperty() throws ClassNotFoundException, IOException, SQLException {
		PropertyBO p_BO = new PropertyBO();
		Property p = new Property();
		assertThat(p_BO, is(notNullValue()));
		int testResult = p_BO.registerProperty(0, 0, 0, null, null, null, 0, 0, true, 0);
		assertThat(testResult, is(-1));

	
}
}