package br.com.rocha.example.tracer.controller;

import br.com.rocha.example.tracer.dto.ProdutoDTO;
import br.com.rocha.example.tracer.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProduto(@PathVariable("id") Long id) {
        return ResponseEntity.ok(produtoService.getProduto(id));
    }
}
