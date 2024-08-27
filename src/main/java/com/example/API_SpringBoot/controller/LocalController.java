package com.example.API_SpringBoot.controller;

import com.example.API_SpringBoot.entity.Local;
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
    public Local findLocalById(@PathVariable int id) {
        return localService.findLocalById(id);
    }

    @PostMapping("/store")
    public Local save(@RequestBody Local local) {
        return localService.saveLocal(local);
    }

    @PutMapping("/store/{id}")
    public Local update(@PathVariable Long id, @RequestBody Local local) {
        return localService.updateLocal(id, local);
    }

    @DeleteMapping("/store/{id}")
    public void delete(@PathVariable int id) {
        localService.deleteLocal(id);
    }

    //Consultas complejas
    @GetMapping("/storeQuery/{name}")
    Optional<Local> findLocalByNameIgnoreCase(@PathVariable String name) {
        return localService.findByNameIgnoreCase(name);
    }
}
