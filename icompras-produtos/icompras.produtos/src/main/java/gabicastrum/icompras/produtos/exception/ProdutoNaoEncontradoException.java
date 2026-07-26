package gabicastrum.icompras.produtos.exception;

public class ProdutoNaoEncontradoException extends AplicacaoException {

    public ProdutoNaoEncontradoException(String componente, String mensagem) {
        super(componente, mensagem);
    }
}