package br.com.hugobrendow.starwars.dto.request.negocio;

import br.com.hugobrendow.starwars.model.ItemInventario;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class RebeldeNegocioRequest {
    private UUID id;
    private List<ItemInventario> itens;
}
