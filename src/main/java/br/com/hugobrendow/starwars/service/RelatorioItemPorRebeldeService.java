package br.com.hugobrendow.starwars.service;

import br.com.hugobrendow.starwars.dto.response.relatorio.ItemPorRebeldeResponse;
import br.com.hugobrendow.starwars.dto.response.relatorio.RelatorioItemPorRebeldeResponse;
import br.com.hugobrendow.starwars.model.Item;
import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.repository.ItemRepository;
import br.com.hugobrendow.starwars.repository.RebeldeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RelatorioItemPorRebeldeService {
    private RebeldeRepository rebeldeRepository;
    private ItemRepository itemRepository;

    public RelatorioItemPorRebeldeResponse armasPorRebelde() {
        List<Rebelde> rebeldes = rebeldeRepository.findAll();
        List<Item> itens = itemRepository.findAll();

        List<ItemPorRebeldeResponse> itemPorRebeldeResponses = new ArrayList<>();
        itens.stream()
                .map(item -> {
                    long rebeldesItem = rebeldes.stream()
                            .filter(rebelde -> rebelde.getInventario().getItens().stream().anyMatch(itemRebelde -> itemRebelde.getItem().getId().equals(item.getId())))
                            .count();

                    ItemPorRebeldeResponse itemPorRebeldeResponse = ItemPorRebeldeResponse.builder()
                            .item(item.getNome())
                            .mediaPorRebelde(Double.valueOf(rebeldes.size()) / Double.valueOf(rebeldesItem))
                            .build();
                    itemPorRebeldeResponses.add(itemPorRebeldeResponse);
                    return itemPorRebeldeResponse;
                });
        return RelatorioItemPorRebeldeResponse.builder().armaPorRebelde(itemPorRebeldeResponses).build();
    }
}
