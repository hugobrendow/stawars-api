package br.com.hugobrendow.starwars.controller;

import br.com.hugobrendow.starwars.mapper.RebeldeMapper;
import br.com.hugobrendow.starwars.service.ReportarRebeldeService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class ReportarRebeldeController {
    private ReportarRebeldeService reportarRebeldeService;

    @ApiOperation(value = "Reportar traição de rebelde")
    @PutMapping("/v1/rebeldes/reportar-traidor/{idRebelde}")
    public ResponseEntity<?> reportarTraidor(@PathVariable UUID idRebelde) {
        return ResponseEntity.ok(RebeldeMapper.INSTANCE.rebeldeEntityToRebeldeResponse(reportarRebeldeService.reportarTraidor(idRebelde)));
    }
}
