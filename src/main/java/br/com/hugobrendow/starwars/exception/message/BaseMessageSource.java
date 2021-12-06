package br.com.hugobrendow.starwars.exception.message;

import br.com.hugobrendow.starwars.exception.AppErrors;
import org.springframework.stereotype.Component;

@Component
public interface BaseMessageSource {
    String getMessage(String resource, Object[] params);
    String getMessage(AppErrors error, Object[] params);
}