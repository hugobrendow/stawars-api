package br.com.hugobrendow.starwars.controller;

import br.com.hugobrendow.starwars.service.RelatorioTraidoresService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RelatorioArmasPorRebeldeController {
    private RelatorioTraidoresService relatorioTraidoresService;

    @ApiOperation(value = "Relatório de armas por rebeldes")
    @GetMapping("/v1/rebeldes/relatorios/armas")
    public ResponseEntity<?> relatorioArmasPorRebelde() {
        return ResponseEntity.ok(relatorioTraidoresService.porcentagemTraidores());
    }
}
