package br.com.hugobrendow.starwars;

import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.service.CriarRebeldeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class CriarRebeldeServiceTest extends BaseServiceTest {
    @Autowired
    private CriarRebeldeService criarRebeldeService;

    @Before
    public void setup() {
        Mockito.when(rebeldeRepository.save(Mockito.any())).thenReturn(getRebelde());
    }

    @Test
    public void criarRebelde() {
        Rebelde rebelde = criarRebeldeService.salvarRebelde(getRebelde());
        assertThat(rebelde.getNome()).isEqualTo("Hugo Brendow");
    }
}
