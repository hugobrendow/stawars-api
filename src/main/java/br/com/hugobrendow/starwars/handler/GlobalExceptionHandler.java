package br.com.hugobrendow.starwars.handler;

import br.com.hugobrendow.starwars.dto.response.BaseResponse;
import br.com.hugobrendow.starwars.exception.AppErrors;
import br.com.hugobrendow.starwars.exception.BaseException;
import br.com.hugobrendow.starwars.exception.InventarioVazioException;
import br.com.hugobrendow.starwars.exception.ItemInvalidoException;
import br.com.hugobrendow.starwars.exception.RebeldeBloqueadoTransacionarException;
import br.com.hugobrendow.starwars.exception.RebeldeNaoEncontradoException;
import br.com.hugobrendow.starwars.exception.ValoresInvalidosException;
import br.com.hugobrendow.starwars.exception.message.BaseMessageSource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;


@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final BaseMessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
        if (BaseException.class.isAssignableFrom(e.getClass())) {
            return handleException(((BaseException) e).error(), e.getMessage(), e);
        }

        return handleException(AppErrors.SERVER_ERROR, e.getMessage(), e);
    }

    @ExceptionHandler(InventarioVazioException.class)
    public ResponseEntity<Object> handleInventarioVazioException(InventarioVazioException e, WebRequest request) {
        return handleException(AppErrors.INVENTARIO_VAZIO, e.getMessage(), e);
    }

    @ExceptionHandler(ItemInvalidoException.class)
    public ResponseEntity<Object> handleItemInvalidoException(ItemInvalidoException e, WebRequest request) {
        return handleException(AppErrors.ITEM_INVALIDO, e.getMessage(), e);
    }

    @ExceptionHandler(RebeldeBloqueadoTransacionarException.class)
    public ResponseEntity<Object> handleRebeldeBloqueadoTransacionarException(RebeldeBloqueadoTransacionarException e, WebRequest request) {
        return handleException(AppErrors.REBELDE_BLOQUEADO_TRANSACIONAR, e.getMessage(), e);
    }

    @ExceptionHandler(RebeldeNaoEncontradoException.class)
    public ResponseEntity<Object> handleRebeldeNaoEncontradoException(RebeldeNaoEncontradoException e, WebRequest request) {
        return handleException(AppErrors.REBELDE_NAO_ENCONTRADO, e.getMessage(), e);
    }

    @ExceptionHandler(ValoresInvalidosException.class)
    public ResponseEntity<Object> handleValoresInvalidosException(ValoresInvalidosException e, WebRequest request) {
        return handleException(AppErrors.VALORES_INVALIDOS_NEGOCIACAO, e.getMessage(), e);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleException(AppErrors.BAD_REQUEST_ERROR, e.getMessage(), e);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleException(AppErrors.METHOD_NOT_ALLOWED_ERROR, e.getMessage(), e);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException e, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest request) {
        return handleException(AppErrors.NOT_FOUND_ERROR, e.getMessage(), e);
    }

    private ResponseEntity<Object> handleException(AppErrors error, String message, Exception e) {
        return handleException(error, new Object[]{message}, e);
    }

    private ResponseEntity<Object> handleException(AppErrors error, Object[] params, Exception e) {
        String message = messageSource.getMessage(error, params);
        logger.error(message, e);

        return ResponseEntity.status(error.getHttpStatus())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BaseResponse.notOk(error.getCode(), message, error.getDetails()));
    }

    private ResponseEntity<Object> handleException(AppErrors error, List<BaseResponse.Error> errors, Exception e) {
        logger.error("Error", e);

        return ResponseEntity.status(error.getHttpStatus())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(BaseResponse.notOk(errors));
    }

}
