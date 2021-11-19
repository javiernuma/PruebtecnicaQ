package com.puntoCuatro.resproductionList.rest;

import com.puntoCuatro.resproductionList.dto.ListaReproduccioDTO;
import com.puntoCuatro.resproductionList.dto.UsuarioDTO;
import com.puntoCuatro.resproductionList.general.utils.ResponseObject;
import com.puntoCuatro.resproductionList.models.ListaReproduccion;
import com.puntoCuatro.resproductionList.services.ListaReproduccionService;
import com.puntoCuatro.resproductionList.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListaReproduccionRest {


    @Autowired
    private ListaReproduccionService listaReproduccionService;

    private static final Logger logger = LoggerFactory.getLogger(ListaReproduccionRest.class);

    @PostMapping()
    public ResponseObject<ListaReproduccioDTO> añadirLista(@RequestBody ListaReproduccioDTO listaReproduccioDTO){
        try{
            logger.info("#### Se edita el perfil de la persona ###");
            listaReproduccionService.addList(listaReproduccioDTO);
            return new ResponseObject<>(HttpStatus.CREATED.value(), HttpStatus.CREATED.getReasonPhrase());
        }catch (Exception e){
            return new ResponseObject<>(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<List<ListaReproduccioDTO>> getAllLists(){
        try{
            return new ResponseObject<>(listaReproduccionService.getAllLists());
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            return new ResponseObject<>(
                    HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
    }

    @GetMapping(value="/{listName}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<ListaReproduccioDTO> getUsuarioPorId(@PathVariable String listName){
        try{
            return new ResponseObject<>(listaReproduccionService.getList(listName));
        }catch (Exception e){
            return new ResponseObject<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
        }

    }

    @DeleteMapping(value = "/{listName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseObject<String> recuperarClave(@PathVariable String listName){
        logger.info("#### Se elimina la lista de reproduccion  ###");
        try{
            listaReproduccionService.deleteList(listName);
            return new ResponseObject<>(HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT.getReasonPhrase());
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            return new ResponseObject<>(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
        }
    }


}
