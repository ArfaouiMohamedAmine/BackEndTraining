package org.exoplatform.training.Services;

import org.exoplatform.training.Entity.Exoers;
import org.exoplatform.training.dto.ExoersDTO;

public class MapperExoer {
    public static ExoersDTO exoerToDTO(Exoers entity){

        ExoersDTO res = new ExoersDTO();

        if(entity != null)
        {
            res.setId(entity.getId());
            res.setName(entity.getName());
            res.setFunctionn(entity.getFunctionn());
        }
        return res;
    }
}
