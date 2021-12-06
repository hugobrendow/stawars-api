package br.com.hugobrendow.starwars.service;

import br.com.hugobrendow.starwars.exception.RebeldeNaoEncontradoException;
import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.repository.RebeldeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ReportarRebeldeService {
    private RebeldeRepository rebeldeRepository;

    public Rebelde reportarTraidor(UUID id) {
        Rebelde rebelde = rebeldeRepository.findById(id).orElseThrow(() -> new RebeldeNaoEncontradoException());
        Integer acusacoesAtualizadas = rebelde.getAcusacoes()+1;
        rebelde.setAcusacoes(acusacoesAtualizadas);
        return rebeldeRepository.save(rebelde);
    }
}
