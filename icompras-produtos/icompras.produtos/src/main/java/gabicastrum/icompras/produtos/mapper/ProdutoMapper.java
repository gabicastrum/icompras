package gabicastrum.icompras.produtos.mapper;

import gabicastrum.icompras.produtos.dominio.Produto;
import gabicastrum.icompras.produtos.dto.request.ProdutoDTORequest;
import gabicastrum.icompras.produtos.dto.response.ProdutoDTOResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mapping(target = "codigo", ignore = true)
    Produto paraEntidade(ProdutoDTORequest request);

    ProdutoDTOResponse paraResponse(Produto produto);
}