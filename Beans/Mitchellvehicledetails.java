package WebService.Claims.Beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mitchellvehicledetails {

	private String vin;
	private int modelyear;
	private String makedescription;
	private String modeldescription;
	private String enginedescription;
	private String exteriorcolor;	
	private String licplate;
	private String licplatestate;
	private String licplateexpdate;
	private String damagedescription;
	private int mileage;
   
	public Mitchellvehicledetails()
	{
		
	}

	public int getModelyear() {
		return modelyear;
	}

	public void setModelyear(int modelyear) {
		this.modelyear = modelyear;
	}

	public String getMakedescription() {
		return makedescription;
	}

	public void setMakedescription(String makedescription) {
		this.makedescription = makedescription;
	}

	public String getModeldescription() {
		return modeldescription;
	}

	public void setModeldescription(String modeldescription) {
		this.modeldescription = modeldescription;
	}

	public String getEnginedescription() {
		return enginedescription;
	}

	public void setEnginedescription(String enginedescription) {
		this.enginedescription = enginedescription;
	}

	public String getExteriorcolor() {
		return exteriorcolor;
	}

	public void setExteriorcolor(String exteriorcolor) {
		this.exteriorcolor = exteriorcolor;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getLicplate() {
		return licplate;
	}

	public void setLicplate(String licplate) {
		this.licplate = licplate;
	}

	public String getLicplatestate() {
		return licplatestate;
	}

	public void setLicplatestate(String licplatestate) {
		this.licplatestate = licplatestate;
	}

	public String getLicplateexpdate() {
		return licplateexpdate;
	}

	public void setLicplateexpdate(String licplateexpdate) {
		this.licplateexpdate = licplateexpdate;
	}

	public String getDamagedescription() {
		return damagedescription;
	}

	public void setDamagedescription(String damagedescription) {
		this.damagedescription = damagedescription;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	
}
