package br.com.hugobrendow.starwars.dto.request.item;

import lombok.Data;

import java.util.UUID;

@Data
public class ListarItemResponse {
    private UUID id;
    private String nome;
    private String pontos;
}
