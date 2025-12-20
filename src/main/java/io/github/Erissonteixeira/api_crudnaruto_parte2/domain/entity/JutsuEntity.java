package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Table(name = "jutsu")
@Getter
public class JutsuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String nome;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Integer dano;

    @NotNull
    @Min(1)
    @Column(name = "consumo_chakra", nullable = false)
    private Integer consumoDeChakra;

    protected JutsuEntity() {
    }

    public JutsuEntity(String nome, Integer dano, Integer consumoDeChakra) {
        this.nome = nome;
        this.dano = dano;
        this.consumoDeChakra = consumoDeChakra;
    }
}

