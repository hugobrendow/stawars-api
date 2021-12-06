package br.com.hugobrendow.starwars.exception;

public abstract class BaseException extends RuntimeException {
    public abstract AppErrors error();
}
