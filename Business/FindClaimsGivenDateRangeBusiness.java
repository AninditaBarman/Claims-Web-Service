package WebService.Claims.Business;

import java.util.Date;
import java.util.List;

import WebService.Claims.Beans.Claim;
import WebService.Claims.DAL.CrudOperations;

public class FindClaimsGivenDateRangeBusiness {

	public static List<Claim> findClaimsGivenDateRange(Date d1, Date d2) throws Exception
	{	
		try
		{
			return CrudOperations.getListOfClaimsFromDatabase( d1, d2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
