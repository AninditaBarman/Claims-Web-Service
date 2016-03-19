package WebService.Claims.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import WebService.Claims.Beans.Claim;
import WebService.Claims.Beans.Inputclaimnumber;
import WebService.Claims.Business.ReadClaimBusiness;

/*
 * Root resource (exposed at "readclaim" path)
 */

@Path("/readclaim")
public class ReadClaim 
{	 
    /*
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "xml" media type.
     */	
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Claim readClaimFromDatabase(Inputclaimnumber readclaimRequest) throws Exception
	{
    	try
    	{	
    		String claimNumber= readclaimRequest.getClaimnumber();
        	return ReadClaimBusiness.readClaim(claimNumber);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return null;    	
    }
	
}