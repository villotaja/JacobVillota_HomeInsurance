package jacob.casestudy.BOTests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jacob.casestudy.BO.PoliciesBO;
import jacob.casestudy.models.Policy;



public class PoliciesBOTest {

	@Test
	public void testGetAllPolicies() throws SQLException, IOException {
		PoliciesBO p_BO = new PoliciesBO();
		List<Policy> p_list = new ArrayList<Policy>();
		p_list= p_BO.getPolicies();
		assertThat(p_BO, is(notNullValue()));

	}

	@Test()
	public void assignPolicy() throws ClassNotFoundException, IOException, SQLException {
		PoliciesBO p_BO = new PoliciesBO();
		Policy p = new Policy();
		assertThat(p_BO, is(notNullValue()));
		int testResult = p_BO.registerPolicy(null, null, 1, null, 0);
		assertThat(testResult, is(-1));

}
}
