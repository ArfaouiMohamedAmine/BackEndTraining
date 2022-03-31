package org.exoplatform.training.plugins;

import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.picocontainer.Startable;

public class StartableExoerService implements Startable {

    private static final Log LOG     = ExoLogger.getLogger(StartableExoerService.class);

    ExoerPluginInterface exoerService;

    String text = "one two one two that's what I do!";

    public StartableExoerService(ExoerPluginInterface eggzooService){
        this.exoerService = eggzooService;
    }
    @Override
    public void start() {
        LOG.info("START : Service Product started successfully !");
        exoerService.displayText(text);
        LOG.info("Executing plugins");
    }

    @Override
    public void stop() {
        LOG.info("Stop : Service Product Stoped successfully !");
    }
}


