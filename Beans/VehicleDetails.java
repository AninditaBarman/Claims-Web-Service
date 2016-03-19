package WebService.Claims.Beans;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VehicleDetails {

	private int modelYear;
	private String makeDescription;
	private String modelDescription;
	private String engineDescription;
	private String exteriorColor;
	private String vin;
	private String licPlate;
	private String licPlateState;
	private Date licPlateExpDate;
	private String damageDescription;
	private int mileage;
   
	public VehicleDetails()
	{
		
	}
	
	public void setModelYear(int modelYear)
	{
		this.modelYear= modelYear;
	}
	
	public int getModelYear()
	{
		return this.modelYear;
	}
	
	public void setMakeDescription(String makeDescription)
	{
		this.makeDescription= makeDescription;
	}
	
	public String getMakeDescription()
	{
		return this.makeDescription;
	}
	
	public void setModelDescription(String modelDescription)
	{
		this.modelDescription= modelDescription;
	}
	
	public String getModelDescription()
	{
		return this.modelDescription;
	}
	
	public void setEngineDescription(String engineDescription)
	{
		this.engineDescription= engineDescription;
	}
	
	public String getEngineDescription()
	{
		return this.engineDescription;
	}
	
	public void setExteriorColor(String exteriorColor)
	{
		this.exteriorColor= exteriorColor;
	}
	
	public String getExteriorColor()
	{
		return this.exteriorColor;
	}
	
	public void setVin(String vin)
	{
		this.vin= vin;
	}
	
	public String getVin()
	{
		return this.vin;
	}
	
	public void setLicPlate(String licPlate)
	{
		this.licPlate= licPlate;
	}
	
	public String getLicPlate()
	{
		return this.licPlate;
	}
	
	public void setLicPlateState(String licPlateState)
	{
		this.licPlateState= licPlateState;
	}
	
	public String getLicPlateState()
	{
		return this.licPlateState;
	}
	
	public void setLicPlateExpDate(Date licPlateExpDate)
	{
		this.licPlateExpDate= licPlateExpDate;
	}
	
	public Date getLicPlateExpDate()
	{
		return this.licPlateExpDate;
	}
	
	public void setDamageDescription(String damageDescription)
	{
		this.damageDescription= damageDescription;
	}
	
	public String getDamageDescription()
	{
		return this.damageDescription;
	}
	
	public void setMileage(int mileage)
	{
		this.mileage= mileage;
	}
	
	public int getMileage()
	{
		return this.mileage;
	}
}
