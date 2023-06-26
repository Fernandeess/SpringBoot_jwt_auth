package com.example.springteste.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Table(name = "cliente", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Entity // indica que a classe é uma entidade
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {
    @Id // indica que o atributo é uma chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // indica que o atributo é auto incrementado
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private String senha;
}
