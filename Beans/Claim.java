package WebService.Claims.Beans;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Claim {

	private String claimNumber;
	private String claimantFirstName;
	private String claimantLastName;
	private StatusCode status;
	private Date lossDate;
	private long assignedAdjusterId;
	private LossInfo lossInfo;
	private List<VehicleDetails> vehicles;
	
	public Claim()
	{
		
	}
	
	public void setClaimNumber(String claimNumber)
	{
		this.claimNumber= claimNumber;
	}

	public String getClaimNumber()
	{
		return this.claimNumber;
	}

	public void setClaimantFirstName(String claimantFirstName)
	{
		this.claimantFirstName= claimantFirstName;
	}

	public String getClaimantFirstName()
	{
		return this.claimantFirstName;
	}

	public void setClaimantLastName(String claimantLastName)
	{
		this.claimantLastName= claimantLastName;
	}

	public String getClaimantLastName()
	{
		return this.claimantLastName;
	}

	public void setStatus(StatusCode status)
	{
		this.status= status;
	}

	public StatusCode getStatus()
	{
		return this.status;
	}

	public void setLossDate(Date date)
	{
		this.lossDate= date;
	}

	public Date getLossDate()
	{
		return this.lossDate;
	}

	public void setAssignedAdjusterId(long assignedAdjusterId)
	{
		this.assignedAdjusterId= assignedAdjusterId;
	}

	public long getAssignedAdjusterId()
	{
		return this.assignedAdjusterId;
	}
	
	public void setLossInfo(LossInfo lossInfo)
	{
		this.lossInfo= lossInfo;
	}

	public LossInfo getLossInfo()
	{
		return this.lossInfo;
	}
	
	public void setVehicles(List<VehicleDetails> vehicles)
	{
		this.vehicles= vehicles;
	}

	public List<VehicleDetails> getVehicles()
	{
		return this.vehicles;
	}
}
