package br.com.hugobrendow.starwars.dto.response.relatorio;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RelatorioTraidores {
    private String traidores;
}
