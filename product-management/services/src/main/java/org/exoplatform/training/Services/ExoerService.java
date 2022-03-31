package org.exoplatform.training.Services;

import org.exoplatform.services.listener.ListenerService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.training.Entity.Exoers;
import org.exoplatform.training.dao.ExoersDAO;

import java.util.List;

public class ExoerService  implements ResourceContainer, ExoerServiceInterface {
    private ExoersDAO eggzoodao ;

    private static Log log =  ExoLogger.getLogger(ExoerServiceRest.class);
    private ListenerService listenerService ;
    public ExoerService(ExoersDAO eggzodao , ListenerService listenerService ){
        this.eggzoodao=eggzodao;
        this.listenerService = listenerService ;
    }
    @Override
    public List<Exoers> getAllExoers() throws Exception {
        return this.eggzoodao.findAll();
    }
    @Override
    public Exoers addExoer(Exoers a) {

        Exoers eggz = new Exoers(a.getName(),a.getFunction(),a.getDateOfBirth());
        Exoers res= null;
        try {
            res = eggzoodao.create(eggz);
            listenerService.broadcast("exoer-added-success" , this , res);
        }catch (Exception e) {
            log.error("Cannot create the exoer", e);
        }
        return res;
    }
    @Override
    public void deleteExoer(long id) {
        Exoers egz = this.eggzoodao.find(id);
        try {
            this.eggzoodao.delete(egz);
        }catch (Exception e) {
            log.error("Cannot delete the Product", e);
        }
    }
}
