package jacob.casestudy.models;

import java.sql.Date;

public class Policy {
private int Policy_Id;
private Date Start_date;
private Date End_Date;
private int Term;
private String Status;
private int Quotes_Quote_ID;
public Policy(int policy_Id, Date start_date, Date end_Date, int term, String status, int quotes_Quote_ID) {
	super();
	Policy_Id = policy_Id;
	Start_date = start_date;
	End_Date = end_Date;
	Term = term;
	Status = status;
	Quotes_Quote_ID = quotes_Quote_ID;
}


public Policy() {
	super();
}


public Policy(Date start_date2, Date end_Date2, int term, String status, int quotes_Quote_ID) {
	super();
	Start_date = start_date2;
	End_Date = end_Date2;
	Term = term;
	Status = status;
	Quotes_Quote_ID = quotes_Quote_ID;
}

public int getPolicy_Id() {
	return Policy_Id;
}
public void setPolicy_Id(int policy_Id) {
	Policy_Id = policy_Id;
}
public Date getStart_date() {
	return Start_date;
}
public void setStart_date(Date start_date) {
	Start_date = start_date;
}
public Date getEnd_Date() {
	return End_Date;
}
public void setEnd_Date(Date end_Date) {
	End_Date = end_Date;
}
public int getTerm() {
	return Term;
}
public void setTerm(int term) {
	Term = term;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public int getQuotes_Quote_ID() {
	return Quotes_Quote_ID;
}
public void setQuotes_Quote_ID(int quotes_Quote_ID) {
	Quotes_Quote_ID = quotes_Quote_ID;
}


}
