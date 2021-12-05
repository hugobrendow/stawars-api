package br.com.hugobrendow.starwars.dto.request;

import lombok.Data;

@Data
public class ItemInventarioRequest {
    private ItemRequest item;
    private Integer quantidade;
}
