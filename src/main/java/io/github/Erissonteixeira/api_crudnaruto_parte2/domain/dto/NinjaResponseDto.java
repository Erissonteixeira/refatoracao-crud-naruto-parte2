package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.Set;

@Schema(name = "NinjaResponseDto", description = "DTO usado para retorno de dados de um ninja")
public class NinjaResponseDto {

    @Schema(description = "Identificador único do ninja", example = "1")
    private Long id;
    @Schema(description = "Nome do ninja", example = "Naruto Uzumaki")
    private String nome;
    @Schema(description = "Vila de origem do ninja", example = "Konoha")
    private String vila;
    @Schema(description = "Idade do ninja", example = "17")
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
