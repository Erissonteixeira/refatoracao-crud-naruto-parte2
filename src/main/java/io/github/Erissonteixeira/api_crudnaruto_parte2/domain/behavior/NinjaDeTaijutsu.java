package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.behavior;

import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.contract.Ninja;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity.NinjaEntity;

public class NinjaDeTaijutsu implements Ninja {

    private final NinjaEntity ninja;

    public NinjaDeTaijutsu(NinjaEntity ninja){
        this.ninja = ninja;
    }

    @Override
    public void usarJutsu(){
        System.out.println(ninja.getNome() + " Está usando um golpe de Taijutsu");
    }

    @Override
    public void desviar(){
        System.out.println(ninja.getNome() + " Desviou do ataque usando Taijutsu");
    }
}
