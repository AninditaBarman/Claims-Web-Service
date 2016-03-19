package WebService.Claims.Business;

import WebService.Claims.Beans.VehicleDetails;
import WebService.Claims.DAL.CrudOperations;

public class ReadVehicleFromClaimBusiness {
	public static VehicleDetails readVehicleFromClaim(String claimNumber, String vin) throws Exception
	{	
		try
		{
			return CrudOperations.readVehicleFromClaim(claimNumber, vin);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
