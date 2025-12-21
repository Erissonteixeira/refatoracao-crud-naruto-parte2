package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.Erissonteixeira.api_crudnaruto_parte2.controller.NinjaController;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaRequestDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaResponseDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.service.NinjaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class NinjaControllerTest {

    private MockMvc mockMvc;

    @Mock
    private NinjaService service;

    @InjectMocks
    private NinjaController controller;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void criarNinja_deveRetornarNinjaCriado() throws Exception {

        NinjaResponseDto response = new NinjaResponseDto(
                1L, "Naruto", "Konoha", 17, 100, Set.of(), LocalDateTime.now()
        );

        when(service.criar(any(NinjaRequestDto.class))).thenReturn(response);

        String jsonRequest = objectMapper.writeValueAsString(
                java.util.Map.of("nome", "Naruto", "vila", "Konoha", "idade", 17)
        );

        mockMvc.perform(post("/ninjas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Naruto"))
                .andExpect(jsonPath("$.vila").value("Konoha"))
                .andExpect(jsonPath("$.idade").value(17));
    }
}