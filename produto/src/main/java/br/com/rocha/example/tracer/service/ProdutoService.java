package br.com.rocha.example.tracer.service;

import br.com.rocha.example.tracer.dto.AvaliacaoDTO;
import br.com.rocha.example.tracer.dto.ProdutoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Value("${api.avaliacao}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    public ProdutoDTO getProduto(Long id) {
        if (id == 3L) {
            return null;
        }

        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(apiUrl + "/" + id, Object[].class);
        Object[] objects = responseEntity.getBody();

        return new ProdutoDTO(
                1L,
                "MacBook Pro M2",
                BigDecimal.valueOf(25000L),
                convertAvaliacao(objects));
    }

    private List<AvaliacaoDTO> convertAvaliacao(Object[] objects) {
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, AvaliacaoDTO.class))
                .collect(Collectors.toList());
    }
}
