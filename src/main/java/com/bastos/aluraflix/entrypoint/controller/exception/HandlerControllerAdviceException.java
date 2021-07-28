package com.bastos.aluraflix.entrypoint.controller.exception;

import com.bastos.aluraflix.entrypoint.controller.exception.enums.UrlErroEnum;
import com.bastos.aluraflix.entrypoint.model.response.CampoMensagemErrorModelResponse;
import com.bastos.aluraflix.entrypoint.model.response.MensagemErrorModelResponse;
import com.bastos.aluraflix.exception.ErroInternoServidor;
import com.bastos.aluraflix.exception.NenhumConteudoException;
import com.bastos.aluraflix.exception.VideoNaoRegistradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class HandlerControllerAdviceException extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(NenhumConteudoException.class)
    public ResponseEntity<?> handleNoContent() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler({ ErroInternoServidor.class })
    public ResponseEntity<?> handleInternalServer(Exception exception) {
        MensagemErrorModelResponse mensagemErrorModelResponse = MensagemErrorModelResponse.builder()
                .codigo(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .mensagem(exception.getMessage())
                .urlErro(UrlErroEnum.buscaUrl(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .build();

        return new ResponseEntity<>(mensagemErrorModelResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ VideoNaoRegistradoException.class })
    public ResponseEntity<?> handleNotFound(Exception exception) {
        MensagemErrorModelResponse mensagemErrorModelResponse = MensagemErrorModelResponse.builder()
                .codigo(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .mensagem(exception.getMessage())
                .urlErro(UrlErroEnum.buscaUrl(HttpStatus.NOT_FOUND.value()))
                .build();

        return new ResponseEntity<>(mensagemErrorModelResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        MensagemErrorModelResponse mensagemErrorModelResponse = new MensagemErrorModelResponse();
        List<CampoMensagemErrorModelResponse> campoMensagemErrorModelResponses = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            CampoMensagemErrorModelResponse campoMensagemErrorModelResponse = new CampoMensagemErrorModelResponse();
            campoMensagemErrorModelResponse.setCampo(e.getField());
            campoMensagemErrorModelResponse.setMensagem(mensagem);

            campoMensagemErrorModelResponses.add(campoMensagemErrorModelResponse);
        });

        mensagemErrorModelResponse.setCodigo(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        mensagemErrorModelResponse.setMensagem("Houve um erro no momento da requisição, é necessário corrigir.");
        mensagemErrorModelResponse.setUrlErro(UrlErroEnum.buscaUrl(HttpStatus.BAD_REQUEST.value()));
        mensagemErrorModelResponse.setCampos(campoMensagemErrorModelResponses);

        return new ResponseEntity<>(mensagemErrorModelResponse, HttpStatus.BAD_REQUEST);
    }
}
