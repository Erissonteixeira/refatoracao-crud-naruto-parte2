package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.service;

import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.contract.Ninja;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity.NinjaEntity;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.repository.NinjaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class NinjaServiceTest {

    @Mock
    private NinjaRepository repository;

    @InjectMocks
    private NinjaService service;

    @Test
    void deveExecutarAtaqueComNinjutsu() {

        NinjaEntity ninja = new NinjaEntity("Naruto", "Konoha", 17);

        Ninja resultado = service.executarAtaque("ninjutsu", ninja);

        assertNotNull(resultado);
        assertEquals("Naruto", ninja.getNome());
    }

    @Test
    void deveExecutarAtaqueComTaijutsu() {

        NinjaEntity ninja = new NinjaEntity("Rock Lee", "Konoha", 16);

        Ninja resultado = service.executarAtaque("taijutsu", ninja);

        assertNotNull(resultado);
        assertEquals("Rock Lee", ninja.getNome());
    }

    @Test
    void deveExecutarAtaqueComGenjutsu() {

        NinjaEntity ninja = new NinjaEntity("Itachi", "Konoha", 21);

        Ninja resultado = service.executarAtaque("genjutsu", ninja);

        assertNotNull(resultado);
        assertEquals("Itachi", ninja.getNome());
    }

    @Test
    void deveLancarExececaoQuandoTipoInvalido() {

        NinjaEntity ninja = new NinjaEntity("Sasuke", "Konoha", 18);

        assertThrows(IllegalArgumentException.class, () -> service.executarAtaque("invalido", ninja));
    }
}
