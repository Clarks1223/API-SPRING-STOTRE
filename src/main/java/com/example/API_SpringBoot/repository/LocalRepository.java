package com.example.API_SpringBoot.repository;

import com.example.API_SpringBoot.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//esta clase permite extender metodos de la clase JPA
public interface LocalRepository extends JpaRepository<Local, Long> {
    //JPA Ignara Mayusculas y minusculas
    Optional<Local> findByNameIgnoreCase(String name);
}
