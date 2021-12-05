package br.com.hugobrendow.starwars.controller;

import br.com.hugobrendow.starwars.mapper.RebeldeMapper;
import br.com.hugobrendow.starwars.service.ListarRebeldeService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ListarRebeldeController {
    private ListarRebeldeService listarRebeldeService;

    @ApiOperation(value = "Listar todos rebeldes")
    @GetMapping("/v1/rebeldes")
    public ResponseEntity<?> listarRebeldes() {
        return ResponseEntity.ok(RebeldeMapper.INSTANCE.rebeldeEntityToRebeldeResponse(listarRebeldeService.listarRebeldes()));
    }
}
