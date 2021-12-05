package br.com.hugobrendow.starwars.service;

import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.repository.RebeldeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListarRebeldeService {
    private RebeldeRepository rebeldeRepository;

    public List<Rebelde> listarRebeldes() {
        return rebeldeRepository.findAll();
    }
}
