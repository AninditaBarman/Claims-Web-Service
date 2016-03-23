package WebService.Claims.Business;

import WebService.Claims.Beans.Claim;
import WebService.Claims.DAL.CrudOperations;

public class ReadClaimBusiness {
	

	//Business logic - any data validation etc
	//after everything is fine, call data access layer methods to retrieve info
	//return result to controller.
	
	public Claim readClaim(String claimNumber) throws Exception
	{	
		try
		{
			CrudOperations crud= new CrudOperations();
			return crud.readClaimFromDatabase(claimNumber);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
