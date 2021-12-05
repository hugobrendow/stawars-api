package br.com.hugobrendow.starwars.service;

import br.com.hugobrendow.starwars.model.Localizacao;
import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.repository.RebeldeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AtualizarLocalizacaoService {
    private RebeldeRepository rebeldeRepository;

    public Rebelde atualizarLocalizacao(UUID id, Localizacao localizacao) {
        Rebelde rebelde = rebeldeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        rebelde.setLocalizacao(localizacao);
        return rebeldeRepository.save(rebelde);
    }
}
