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

import jacob.casestudy.DAO.QuoteDAO;
import jacob.casestudy.models.Quote;


	public class QuotesDAOTest {

		@Test
		public void testGetAllQuotes() throws SQLException, IOException {
			QuoteDAO q_dao = new QuoteDAO();
			List<Quote> q_list = new ArrayList<Quote>();
			q_list= q_dao.getAllQuote();
			assertThat(q_dao, is(notNullValue()));

		}

		@Test()
		public void assignQuote() throws ClassNotFoundException, IOException, SQLException {
			QuoteDAO q_dao = new QuoteDAO();
			Quote q = new Quote();
			assertThat(q_dao, is(notNullValue()));
			int testResult = q_dao.registerQuote(q);
			assertThat(testResult, is(-1));

	}
	}



