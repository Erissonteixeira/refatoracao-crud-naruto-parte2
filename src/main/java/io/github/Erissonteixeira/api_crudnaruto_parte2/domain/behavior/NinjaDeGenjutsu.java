package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.behavior;

import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.contract.Ninja;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity.NinjaEntity;

public class NinjaDeGenjutsu implements Ninja {

    private final NinjaEntity ninja;

    public NinjaDeGenjutsu(NinjaEntity ninja) {
        this.ninja = ninja;
    }

    @Override
    public void usarJutsu() {
        System.out.println(ninja.getNome() + " Está usando um jutsu de Genjutsu");
    }

    @Override
    public void desviar(){
        System.out.println(ninja.getNome() + " Desviou do ataque usando Genjutsu");
    }
}
