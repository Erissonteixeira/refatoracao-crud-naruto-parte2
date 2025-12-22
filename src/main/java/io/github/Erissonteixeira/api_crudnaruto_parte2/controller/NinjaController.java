package io.github.Erissonteixeira.api_crudnaruto_parte2.controller;

import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaRequestDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.dto.NinjaResponseDto;
import io.github.Erissonteixeira.api_crudnaruto_parte2.domain.service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Cadastrar um novo ninja")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public NinjaResponseDto criar(@RequestBody @Valid NinjaRequestDto dto) {
        return service.criar(dto);
    }

    @Operation(summary = "Listar todos os ninjas cadastrados")
    @ApiResponse(responseCode = "200", description = "Lista de ninjas retomada com sucesso")
    @GetMapping
    public List<NinjaResponseDto> listar() {
        return service.listar();
    }

    @Operation(summary = "Buscar um ninja pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja encontrado"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    @GetMapping("/{id}")
    public NinjaResponseDto buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualizar um ninja pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    @PutMapping("/{id}")
    public NinjaResponseDto atualizar(
            @PathVariable Long id,
            @RequestBody @Valid NinjaRequestDto dto
    ) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Deletar um ninja pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
