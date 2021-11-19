package com.puntoCuatro.resproductionList.rest;

import com.puntoCuatro.resproductionList.dto.UsuarioDTO;
import com.puntoCuatro.resproductionList.general.utils.ResponseObject;
import com.puntoCuatro.resproductionList.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioRest {

    @Autowired
    private UsuarioService usuarioService;

    private static final Logger logger = LoggerFactory.getLogger(UsuarioRest.class);

    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<UsuarioDTO> getUsuarioPorId(@PathVariable Long id){

        return new ResponseObject<>(usuarioService.obtenerInfo(id));
    }

    /**@PostMapping("/editarPerfil")
    public ResponseObject<ResgistroPersonaDTO> editarPerfil(@RequestBody ResgistroPersonaDTO resgistroPersonaDTO){
        try{
            logger.info("#### Se edita el perfil de la persona ###");

           return new ResponseObject<>(usuarioService.actualizarPerfil(resgistroPersonaDTO));
        }catch (Exception e){
            return new ResponseObject<>(ResponseCodes.REQUEST_ERROR_CODE, messageSource.getMessage(
                    exceptionMessage, null, LocaleContextHolder.getLocale()));
        }

    }**/


    @PostMapping(value = "/cambiarclave", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<String> recuperarClave(@RequestBody UsuarioDTO usuarioDTO){
        logger.info("#### Se cambia la clave del usuario ###");
        try{
            return new ResponseObject<>(usuarioService.recuperarClave(usuarioDTO.getLogin()));
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            return new ResponseObject<>(
                    HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }
    @PostMapping("/crear")
    public ResponseObject<UsuarioDTO> editarPerfil(@RequestBody UsuarioDTO usuarioDTO){
        try{
            logger.info("#### Se edita el perfil de la persona ###");
            return new ResponseObject<>(usuarioService.crearUsuario(usuarioDTO));
        }catch (Exception e){
            return new ResponseObject<>(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }




}
