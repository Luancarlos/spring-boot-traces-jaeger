package br.com.rocha.example.tracer.service;

import br.com.rocha.example.tracer.dto.AvaliacaoDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AvaliacaoService {

    public List<AvaliacaoDTO> getAvaliacoes(Long idProduto) {
        var avalicao = new AvaliacaoDTO(1L, 1L, 5);
        var avalicao1 = new AvaliacaoDTO(2L, 1L, 5);
        var avalicao2 = new AvaliacaoDTO(3L, 1L, 5);

        if (idProduto == 2L) {
            return null;
        }

        return Arrays.asList(avalicao, avalicao1, avalicao2);
    }

}
