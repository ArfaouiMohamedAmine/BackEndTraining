package org.exoplatform.training.Services;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.training.Entity.Products;
import org.json.JSONArray;
import org.json.JSONObject;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.log.ExoLogger;
@Path("/v1/products")
@RolesAllowed("users")
public class ProdcutServiceRest  implements ResourceContainer {
  
  ProdcutService productService  ; 
  private static Log log =  ExoLogger.getLogger(ProdcutServiceRest.class);
  public ProdcutServiceRest(ProdcutService prodService )
  {
    this.productService = prodService;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @RolesAllowed("users")
  public Response getProducts() {
    
    JSONArray jsonArray = new JSONArray();
    try {

      List<Products> products = productService.getAllProducts();
      System.out.println(products.toString());
      for (Products a : products){
          System.out.println(a.toString());
          jsonArray.put(MapperProduct.productToDto(a).toJSONObject());
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
  public Response addProduct(Products product ) {
    
    JSONObject jsonObject = new JSONObject();

    try {

      Products a = productService.addProduct(product);

        jsonObject.put("name", a.getName());
        jsonObject.put("img", a.getImg());
        jsonObject.put("description", a.getDescription());
        jsonObject.put("price", a.getPrice());

    } catch (Exception e) {
        log.error(e.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(e.getMessage()).build();
    }
    return Response.ok(jsonObject.toString(), MediaType.APPLICATION_JSON).build();
    
   
  }

  @POST
  @Path("/deleteProduct/{id}")
  public Response deleteProduct(@PathParam("id") String id){
      try {
        productService.deleteProduct(Long.parseLong(id));
      } catch (Exception e) {
          log.error(e.getMessage());
          return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                  .entity("An internal error has occurred when trying to delete the products").build();
      }
      return Response.ok(MediaType.APPLICATION_JSON).build();
  }
}
