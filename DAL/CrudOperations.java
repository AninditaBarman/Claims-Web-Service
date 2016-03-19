package WebService.Claims.DAL;

import java.sql.*;
import java.util.*;
import java.util.Date;

import WebService.Claims.Beans.CauseOfLossCode;
import WebService.Claims.Beans.Claim;
import WebService.Claims.Beans.LossInfo;
import WebService.Claims.Beans.StatusCode;
import WebService.Claims.Beans.VehicleDetails;

public class CrudOperations {

	static final String username="root";
	static final String password= "root";
	static final String dbUrl= "jdbc:mysql://localhost/ClaimsDatabase";
	/* JDBC URL FORMAT: jdbc:mysql://<host>:<port>/<database_name> 
	The default port for MySQL is 3306. Usually, if the default port 
	is being used by the database server, the :<port> value 
	of the JDBC url can be omitted. */
	
	private static Connection connection = null;//db session
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	
	//Create a claim and persist it to a backing store
	public static void createClaim(Claim claim)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, username,password);//connect with the db	
			
			preparedStatement = connection.prepareStatement("insert into claims values (?, ?, ?, ?, ?, ?);");
			preparedStatement.setString(1, claim.getClaimNumber());
			preparedStatement.setString(2, claim.getClaimantFirstName());
			preparedStatement.setString(3, claim.getClaimantLastName());
			preparedStatement.setString(4, claim.getStatus().toString());
			
			java.sql.Date lossDate = new java.sql.Date(claim.getLossDate().getTime());//converting util.Date to sql.Date
			preparedStatement.setDate(5, lossDate);
			
			preparedStatement.setLong(6, claim.getAssignedAdjusterId());
		    preparedStatement.executeUpdate();
		    
		    LossInfo lossInfo= claim.getLossInfo();
		    
		    preparedStatement = connection.prepareStatement("insert into lossinfo values (?, ?, ?, ?);");
			preparedStatement.setString(1, claim.getClaimNumber());
			preparedStatement.setString(2, lossInfo.getCauseOfLoss().toString());
			
			java.sql.Date reportedDate = new java.sql.Date(lossInfo.getReportedDate().getTime());//converting util.Date to sql.Date
			preparedStatement.setDate(3, reportedDate);
			
			preparedStatement.setString(4, lossInfo.getLossDescription());
			preparedStatement.executeUpdate();
			
			List<VehicleDetails> vehicles= claim.getVehicles();
			
			for(VehicleDetails v: vehicles)
			{
				 preparedStatement = connection.prepareStatement("insert into vehicledetails values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
				 preparedStatement.setInt(1, v.getModelYear());
				 preparedStatement.setString(2, v.getMakeDescription());
				 preparedStatement.setString(3, v.getModelDescription());
				 preparedStatement.setString(4, v.getEngineDescription());
				 preparedStatement.setString(5, v.getExteriorColor());
				 preparedStatement.setString(6, v.getLicPlate());
				 preparedStatement.setString(7, v.getLicPlateState());
				 
				 java.sql.Date licPlateExpDate = new java.sql.Date(v.getLicPlateExpDate().getTime());
				 preparedStatement.setDate(8, licPlateExpDate);
				 
				 preparedStatement.setString(9, v.getDamageDescription());
				 preparedStatement.setInt(10, v.getMileage());
				 preparedStatement.setString(11, claim.getClaimNumber());
				 preparedStatement.setString(12, v.getVin());
				 preparedStatement.executeUpdate();
			}
		    
		    System.out.println("Successfully created claim.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close();
		}
	}
	
	//Read a claim from the backing store, given a claim number
	public static Claim readClaimFromDatabase(String claimNumber) throws Exception
	{
		Claim claim= null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, username,password);//connect with the db	
			
			preparedStatement = connection.prepareStatement("select * from claims where ClaimNumber= ? ;");
			preparedStatement.setString(1, claimNumber);
		    resultSet = preparedStatement.executeQuery();		       
		    
		    if (resultSet.next()) 
		    {
		    	String firstName = resultSet.getString(2);
			    String lastName = resultSet.getString(3);
			    String status = resultSet.getString(4);
			    Date lossDate = resultSet.getDate(5);
			    int adjusterId = resultSet.getInt(6);	
			      
			    claim= new Claim();
			    claim.setClaimNumber(claimNumber);
			    claim.setClaimantFirstName(firstName);
			    claim.setClaimantLastName(lastName);
			    claim.setStatus(StatusCode.valueOf(status.toUpperCase()));//enum
			    claim.setLossDate(lossDate);
			    claim.setAssignedAdjusterId(adjusterId);  
		    }  
		    
		    //now set lossinfo and vehicles
		    preparedStatement = connection.prepareStatement("select * from lossinfo where ClaimNumber= ? ;");
			preparedStatement.setString(1, claimNumber);
		    resultSet = preparedStatement.executeQuery();
		    
		    if(resultSet.next())
		    {
		    	String causeOfLoss= resultSet.getString(2);
		    	Date reportedDate= resultSet.getDate(3);
		    	String lossDescription= resultSet.getString(4);
		    	
		    	LossInfo lossInfo= new LossInfo();
		    	lossInfo.setCauseOfLoss(CauseOfLossCode.valueOf(causeOfLoss.toUpperCase()));
		    	lossInfo.setReportedDate(reportedDate);
		    	lossInfo.setLossDescription(lossDescription);
		    	claim.setLossInfo(lossInfo);
		    }
		    
		    preparedStatement = connection.prepareStatement("select * from vehicledetails where ClaimNumber= ? ;");
			preparedStatement.setString(1, claimNumber);
		    resultSet = preparedStatement.executeQuery();
		    
		    List<VehicleDetails> vehicles= new ArrayList<VehicleDetails>();
		    VehicleDetails vehicleInfo= null;
		    while(resultSet.next())
		    {
		    	int modelYear = resultSet.getInt(1);
			    String makeDescription = resultSet.getString(2);
			    String modelDescription = resultSet.getString(3);
			    String engineDescription = resultSet.getString(4);
			    String exteriorColor = resultSet.getString(5);
			    String licPlate = resultSet.getString(6);
			    String licPlateState= resultSet.getString(7);
			    Date licPlateExpDate = resultSet.getDate(8);
			    String damageDescription = resultSet.getString(9);
			    int mileage = resultSet.getInt(10);	
			    String vin= resultSet.getString(12);
			    
			    vehicleInfo= new VehicleDetails();
			    vehicleInfo.setVin(vin);
			    vehicleInfo.setModelYear(modelYear);
			    vehicleInfo.setMakeDescription(makeDescription);
			    vehicleInfo.setModelDescription(modelDescription);
			    vehicleInfo.setEngineDescription(engineDescription);
			    vehicleInfo.setExteriorColor(exteriorColor);
			    vehicleInfo.setLicPlate(licPlate);
			    vehicleInfo.setLicPlateState(licPlateState);
			    vehicleInfo.setLicPlateExpDate(licPlateExpDate);
			    vehicleInfo.setDamageDescription(damageDescription);
			    vehicleInfo.setMileage(mileage);		    
			    vehicles.add(vehicleInfo);
		    }
		    claim.setVehicles(vehicles);
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close();
		}
		return claim;
	}
	
	//Find a list of claims in db by date range of the LossDate
	public static List<Claim> getListOfClaimsFromDatabase(Date d1, Date d2) throws Exception
	{
		List<Claim> claims= null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, username,password);//connect with the db	
			
			preparedStatement = connection.prepareStatement("select * from claims where LossDate between ? and ? ;");
			java.sql.Date fromDate = new java.sql.Date(d1.getTime());//converting util.Date to sql.Date
			java.sql.Date toDate = new java.sql.Date(d2.getTime());
			
			preparedStatement.setDate(1, fromDate);
			preparedStatement.setDate(2, toDate);
		    resultSet = preparedStatement.executeQuery();
		    
		    claims= new ArrayList<Claim>();
		    Claim claim= null; 
		    LossInfo lossInfo= null;
		    List<VehicleDetails> vehicles= null;
		    
		    PreparedStatement preparedStatement2 = null;
			ResultSet resultSet2 = null;
		    
		    while (resultSet.next()) 
		    {
		    	String claimNumber= resultSet.getString(1);
		    	String firstName = resultSet.getString(2);
			    String lastName = resultSet.getString(3);
			    String status = resultSet.getString(4);
			    Date lossDate = resultSet.getDate(5);
			    int adjusterId = resultSet.getInt(6);	
			      
			    claim= new Claim();
			    claim.setClaimNumber(claimNumber);
			    claim.setClaimantFirstName(firstName);
			    claim.setClaimantLastName(lastName);
			    claim.setStatus(StatusCode.valueOf(status.toUpperCase()));//enum
			    claim.setLossDate(lossDate);
			    claim.setAssignedAdjusterId(adjusterId);
			    
				//now set lossinfo and vehicles for each claim
			    preparedStatement2 = connection.prepareStatement("select * from lossinfo where ClaimNumber= ? ;");
				preparedStatement2.setString(1, claimNumber);
			    resultSet2 = preparedStatement2.executeQuery();
			    
			    if(resultSet2.next())
			    {
			    	String causeOfLoss= resultSet2.getString(2);
			    	Date reportedDate= resultSet2.getDate(3);
			    	String lossDescription= resultSet2.getString(4);
			    	
			    	lossInfo= new LossInfo();
			    	lossInfo.setCauseOfLoss(CauseOfLossCode.valueOf(causeOfLoss.toUpperCase()));
			    	lossInfo.setReportedDate(reportedDate);
			    	lossInfo.setLossDescription(lossDescription);
			    	claim.setLossInfo(lossInfo);
			    }
			    
			    preparedStatement2 = connection.prepareStatement("select * from vehicledetails where ClaimNumber= ? ;");
				preparedStatement2.setString(1, claimNumber);
			    resultSet2 = preparedStatement2.executeQuery();
			    
			    vehicles= new ArrayList<VehicleDetails>();
			    VehicleDetails vehicleInfo= null;
			    while(resultSet2.next())
			    {
			    	int modelYear = resultSet2.getInt(1);
				    String makeDescription = resultSet2.getString(2);
				    String modelDescription = resultSet2.getString(3);
				    String engineDescription = resultSet2.getString(4);
				    String exteriorColor = resultSet2.getString(5);
				    String licPlate = resultSet2.getString(6);
				    String licPlateState= resultSet2.getString(7);
				    Date licPlateExpDate = resultSet2.getDate(8);
				    String damageDescription = resultSet2.getString(9);
				    int mileage = resultSet2.getInt(10);	
				    String vin= resultSet2.getString(12);
				    
				    vehicleInfo= new VehicleDetails();
				    vehicleInfo.setVin(vin);
				    vehicleInfo.setModelYear(modelYear);
				    vehicleInfo.setMakeDescription(makeDescription);
				    vehicleInfo.setModelDescription(modelDescription);
				    vehicleInfo.setEngineDescription(engineDescription);
				    vehicleInfo.setExteriorColor(exteriorColor);
				    vehicleInfo.setLicPlate(licPlate);
				    vehicleInfo.setLicPlateState(licPlateState);
				    vehicleInfo.setLicPlateExpDate(licPlateExpDate);
				    vehicleInfo.setDamageDescription(damageDescription);
				    vehicleInfo.setMileage(mileage);		    
				    vehicles.add(vehicleInfo);
			    }
			    claim.setVehicles(vehicles);
			    
			    claims.add(claim);
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close();
		}
		return claims;
	}
	
	//read a specific vehicle from a specific claim
	public static VehicleDetails readVehicleFromClaim(String claimNumber, String vin) throws Exception
	{
		VehicleDetails vehicleInfo= null;
		try
		{	
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, username,password);//connect with the db			
			
			preparedStatement = connection.prepareStatement("select * from vehicledetails where ClaimNumber= ? and VIN= ?;");
			preparedStatement.setString(1, claimNumber);
			preparedStatement.setString(2, vin);
		    resultSet = preparedStatement.executeQuery();
		    
		    if(resultSet.next())
		    {
		    	int modelYear = resultSet.getInt(1);
			    String makeDescription = resultSet.getString(2);
			    String modelDescription = resultSet.getString(3);
			    String engineDescription = resultSet.getString(4);
			    String exteriorColor = resultSet.getString(5);
			    String licPlate = resultSet.getString(6);
			    String licPlateState= resultSet.getString(7);
			    Date licPlateExpDate = resultSet.getDate(8);
			    String damageDescription = resultSet.getString(9);
			    int mileage = resultSet.getInt(10);
			    
			    vehicleInfo= new VehicleDetails();
			    vehicleInfo.setVin(vin);
			    vehicleInfo.setModelYear(modelYear);
			    vehicleInfo.setMakeDescription(makeDescription);
			    vehicleInfo.setModelDescription(modelDescription);
			    vehicleInfo.setEngineDescription(engineDescription);
			    vehicleInfo.setExteriorColor(exteriorColor);
			    vehicleInfo.setLicPlate(licPlate);
			    vehicleInfo.setLicPlateState(licPlateState);
			    vehicleInfo.setLicPlateExpDate(licPlateExpDate);
			    vehicleInfo.setDamageDescription(damageDescription);
			    vehicleInfo.setMileage(mileage);			    
		    }		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close();
		}
		return vehicleInfo;
	}
	
	//delete a claim from the backing store- cascades to vehicledetails and lossinfo
	public static String deleteClaimFromDatabase(String claimNumber) throws Exception
	{		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, username,password);//connect with the db	
			
			preparedStatement = connection.prepareStatement("delete from claims where ClaimNumber= ? ;");
			preparedStatement.setString(1, claimNumber);
		    preparedStatement.executeUpdate();
		    return(new String("Deleted successfully."));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close();
		}
		return null;
	}	
	
	//close the resultSet
	  private static void close() 
	  {
		    try 
		    {
		    	if (resultSet != null) 
		    	{
			        resultSet.close();
		    	}
		    	if (connection != null) 
		    	{
			        connection.close();		    		
		    	}
		    } 
		    catch (Exception e) 
		    {
		    	e.printStackTrace();
		    }
	  }	
}
