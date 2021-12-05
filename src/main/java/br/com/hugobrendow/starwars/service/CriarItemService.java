package br.com.hugobrendow.starwars.service;

import br.com.hugobrendow.starwars.model.Item;
import br.com.hugobrendow.starwars.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarItemService {
    private ItemRepository itemRepository;

    public Item salvarItem(Item item) {
        return itemRepository.save(item);
    }
}
