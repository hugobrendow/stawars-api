package br.com.hugobrendow.starwars;

import br.com.hugobrendow.starwars.exception.RebeldeNaoEncontradoException;
import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.service.AtualizarLocalizacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class AtualizarLocalizacaoServiceTest extends BaseServiceTest {
    @Autowired
    private AtualizarLocalizacaoService atualizarLocalizacaoService;

    @BeforeEach
    public void setup() {
        Rebelde rebelde = getRebelde();
        rebelde.setLocalizacao(getLocalizacaoAlterada());
        Mockito.when(rebeldeRepository.findById(UUID.fromString("340aff20-563a-11ec-bf63-0242ac130002"))).thenReturn(Optional.of(getRebelde()));
        Mockito.when(rebeldeRepository.save(Mockito.any())).thenReturn(rebelde);
    }

    @Test
    public void atualizarLocalizacao() {
        Rebelde rebelde = atualizarLocalizacaoService.atualizarLocalizacao(UUID.fromString("340aff20-563a-11ec-bf63-0242ac130002"), getLocalizacaoAlterada());
        assertThat(rebelde.getLocalizacao().getBase()).isEqualTo(getLocalizacaoAlterada().getBase());
        assertThat(rebelde.getLocalizacao().getLatitude()).isEqualTo(getLocalizacaoAlterada().getLatitude());
        assertThat(rebelde.getLocalizacao().getLongitude()).isEqualTo(getLocalizacaoAlterada().getLongitude());
    }

    @Test
    public void atualizarLocalizacaoRebeldeNaoEncontradoException() {
        assertThrows(RebeldeNaoEncontradoException.class, () ->
                atualizarLocalizacaoService.atualizarLocalizacao(UUID.fromString("99266258-5641-11ec-bf63-0242ac130002"), getLocalizacaoAlterada()));
    }
}
