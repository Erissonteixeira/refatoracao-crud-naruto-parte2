package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.behavior;

import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.contract.Ninja;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity.NinjaEntity;

public class NinjaDeNinjutsu implements Ninja {

    private final NinjaEntity ninja;

    public NinjaDeNinjutsu(NinjaEntity ninja) {
        this.ninja = ninja;
    }

    @Override
    public void usarJutsu() {
        System.out.println(ninja.getNome() + " Está usando um jutsu de Ninjutsu");
    }

    @Override
    public void desviar() {
        System.out.println(ninja.getNome() + " Desviou do ataque usando Ninjutsu");
    }

}
