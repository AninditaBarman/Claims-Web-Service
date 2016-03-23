package WebService.Claims.Business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import WebService.Claims.Beans.CauseOfLossCode;
import WebService.Claims.Beans.Claim;
import WebService.Claims.Beans.LossInfo;
import WebService.Claims.Beans.Mitchellclaim;
import WebService.Claims.Beans.Mitchelllossinfo;
import WebService.Claims.Beans.Mitchellvehicledetails;
import WebService.Claims.Beans.StatusCode;
import WebService.Claims.Beans.VehicleDetails;
import WebService.Claims.DAL.CrudOperations;

public class CreateClaimBusiness {	
	
	public String createClaim(Mitchellclaim mclaim)
	{
		try
		{			
			Claim claim= new Claim();
			claim.setClaimNumber(mclaim.getClaimnumber());
			claim.setClaimantFirstName(mclaim.getClaimantfirstname());
			claim.setClaimantLastName(mclaim.getClaimantlastname());
			claim.setStatus(StatusCode.valueOf(mclaim.getStatus().toUpperCase()));
			
			Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(mclaim.getLossdate().substring(0,10));//parsing String to date
			claim.setLossDate(d1);
			
			claim.setAssignedAdjusterId(mclaim.getAssignedadjusterid());
			
			Mitchelllossinfo mlossinfo= mclaim.getLossinfo();
			
			LossInfo lossInfo= new LossInfo();
			lossInfo.setCauseOfLoss(CauseOfLossCode.valueOf(mlossinfo.getCauseofloss().toUpperCase()));
			lossInfo.setLossDescription(mlossinfo.getLossdescription());
			
			Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse(mlossinfo.getReporteddate().substring(0,10));//parsing String to date
			lossInfo.setReportedDate(d2);
			
			claim.setLossInfo(lossInfo);
			
			List<VehicleDetails> vehicles= new ArrayList<VehicleDetails>();
			List<Mitchellvehicledetails> mvehicles= mclaim.getVehicles();
			VehicleDetails v= null;
			for(Mitchellvehicledetails mv: mvehicles)
			{
				v= new VehicleDetails();
				v.setVin(mv.getVin());
				v.setModelYear(mv.getModelyear());
				v.setMakeDescription(mv.getMakedescription());
				v.setModelDescription(mv.getModeldescription());
				v.setEngineDescription(mv.getEnginedescription());
				v.setExteriorColor(mv.getExteriorcolor());
				v.setLicPlate(mv.getLicplate());
				v.setLicPlateState(mv.getLicplatestate());
				
				Date d3 = new SimpleDateFormat("yyyy-MM-dd").parse(mv.getLicplateexpdate().substring(0,10));//parsing String to date
				v.setLicPlateExpDate(d3);
				
				v.setDamageDescription(mv.getDamagedescription());
				v.setMileage(mv.getMileage());
				
				vehicles.add(v);
			}
			
			claim.setVehicles(vehicles);
			
			CrudOperations crud= new CrudOperations();
			return crud.createClaim(claim);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "failed";
	}
}
