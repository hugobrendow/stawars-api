package br.com.hugobrendow.starwars.controller;

import br.com.hugobrendow.starwars.dto.request.RebeldeRequest;
import br.com.hugobrendow.starwars.mapper.RebeldeMapper;
import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.service.CriarRebeldeService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@AllArgsConstructor
public class CriarRebeldeController {
    private CriarRebeldeService criarRebeldeService;

    @ApiOperation(value = "Salvar um novo rebelde")
    @PostMapping
    public ResponseEntity<?> salvarRebelde(@RequestBody @Valid RebeldeRequest rebeldeRequest) {
        Rebelde rebelde = criarRebeldeService.salvarRebelde(RebeldeMapper.INSTANCE.rebeldeRequestToRebeldeEntity(rebeldeRequest));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(rebelde.getId().toString()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
