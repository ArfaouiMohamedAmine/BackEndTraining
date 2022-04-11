package org.exoplatform.training.listener;

import org.exoplatform.services.listener.Event;
import org.exoplatform.services.listener.Listener;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.training.Entity.Exoers;
import org.exoplatform.training.Services.ExoerService;

import javax.swing.*;

public class ExoerSecondEventCreateListener extends Listener<ExoerService, Exoers> {
    private static Log log =  ExoLogger.getLogger(ExoerEventCreateListener.class);
    @Override
    public void onEvent(Event<ExoerService, Exoers> event ) throws Exception {
        new JDialog();
        log.info("Exoer "+  event.getData().getName() + "%c" + "This console is on fire", "font-family:Comic Sans MS; font-size:50px; font-weight:bold; background: linear-gradient(#f00, yellow); border-radius: 5px; padding: 20px");
    }
}
