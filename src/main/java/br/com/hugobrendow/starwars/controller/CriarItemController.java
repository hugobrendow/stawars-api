package br.com.hugobrendow.starwars.controller;

import br.com.hugobrendow.starwars.dto.request.item.CriarItemRequest;
import br.com.hugobrendow.starwars.mapper.RebeldeMapper;
import br.com.hugobrendow.starwars.model.Item;
import br.com.hugobrendow.starwars.service.CriarItemService;
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
public class CriarItemController {
    private CriarItemService itemService;

    @ApiOperation(value = "Salvar um novo item")
    @PostMapping("/v1/itens")
    public ResponseEntity<?> salvarItem(@RequestBody @Valid CriarItemRequest itemRequest) {
        Item item = itemService.salvarItem(RebeldeMapper.INSTANCE.criarItemRequestToItemEntity(itemRequest));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(item.getId().toString()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
