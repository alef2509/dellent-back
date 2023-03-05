package br.com.dellent.labseq.config;

import br.com.dellent.labseq.sequencia.exception.ValorInvalidoException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValorInvalidoException.class)
    public ResponseEntity<Object> handleValorInvalidoException(ValorInvalidoException ex) {
        String mensagem = "O valor informado é inválido";
        CustomErrorResponse erro = new CustomErrorResponse(HttpStatus.BAD_REQUEST, mensagem);
        return new ResponseEntity<>(erro, erro.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        CustomErrorResponse erro = new CustomErrorResponse(status, ex.getMessage());
        return new ResponseEntity<>(erro, status);
    }

    static class CustomErrorResponse {
        private final HttpStatus status;
        private final String mensagem;

        public CustomErrorResponse(HttpStatus status, String mensagem) {
            this.status = status;
            this.mensagem = mensagem;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public String getMensagem() {
            return mensagem;
        }
    }
}