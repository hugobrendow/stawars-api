package br.com.hugobrendow.starwars.service;

import br.com.hugobrendow.starwars.dto.response.relatorio.RelatorioTraidores;
import br.com.hugobrendow.starwars.repository.RebeldeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RelatorioTraidoresService {
    private RebeldeRepository rebeldeRepository;

    public RelatorioTraidores porcentagemTraidores() {
        Double totalRebeldes = Double.valueOf(rebeldeRepository.count());
        Double totalTraidores = Double.valueOf(rebeldeRepository.listarTraidores().stream().count());

        Double porcentagem = (totalTraidores / totalRebeldes) * Double.valueOf(100);
        return RelatorioTraidores.builder().traidores(String.format("%.0f%%", porcentagem)).build();
    }
}
