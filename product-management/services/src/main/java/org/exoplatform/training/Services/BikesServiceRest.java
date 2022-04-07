package org.exoplatform.training.Services;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.training.Entity.Bikes;
import org.json.JSONArray;
import org.json.JSONObject;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.log.ExoLogger;
@Path("/v1/bikes")
public class BikesServiceRest implements ResourceContainer {

    public BikesServiceRest() {
    }

    BikesService bikesService;
    private static Log log =  ExoLogger.getLogger(BikesServiceRest.class);
    public BikesServiceRest(BikesService bikesService)
    {
        this.bikesService = bikesService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBikes() {

        JSONArray jsonArray = new JSONArray();
        try {

            List<Bikes> bikes = bikesService.getAllBikes();
            System.out.println(bikes.toString());
            for (Bikes b : bikes){
                System.out.println(b.toString());
                jsonArray.put(MapperBikes.BikesToDTO(b).toJSONObject());
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
    public Response addBikes(Bikes bikes ) {

        JSONObject jsonObject = new JSONObject();

        try {
            Bikes a = bikesService.addBikes(bikes);
            jsonObject.put("name", a.getCirculationNmber());
            jsonObject.put("color", a.getColor());
            jsonObject.put("engineSize", a.getEngineSize());
            jsonObject.put("img", a.getImg());
            jsonObject.put("bikeDesc", a.getBikeDesc());
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage()).build();
        }
        return Response.ok(jsonObject.toString(), MediaType.APPLICATION_JSON).build();


    }

    @POST
    @Path("/deleteBikes/{id}")
    public Response deleteBikes(@PathParam("id") String id){
        try {
            bikesService.deleteBikes(Long.parseLong(id));
        } catch (Exception e) {
            log.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred when trying to delete the Bikes").build();
        }
        return Response.ok(MediaType.APPLICATION_JSON).build();
    }
}
