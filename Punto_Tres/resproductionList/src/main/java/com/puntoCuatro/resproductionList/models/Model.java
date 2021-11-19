package com.puntoCuatro.resproductionList.models;

import com.puntoCuatro.resproductionList.dto.DTO;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Model<T extends DTO> {

    //private static final Logger LOGGER = Logger.(Model.class);

    public T getDto() {

        try {
            T dto = this.getDtoClass().newInstance();
            BeanUtils.copyProperties(this, dto);
            return dto;
        } catch (InstantiationException | IllegalAccessException | NullPointerException e) {
            //LOGGER.err(e.getMessage());
        }
        return null;
    }

    /**
     * Descripción
     *
     * @return Class<T>
     *
     */
    public abstract Class<T> getDtoClass();

}
