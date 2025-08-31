package com.cidadecidada.ouvidoria.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "manifestacoes")
public class Manifestacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O protocolo é obrigatório")
    @Size(max = 20, message = "O protocolo deve ter no máximo 20 caracteres")
    @Column(unique = true, nullable = false, length = 20)
    private String protocolo;
    
    @NotBlank(message = "O nome do solicitante é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nomeSolicitante;
    
    @NotBlank(message = "O email é obrigatório")
    @Size(max = 100, message = "O email deve ter no máximo 100 caracteres")
    @Column(nullable = false, length = 100)
    private String email;
    
    @NotBlank(message = "O telefone é obrigatório")
    @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres")
    @Column(nullable = false, length = 20)
    private String telefone;
    
    @NotBlank(message = "O assunto é obrigatório")
    @Size(max = 200, message = "O assunto deve ter no máximo 200 caracteres")
    @Column(nullable = false, length = 200)
    private String assunto;
    
    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 2000, message = "A descrição deve ter no máximo 2000 caracteres")
    @Column(nullable = false, length = 2000)
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O tipo de manifestação é obrigatório")
    @Column(nullable = false)
    private TipoManifestacao tipo;
    
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O status é obrigatório")
    @Column(nullable = false)
    private StatusManifestacao status;
    
    @Column(nullable = false)
    private LocalDateTime dataCriacao;
    
    @Column
    private LocalDateTime dataAtualizacao;
    
    @Column(length = 1000)
    private String observacoes;
    
    public Manifestacao() {
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusManifestacao.ABERTA;
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
    
    @PreUpdate
    public void preUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }
}
