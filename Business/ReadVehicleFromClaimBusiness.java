package WebService.Claims.Business;

import WebService.Claims.Beans.VehicleDetails;
import WebService.Claims.DAL.CrudOperations;

public class ReadVehicleFromClaimBusiness {
	public VehicleDetails readVehicleFromClaim(String claimNumber, String vin) throws Exception
	{	
		try
		{
			CrudOperations crud= new CrudOperations();
			return crud.readVehicleFromClaim(claimNumber, vin);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
