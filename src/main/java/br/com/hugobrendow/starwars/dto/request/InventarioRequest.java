package br.com.hugobrendow.starwars.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class InventarioRequest {
    private List<ItemInventarioRequest> itemInventario;
}
