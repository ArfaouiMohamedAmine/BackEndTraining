package org.exoplatform.training.Services;

import org.exoplatform.training.Entity.Bikes;
import org.exoplatform.training.dto.BikesDTO;
import org.jetbrains.annotations.NotNull;

public class MapperBikes {
    public static BikesDTO BikesToDTO(Bikes entity){

        BikesDTO res = new BikesDTO();

        if(entity != null)
        {
            res.setId(entity.getId());
            res.setCirculationNmber(entity.getCirculationNmber());
            res.setColor(entity.getColor());
            res.setEngineSize(String.valueOf(entity.getEngineSize()));
            res.setImg(entity.getImg());
            res.setBikeDesc(entity.getBikeDesc());

        }
        return res;
    }
}
