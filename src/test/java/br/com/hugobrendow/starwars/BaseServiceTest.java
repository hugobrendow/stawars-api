package br.com.hugobrendow.starwars;

import br.com.hugobrendow.starwars.dto.request.negocio.NegocioRequest;
import br.com.hugobrendow.starwars.dto.request.negocio.RebeldeNegocioRequest;
import br.com.hugobrendow.starwars.model.Genero;
import br.com.hugobrendow.starwars.model.Inventario;
import br.com.hugobrendow.starwars.model.Item;
import br.com.hugobrendow.starwars.model.ItemInventario;
import br.com.hugobrendow.starwars.model.Localizacao;
import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.repository.ItemRepository;
import br.com.hugobrendow.starwars.repository.RebeldeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseServiceTest {
    @MockBean
    protected RebeldeRepository rebeldeRepository;

    @MockBean
    protected ItemRepository itemRepository;

    @Test
    public void validateRebelde() {
        Rebelde rebelde = getRebelde();
        assertEquals(rebelde.getNome(), "Hugo Brendow");
    }

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
        inventario.setItens(Arrays.asList(getItemInventario()));
        return inventario;
    }

    protected Localizacao getLocalizacao() {
        Localizacao localizacao = new Localizacao();
        localizacao.setBase("Base Test");
        localizacao.setLatitude("123");
        localizacao.setLongitude("21312");
        return localizacao;
    }

    protected Localizacao getLocalizacaoAlterada() {
        Localizacao localizacao = new Localizacao();
        localizacao.setBase("Base Test Alterada");
        localizacao.setLatitude("1235");
        localizacao.setLongitude("213125");
        return localizacao;
    }

    protected Item getItem() {
        Item item = new Item();
        item.setId(UUID.fromString("340aff20-563a-11ec-bf63-0242ac130002"));
        item.setNome("Espada");
        item.setPontos(200);
        return item;
    }

    protected ItemInventario getItemInventario() {
        ItemInventario itemInventario = new ItemInventario();
        itemInventario.setItem(getItem());
        itemInventario.setQuantidade(1);
        itemInventario.setId(UUID.fromString("340aff20-563a-11ec-bf63-0242ac130002"));
        return itemInventario;
    }

    protected NegocioRequest getNegocioRequest() {
        NegocioRequest negocioRequest = new NegocioRequest();

        RebeldeNegocioRequest rebeldeNegociante = new RebeldeNegocioRequest();
        rebeldeNegociante.setId(UUID.fromString("d2e6ee48-5693-11ec-bf63-0242ac130002"));
        rebeldeNegociante.setItens(Arrays.asList(getItemInventario()));

        RebeldeNegocioRequest rebeldeNegociador = new RebeldeNegocioRequest();
        rebeldeNegociador.setId(UUID.fromString("f1253df6-5693-11ec-bf63-0242ac130002"));
        rebeldeNegociador.setItens(Arrays.asList(getItemInventario()));

        negocioRequest.setRebeldeNegociante(rebeldeNegociante);
        negocioRequest.setRebeldeNegociador(rebeldeNegociador);

        return negocioRequest;
    }
}
