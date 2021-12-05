package br.com.hugobrendow.starwars.dto.response;

import lombok.Data;

@Data
public class LocalizacaoResponse {
    private String latitude;
    private String longitude;
    private String base;
}
