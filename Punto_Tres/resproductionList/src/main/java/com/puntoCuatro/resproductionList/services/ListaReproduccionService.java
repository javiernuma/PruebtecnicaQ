package com.puntoCuatro.resproductionList.services;

import com.puntoCuatro.resproductionList.dto.CancionDTO;
import com.puntoCuatro.resproductionList.dto.ListaReproduccioDTO;
import com.puntoCuatro.resproductionList.general.utils.DTOList;
import com.puntoCuatro.resproductionList.models.Cancion;
import com.puntoCuatro.resproductionList.models.ListaReproduccion;
import com.puntoCuatro.resproductionList.repository.CancionRepository;
import com.puntoCuatro.resproductionList.repository.ListaReproduccionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ListaReproduccionService {

    @Autowired
    ListaReproduccionRepository listaReproduccionRepository;

    @Autowired
    CancionRepository cancionRepository;

    @Autowired
    DTOList dtoList;


    public void addList(ListaReproduccioDTO listaReproduccioDTO) throws Exception {
        ListaReproduccion listaReproduccion = new ListaReproduccion();
        List<Cancion> cancionList = new ArrayList<>();
        if (listaReproduccioDTO.getNombreLista() != null){
            listaReproduccion = listaReproduccionRepository.findByNombreLista(listaReproduccioDTO.getNombreLista());
            if (listaReproduccion != null){
                throw new RuntimeException("Nombre de lista existe");
            }
        }else {
            throw new RuntimeException("Nombre no valido");
        }
        if (!listaReproduccioDTO.getListaCanciones().isEmpty()){
          cancionList = addSongs(listaReproduccioDTO.getListaCanciones());
        }
        BeanUtils.copyProperties(listaReproduccioDTO, listaReproduccion);
        if (!cancionList.isEmpty()){
            cancionList = cancionList.stream().filter(Objects::nonNull).collect(Collectors.toList());
        }

        listaReproduccion.setListaCanciones(cancionList);
        listaReproduccionRepository.save(listaReproduccion);
    }

    private List<Cancion>  addSongs(List<CancionDTO> listaCanciones){
        return listaCanciones.stream().map(
                songTemp -> {
                    if (!cancionRepository.existsById(songTemp.getId())){
                        Cancion cancion = new Cancion();
                        BeanUtils.copyProperties(songTemp, cancion);
                        return cancionRepository.save(cancion);
                    }
                    return null;
                }).collect(Collectors.toList());
    }

    public List<ListaReproduccioDTO> getAllLists(){
        return dtoList.getDtoList(listaReproduccionRepository.findAll());
    }

    public ListaReproduccioDTO getList(String nameList){
        return listaReproduccionRepository.findByNombreLista(nameList).getDto();
    }

    public void  deleteList(String nameList){
        ListaReproduccion listaReproduccion = listaReproduccionRepository.findByNombreLista(nameList);
        listaReproduccionRepository.delete(listaReproduccion);
    }
}
