package com.puntoCuatro.resproductionList.services;


import com.puntoCuatro.resproductionList.models.Usuario;

public interface IAuthUsuarioService {

    public Usuario findByUsername(String username);
}
