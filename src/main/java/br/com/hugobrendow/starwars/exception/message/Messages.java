package br.com.hugobrendow.starwars.exception.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Messages {
    TEMP("message.temp");

    @Getter
    private final String value;
}