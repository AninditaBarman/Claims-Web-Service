package WebService.Claims.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import WebService.Claims.Business.CreateClaimBusiness;
import WebService.Claims.Beans.Mitchellclaim;

@Path("/createclaim")
public class CreateClaim {

	@POST
	@Consumes(MediaType.APPLICATION_XML)
    public void createClaim(Mitchellclaim mclaim)
	{
		try
		{	
			CreateClaimBusiness.createClaim(mclaim);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*public Claim parseXmlToClaimObject() throws Exception
	{		
        SAXBuilder builder= new SAXBuilder();//creating JDOM SAX parser
        
        Document xml= null;
        
        try
        {
        	xml= builder.build(new File("C:/Users/Sumax/Desktop/Mitchell/Coding Challenge/create-claim.xml"));
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        
        Element root= xml.getRootElement();
        Namespace ns= Namespace.getNamespace("cla", "http://www.mitchell.com/examples/claim");
        
        String claimNumber= root.getChildText("ClaimNumber",ns);
        String claimantFirstName= root.getChildText("ClaimantFirstName",ns);
        String claimantLastName= root.getChildText("ClaimantLastName",ns);
        String status= root.getChildText("Status",ns);
        String lossDate= root.getChildText("LossDate",ns);
        long assignedAdjusterId= Long.parseLong(root.getChildText("AssignedAdjusterID",ns));
        
        Claim claim= new Claim();
        
        claim.setClaimNumber(claimNumber);
        claim.setClaimantFirstName(claimantFirstName);
        claim.setClaimantLastName(claimantLastName);
        claim.setStatus(StatusCode.valueOf(status.toUpperCase()));
        
        Date d = new SimpleDateFormat("yyyy-MM-dd").parse(lossDate);        
        claim.setLossDate(d);
        
        claim.setAssignedAdjusterId(assignedAdjusterId);
        
        Element lossInfoTag= root.getChild("LossInfo", ns);
        String causeOfLoss= lossInfoTag.getChildText("CauseOfLoss", ns);
        String reportedDate= lossInfoTag.getChildText("ReportedDate", ns);
        String lossDescription= lossInfoTag.getChildText("LossDescription", ns);
       
        LossInfo lossInfo= new LossInfo();
        lossInfo.setCauseOfLoss(CauseOfLossCode.valueOf(causeOfLoss.toUpperCase()));
        
        Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(reportedDate);
        lossInfo.setReportedDate(d1);
        
        lossInfo.setLossDescription(lossDescription);
        
        claim.setLossInfo(lossInfo);
        
        Element vehiclesTag= root.getChild("Vehicles", ns);
        List vehicleChildTags= vehiclesTag.getChildren();
        Iterator itr= vehicleChildTags.iterator();
        
        List<VehicleDetails> vehicles= new ArrayList<VehicleDetails>();
        VehicleDetails vehicle= null;
        
        while(itr.hasNext())
        {
        	Element vehicleTag= (Element) itr.next();
        	
        	String vin= vehicleTag.getChildText("Vin", ns);
        	int modelYear= Integer.parseInt(vehicleTag.getChildText("ModelYear", ns));
        	String makeDescription= vehicleTag.getChildText("MakeDescription", ns);
        	String modelDescription= vehicleTag.getChildText("ModelDescription", ns);
        	String engineDescription= vehicleTag.getChildText("EngineDescription", ns);
        	String exteriorColor= vehicleTag.getChildText("ExteriorColor", ns);
        	String licPlate= vehicleTag.getChildText("LicPlate", ns);
        	String licPlateState= vehicleTag.getChildText("LicPlateState", ns);
        	String licPlateExpDate= vehicleTag.getChildText("LicPlateExpDate", ns);
        	String damageDescription= vehicleTag.getChildText("DamageDescription", ns);
        	int mileage= Integer.parseInt(vehicleTag.getChildText("Mileage", ns));
        	
        	vehicle= new VehicleDetails();
        	vehicle.setVin(vin);
        	vehicle.setModelYear(modelYear);
        	vehicle.setMakeDescription(makeDescription);
        	vehicle.setModelDescription(modelDescription);
        	vehicle.setEngineDescription(engineDescription);
        	vehicle.setExteriorColor(exteriorColor);
        	vehicle.setLicPlate(licPlate);
        	vehicle.setLicPlateState(licPlateState);
        	
        	Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(licPlateExpDate);
            lossInfo.setReportedDate(d2);
        	vehicle.setLicPlateExpDate(d2);
        	
        	vehicle.setDamageDescription(damageDescription);
        	vehicle.setMileage(mileage);
        	        	
        	vehicles.add(vehicle);
        }
        claim.setVehicles(vehicles);
               
		return claim;
	}*/	
}
