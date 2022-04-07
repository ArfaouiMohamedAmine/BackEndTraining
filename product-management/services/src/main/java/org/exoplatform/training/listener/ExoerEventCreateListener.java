package org.exoplatform.training.listener;

import org.exoplatform.services.listener.Event;
import org.exoplatform.services.listener.Listener;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.training.Entity.Exoers;
import org.exoplatform.training.Services.ExoerService;

public class ExoerEventCreateListener  extends Listener<ExoerService, Exoers> {
    private static Log log =  ExoLogger.getLogger(ExoerEventCreateListener.class);

    @Override
    public void onEvent(Event<ExoerService, Exoers> event ) throws Exception {
        log.info("Exoer "+  event.getData().getName());
    }
}