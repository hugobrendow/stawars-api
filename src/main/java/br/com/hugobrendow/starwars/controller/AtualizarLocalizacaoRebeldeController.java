package br.com.hugobrendow.starwars.controller;

import br.com.hugobrendow.starwars.dto.request.LocalizacaoRequest;
import br.com.hugobrendow.starwars.mapper.RebeldeMapper;
import br.com.hugobrendow.starwars.model.Localizacao;
import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.service.AtualizarLocalizacaoService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class AtualizarLocalizacaoRebeldeController {
    private AtualizarLocalizacaoService atualizarLocalizacaoService;

    @ApiOperation(value = "Atualizar localização de um rebelde")
    @PutMapping("/v1/rebeldes/localizacao/{idRebelde}")
    public ResponseEntity<Rebelde> atualizarLocalizacao(@PathVariable UUID idRebelde,
                                                               @RequestBody LocalizacaoRequest localizacaoDto) {
        Localizacao localizacao = RebeldeMapper.INSTANCE.localizacaoRequestToLocalizacaoEntity(localizacaoDto);
        return ResponseEntity.ok(atualizarLocalizacaoService.atualizarLocalizacao(idRebelde, localizacao));
    }
}
