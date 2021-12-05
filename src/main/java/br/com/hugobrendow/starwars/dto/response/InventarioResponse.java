package br.com.hugobrendow.starwars.dto.response;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class InventarioResponse {
    private List<ItemInventarioResponse> itemInventario = Collections.emptyList();
}
