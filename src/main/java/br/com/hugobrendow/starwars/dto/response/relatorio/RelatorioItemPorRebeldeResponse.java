package br.com.hugobrendow.starwars.dto.response.relatorio;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RelatorioItemPorRebeldeResponse {
    private List<ItemPorRebeldeResponse> armaPorRebelde;
}
