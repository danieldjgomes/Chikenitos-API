package com.gomes.daniel.ckn.mineracao.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class Pesquisa {

    private Long idSite;
    private BigDecimal preco;

}
