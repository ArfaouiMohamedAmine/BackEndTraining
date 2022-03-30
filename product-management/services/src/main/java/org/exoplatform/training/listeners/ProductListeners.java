package org.exoplatform.training.listeners;

import org.exoplatform.services.listener.Event;
import org.exoplatform.services.listener.Listener;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.training.Entity.Products;
import org.exoplatform.training.Services.ProdcutService;

public class ProductListeners  extends Listener<ProdcutService, Products> {
  private static Log log =  ExoLogger.getLogger(ProductListeners.class);

  @Override
  public void onEvent(Event<ProdcutService, Products> event ) throws Exception {
    log.info("product "+  event.getData().getName());
  }
}
