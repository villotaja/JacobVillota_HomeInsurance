package jacob.casestudy.BO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jacob.casestudy.DAO.LocationDAO;
import jacob.casestudy.DAO.PolicyDAO;
import jacob.casestudy.models.Location;
import jacob.casestudy.models.Policy;

import java.sql.Date;


public class PoliciesBO {
	public List<Policy> getPolicies() throws SQLException, IOException {
		List<Policy> allPolicies = new ArrayList<Policy>();
		PolicyDAO p_dao = new PolicyDAO();
		allPolicies = p_dao.getAllPolicy();
		return allPolicies;
	}

	public int registerPolicy(Date start_date, Date end_Date, int term, String status, int Quotes_quote_ID)
			throws SQLException, IOException {
		Policy p = new Policy(start_date, end_Date, term, status, Quotes_quote_ID);
		PolicyDAO p_dao = new PolicyDAO();
		int ID = p_dao.registerPolicy(p);
		return ID;
	}
	public HashMap<Integer, Policy> GetPoliciesbyUser(int i)throws SQLException, IOException {
		HashMap<Integer, Policy> newPolicy;
		PolicyDAO P_Dao = new PolicyDAO();
		newPolicy = P_Dao.GetPoliciesbyUser(i);
		return newPolicy;
	}

}
