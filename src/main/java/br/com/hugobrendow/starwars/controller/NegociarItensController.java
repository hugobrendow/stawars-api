package br.com.hugobrendow.starwars.controller;

import br.com.hugobrendow.starwars.dto.request.negocio.NegocioRequest;
import br.com.hugobrendow.starwars.service.NegocioItensService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class NegociarItensController {
    private NegocioItensService negocioItensService;

    @ApiOperation(value = "Negociar itens com outro rebelde")
    @PostMapping("/v1/rebeldes/negociar")
    public ResponseEntity<Void> negociarItens(@RequestBody @Valid NegocioRequest negocioRequest) {
        negocioItensService.negociarItens(negocioRequest);
        return ResponseEntity.ok().build();
    }
}
