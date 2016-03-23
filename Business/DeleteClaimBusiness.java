package WebService.Claims.Business;

import WebService.Claims.DAL.CrudOperations;

public class DeleteClaimBusiness {

	public String deleteClaim(String claimNumber) throws Exception
	{	
		try
		{
			CrudOperations crud= new CrudOperations();
			return crud.deleteClaimFromDatabase(claimNumber);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "failed";
	}
}
