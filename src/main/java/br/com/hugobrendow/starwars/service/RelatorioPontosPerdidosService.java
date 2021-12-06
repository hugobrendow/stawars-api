package br.com.hugobrendow.starwars.service;

import br.com.hugobrendow.starwars.model.Rebelde;
import br.com.hugobrendow.starwars.repository.RebeldeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RelatorioPontosPerdidosService {
    private RebeldeRepository rebeldeRepository;

    public Integer pontosPerdidos() {
        List<Rebelde> traidores = rebeldeRepository.listarTraidores();
        return traidores.stream()
                .map(traidor -> traidor.getInventario())
                .flatMap(inventario -> inventario.getItens().stream())
                .map(itemInventario -> itemInventario.getItem().getPontos() * itemInventario.getQuantidade())
                .reduce(0, (valor, valorIndex) -> valor + valorIndex);
    }
}
