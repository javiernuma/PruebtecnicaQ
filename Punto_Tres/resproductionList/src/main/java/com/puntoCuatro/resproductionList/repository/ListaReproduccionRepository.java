package com.puntoCuatro.resproductionList.repository;

import com.puntoCuatro.resproductionList.models.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaReproduccionRepository extends JpaRepository<Long, Cancion> {
}
