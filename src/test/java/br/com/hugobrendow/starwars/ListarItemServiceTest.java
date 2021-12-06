package br.com.hugobrendow.starwars;

import br.com.hugobrendow.starwars.model.Item;
import br.com.hugobrendow.starwars.service.ListarItemService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListarItemServiceTest extends BaseServiceTest {
    @Autowired
    private ListarItemService listarItemService;

    @Before
    public void setup() {
        Mockito.when(itemRepository.findAll()).thenReturn(Arrays.asList(getItem()));
    }

    @Test
    public void listarItens() {
        List<Item> itens = listarItemService.listarItens();
        assertThat(itens.size()).isEqualTo(1);
    }
}
