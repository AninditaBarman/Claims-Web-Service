package WebService.Claims.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import WebService.Claims.Beans.Inputclaimnumberandvin;
import WebService.Claims.Beans.VehicleDetails;
import WebService.Claims.Business.ReadVehicleFromClaimBusiness;

@Path("/readvehiclefromclaim")
public class ReadVehicleFromClaim {

	@POST
	@Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
	public VehicleDetails readVehicleFromClaim(Inputclaimnumberandvin readvehiclerequest) throws Exception
    {
    	try
    	{   
			String claimNumber= readvehiclerequest.getClaimnumber();
			String vin= readvehiclerequest.getVin();
			
			ReadVehicleFromClaimBusiness readVehicle= new ReadVehicleFromClaimBusiness();
        	return readVehicle.readVehicleFromClaim(claimNumber, vin);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return null;    	
    }
	
	
}
