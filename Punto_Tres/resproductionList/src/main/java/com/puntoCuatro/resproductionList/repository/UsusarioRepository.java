package com.puntoCuatro.resproductionList.repository;

import com.puntoCuatro.resproductionList.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsusarioRepository extends CrudRepository<Usuario,Long> {

    Optional<Usuario> findByLogin(String username);

    List<Usuario> findByHabilitado(Boolean inactivo);
}
