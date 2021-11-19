package com.puntoCuatro.resproductionList.general.utils;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DateUtils {

    public Date obtenerFechaActual(){
        return new Date();
    }
}
