package br.com.hugobrendow.starwars.dto.request;

import br.com.hugobrendow.starwars.model.Genero;
import lombok.Data;

@Data
public class CriarRebeldeRequest {
    private String nome;
    private Integer idade;
    private Genero genero;
    private Integer acusacoes = 0;
    private LocalizacaoRequest localizacao;
    private InventarioRequest inventario;
}
