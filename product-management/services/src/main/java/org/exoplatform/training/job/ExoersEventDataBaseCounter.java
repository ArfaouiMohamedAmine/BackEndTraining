package org.exoplatform.training.job;


import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.training.Entity.Exoers;
import org.exoplatform.training.dao.ExoersDAO;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * A job to to Upcase the data base every minute
 */
@DisallowConcurrentExecution

public class ExoersEventDataBaseCounter implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        final Log LOG = ExoLogger.getLogger(ExoersEventDataBaseCleaner.class);
        ExoersDAO exoersDAO = new ExoersDAO();
        try{
            Exoers exoers = new Exoers("arfaoui","Med","amine");
            exoersDAO.create(exoers);

            LOG.info("the arfaoui exoer has been created succefully");
        } catch  (Exception e) {
            LOG.error("Error while computing counter reminder of events", e);
        }
    }
}
