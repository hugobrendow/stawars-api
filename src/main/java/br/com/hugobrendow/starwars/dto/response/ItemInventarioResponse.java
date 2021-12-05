package br.com.hugobrendow.starwars.dto.response;

import lombok.Data;

@Data
public class ItemInventarioResponse {
    private ItemResponse item;
    private Integer quantidade;
}
