package com.puntoCuatro.resproductionList.repository;

import com.puntoCuatro.resproductionList.models.ListaReproduccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaReproduccionRepository extends JpaRepository<ListaReproduccion, Long>, PagingAndSortingRepository<ListaReproduccion, Long> {

    List<ListaReproduccion> findAll();

    ListaReproduccion findByNombreLista(String nameList);
}
