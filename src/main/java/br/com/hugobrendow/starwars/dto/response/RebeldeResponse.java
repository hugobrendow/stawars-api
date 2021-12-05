package br.com.hugobrendow.starwars.dto.response;

import br.com.hugobrendow.starwars.model.Genero;
import lombok.Data;

@Data
public class RebeldeResponse {
    private String nome;
    private Integer idade;
    private Genero genero;
    private Integer acusacoes = 0;
    private LocalizacaoResponse localizacao;
    private InventarioResponse inventario;
}
