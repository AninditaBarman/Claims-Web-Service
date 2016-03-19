package WebService.Claims.Controller;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import WebService.Claims.Beans.Claim;
import WebService.Claims.Beans.Inputlossdates;
import WebService.Claims.Business.FindClaimsGivenDateRangeBusiness;

/*
 * Root resource (exposed at "findClaimsGivenDateRange" path)
 */

@Path("/findclaimsgivendaterange")
public class FindClaimsGivenDateRange 
{	 
    /*
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "xml" media type.
     */	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public List<Claim> findClaimsGivenDateRangeFromDatabase(Inputlossdates findclaimsrequest) throws Exception
    {
    	try
    	{    		
    		Date d1 = findclaimsrequest.getFromdate();
			Date d2 = findclaimsrequest.getTodate();
			
        	return FindClaimsGivenDateRangeBusiness.findClaimsGivenDateRange(d1, d2);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return null;    	
    }
	
}