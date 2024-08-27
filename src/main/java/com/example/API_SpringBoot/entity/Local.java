package com.example.API_SpringBoot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity//Le indica a spring que eso sera una entidad
@Table(name = "locals")//Le indica a spring que esta sera una tabla de mi BD
@Data//Genera los getter y setters
@AllArgsConstructor//Genera un constructor con todos los atributos
@NoArgsConstructor//Genera un cosntructor vacio
@Builder
public class Local {
    @Id//le indica que este atributo sera el id de la tabla
    @GeneratedValue(strategy = GenerationType.AUTO)//aumentara una unidad atomaticamente
    private long id;
    @NotBlank(message = "The camp 'name' is mandatory")
    private String name;
    @NotBlank(message = "The camp 'floor' is mandatory")
    private String floor;
    @Length(min = 4, max = 10)
    private String code;
}
