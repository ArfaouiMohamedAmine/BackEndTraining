package org.exoplatform.training.job;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.training.dao.ExoersDAO;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.exoplatform.services.log.Log;
/**
 * A job to to clean the data base every minute
 */

@DisallowConcurrentExecution
public class ExoersEventDataBaseCleaner implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        final Log LOG = ExoLogger.getLogger(ExoersEventDataBaseCleaner.class);
        ExoersDAO exoersDAO = new ExoersDAO();
        try{
              exoersDAO.deleteAll();
        } catch  (Exception e) {
            LOG.error("Error while computing reminder date of events", e);

        }

    }
}
