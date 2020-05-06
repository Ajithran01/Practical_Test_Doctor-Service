package com;
import model.Doctor;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("rest")
public class DoctorService {

//read	
	Doctor d1 = new Doctor();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String read()
	 {
	    return d1.readDoctor();
	 } 
//insert	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoctor(@FormParam("dID") String ID,
	 @FormParam("dName") String Name,
	 @FormParam("specialization") String specialization,
	 @FormParam("hName") String Hospital)
	{
	 String output = d1.insertDoctor(ID, Name, specialization,Hospital);
	return output;
	}
	
//Delete	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctor(String ID)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(ID, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String dID = doc.select("dID").text();
	 String output = d1.deleteDoctor(dID);
	return output;
	}
	
	//Update
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctor(String Data)
	{
	//Convert the input string to a JSON object
	 JsonObject doctor = new JsonParser().parse(Data).getAsJsonObject();
	//Read the values from the JSON object
	 String ID = doctor.get("dID").getAsString();
	 String name = doctor.get("dName").getAsString();
	 String specialization = doctor.get("specialization").getAsString();
	 String hospital = doctor.get("hName").getAsString();
	 //String itemDesc = itemObject.get("itemDesc").getAsString();
	 String output = d1.updateDoctor(ID, name, specialization, hospital);
	return output;
	}
}
