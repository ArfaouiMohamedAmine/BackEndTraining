package org.exoplatform.training.Services;

import org.exoplatform.training.Entity.Bikes;
import org.exoplatform.training.Entity.Exoers;

import java.util.List;

public interface BikesServiceInterface {
    List<Bikes> getAllBikes() throws Exception;

    Bikes addBikes(Bikes b);

    void deleteBikes(long id);
}
