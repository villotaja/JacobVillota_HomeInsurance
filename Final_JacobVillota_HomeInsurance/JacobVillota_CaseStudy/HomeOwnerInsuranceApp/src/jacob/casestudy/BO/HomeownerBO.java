package jacob.casestudy.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;
import java.util.List;

import jacob.casestudy.DAO.HomeOwnerDAO;
import jacob.casestudy.DAO.QuoteDAO;
import jacob.casestudy.models.Homeowner;
import jacob.casestudy.models.Quote;


public class HomeownerBO {

	public List<Homeowner> getHomeowners() throws SQLException, IOException {
		List<Homeowner> allHomeowners = new ArrayList <Homeowner>();
		HomeOwnerDAO h_dao = new HomeOwnerDAO();
		allHomeowners = h_dao.getAllHomeOwners();
		return allHomeowners;
	}
	
	public int registerHomowner(String Firstname, String Lastname, Date Birthday, Boolean Retired, String SSN, int User_IDFK, String Email)throws SQLException, IOException {
		Homeowner h = new Homeowner(Firstname, Lastname, Birthday,Retired, SSN, User_IDFK, Email);
		HomeOwnerDAO h_dao = new HomeOwnerDAO();
		int ID = h_dao.registerHomeowner(h);
		return ID;
	}
	 public int registerHomeowner(Homeowner H) throws SQLException, IOException {
			HomeOwnerDAO H_dao = new HomeOwnerDAO();
			int ID = H_dao.registerHomeowner(H);
			return ID;
	 }
	 public HashMap<Integer, Homeowner> getQuoteByUser(String uHomewnerID)throws SQLException, IOException {
			HashMap<Integer, Homeowner> newHomeowner;
			HomeOwnerDAO H_dao = new HomeOwnerDAO();
			newHomeowner = H_dao.getHomownerByQuote(uHomewnerID);
			return newHomeowner;
		}
}
