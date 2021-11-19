package com.puntoCuatro.resproductionList.repository;

import com.puntoCuatro.resproductionList.models.Cancion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionRepository extends CrudRepository<Cancion, Long> {
}
