package jacob.casestudy.models;

public class Property {
private int Property_Id;
private double Property_Value;
private int Year_Build;
private int SQ_Feet;
private String Dwelling_Style;
private String Roof_Material;
private String Garage_Type;
private int Num_Baths;
private int Half_Baths;
private boolean Swimming_Pool;
private int Locations_Locations_ID;
public Property(int property_Id, double property_Value, int year_Build, int sQ_Feet, String dwelling_Style,
		String roof_Material, String garage_Type, int num_Baths, int half_Baths, boolean swimming_Pool,
		int locations_Locations_ID) {
	super();
	Property_Id = property_Id;
	Property_Value = property_Value;
	Year_Build = year_Build;
	SQ_Feet = sQ_Feet;
	Dwelling_Style = dwelling_Style;
	Roof_Material = roof_Material;
	Garage_Type = garage_Type;
	Num_Baths = num_Baths;
	Half_Baths = half_Baths;
	Swimming_Pool = swimming_Pool;
	Locations_Locations_ID = locations_Locations_ID;
}
public Property() {
	super();
}



public Property(double property_Value, int year_Build, int sQ_Feet, String dwelling_Style, String roof_Material,
		String garage_Type, int num_Baths, int half_Baths, boolean swimming_Pool, int locations_Locations_ID) {
	super();
	Property_Value = property_Value;
	Year_Build = year_Build;
	SQ_Feet = sQ_Feet;
	Dwelling_Style = dwelling_Style;
	Roof_Material = roof_Material;
	Garage_Type = garage_Type;
	Num_Baths = num_Baths;
	Half_Baths = half_Baths;
	Swimming_Pool = swimming_Pool;
	Locations_Locations_ID = locations_Locations_ID;
}
public int getProperty_Id() {
	return Property_Id;
}
public void setProperty_Id(int property_Id) {
	Property_Id = property_Id;
}
public double getProperty_Value() {
	return Property_Value;
}
public void setProperty_Value(double property_Value) {
	Property_Value = property_Value;
}
public int getYear_Build() {
	return Year_Build;
}
public void setYear_Build(int year_Build) {
	Year_Build = year_Build;
}
public int getSQ_Feet() {
	return SQ_Feet;
}
public void setSQ_Feet(int sQ_Feet) {
	SQ_Feet = sQ_Feet;
}
public String getDwelling_Style() {
	return Dwelling_Style;
}
public void setDwelling_Style(String dwelling_Style) {
	Dwelling_Style = dwelling_Style;
}
public String getRoof_Material() {
	return Roof_Material;
}
public void setRoof_Material(String roof_Material) {
	Roof_Material = roof_Material;
}
public String getGarage_Type() {
	return Garage_Type;
}
public void setGarage_Type(String garage_Type) {
	Garage_Type = garage_Type;
}
public int getNum_Baths() {
	return Num_Baths;
}
public void setNum_Baths(int num_Baths) {
	Num_Baths = num_Baths;
}
public int getHalf_Baths() {
	return Half_Baths;
}
public void setHalf_Baths(int half_Baths) {
	Half_Baths = half_Baths;
}
public boolean isSwimming_Pool() {
	return Swimming_Pool;
}
public void setSwimming_Pool(boolean swimming_Pool) {
	Swimming_Pool = swimming_Pool;
}
public int getLocations_Locations_ID() {
	return Locations_Locations_ID;
}
public void setLocations_Locations_ID(int locations_Locations_ID) {
	Locations_Locations_ID = locations_Locations_ID;
}


}
