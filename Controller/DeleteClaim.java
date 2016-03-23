package WebService.Claims.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import WebService.Claims.Beans.Inputclaimnumber;
import WebService.Claims.Business.DeleteClaimBusiness;

@Path("/deleteclaim")
public class DeleteClaim {
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteClaimFromDatabase(Inputclaimnumber deleteclaimRequest) throws Exception
    {
    	try
    	{
    		String claimNumber= deleteclaimRequest.getClaimnumber();
    		DeleteClaimBusiness deleteClaim= new DeleteClaimBusiness();
    		return deleteClaim.deleteClaim(claimNumber);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}   
    	return "failed";
    }
}
