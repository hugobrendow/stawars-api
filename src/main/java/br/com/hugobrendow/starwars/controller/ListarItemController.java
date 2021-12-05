package br.com.hugobrendow.starwars.controller;

import br.com.hugobrendow.starwars.mapper.RebeldeMapper;
import br.com.hugobrendow.starwars.service.ListarItemService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ListarItemController {
    private ListarItemService itemService;

    @ApiOperation(value = "Listar todos rebeldes")
    @GetMapping("/v1/itens")
    public ResponseEntity<?> listarItens() {
        return ResponseEntity.ok(RebeldeMapper.INSTANCE.itemEntityToListarItemResponse(itemService.listarItens()));
    }
}
