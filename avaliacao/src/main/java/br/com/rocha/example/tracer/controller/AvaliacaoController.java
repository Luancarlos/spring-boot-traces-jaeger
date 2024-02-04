package br.com.rocha.example.tracer.controller;

import br.com.rocha.example.tracer.dto.AvaliacaoDTO;
import br.com.rocha.example.tracer.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/{idProduto}")
    public ResponseEntity<List<AvaliacaoDTO>> getAvaliacoes(@PathVariable("idProduto") Long idProduto) {
        var avaliacoes = this.avaliacaoService.getAvaliacoes(idProduto);
        if (avaliacoes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(avaliacoes);
    }

}
