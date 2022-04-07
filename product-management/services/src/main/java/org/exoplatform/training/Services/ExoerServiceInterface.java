package org.exoplatform.training.Services;

import org.exoplatform.training.Entity.Exoers;

import java.util.List;

public interface ExoerServiceInterface {
    List<Exoers> getAllExoers() throws Exception;

     Exoers getOneExoerById(long id);
    Exoers addExoer(Exoers a);

    void deleteExoer(long id);
}
