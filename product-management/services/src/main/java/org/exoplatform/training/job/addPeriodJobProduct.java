package org.exoplatform.training.job;

import org.exoplatform.services.log.Log;
import org.exoplatform.services.log.ExoLogger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class addPeriodJobProduct implements Job  {

  private static final Log log = ExoLogger.getLogger(addPeriodJobProduct.class);

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    log.info("Product is running!!!");
   // ProductPluginInterface trainingService = (ProductPluginInterface) PortalContainer.getInstance().getComponentInstanceOfType(ProductPluginInterface.class);
   // trainingService.printRandonQuote();

  }
}
