package br.com.hugobrendow.starwars;

import br.com.hugobrendow.starwars.exception.RebeldeNaoEncontradoException;
import br.com.hugobrendow.starwars.service.NegocioItensService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class NegocioItensServiceTest extends BaseServiceTest {
    @Autowired
    private NegocioItensService negocioItensService;

    @Before
    public void setup() {
        Mockito.when(rebeldeRepository.findById(UUID.fromString("340aff20-563a-11ec-bf63-0242ac130002"))).thenReturn(Optional.of(getRebelde()));
    }

    @Test
    public void negocioRebeldeNaoEncontrado() {
        assertThrows(RebeldeNaoEncontradoException.class, () ->
                negocioItensService.negociarItens(getNegocioRequest()));
    }

    @Test
    public void negocioRebeldeCompleto() {
        Mockito.when(rebeldeRepository.findById(UUID.fromString("d2e6ee48-5693-11ec-bf63-0242ac130002"))).thenReturn(Optional.of(getRebelde()));
        Mockito.when(rebeldeRepository.findById(UUID.fromString("f1253df6-5693-11ec-bf63-0242ac130002"))).thenReturn(Optional.of(getRebelde()));
        Mockito.when(rebeldeRepository.save(Mockito.any())).thenReturn(getRebelde());

        negocioItensService.negociarItens(getNegocioRequest());
        verify(rebeldeRepository, times(2)).save(Mockito.any());
    }
}
