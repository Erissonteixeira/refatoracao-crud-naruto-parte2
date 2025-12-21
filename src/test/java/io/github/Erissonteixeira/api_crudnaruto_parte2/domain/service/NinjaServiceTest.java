package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.service;

import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaRequestDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaResponseDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity.NinjaEntity;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.repository.NinjaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NinjaServiceTest {

    @Mock
    private NinjaRepository repository;

    @InjectMocks
    private NinjaService service;

    @Test
    void deveCriarNinja() {
        NinjaRequestDto dto = new NinjaRequestDto("Naruto", "Konoha", 17);
        NinjaEntity entity = new NinjaEntity("Naruto", "Konoha", 17);

        when(repository.save(any())).thenReturn(entity);

        NinjaResponseDto response = service.criar(dto);

        assertEquals("Naruto", response.getNome());
    }

    @Test
    void deveListarNinjas() {
        when(repository.findAll()).thenReturn(List.of(
                new NinjaEntity("Naruto", "Konoha", 17)
        ));

        List<NinjaResponseDto> lista = service.listar();

        assertFalse(lista.isEmpty());
    }

    @Test
    void deveBuscarPorId() {
        when(repository.findById(1L))
                .thenReturn(Optional.of(new NinjaEntity("Sasuke", "Konoha", 18)));

        NinjaResponseDto response = service.buscarPorId(1L);

        assertEquals("Sasuke", response.getNome());
    }

    @Test
    void deveDeletarNinja() {
        Long id = 1L;

        service.deletar(id);

        verify(repository).deleteById(id);
    }
}
