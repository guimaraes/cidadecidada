package com.cidadecidada.ouvidoria.domain.dto;

import com.cidadecidada.ouvidoria.domain.model.StatusManifestacao;
import com.cidadecidada.ouvidoria.domain.model.TipoManifestacao;
import java.time.LocalDateTime;

public class ManifestacaoDTO {
    
    private Long id;
    private String protocolo;
    private String nomeSolicitante;
    private String email;
    private String telefone;
    private String assunto;
    private String descricao;
    private TipoManifestacao tipo;
    private StatusManifestacao status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private String observacoes;
    
    public ManifestacaoDTO() {}
    
    public ManifestacaoDTO(Long id, String protocolo, String nomeSolicitante, String email, 
                          String telefone, String assunto, String descricao, 
                          TipoManifestacao tipo, StatusManifestacao status, 
                          LocalDateTime dataCriacao, LocalDateTime dataAtualizacao, 
                          String observacoes) {
        this.id = id;
        this.protocolo = protocolo;
        this.nomeSolicitante = nomeSolicitante;
        this.email = email;
        this.telefone = telefone;
        this.assunto = assunto;
        this.descricao = descricao;
        this.tipo = tipo;
        this.status = status;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
        this.observacoes = observacoes;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getProtocolo() {
        return protocolo;
    }
    
    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }
    
    public String getNomeSolicitante() {
        return nomeSolicitante;
    }
    
    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getAssunto() {
        return assunto;
    }
    
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public TipoManifestacao getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoManifestacao tipo) {
        this.tipo = tipo;
    }
    
    public StatusManifestacao getStatus() {
        return status;
    }
    
    public void setStatus(StatusManifestacao status) {
        this.status = status;
    }
    
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
    
    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
    
    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    
    public String getObservacoes() {
        return observacoes;
    }
    
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
