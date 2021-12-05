package br.com.hugobrendow.starwars.service;

import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.repository.RebeldeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarRebeldeService {
    private RebeldeRepository rebeldeRepository;

    public Rebelde salvarRebelde(Rebelde rebelde) {
        return rebeldeRepository.save(rebelde);
    }
}
