package jacob.casestudy.BOTests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import jacob.casestudy.BO.HomeownerBO;
import jacob.casestudy.models.Homeowner;



public class HomeownerBOTest {
	@Test
	public void testGetAllHomeowners() throws SQLException, IOException {
		HomeownerBO h_BO = new HomeownerBO();
		List<Homeowner> h_list = new ArrayList<Homeowner>();
		h_list = h_BO.getHomeowners();
		assertThat(h_BO, is(notNullValue()));

	}

	@Test()
	public void assignHomeowner() throws ClassNotFoundException, IOException, SQLException {
		HomeownerBO h_BO = new HomeownerBO();
		Homeowner h = new Homeowner();
		assertThat(h_BO, is(notNullValue()));
		int testResult = h_BO.registerHomowner("John", "guy", null, false, "123456789", 2, "John@jon.com");
		assertThat(testResult, is(-1));

}
	
	


}
