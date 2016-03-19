package WebService.Claims.Beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mitchellclaim {

	private String claimnumber;
	private String claimantfirstname;
	private String claimantlastname;
	private String status;
	private String lossdate;
	private long assignedadjusterid;
	private Mitchelllossinfo lossinfo;
	private List<Mitchellvehicledetails> vehicles;
	
	public Mitchellclaim()
	{
		
	}
	
	public String getClaimnumber() {
		return claimnumber;
	}

	public void setClaimnumber(String claimnumber) {
		this.claimnumber = claimnumber;
	}

	public String getClaimantfirstname() {
		return claimantfirstname;
	}

	public void setClaimantfirstname(String claimantfirstname) {
		this.claimantfirstname = claimantfirstname;
	}

	public String getClaimantlastname() {
		return claimantlastname;
	}

	public void setClaimantlastname(String claimantlastname) {
		this.claimantlastname = claimantlastname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getAssignedadjusterid() {
		return assignedadjusterid;
	}

	public void setAssignedadjusterid(long assignedadjusterid) {
		this.assignedadjusterid = assignedadjusterid;
	}
	
	public String getLossdate() {
		return lossdate;
	}

	public void setLossdate(String lossdate) {
		this.lossdate = lossdate;
	}

	public Mitchelllossinfo getLossinfo() {
		return lossinfo;
	}

	public void setLossinfo(Mitchelllossinfo lossinfo) {
		this.lossinfo = lossinfo;
	}

	public List<Mitchellvehicledetails> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Mitchellvehicledetails> vehicles) {
		this.vehicles = vehicles;
	}

	
	
}
