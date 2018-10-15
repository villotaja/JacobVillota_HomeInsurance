package jacob.casestudy.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jacob.casestudy.DAO.QuoteDAO;
import jacob.casestudy.DAO.UserDAO;
import jacob.casestudy.models.Property;
import jacob.casestudy.models.Quote;
import jacob.casestudy.models.User;


public class QuoteBO {
 public List<Quote> GetQuotes() throws SQLException, IOException {
	 List<Quote> allQuotes = new ArrayList<Quote>();
	 QuoteDAO q_dao = new QuoteDAO();
	 allQuotes = q_dao.getAllQuote();
	 return allQuotes;
 }
 public int registerQuote(double monthly_premium, double dwelling_coverage, double detatched_structures,
		 double personal_property, double additional_living_exp, double med_exp, double deductible,
		 int locations_location_id, int user_users_ID) throws SQLException, IOException {
	 Quote q = new Quote(monthly_premium,  dwelling_coverage,  detatched_structures,
		  personal_property,  additional_living_exp,  med_exp,  deductible,
		  locations_location_id,  user_users_ID);
	 QuoteDAO q_dao = new QuoteDAO();
	 int ID = q_dao.registerQuote(q);
	 return ID;
	 
 }
 
 public int registerQuote(Quote q) throws SQLException, IOException {
	QuoteDAO q_dao = new QuoteDAO();
	int ID = q_dao.registerQuote(q);
	return ID;
}
 public double DC(Property p)  {	
		int CC;
		double HomeValue = 0;
		double DwellingC;
		CC = (120 * p.getSQ_Feet());
		System.out.println(CC);
		if(p.getYear_Build() < 5 ) {
			HomeValue =  (CC *  0.1);
			System.out.println(HomeValue+" age 5");
		}
		else if(p.getYear_Build() < 10){
			HomeValue =  (CC * .2);
			System.out.println(HomeValue+" age 10");
		}
		else if(p.getYear_Build() < 20) {
			HomeValue = CC*.3;
			System.out.println(HomeValue+" age 20");
		}
		else {
			HomeValue = CC*.5;
			System.out.println(HomeValue+" age 20+");
		}
		
		DwellingC = (.5 * p.getProperty_Value()) +	HomeValue;
		System.out.println(DwellingC);
		return DwellingC;
	}
	public HashMap<Integer, Quote> getQuoteByUser(String uUserID)throws SQLException, IOException {
		HashMap<Integer, Quote> newQuote;
		QuoteDAO q_dao = new QuoteDAO();
		newQuote = q_dao.getQuoteByUser(uUserID);
		return newQuote;
	}
 
}
