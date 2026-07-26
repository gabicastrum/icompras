package gabicastrum.icompras.produtos.dto.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErroDTO(
        int statusCode,
        String error,
        String tipo,
        String mensagem,
        String componente,
        LocalDateTime timestamp
) {}