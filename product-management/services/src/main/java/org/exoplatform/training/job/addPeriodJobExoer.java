package org.exoplatform.training.job;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;





    public class addPeriodJobExoer implements Job {

        private static final Log log = ExoLogger.getLogger(org.exoplatform.training.job.addPeriodJobExoer.class);

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            log.info("Eggzooer is running!!!");
            // ProductPluginInterface trainingService = (ProductPluginInterface) PortalContainer.getInstance().getComponentInstanceOfType(ProductPluginInterface.class);
            // trainingService.printRandonQuote();

        }
    }


