package com.example.API_SpringBoot.service;

import com.example.API_SpringBoot.entity.Local;
import com.example.API_SpringBoot.error.LocalNotFoundException;
import com.example.API_SpringBoot.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocalServiceImpl implements LocalService {//Se debe implementar el servicio
    @Autowired//inversion de control
    LocalRepository localRepository;

    @Override
    public List<Local> findAllLocals() {
        return localRepository.findAll();
    }

    @Override
    public Local findLocalById(long id) throws LocalNotFoundException {
        Optional<Local> local = localRepository.findById(id);
        if (!local.isPresent()) {
            throw new LocalNotFoundException("Local with id " + id + " not found");
        }
        return local.get();
    }

    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local updateLocal(long id, Local local) throws LocalNotFoundException {
        Optional<Local> localOptional = localRepository.findById(id);
        if (!localOptional.isPresent()) {
            throw new LocalNotFoundException("Local with id " + id + " not found");
        }
        Local localDB = localRepository.findById(id).get();
        //Filtrar la informacion que llega
        if (Objects.nonNull(local.getCode()) && !"".equalsIgnoreCase(local.getCode())) {
            localDB.setCode(local.getCode());
        }
        if (Objects.nonNull(local.getFloor()) && !"".equalsIgnoreCase(local.getFloor())) {
            localDB.setFloor(local.getFloor());
        }
        if (Objects.nonNull(local.getName()) && !"".equalsIgnoreCase(local.getName())) {
            localDB.setName(local.getName());
        }
        return localRepository.save(localDB);
    }

    @Override
    public void deleteLocal(long id) throws LocalNotFoundException {
        Optional<Local> localOptional = localRepository.findById(id);
        localRepository.deleteById(id);
    }

    //Consultas complejas

    @Override
    public Optional<Local> findByNameIgnoreCase(String name) throws LocalNotFoundException {
        Optional<Local> localOptional = localRepository.findByNameIgnoreCase(name);
        if (!localOptional.isPresent()) {
            throw new LocalNotFoundException("Local with name " + name + " not found");
        }
        //return localRepository.findByNameIgnoreCase(name);
        return localOptional;
    }


}
