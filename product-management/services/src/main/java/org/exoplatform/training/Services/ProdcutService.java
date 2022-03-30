package org.exoplatform.training.Services;


import java.util.List;

import org.exoplatform.services.listener.ListenerService;
import org.exoplatform.training.Entity.Products;
import org.exoplatform.training.dao.ProductDAO;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.log.ExoLogger;
public class ProdcutService  implements ProductInterface{
  private ProductDAO productdao ;
  private static Log log =  ExoLogger.getLogger(ProdcutServiceRest.class);
  private ListenerService listenerService ;
  public ProdcutService(ProductDAO productdao , ListenerService listenerService ){
    this.productdao=productdao;
    this.listenerService = listenerService ;
  }

  @Override
  public List<Products> getAllProducts() throws Exception {
    return this.productdao.findAll();
  }

  @Override
  public Products addProduct(Products a) {

      Products product = new Products(a.getName(),a.getDescription(),a.getImg(),a.getPrice());
      Products res= null;
        try {
            res = productdao.create(product);
          listenerService.broadcast("product-added-success" , this , res);
          }catch (Exception e) {
          log.error("Cannot create the product", e);
        }
        return res;
  }

  @Override
  public void deleteProduct(long id) {
    Products prod = this.productdao.find(id);
        try {
            this.productdao.delete(prod);
        }catch (Exception e) {
            log.error("Cannot delete the Product", e);
        }
  }
  
   
}
