package br.com.hugobrendow.starwars.service;

import br.com.hugobrendow.starwars.dto.response.relatorio.RelatorioTraidores;
import br.com.hugobrendow.starwars.repository.RebeldeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RelatorioRebeldesService {
    private RebeldeRepository rebeldeRepository;

    public RelatorioTraidores porcentagemRebeldes() {
        Double totalRebeldes = Double.valueOf(rebeldeRepository.count());
        Double totalTraidores = Double.valueOf(rebeldeRepository.listarTraidores().stream().count());

        Double porcentagem = (totalTraidores / totalRebeldes) * Double.valueOf(100);
        porcentagem = (porcentagem - 100) * -1;
        return RelatorioTraidores.builder().traidores(String.format("%.0f%%", porcentagem)).build();
    }
}
