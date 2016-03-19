package WebService.Claims.Beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Inputclaimnumberandvin {
	private String claimnumber;
	private String vin;	
	
	public Inputclaimnumberandvin(){

	}
	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getClaimnumber() {
		return claimnumber;
	}

	public void setClaimnumber(String claimnumber) {
		this.claimnumber = claimnumber;
	}

}
