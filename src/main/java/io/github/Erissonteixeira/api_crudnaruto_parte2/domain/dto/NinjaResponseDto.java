package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class NinjaResponseDto {

    private Long id;
    private String nome;
    private String vila;
    private Integer idade;
    private Integer chakra;
    private Set<String> jutsus;
    private LocalDateTime criadoEm;

    public NinjaResponseDto(Long id, String nome, String vila, Integer idade, Integer chakra, Set<String> jutsus, LocalDateTime criadoEm) {
        this.id = id;
        this.nome = nome;
        this.vila = vila;
        this.idade = idade;
        this.chakra = chakra;
        this.jutsus = jutsus;
        this.criadoEm = criadoEm;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getVila() {
        return vila;
    }

    public Integer getIdade() {
        return idade;
    }

    public Integer getChakra() {
        return chakra;
    }

    public Set<String> getJutsus() {
        return jutsus;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}
