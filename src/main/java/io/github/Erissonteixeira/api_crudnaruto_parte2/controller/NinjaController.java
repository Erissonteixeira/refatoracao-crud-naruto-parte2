package io.github.Erissonteixeira.api_crudnaruto_parte2.controller;

import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaRequestDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaResponseDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.service.NinjaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ninjas", description = "Endpoints responsáveis pelo gerenciamento de ninjas")
@RestController
@RequestMapping("api/v1/ninjas")
public class NinjaController {

    private final NinjaService service;

    public NinjaController(NinjaService service) {
        this.service = service;
    }

    @PostMapping
    public NinjaResponseDto criar(@RequestBody @Valid NinjaRequestDto dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<NinjaResponseDto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public NinjaResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public NinjaResponseDto atualizar(
            @PathVariable Long id,
            @RequestBody @Valid NinjaRequestDto dto
    ) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
