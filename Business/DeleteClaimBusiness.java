package WebService.Claims.Business;

import WebService.Claims.DAL.CrudOperations;

public class DeleteClaimBusiness {

	public static String deleteClaim(String claimNumber) throws Exception
	{	
		try
		{
			return CrudOperations.deleteClaimFromDatabase(claimNumber);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
