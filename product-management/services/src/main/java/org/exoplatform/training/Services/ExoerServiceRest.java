package org.exoplatform.training.Services;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.training.Entity.Exoers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.log.ExoLogger;
@Path("/v1/exoers")
public class ExoerServiceRest implements ResourceContainer {

    public ExoerServiceRest() {
    }

    ExoerService exoerService  ;
  private static Log log =  ExoLogger.getLogger(ExoerServiceRest.class);
  public ExoerServiceRest(ExoerService exoerService)
  {
    this.exoerService = exoerService;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getExoers() {
    
    JSONArray jsonArray = new JSONArray();
    try {

      List<Exoers> exoers = exoerService.getAllExoers();
      System.out.println(exoers.toString());
      for (Exoers a : exoers){
          System.out.println(a.toString());
          jsonArray.put(MapperExoer.exoerToDTO(a).toJSONObject());
      }
    } catch (Exception e) {
        log.error(e.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(e.getMessage()).build();
    }
    return Response.ok(jsonArray.toString(), MediaType.APPLICATION_JSON).build();
  }
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
  public Response addProduct(Exoers exoers ) {
    
    JSONObject jsonObject = new JSONObject();

    try {

        Exoers a = exoerService.addExoer(exoers);

        jsonObject.put("name", a.getName());
        jsonObject.put("function", a.getFunction());
        jsonObject.put("dateOfBirth", a.getDateOfBirth());

    } catch (Exception e) {
        log.error(e.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(e.getMessage()).build();
    }
    return Response.ok(jsonObject.toString(), MediaType.APPLICATION_JSON).build();
    
   
  }

  @POST
  @Path("/deleteExoers/{id}")
  public Response deleteExoer(@PathParam("id") String id){
      try {
        exoerService.deleteExoer(Long.parseLong(id));
      } catch (Exception e) {
          log.error(e.getMessage());
          return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                  .entity("An internal error has occurred when trying to delete the exoers").build();
      }
      return Response.ok(MediaType.APPLICATION_JSON).build();
  }
}
