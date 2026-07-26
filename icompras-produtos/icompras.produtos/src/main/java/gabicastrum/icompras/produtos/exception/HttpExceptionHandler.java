package gabicastrum.icompras.produtos.exception;

import gabicastrum.icompras.produtos.dto.response.ErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<ErroDTO> tratarNaoEncontrado(ProdutoNaoEncontradoException ex) {
        return construirResposta(HttpStatus.NOT_FOUND, "Recurso não encontrado", ex);
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<ErroDTO> tratarRegraViolada(RegraDeNegocioException ex) {
        return construirResposta(HttpStatus.UNPROCESSABLE_ENTITY, "Regra de negócio violada", ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroDTO> tratarErroGenerico(Exception ex) {
        var erro = ErroDTO.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Erro interno")
                .tipo("ERRO_INESPERADO")
                .mensagem(ex.getMessage())
                .componente("Desconhecido")
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

    private ResponseEntity<ErroDTO> construirResposta(HttpStatus status, String error, AplicacaoException ex) {
        var erro = ErroDTO.builder()
                .statusCode(status.value())
                .error(error)
                .tipo(ex.getClass().getSimpleName())
                .mensagem(ex.getMessage())
                .componente(ex.getComponente())
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(status).body(erro);
    }
}