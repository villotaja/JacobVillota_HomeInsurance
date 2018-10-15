package jacob.casestudy.BOTests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jacob.casestudy.BO.QuoteBO;
import jacob.casestudy.models.Quote;



public class QuotesBOTest {
	@Test
	public void testGetAllQuotes() throws SQLException, IOException {
		QuoteBO q_BO = new QuoteBO();
		List<Quote> q_list = new ArrayList<Quote>();
		q_list= q_BO.GetQuotes();
		assertThat(q_BO, is(notNullValue()));

	}

	@Test()
	public void assignQuote() throws ClassNotFoundException, IOException, SQLException {
		QuoteBO q_BO = new QuoteBO();
		assertThat(q_BO, is(notNullValue()));
		int testResult = q_BO.registerQuote(0, 0, 0, 0, 0, 0, 0, 0, 0);
		assertThat(testResult, is(-1));

}
	
}
