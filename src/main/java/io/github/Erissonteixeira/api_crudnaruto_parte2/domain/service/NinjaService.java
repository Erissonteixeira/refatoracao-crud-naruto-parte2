package io.github.Erissonteixeira.api_crudnaruto_parte2.domain.service;

import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaRequestDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaResponseDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.entity.NinjaEntity;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository repository;

    public NinjaService(NinjaRepository repository) {
        this.repository = repository;
    }

    public NinjaResponseDto criar(NinjaRequestDto dto) {
        NinjaEntity ninja = new NinjaEntity(
                dto.getNome(),
                dto.getVila(),
                dto.getIdade()
        );

        NinjaEntity salvo = repository.save(ninja);
        return toResponse(salvo);
    }

    public List<NinjaResponseDto> listar() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public NinjaResponseDto buscarPorId(Long id) {
        NinjaEntity ninja = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ninja não encontrado"));

        return toResponse(ninja);
    }

    public NinjaResponseDto atualizar(Long id, NinjaRequestDto dto) {
        NinjaEntity ninja = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ninja não encontrado"));

        ninja = new NinjaEntity(
                dto.getNome(),
                dto.getVila(),
                dto.getIdade()
        );

        NinjaEntity atualizado = repository.save(ninja);
        return toResponse(atualizado);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private NinjaResponseDto toResponse(NinjaEntity ninja) {
        return new NinjaResponseDto(
                ninja.getId(),
                ninja.getNome(),
                ninja.getVila(),
                ninja.getIdade(),
                ninja.getChakra(),
                ninja.getJustus().stream().map(j -> j.getNome()).collect(java.util.stream.Collectors.toSet()),
                ninja.getCriadoEm()
        );
    }
}
