package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public class NinjaRequestDto {
    @Schema(description = "Nome do ninja", example = "Naturo Uzumaki", maxLength = 30)
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 30, message = "Nome deve ter no máximo 30 caracteres")
    private String nome;

    @Schema(description = "Vila de origem do ninja", example = "Konoha", maxLength = 50)
    @NotBlank(message = "Vila é obrigatória")
    @Size(max = 50, message = "Vila deve ter no máximo 50 caracteres")
    private String vila;

    @NotNull(message = "Idade é obrigatória")
    @Min(value = 0, message = "Idade não pode ser negativa")
    @Max(value = 115, message = "Idade máxima permitida é 115 anos")
    private Integer idade;

    public NinjaRequestDto() {
    }

    public NinjaRequestDto(String naruto, String konoha, int i) {
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVila(String vila) {
        this.vila = vila;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}