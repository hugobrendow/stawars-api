package br.com.hugobrendow.starwars.dto.request;

import lombok.Data;

@Data
public class LocalizacaoRequest {
    private String latitude;
    private String longitude;
    private String base;
}
