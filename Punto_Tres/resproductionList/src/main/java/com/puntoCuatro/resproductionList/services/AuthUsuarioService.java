package com.puntoCuatro.resproductionList.services;

import com.puntoCuatro.resproductionList.models.Usuario;
import com.puntoCuatro.resproductionList.repository.UsusarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthUsuarioService implements IAuthUsuarioService,UserDetailsService {

    private final Logger logger = LoggerFactory.getLogger(AuthUsuarioService.class);

    @Autowired
    private UsusarioRepository ususarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = ususarioRepository.findByLogin(username);

        if (!usuario.isPresent()){
            logger.error("Error en el login: no existe el usuario'"+username+"' en el sistema");
            throw new UsernameNotFoundException("Error en el login: no existe el usuario'"+username+"' en el sistema");
        }

        List<GrantedAuthority> authorityList = usuario.get().getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .collect(Collectors.toList());
        return new User(usuario.get().getLogin(), usuario.get().getContrasena(), usuario.get().getHabilitado(), true, true, true,  authorityList);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        return ususarioRepository.findByLogin(username).get();
    }
}
