package WebService.Claims.Beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Inputclaimnumber {
	private String claimnumber;
	
	public Inputclaimnumber(){

	}

	public String getClaimnumber() {
		return claimnumber;
	}

	public void setClaimnumber(String claimnumber) {
		this.claimnumber = claimnumber;
	}

}
