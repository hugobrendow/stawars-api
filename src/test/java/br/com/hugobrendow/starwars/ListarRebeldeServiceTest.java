package br.com.hugobrendow.starwars;

import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.service.ListarRebeldeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListarRebeldeServiceTest extends BaseServiceTest {
    @Autowired
    private ListarRebeldeService listarRebeldeService;

    @Before
    public void setup() {
        Mockito.when(rebeldeRepository.findAll()).thenReturn(Arrays.asList(getRebelde()));
    }

    @Test
    public void listarRebeldes() {
        List<Rebelde> rebeldes = listarRebeldeService.listarRebeldes();
        assertThat(rebeldes.size()).isEqualTo(1);
    }
}
