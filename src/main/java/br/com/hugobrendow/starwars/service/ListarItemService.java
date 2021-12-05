package br.com.hugobrendow.starwars.service;

import br.com.hugobrendow.starwars.model.Item;
import br.com.hugobrendow.starwars.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListarItemService {
    private ItemRepository itemRepository;

    public List<Item> listarItens() {
        return itemRepository.findAll();
    }
}
