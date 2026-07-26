package gabicastrum.icompras.produtos.exception;

public class AplicacaoException extends RuntimeException {

    private final String componente;

    public AplicacaoException(String componente, String mensagem) {
        super(mensagem);
        this.componente = componente;
    }

    public String getComponente() {
        return componente;
    }
}