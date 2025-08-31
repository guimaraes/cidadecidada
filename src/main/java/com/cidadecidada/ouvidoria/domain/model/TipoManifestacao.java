package com.cidadecidada.ouvidoria.domain.model;

public enum TipoManifestacao {
    DENUNCIA("Denúncia"),
    RECLAMACAO("Reclamação"),
    SUGESTAO("Sugestão"),
    ELOGIO("Elogio"),
    SOLICITACAO("Solicitação"),
    INFORMACAO("Informação");
    
    private final String descricao;
    
    TipoManifestacao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
