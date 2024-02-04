package br.com.rocha.example.tracer.dto;

import java.math.BigDecimal;
import java.util.List;

public record ProdutoDTO(Long id, String nome, BigDecimal valor, List<AvaliacaoDTO> avaliacoes) {
}
