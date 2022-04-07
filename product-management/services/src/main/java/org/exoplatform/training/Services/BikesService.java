package org.exoplatform.training.Services;

import org.exoplatform.services.listener.ListenerService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;
import org.exoplatform.training.Entity.Bikes;
import org.exoplatform.training.dao.BikesDAO;

import java.util.List;

public class BikesService implements ResourceContainer, BikesServiceInterface {
    private BikesDAO bikesdao ;

    private static Log log =  ExoLogger.getLogger(BikesServiceRest.class);
    private ListenerService listenerService ;
    public BikesService(BikesDAO Byekdao , ListenerService listenerService ){
        this.bikesdao=Byekdao;
        this.listenerService = listenerService ;
    }
    @Override
    public List<Bikes> getAllBikes() throws Exception {
        return this.bikesdao.findAll();
    }
    @Override
    public Bikes addBikes(Bikes b) {

        Bikes bikez = new Bikes(b.getCirculationNmber(),b.getColor(),b.getEngineSize(),b.getImg(),b.getBikeDesc());
        Bikes res= null;
        try {
            res = bikesdao.create(bikez);
            listenerService.broadcast("bike-added-success" , this , res);
        }catch (Exception e) {
            log.error("Cannot create the Bike", e);
        }
        return res;
    }
    @Override
    public void deleteBikes(long id) {
        Bikes egz = this.bikesdao.find(id);
        try {
            this.bikesdao.delete(egz);
        }catch (Exception e) {
            log.error("Cannot delete the Product", e);
        }
    }
}



