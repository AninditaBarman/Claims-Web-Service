package WebService.Claims.Beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LossInfo {

	private CauseOfLossCode causeOfLoss;
	private Date reportedDate;
	private String lossDescription;
	
	public LossInfo()
	{
		
	}
	
	public void setCauseOfLoss(CauseOfLossCode causeOfLoss)
	{
		this.causeOfLoss= causeOfLoss;
	}
	
	public CauseOfLossCode getCauseOfLoss()
	{
		return this.causeOfLoss;
	}
	
	public void setReportedDate(Date reportedDate)
	{
		this.reportedDate= reportedDate;
	}
	
	public Date getReportedDate()
	{
		return this.reportedDate;
	}
	
	public void setLossDescription(String lossDescription)
	{
		this.lossDescription= lossDescription;
	}
	
	public String getLossDescription()
	{
		return this.lossDescription;
	}
	
}
