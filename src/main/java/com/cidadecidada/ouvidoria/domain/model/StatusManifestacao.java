package com.cidadecidada.ouvidoria.domain.model;

public enum StatusManifestacao {
    ABERTA("Aberta"),
    EM_ANALISE("Em Análise"),
    EM_ANDAMENTO("Em Andamento"),
    RESOLVIDA("Resolvida"),
    CANCELADA("Cancelada"),
    ARQUIVADA("Arquivada");
    
    private final String descricao;
    
    StatusManifestacao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
