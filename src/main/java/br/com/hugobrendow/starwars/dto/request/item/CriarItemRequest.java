package br.com.hugobrendow.starwars.dto.request.item;

import lombok.Data;

@Data
public class CriarItemRequest {
    private String nome;
    private String pontos;
}
