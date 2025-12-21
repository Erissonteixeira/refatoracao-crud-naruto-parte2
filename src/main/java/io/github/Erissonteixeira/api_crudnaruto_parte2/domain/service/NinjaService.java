package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.service;

import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.behavior.NinjaDeGenjutsu;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.behavior.NinjaDeNinjutsu;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.behavior.NinjaDeTaijutsu;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.contract.Ninja;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity.NinjaEntity;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.repository.NinjaRepository;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {

    private final NinjaRepository repository;

    public NinjaService(NinjaRepository repository) {
        this.repository = repository;
    }

    public Ninja executarAtaque(String tipo, NinjaEntity ninja) {

        Ninja comportamento = escolherComportamento(tipo, ninja);

        comportamento.usarJutsu();
        comportamento.desviar();

        return comportamento;
    }

    private Ninja escolherComportamento(String tipo, NinjaEntity ninja) {
        return switch (tipo.toUpperCase()) {
            case "TAIJUTSU" -> new NinjaDeTaijutsu(ninja);
            case "NINJUTSU" -> new NinjaDeNinjutsu(ninja);
            case "GENJUTSU" -> new NinjaDeGenjutsu(ninja);
            default -> throw new IllegalArgumentException("Tipo de ninja inválido");
        };
    }
}
