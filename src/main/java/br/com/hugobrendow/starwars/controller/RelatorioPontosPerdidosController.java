package br.com.hugobrendow.starwars.controller;

import br.com.hugobrendow.starwars.service.RelatorioPontosPerdidosService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RelatorioPontosPerdidosController {
    private RelatorioPontosPerdidosService relatorioPontosPerdidosService;

    @ApiOperation(value = "Relatório de pontos perdidos por traidores")
    @GetMapping("/v1/rebeldes/relatorios/pontos-perdidos")
    public ResponseEntity<?> relatorioArmasPorRebelde() {
        return ResponseEntity.ok(relatorioPontosPerdidosService.pontosPerdidos());
    }
}
