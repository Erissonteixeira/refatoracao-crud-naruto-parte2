package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ninja")
@Getter
public class NinjaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String vila;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Integer idade;

    @NotNull
    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private Integer chakra;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm;

    @ManyToMany
    @JoinTable(name = "ninja_jutsu", joinColumns = @JoinColumn(name = "ninja_id"), inverseJoinColumns = @JoinColumn(name = "jutsu_id"))
    private Set<JutsuEntity> justus = new HashSet<>();

    protected NinjaEntity() {
    }

    public NinjaEntity(String nome, String vila, Integer idade) {
        this.nome = nome;
        this.vila = vila;
        this.idade = idade;
        this.chakra = 100;
        this.criadoEm = LocalDateTime.now();
    }

    public void consumirChakra(int custo) {
        this.chakra -= custo;
    }

    public boolean temChakraSuficiente(int custo) {
        return this.chakra >= custo;
    }

    public void adicionarJutsu(JutsuEntity jutsu) {
        this.justus.add(jutsu);
    }
}
