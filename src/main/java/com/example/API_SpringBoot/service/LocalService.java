package com.example.API_SpringBoot.service;

import com.example.API_SpringBoot.entity.Local;

import java.util.List;
import java.util.Optional;

public interface LocalService {
    //Defino los metodos que seran utilizados en la capa de servicio
    List<Local> findAllLocals();

    Local findLocalById(long id);

    Local saveLocal(Local local);

    Local updateLocal(long id, Local local);

    void deleteLocal(long id);

    Optional<Local> findByNameIgnoreCase(String name);
}
