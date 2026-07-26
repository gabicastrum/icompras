package gabicastrum.icompras.produtos.exception;

public class RegraDeNegocioException extends AplicacaoException {

    public RegraDeNegocioException(String componente, String mensagem) {
        super(componente, mensagem);
    }
}