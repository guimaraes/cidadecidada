package com.cidadecidada.ouvidoria.domain.request;

import com.cidadecidada.ouvidoria.domain.model.TipoManifestacao;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CriarManifestacaoRequest {
    
    @NotBlank(message = "O nome do solicitante é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nomeSolicitante;
    
    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email deve ser válido")
    @Size(max = 100, message = "O email deve ter no máximo 100 caracteres")
    private String email;
    
    @NotBlank(message = "O telefone é obrigatório")
    @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres")
    private String telefone;
    
    @NotBlank(message = "O assunto é obrigatório")
    @Size(max = 200, message = "O assunto deve ter no máximo 200 caracteres")
    private String assunto;
    
    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 2000, message = "A descrição deve ter no máximo 2000 caracteres")
    private String descricao;
    
    @NotNull(message = "O tipo de manifestação é obrigatório")
    private TipoManifestacao tipo;
    
    public CriarManifestacaoRequest() {}
    
    public CriarManifestacaoRequest(String nomeSolicitante, String email, String telefone, 
                                   String assunto, String descricao, TipoManifestacao tipo) {
        this.nomeSolicitante = nomeSolicitante;
        this.email = email;
        this.telefone = telefone;
        this.assunto = assunto;
        this.descricao = descricao;
        this.tipo = tipo;
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
}
