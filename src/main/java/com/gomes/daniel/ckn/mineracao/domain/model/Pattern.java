package com.gomes.daniel.ckn.mineracao.domain.model;

import lombok.Data;

@Data
public class Pattern {

    private String url;
    private String patternBody;
    private String prefix;
    private String suffix;
    private String classeCSS;
}
