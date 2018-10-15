package jacob.casestudy.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jacob.casestudy.DAO.LocationDAO;
import jacob.casestudy.DAO.QuoteDAO;
import jacob.casestudy.models.Location;
import jacob.casestudy.models.Quote;


public class LocationBO {

	public List<Location> getLocation() throws SQLException, IOException {
		List<Location> allLocation = new ArrayList<Location>();
		LocationDAO l_dao = new LocationDAO();
		allLocation = l_dao.getAllLocation();
		return allLocation;
	}

	public int registerLocation(String residence_type, String address_line_1, String address_line_2, String city,
			String location_state, String zipcode, String residence_use, int user_user_id)
			throws SQLException, IOException {
		
		Location l = new Location(residence_type, address_line_1, address_line_2, city, location_state, zipcode,
				residence_use, user_user_id);
		
		LocationDAO l_dao = new LocationDAO();
		
		int ID = l_dao.registerLocation(l);
		return ID;
	}
	
	 public int registerLocation(Location L) throws SQLException, IOException {
			LocationDAO L_dao = new LocationDAO();
			int ID = L_dao.registerLocation(L);
			return ID;

}
		public HashMap<Integer, Location> getLocationQuoteByUser(String uUserID)throws SQLException, IOException {
			HashMap<Integer,Location> newLocation;
			LocationDAO l_Dao = new LocationDAO();
			newLocation = l_Dao.getLocationQuoteByUser(uUserID);
			return newLocation;
		}

}