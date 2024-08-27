package com.example.API_SpringBoot.controller;

import com.example.API_SpringBoot.entity.Local;
import com.example.API_SpringBoot.error.LocalNotFoundException;
import com.example.API_SpringBoot.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocalController {
    @Autowired
    LocalService localService;

    @GetMapping("/store")
    public List<Local> findAllLocal() {
        return localService.findAllLocals();
    }

    @GetMapping("/store/{id}")
    public Local findLocalById(@PathVariable int id) throws LocalNotFoundException {
        return localService.findLocalById(id);
    }

    @PostMapping("/store")
    public Local save(@RequestBody Local local) {
        return localService.saveLocal(local);
    }

    @PutMapping("/store/{id}")
    public Local update(@PathVariable Long id, @RequestBody Local local) throws LocalNotFoundException {
        return localService.updateLocal(id, local);
    }

    @DeleteMapping("/store/{id}")
    public void delete(@PathVariable int id) throws LocalNotFoundException {
        localService.deleteLocal(id);
    }

    //Consultas complejas
    @GetMapping("/storeQuery/{name}")
    Optional<Local> findLocalByNameIgnoreCase(@PathVariable String name) throws LocalNotFoundException {
        return localService.findByNameIgnoreCase(name);
    }
}
