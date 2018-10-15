package jacob.casestudy.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jacob.casestudy.DAO.PropertyDAO;
import jacob.casestudy.DAO.QuoteDAO;
import jacob.casestudy.models.Property;
import jacob.casestudy.models.Quote;


public class PropertyBO {
	public List<Property> getProperty() throws SQLException, IOException {
		List<Property> allProperty = new ArrayList<Property>();
		PropertyDAO p_dao = new PropertyDAO();
		allProperty = p_dao.getProperties();
		return allProperty;
	}

	public int registerProperty(double property_value, int year_Build, int sq_ft, String dwelling_style,
			String roof_material, String garage_type, int num_baths, int half_baths, boolean swimming_pool,
			int locations_location_Id) throws SQLException, IOException {
		Property p = new Property(property_value, year_Build, sq_ft, dwelling_style, roof_material, garage_type,
				num_baths, half_baths, swimming_pool, locations_location_Id);
		PropertyDAO p_dao = new PropertyDAO();
		int ID = p_dao.registerProperty(p);
		return ID;

	}
	 public int registerProperty(Property P) throws SQLException, IOException {
			PropertyDAO P_dao = new PropertyDAO();
			int ID = P_dao.registerProperty(P);
			return ID;
	 }
		public HashMap<Integer, Property> getPropbyLocation(String uUserID)throws SQLException, IOException {
			HashMap<Integer, Property> newProperty;
			PropertyDAO p_dao = new PropertyDAO();
			newProperty = p_dao.getPropbyLocation(uUserID);
			return newProperty;
		}
	 
}
