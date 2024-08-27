package com.example.API_SpringBoot.service;

import com.example.API_SpringBoot.entity.Local;
import com.example.API_SpringBoot.error.LocalNotFoundException;

import java.util.List;
import java.util.Optional;

public interface LocalService {
    //Defino los metodos que seran utilizados en la capa de servicio
    List<Local> findAllLocals();

    Local findLocalById(long id) throws LocalNotFoundException;

    Local saveLocal(Local local);

    Local updateLocal(long id, Local local) throws LocalNotFoundException;

    void deleteLocal(long id) throws LocalNotFoundException;

    Optional<Local> findByNameIgnoreCase(String name) throws LocalNotFoundException;
}
