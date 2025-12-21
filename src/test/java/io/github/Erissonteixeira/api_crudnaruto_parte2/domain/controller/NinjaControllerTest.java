package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.Erissonteixeira.api_crudnaruto_parte2.controller.NinjaController;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaRequestDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaResponseDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.service.NinjaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NinjaController.class)
class NinjaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NinjaService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void criarNinja_deveRetornarNinjaCriado() throws Exception {

        NinjaResponseDto response = new NinjaResponseDto(
                1L, "Naruto", "Konoha", 17, 100, Set.of(), LocalDateTime.now()
        );

        when(service.criar(any(NinjaRequestDto.class))).thenReturn(response);

        String jsonRequest = """
                {
                  "nome": "Naruto",
                  "vila": "Konoha",
                  "idade": 17
                }
                """;

        mockMvc.perform(post("/api/v1/ninjas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Naruto"))
                .andExpect(jsonPath("$.vila").value("Konoha"))
                .andExpect(jsonPath("$.idade").value(17));
    }

    @Test
    void listarNinjas_deveRetornarLista() throws Exception {

        when(service.listar()).thenReturn(List.of(
                new NinjaResponseDto(
                        1L, "Naruto", "Konoha", 17, 100, Set.of(), LocalDateTime.now()
                )
        ));

        mockMvc.perform(get("/api/v1/ninjas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Naruto"));
    }

    @Test
    void buscarPorId_deveRetornarNinja() throws Exception {

        when(service.buscarPorId(1L)).thenReturn(
                new NinjaResponseDto(
                        1L, "Sasuke", "Konoha", 18, 100, Set.of(), LocalDateTime.now()
                )
        );

        mockMvc.perform(get("/api/v1/ninjas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Sasuke"));
    }

    @Test
    void atualizarNinja_deveRetornarNinjaAtualizado() throws Exception {

        when(service.atualizar(anyLong(), any(NinjaRequestDto.class))).thenReturn(
                new NinjaResponseDto(
                        1L, "Kakashi", "Konoha", 30, 100, Set.of(), LocalDateTime.now()
                )
        );

        String jsonRequest = """
                {
                  "nome": "Kakashi",
                  "vila": "Konoha",
                  "idade": 30
                }
                """;

        mockMvc.perform(put("/api/v1/ninjas/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Kakashi"))
                .andExpect(jsonPath("$.idade").value(30));
    }

    @Test
    void deletarNinja_deveRetornarStatus200() throws Exception {

        doNothing().when(service).deletar(1L);

        mockMvc.perform(delete("/api/v1/ninjas/1"))
                .andExpect(status().isOk());
    }
}
