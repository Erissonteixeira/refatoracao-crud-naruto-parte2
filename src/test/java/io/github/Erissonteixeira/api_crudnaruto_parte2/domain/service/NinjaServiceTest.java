package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.service;

import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.contract.Ninja;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity.NinjaEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NinjaServiceTest {

    @Test
    void deveExecutarAtaqueComNinjutsu() {

        NinjaService service = new NinjaService();
        NinjaEntity ninja = new NinjaEntity("Naruto", "Konoha", 17);

        Ninja resultado = service.executarAtaque("ninjutsu", ninja);

        assertNotNull(resultado);
        assertEquals("Naruto", ninja.getNome());
    }

    @Test
    void deveExecutarAtaqueComTaijutsu() {

        NinjaService service = new NinjaService();
        NinjaEntity ninja = new NinjaEntity("Rock Lee", "Konoha", 16);

        Ninja resultado = service.executarAtaque("taijutsu", ninja);

        assertNotNull(resultado);
        assertEquals("Rock Lee", ninja.getNome());
    }

    @Test
    void deveExecutarAtaqueComGenjutsu() {

        NinjaService service = new NinjaService();
        NinjaEntity ninja = new NinjaEntity("Itachi", "Konoha", 21);

        Ninja resultado = service.executarAtaque("genjutsu", ninja);

        assertNotNull(resultado);
        assertEquals("Itachi", ninja.getNome());
    }
}
