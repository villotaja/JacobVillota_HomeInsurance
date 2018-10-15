package jacob.casestudy.models;

public class Quote {
	private int Quote_ID;
	private double Monthly_Premium;
	private double Dwelling_Coverage;
	private double Detached_Structures;
	private double Personal_Property;
	private double Additional_Living_EXP;
	private double Med_Exp;
	private double deductible;
	private int Locations_location;
	private int User_Users_ID;
	private int homeowner_quote_ID;

	public Quote(int quote_ID, double monthly_Premium, double dwelling_Coverage, double detached_Structures,
			double personal_Property, double additional_Living_EXP, double med_Exp, double deductible,
			int locations_location, int user_Users_ID, int homeowner_quote_ID) {
		super();
		Quote_ID = quote_ID;
		Monthly_Premium = monthly_Premium;
		Dwelling_Coverage = dwelling_Coverage;
		Detached_Structures = detached_Structures;
		Personal_Property = personal_Property;
		Additional_Living_EXP = additional_Living_EXP;
		Med_Exp = med_Exp;
		this.deductible = deductible;
		Locations_location = locations_location;
		User_Users_ID = user_Users_ID;
		homeowner_quote_ID = homeowner_quote_ID;
	}

	public Quote(double monthly_Premium, double dwelling_Coverage, double detached_Structures, double personal_Property,
			double additional_Living_EXP, double med_Exp, double deductible, int locations_location,
			int user_Users_ID) {
		super();
		Monthly_Premium = monthly_Premium;
		Dwelling_Coverage = dwelling_Coverage;
		Detached_Structures = detached_Structures;
		Personal_Property = personal_Property;
		Additional_Living_EXP = additional_Living_EXP;
		Med_Exp = med_Exp;
		this.deductible = deductible;
		Locations_location = locations_location;
		User_Users_ID = user_Users_ID;
	}

	public Quote() {
		super();
	}

	public int getQuote_ID() {
		return Quote_ID;
	}

	public void setQuote_ID(int quote_ID) {
		Quote_ID = quote_ID;
	}

	public double getMonthly_Premium() {
		return Monthly_Premium;
	}

	public void setMonthly_Premium(double monthly_Premium) {
		Monthly_Premium = monthly_Premium;
	}

	public double getDwelling_Coverage() {
		return Dwelling_Coverage;
	}

	public void setDwelling_Coverage(double dwelling_Coverage) {
		Dwelling_Coverage = dwelling_Coverage;
	}

	public double getDetached_Structures() {
		return Detached_Structures;
	}

	public void setDetached_Structures(double detached_Structures) {
		Detached_Structures = detached_Structures;
	}

	public double getPersonal_Property() {
		return Personal_Property;
	}

	public void setPersonal_Property(double personal_Property) {
		Personal_Property = personal_Property;
	}

	public double getAdditional_Living_EXP() {
		return Additional_Living_EXP;
	}

	public void setAdditional_Living_EXP(double additional_Living_EXP) {
		Additional_Living_EXP = additional_Living_EXP;
	}

	public double getMed_Exp() {
		return Med_Exp;
	}

	public void setMed_Exp(double med_Exp) {
		Med_Exp = med_Exp;
	}

	public double getDeductible() {
		return deductible;
	}

	public void setDeductible(double deductible) {
		this.deductible = deductible;
	}

	public int getLocations_location() {
		return Locations_location;
	}

	public void setLocations_location(int locations_location) {
		Locations_location = locations_location;
	}

	public int getUser_Users_ID() {
		return User_Users_ID;
	}

	public void setUser_Users_ID(int user_Users_ID) {
		User_Users_ID = user_Users_ID;
	}

	public int getHomeowner_quote_ID() {
		return homeowner_quote_ID;
	}

	public void setHomeowner_quote_ID(int homeowner_quote_ID) {
		this.homeowner_quote_ID = homeowner_quote_ID;
	}

}
