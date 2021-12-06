package br.com.hugobrendow.starwars;

import br.com.hugobrendow.starwars.exception.RebeldeNaoEncontradoException;
import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.service.ReportarRebeldeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class ReportarRebeldeServiceTest extends BaseServiceTest {
    @Autowired
    private ReportarRebeldeService reportarRebeldeService;

    @BeforeEach
    public void setup() {
        Mockito.when(rebeldeRepository.findById(UUID.fromString("583ed93c-5637-11ec-bf63-0242ac130002"))).thenReturn(Optional.of(getRebelde()));
        Rebelde rebelde = getRebelde();
        rebelde.setAcusacoes(1);
        Mockito.when(rebeldeRepository.save(Mockito.any())).thenReturn(rebelde);
    }

    @Test
    public void reportarRebelde() {
        Rebelde rebelde = reportarRebeldeService.reportarTraidor(UUID.fromString("583ed93c-5637-11ec-bf63-0242ac130002"));
        assertThat(rebelde.getNome()).isEqualTo("Hugo Brendow");
        assertThat(rebelde.getAcusacoes()).isEqualTo(1);
    }

    @Test
    public void reportarRebeldeNaoEncontrado() {
        assertThrows(RebeldeNaoEncontradoException.class, () -> reportarRebeldeService.reportarTraidor(UUID.fromString("45e21270-5639-11ec-bf63-0242ac130002")));
    }
}
