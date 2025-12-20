package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NinjaEntityTest {

    @Test
    void deveCriarNinjaComChakraInicialPadrao() {
        NinjaEntity ninja = new NinjaEntity("Naruto", "Konoha", 17);

        assertEquals(100, ninja.getChakra());

        assertEquals("Naruto", ninja.getNome());
        assertEquals("Konoha", ninja.getVila());
        assertEquals(17, ninja.getIdade());
    }

    @Test
    void deveConsumirChakraCorretamente() {
        NinjaEntity ninja = new NinjaEntity("Sasuke", "Konoha", 18);

        ninja.consumirChakra(30);

        assertEquals(70, ninja.getChakra());
    }

    @Test
    void deveRetornarTrueQuandoTiverChakraSuficiente() {
        NinjaEntity ninja = new NinjaEntity("Kakashi", "Konoha", 30);

        boolean resultado = ninja.temChakraSuficiente(50);

        assertTrue(resultado);
    }

    @Test
    void DeveRetornarFalseQuandoNaoTiverChakraSuficiente(){
        NinjaEntity ninja = new NinjaEntity("Rock Lee", "Konoha", 16);

        ninja.consumirChakra(95);

        boolean resultado = ninja.temChakraSuficiente(10);

        assertFalse(resultado);
    }
}
