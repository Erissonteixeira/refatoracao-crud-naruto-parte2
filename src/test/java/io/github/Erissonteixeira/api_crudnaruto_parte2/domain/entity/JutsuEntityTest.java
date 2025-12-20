package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JutsuEntityTest {
    @Test
    void deveCriarJutsuComDadosValidos(){
        JutsuEntity jutsu = new JutsuEntity("Rasengan", 80, 20);

        assertEquals("Rasengan", jutsu.getNome());
        assertEquals(80, jutsu.getDano());
        assertEquals(20, jutsu.getConsumoDeChakra());
    }
}
