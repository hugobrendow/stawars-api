package br.com.hugobrendow.starwars.controller;

import br.com.hugobrendow.starwars.service.RelatorioRebeldesService;
import br.com.hugobrendow.starwars.service.RelatorioTraidoresService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RelatorioRebeldesController {
    private RelatorioRebeldesService relatorioRebeldesService;

    @ApiOperation(value = "Relatório de rebeldes")
    @GetMapping("/v1/rebeldes/relatorios")
    public ResponseEntity<?> relatorioRebeldes() {
        return ResponseEntity.ok(relatorioRebeldesService.porcentagemRebeldes());
    }
}
