
package jacob.casestudy.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
//import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Current;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.openqa.selenium.interactions.touch.LongPressAction;

import com.sun.corba.se.impl.oa.poa.Policies;
import com.sun.glass.ui.View;

import jacob.casestudy.BO.HomeownerBO;
import jacob.casestudy.BO.LocationBO;
import jacob.casestudy.BO.PoliciesBO;
import jacob.casestudy.BO.PropertyBO;
import jacob.casestudy.BO.QuoteBO;
import jacob.casestudy.BO.UserBO;
import jacob.casestudy.DAO.UserDAO;
import jacob.casestudy.models.Homeowner;
import jacob.casestudy.models.Location;
import jacob.casestudy.models.Policy;
import jacob.casestudy.models.Property;
import jacob.casestudy.models.Quote;
import jacob.casestudy.models.User;

@WebServlet(urlPatterns = { "/", "/Index" })
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeownerBO H_BO = new HomeownerBO();
	private LocationBO L_BO = new LocationBO();
	private PoliciesBO PO_BO = new PoliciesBO();
	private PropertyBO P_BO = new PropertyBO();
	private QuoteBO Q_BO = new QuoteBO();

	public Index() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		HttpSession session = request.getSession(false);
		System.out.println(action);
		if (!(action.equals("/LoginPage") || action.equals("/View/LoginPage") || action.equals("/View/RegUser"))
				&& (!request.isRequestedSessionIdValid() || session.getAttribute("currentUser") == null)) {
			action = "not loged in";
		}
		System.out.println(action);
		try {
			switch (action) {
			case "/View/LoginPage":
			case "/LoginPage":
				LoginPage(request, response);
				break;
			case "/View/RegUser":
				RegisterUser(request, response);
				break;
			case "/View/NewQuote":
				GetQuoteInfo(request, response);
				break;
			case "/View/HomeInfo":
				GetHomeInfo(request, response);
				break;
			case "/View/Propdets":
				GetPropDets(request, response);
				break;
			case "/View/coveragedetails":
				GetQuote(request, response);
				break;
			case "/View/buyQuote":
				BuyQuote(request, response);
				break;
			case "/View/QuoteDetails":
				GetAllQuotes(request, response);
				break;
			case "/View/QuoteSummary":
				GetQuoteByQuoteID(request, response);
				break;
			case "/View/AllPolicies":
				GetAllPolicies(request, response);
				break;
			case "/Logout":
				Logout(request, response);
			default:
				response.sendRedirect("/HomeOwnerInsuranceApp/View/LoginPage.jsp");
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void LoginPage(HttpServletRequest request, HttpServletResponse response) // this is the login page
			throws IOException, ServletException {
		HttpSession session = request.getSession(true);
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");

		UserDAO dao = new UserDAO();
		User user = null;
		try {
			user = dao.getUserByUsername(uname);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		String tempPass = user.getUser_Password();

		if (user != null && tempPass != null && tempPass.equals(pwd)) {
			session.removeAttribute("InvalidPassword");
			session.setAttribute("currentUser", user);
			response.sendRedirect("./Home.jsp");
		} else {
			session.setAttribute("InvalidPassword", "Invalid login Please Try again");
			RequestDispatcher rd = request.getRequestDispatcher("/View/LoginPage.jsp");
			rd.forward(request, response);
		}
	}

	private void RegisterUser(HttpServletRequest request, HttpServletResponse response) // allows you to register a user
			throws IOException, ServletException, SQLException {
		HttpSession session = request.getSession(true);
		String name = request.getParameter("newUser");
		String pwd = request.getParameter("newpassword");
		String repwd = request.getParameter("repwd");
		String pattern = "^[a-zA-Z0-9]*$";
		UserBO u_bo = new UserBO();

		if (name != null && pwd != null && repwd != null && pwd.equals(repwd) && pwd.length() >= 8 && pwd.length() <= 20
				&& name.length() <= 20 && pwd.matches(pattern) && name.matches(pattern)) {
			u_bo.registerUser(name, pwd);
			response.sendRedirect("../View/LoginPage.jsp");
		} else {
			session.setAttribute("InvalidRegister", "Oops something went wrong please try again" + "\r\n"
					+ "Please make sure your username and password are less than 20 characters and contain no special keys"
					+ "\r\n" + "and that your passwords match ");
			RequestDispatcher rd = request.getRequestDispatcher("/View/newUser.jsp");
			rd.forward(request, response);
		}
	}

	private void GetQuoteInfo(HttpServletRequest request, HttpServletResponse response) // temp storage for quote info(Location)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession(false);
		Location L = new Location();
		User current;
		current = (User) session.getAttribute("currentUser");
		L.setResidence_type(request.getParameter("rt"));
		L.setAddress_line_1(request.getParameter("add1"));
		L.setAddress_line_2(request.getParameter("add2"));
		L.setLocation_state(request.getParameter("state"));
		L.setCity(request.getParameter("City"));
		L.setZipcode(request.getParameter("Zip"));
		L.setResidence_use(request.getParameter("RU"));
		L.setUsers_user_id(current.getUser_Id());
		String addpat = "^[a-zA-Z0-9,-/.\\s]*$";
		String citypat = "^[a-zA-Z0-9_ ]*$";
		String Zip = "^[0-9]{5}(?:-[0-9]{4})?$";

		if (!L.getResidence_type().equals("") && !L.getAddress_line_1().equals("")
				&& L.getAddress_line_1().matches(addpat) && !L.getLocation_state().equals("")
				&& L.getLocation_state().matches(citypat) && !L.getCity().equals("") && L.getCity().matches(citypat)
				&& !L.getZipcode().equals("") && L.getZipcode().matches(Zip) && !L.getResidence_use().equals("")
				&& L.getAddress_line_1().length() < 50 && L.getCity().length() < 15 && L.getLocation_state().length() < 15
				&& L.getZipcode().length() < 10 && L.getAddress_line_2().length() < 100)  {
			session.setAttribute("Location_Info", L);
			response.sendRedirect("../View/Homeownerinfo.jsp");
		} else if (L.getAddress_line_1() == "" || !L.getAddress_line_1().matches(addpat)
				|| L.getAddress_line_1().length() > 51) {
			session.setAttribute("NullAddress", "Please enter a valid address in line 1");
			current = (User) session.getAttribute("currentUser");
			RequestDispatcher rd = request.getRequestDispatcher("../View/GetQuote.jsp");
			rd.forward(request, response);
			System.out.println("Failed Add1");
		} else if (L.getLocation_state() == "" || !L.getLocation_state().matches(citypat) || L.getLocation_state().length() > 16) {
			session.setAttribute("NullSt", "Please enter a valid State");
			current = (User) session.getAttribute("currentUser");
			RequestDispatcher rd = request.getRequestDispatcher("../View/GetQuote.jsp");
			rd.forward(request, response);
			System.out.print("failed state");
		} else if (L.getCity() == "" || !L.getCity().matches(citypat) || L.getCity().length() > 16) {
			session.setAttribute("NullCt", "Please enter a valid City");
			current = (User) session.getAttribute("currentUser");
			RequestDispatcher rd = request.getRequestDispatcher("../View/GetQuote.jsp");
			rd.forward(request, response);
			System.out.print("failed city");
		} else if (L.getZipcode() == "" || !L.getZipcode().matches(Zip) || L.getZipcode().length() > 16) {
			session.setAttribute("NullZip",
					"Please enter a valid Zip code one that is either 5 digits or 9 digits with a dash");
			current = (User) session.getAttribute("currentUser");
			System.out.print("Failed zip");
			RequestDispatcher rd = request.getRequestDispatcher("../View/GetQuote.jsp");
			rd.forward(request, response);
		}
		else {
			session.setAttribute("NullZip",
					"Please enter a valid Zip code one that is either 5 digits or 9 digits with a dash");
			RequestDispatcher rd = request.getRequestDispatcher("../View/GetQuote.jsp");
					rd.forward(request, response);
					System.out.println("got int to the else");
		}
	}

	private void GetHomeInfo(HttpServletRequest request, HttpServletResponse response) // temp storage for quote(homeowner info)
			throws IOException, ServletException, ParseException {
		HttpSession session = request.getSession(false);
		Homeowner H = new Homeowner();
		User current;
		current = (User) session.getAttribute("currentUser");
		String Alpha = "^[a-zA-Z]*$";
		String Num = "^[0-9]*$";
		String chkemail = "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$";
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		H.setFirstName(request.getParameter("Fname"));
		H.setLastName(request.getParameter("Lname"));
		try {
		H.setBirthday(new java.sql.Date(sdf.parse(request.getParameter("birthday")).getTime()));
		}
		catch(ParseException e){
			
			H.setBirthday(null);
			
			e.printStackTrace();
			
		}
		if(H.getBirthday()==null) {
			System.out.println("cg"+H.getBirthday());
		}
		H.setRetired(Boolean.parseBoolean(request.getParameter("retired")));
		H.setSsn(request.getParameter("SSN"));
		H.setEmail(request.getParameter("Email"));

		
		
			if(H.getFirstName().length() >= 31 || !H.getFirstName().matches(Alpha) || H.getFirstName().equals("")) {
				session.setAttribute("Fname", "Please enter a valid First name");
				RequestDispatcher rd = request.getRequestDispatcher("../View/Homeownerinfo.jsp");
				rd.forward(request, response);	

				System.out.println("Fname Fail");
			}
			else if ( H.getLastName().length() >= 31 || !H.getLastName().matches(Alpha) || H.getLastName().equals("")) {
				session.setAttribute("Lname", "Please enter a valid  Last name");
				RequestDispatcher rd = request.getRequestDispatcher("../View/Homeownerinfo.jsp");
				rd.forward(request, response);
				System.out.println("Lname Fail");
				}		
				
			else if (H.getEmail().length() > 51 || !H.getEmail().matches(chkemail) || H.getEmail().equals("")) {
					session.setAttribute("Email", "Please enter a valid Email");
					RequestDispatcher rd = request.getRequestDispatcher("../View/Homeownerinfo.jsp");
					rd.forward(request, response);

					System.out.println("email Fail");
				}
			else if (!H.getSsn().matches(Num) || H.getSsn().length() > 10 || H.getSsn().equals("")) {
				session.setAttribute("SSN", "Please enter a valid SSN");
				RequestDispatcher rd = request.getRequestDispatcher("../View/Homeownerinfo.jsp");
				rd.forward(request, response);

				System.out.println("SSN Fail");
			}
			else if(H.getBirthday()==null) {
				session.setAttribute("Bday", "Please enter a valid Date in provided format");
				RequestDispatcher rd = request.getRequestDispatcher("../View/Homeownerinfo.jsp");
				rd.forward(request, response);

				System.out.println("Bday Fail");
			}else{
				session.setAttribute("HomeOwner_Info", H);
				response.sendRedirect("../View/Propertydetails.jsp");
				}

	}
			
	
	private void GetPropDets(HttpServletRequest request, HttpServletResponse response) // temp storage for quote (property details)
			throws IOException, ServletException, SQLException {
		HttpSession session = request.getSession(false);
		Property P = new Property();
		User current = new User();
		String mchk = "^[+-]?[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{2})?$";
		current = (User) session.getAttribute("currentUser");
		P.setProperty_Value(Double.parseDouble(request.getParameter("mrktvalue")));
		P.setYear_Build(Integer.parseInt((request.getParameter("yearblt"))));
		P.setSQ_Feet(Integer.parseInt((request.getParameter("sqft"))));
		P.setDwelling_Style(request.getParameter("DS"));
		P.setRoof_Material(request.getParameter("RM"));
		P.setGarage_Type(request.getParameter("Garage"));
		P.setNum_Baths(Integer.parseInt(request.getParameter("Fullbath")));
		P.setHalf_Baths(Integer.parseInt(request.getParameter("HalfBath")));
		P.setSwimming_Pool(Boolean.parseBoolean(request.getParameter("pool")));

		
		if (P.getProperty_Value() > 0 && P.getYear_Build() > 0 && P.getSQ_Feet() > 0 && P.getYear_Build() < 2025) {
			session.setAttribute("Prop_dets", P);
			GetQuote(request, response);
			request.getRequestDispatcher("../View/coveragedetails.jsp").forward(request, response);
		} 
		else {
			session.setAttribute("Blank", "Please make sure all information is filled with a date before 2025");
			RequestDispatcher rd = request.getRequestDispatcher("../View/Propertydetails.jsp");
			rd.forward(request, response);
		}
	}

	private void GetQuote(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException { // creates the quote and adds all the values
		HttpSession session = request.getSession(false);
		User current = null;
		Property prop;
		Quote q = null;
		double DC;
		QuoteBO Q_BO = new QuoteBO();
		current = (User) session.getAttribute("currentUser");
		prop = (Property) session.getAttribute("Prop_dets");
		DC = Q_BO.DC(prop);
		Quote Q = new Quote();
		double p = Math.round(5 * (DC / 1000) / 12);
		Location L;
		Homeowner H;
		Property P;
		
		Q.setMonthly_Premium(p);
		Q.setDwelling_Coverage(DC);
		Q.setDetached_Structures(Math.round(DC * .1));
		Q.setPersonal_Property(Math.round(DC * .60));
		Q.setAdditional_Living_EXP(Math.round(DC * .2));
		Q.setMed_Exp(5000.0);
		Q.setDeductible(Math.round(prop.getProperty_Value() * .01));
		session.setAttribute("DwellingCoverage", DC);
		session.setAttribute("DetatchedStructures", (DC * .1));
		session.setAttribute("Personalprop", (DC * .60));
		session.setAttribute("AddLiving", (DC * .2));
		session.setAttribute("MedExp", 5000.00);
		session.setAttribute("Deductible", (prop.getProperty_Value() * .01));

		L = (Location) session.getAttribute("Location_Info");
		prop = (Property) session.getAttribute("Prop_dets");
		H = (Homeowner) session.getAttribute("HomeOwner_Info");
		L.setLocation_Id(L_BO.registerLocation(L));

		H.setUser_user_id(current.getUser_Id());
		H.setHomeowner_Id(H_BO.registerHomeowner(H));

		prop.setLocations_Locations_ID(L.getLocation_Id());
		prop.setProperty_Id(P_BO.registerProperty(prop));
		
		Q.setHomeowner_quote_ID(H.getHomeowner_Id());

		Q.setUser_Users_ID(current.getUser_Id());
		Q.setLocations_location(L.getLocation_Id());
		Q.setQuote_ID(Q_BO.registerQuote(Q));
		session.setAttribute("quote", Q);
		
		RequestDispatcher rd = request.getRequestDispatcher("../View/QuoteDetails.jsp");
		rd.forward(request, response);
	}

	private void BuyQuote(HttpServletRequest request, HttpServletResponse response) // allows you to buy the quote
			throws ParseException, SQLException, IOException, ServletException {
		HttpSession session = request.getSession(false);
		User current = null;
		Policy Po = new Policy();
		Quote Q = (Quote) session.getAttribute("quote");
		current = (User) session.getAttribute("currentUser");
		int i = 0;

		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		Date startTime = sdf.parse(request.getParameter("start_date"));
		Calendar cal = Calendar.getInstance();
		cal.setTime(startTime);
		cal.add(Calendar.YEAR, 1);
		Date nextYear = cal.getTime();

		Po.setQuotes_Quote_ID(Q.getQuote_ID());
		System.out.println(Q.getQuote_ID());
		Po.setPolicy_Id(2);
		Po.setStart_date(new java.sql.Date(startTime.getTime()));
		Po.setEnd_Date(new java.sql.Date(nextYear.getTime()));
		Po.setTerm(i + 1);
		Po.setStatus("ACTIVE");
		if (!Po.getStart_date().equals(" ")) {
			request.setAttribute("Po", Po);
			PO_BO.registerPolicy(Po.getStart_date(), Po.getEnd_Date(), Po.getTerm(), Po.getStatus(),
					Po.getQuotes_Quote_ID());

			request.getRequestDispatcher("../View/PolicyConfirmation.jsp").forward(request, response);
			;
			System.out.println("hi");
		} else {
			session.setAttribute("Blank", "Please make sure all information is filled");
			RequestDispatcher rd = request.getRequestDispatcher("../View/BuyPolicy.jsp");
			rd.forward(request, response);
		}

	}

	private void GetAllQuotes(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		HttpSession session = request.getSession(false);
		User current;
		current = (User) session.getAttribute("currentUser");
		LocationBO l_Bo = new LocationBO();
		QuoteBO Q_BO = new QuoteBO();
		HashMap<Integer, Location> allLocation = l_Bo.getLocationQuoteByUser("" + current.getUser_Id());
		Collection<Quote> allQuote = Q_BO.getQuoteByUser("" + current.getUser_Id()).values();
		HashMap<Integer, Location> allInfo = new HashMap<>();
		for (Quote quote : allQuote) {
			allInfo.put(quote.getQuote_ID(), allLocation.get(quote.getLocations_location()));
		}
		session.setAttribute("info", allInfo);
		response.sendRedirect("../View/QuoteDetails.jsp");
		
	}
	
	
	
	private void GetQuoteByQuoteID (HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		HttpSession session = request.getSession(false);
		int quoteId = Integer.parseInt(request.getParameter("quoteId"));
		User current;
		LocationBO l_Bo = new LocationBO();
		QuoteBO Q_BO = new QuoteBO();
		current = (User) session.getAttribute("currentUser");
		
		HashMap<Integer, Location> allLocation = l_Bo.getLocationQuoteByUser("" + current.getUser_Id());
		HashMap<Integer,Quote> allQuote = Q_BO.getQuoteByUser("" + current.getUser_Id());
		
		Quote quote = allQuote.get(quoteId);
		HashMap<Integer, Homeowner> allOwner = H_BO.getQuoteByUser("" + quote.getHomeowner_quote_ID() );
		HashMap<Integer, Property> allProp = P_BO.getPropbyLocation("" + current.getUser_Id());
		
		Location l = allLocation.get(quote.getLocations_location());
		Property p = allProp.get(l.getLocation_Id());
		Homeowner h = allOwner.get(quote.getHomeowner_quote_ID());
		session.setAttribute("quote",quote );
		session.setAttribute("location", l);
		session.setAttribute("Prop", p);
		session.setAttribute("HO", h);
		
		response.sendRedirect("../View/quotesum.jsp");
	}
	private void GetAllPolicies(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession(false);
		User current;
		current = (User) session.getAttribute("currentUser");
		Policy p = new Policy();
		HashMap<Integer, Policy> allPolicy = PO_BO.GetPoliciesbyUser(current.getUser_Id()); 
		Policy po = allPolicy.get(allPolicy);
		session.setAttribute("PO", allPolicy.get(po));		
		request.getRequestDispatcher("../View/PolicyDetails.jsp").forward(request, response);
		
		
		
	}

	private void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.invalidate();
		request.getRequestDispatcher("/LoginPage.jsp").forward(request, response);
	}

}
