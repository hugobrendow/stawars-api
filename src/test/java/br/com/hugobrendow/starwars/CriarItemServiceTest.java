package br.com.hugobrendow.starwars;

import br.com.hugobrendow.starwars.model.Item;
import br.com.hugobrendow.starwars.service.CriarItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CriarItemServiceTest extends BaseServiceTest {
    @Autowired
    private CriarItemService criarItemService;

    @BeforeEach
    public void setup() {
        Mockito.when(itemRepository.save(Mockito.any())).thenReturn(getItem());
    }

    @Test
    public void criarItem() {
        Item item = criarItemService.salvarItem(getItem());
        assertThat(item.getId()).isEqualTo(UUID.fromString("340aff20-563a-11ec-bf63-0242ac130002"));
    }
}
