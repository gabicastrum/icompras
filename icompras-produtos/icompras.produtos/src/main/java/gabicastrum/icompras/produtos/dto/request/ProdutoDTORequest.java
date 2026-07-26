package gabicastrum.icompras.produtos;

import java.math.BigDecimal;

public record ProdutoDTORequest(

        String nome,
        BigDecimal valorUnitario
) {}
