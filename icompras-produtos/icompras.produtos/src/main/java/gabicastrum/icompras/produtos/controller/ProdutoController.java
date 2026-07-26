package gabicastrum.icompras.produtos.controller;

import gabicastrum.icompras.produtos.dto.request.ProdutoDTORequest;
import gabicastrum.icompras.produtos.dto.response.ProdutoDTOResponse;
import gabicastrum.icompras.produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTOResponse> salvar(@RequestBody ProdutoDTORequest request) {
        var response = produtoService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ProdutoDTOResponse> buscarPorId(@PathVariable("codigo") Long codigo) {
        var response = produtoService.buscarPorId(codigo);
        return ResponseEntity.ok(response);
    }
}