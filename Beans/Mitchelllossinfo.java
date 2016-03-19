package WebService.Claims.Beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Mitchelllossinfo {

	private String causeofloss;
	private String reporteddate;
	private String lossdescription;
	
	public Mitchelllossinfo()
	{
		
	}
	public String getCauseofloss() {
		return causeofloss;
	}
	
	public void setCauseofloss(String causeofloss) {
		this.causeofloss = causeofloss;
	}

	public String getReporteddate() {
		return reporteddate;
	}

	public void setReporteddate(String reporteddate) {
		this.reporteddate = reporteddate;
	}

	public String getLossdescription() {
		return lossdescription;
	}

	public void setLossdescription(String lossdescription) {
		this.lossdescription = lossdescription;
	}
		
}
