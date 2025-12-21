package io.github.Erissonteixeira.api_crudnaruto_parte2.controller;

import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaRequestDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaResponseDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.service.NinjaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
