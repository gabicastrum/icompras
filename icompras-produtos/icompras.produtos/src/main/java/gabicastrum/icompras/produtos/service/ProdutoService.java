package gabicastrum.icompras.produtos.service;

import gabicastrum.icompras.produtos.dto.request.ProdutoDTORequest;
import gabicastrum.icompras.produtos.dto.response.ProdutoDTOResponse;
import gabicastrum.icompras.produtos.exception.ProdutoNaoEncontradoException;
import gabicastrum.icompras.produtos.mapper.ProdutoMapper;
import gabicastrum.icompras.produtos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoDTOResponse salvar(ProdutoDTORequest request) {

        var produto = ProdutoMapper.INSTANCE.paraEntidade(request);
        var salvo = produtoRepository.save(produto);

        return ProdutoMapper.INSTANCE.paraResponse(salvo);
    }

    public ProdutoDTOResponse buscarPorId(Long codigo) {

        var produto = produtoRepository.findById(codigo)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(
                        "ProdutoService",
                        "Produto não encontrado com o código: " + codigo
                ));

        return ProdutoMapper.INSTANCE.paraResponse(produto);
    }
}