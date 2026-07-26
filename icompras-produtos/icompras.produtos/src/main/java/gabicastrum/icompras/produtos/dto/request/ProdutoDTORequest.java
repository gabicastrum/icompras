package gabicastrum.icompras.produtos.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProdutoDTORequest(

        @NotBlank(message = "O nome do produto é obrigatório")
        String nome,

        @NotNull(message = "O valor unitário é obrigatório")
        @DecimalMin(value = "0.0", inclusive = false, message = "O valor unitário deve ser maior que zero")
        BigDecimal valorUnitario
) {}