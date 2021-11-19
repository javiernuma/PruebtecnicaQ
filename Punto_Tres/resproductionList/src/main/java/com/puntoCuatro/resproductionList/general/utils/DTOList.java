package com.puntoCuatro.resproductionList.general.utils;

import com.puntoCuatro.resproductionList.dto.DTO;
import com.puntoCuatro.resproductionList.models.Model;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DTOList {

    /**
     * Contructor por defecto
     */
    public DTOList() {}

    public <T extends DTO>List<T> getDtoList(List<? extends Model<T>> models) {
        if (models != null && !models.isEmpty()){
            return models.stream().map(Model::getDto).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
