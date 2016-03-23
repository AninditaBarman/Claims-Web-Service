package WebService.Claims.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import WebService.Claims.Business.CreateClaimBusiness;
import WebService.Claims.Beans.Mitchellclaim;

@Path("/createclaim")
public class CreateClaim {

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
    public String createClaim(Mitchellclaim mclaim)
	{
		try
		{	
			CreateClaimBusiness createClaim= new CreateClaimBusiness();
			return createClaim.createClaim(mclaim);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "failed";
	}
}
