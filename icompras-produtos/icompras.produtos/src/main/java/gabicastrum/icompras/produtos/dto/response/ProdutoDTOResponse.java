package gabicastrum.icompras.produtos.dto.response;

import java.math.BigDecimal;

public record ProdutoDTOResponse(
        Long codigo,
        String nome,
        BigDecimal valorUnitario
) {}