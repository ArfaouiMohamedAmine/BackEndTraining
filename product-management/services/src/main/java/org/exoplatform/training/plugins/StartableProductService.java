package org.exoplatform.training.plugins;
import org.picocontainer.Startable;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

public class StartableProductService  implements   Startable{
  private static final Log LOG     = ExoLogger.getLogger(StartableProductService.class);
  ProductPluginInterface productService ;
  String text = "Dev Squad is awesome !";

  public  StartableProductService( ProductPluginInterface prodService  ){

    this.productService = prodService ;
  }
  @Override
  public void start() {
    LOG.info("START : Service Product started successfully !");
    productService.displayText(text);
    LOG.info("Executing plugins");
  }

  @Override
  public void stop() {
    LOG.info("Stop : Service Product Stoped successfully !");
  }
}
