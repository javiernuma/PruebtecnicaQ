package com.puntoCuatro.resproductionList.services;

import com.puntoCuatro.resproductionList.dto.UsuarioDTO;
import com.puntoCuatro.resproductionList.general.utils.DateUtils;
import com.puntoCuatro.resproductionList.models.Usuario;
import com.puntoCuatro.resproductionList.repository.UsusarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private UsusarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private DateUtils dateUtils;


    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);


    public Boolean existeUsuarioDePersona(String login){
        logger.info("Se busca el usuario de la persona solicitada");
        Optional<Usuario> usuario = usuarioRepository.findByLogin(login);
        return usuario.isPresent();

    }


    public String recuperarClave(String login){
        Optional<Usuario>usuario = usuarioRepository.findByLogin(login);
        if (usuario.isPresent()){
            usuario.get().setContrasena(passwordEncoder.encode(usuario.get().getLogin()));
            return "Se ha cambiado la clave a su login";
        }
        return "el usuario no exite";
    }


    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        boolean respuesta = false;
        Usuario usuario = new Usuario();
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setHabilitado(true);
        usuario.setFechaIngresoReg(dateUtils.obtenerFechaActual());
        usuario.setFechaIngresoReg(dateUtils.obtenerFechaActual());
        return usuarioRepository.save(usuario).getDto();
    }

    public UsuarioDTO obtenerInfo(Long id){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()){
            usuarioDTO = usuario.get().getDto();

        }

        return usuarioDTO;
    }




}
