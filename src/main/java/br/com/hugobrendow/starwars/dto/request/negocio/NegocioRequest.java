package br.com.hugobrendow.starwars.dto.request.negocio;

import lombok.Data;

@Data
public class NegocioRequest {
    private RebeldeNegocioRequest rebeldeNegociador;
    private RebeldeNegocioRequest rebeldeNegociante;
}
