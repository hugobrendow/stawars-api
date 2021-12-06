package br.com.hugobrendow.starwars;

import br.com.hugobrendow.starwars.model.Genero;
import br.com.hugobrendow.starwars.model.Inventario;
import br.com.hugobrendow.starwars.model.Item;
import br.com.hugobrendow.starwars.model.Localizacao;
import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.repository.ItemRepository;
import br.com.hugobrendow.starwars.repository.RebeldeRepository;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseServiceTest {
    @MockBean
    protected RebeldeRepository rebeldeRepository;

    @MockBean
    protected ItemRepository itemRepository;

    protected Rebelde getRebelde() {
        Rebelde rebelde = new Rebelde();
        rebelde.setAcusacoes(0);
        rebelde.setId(UUID.fromString("583ed93c-5637-11ec-bf63-0242ac130002"));
        rebelde.setLocalizacao(getLocalizacao());
        rebelde.setGenero(Genero.MASCULINO);
        rebelde.setIdade(24);
        rebelde.setNome("Hugo Brendow");
        rebelde.setInventario(getInventario());
        return rebelde;
    }

    protected Inventario getInventario() {
        Inventario inventario = new Inventario();
        return inventario;
    }

    protected Localizacao getLocalizacao() {
        Localizacao localizacao = new Localizacao();
        localizacao.setBase("Base Test");
        localizacao.setLatitude("123");
        localizacao.setLongitude("21312");
        return localizacao;
    }

    protected Item getItem() {
        Item item = new Item();
        item.setId(UUID.fromString("340aff20-563a-11ec-bf63-0242ac130002"));
        item.setNome("Espada");
        item.setPontos(200);
        return item;
    }
}
