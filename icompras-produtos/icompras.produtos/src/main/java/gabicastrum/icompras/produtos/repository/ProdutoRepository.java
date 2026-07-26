package gabicastrum.icompras.produtos.repository;

import gabicastrum.icompras.produtos.dominio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
