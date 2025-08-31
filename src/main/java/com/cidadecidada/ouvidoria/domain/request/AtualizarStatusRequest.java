package com.cidadecidada.ouvidoria.domain.request;

import com.cidadecidada.ouvidoria.domain.model.StatusManifestacao;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AtualizarStatusRequest {
    
    @NotNull(message = "O status é obrigatório")
    private StatusManifestacao status;
    
    @Size(max = 1000, message = "As observações devem ter no máximo 1000 caracteres")
    private String observacoes;
    
    public AtualizarStatusRequest() {}
    
    public AtualizarStatusRequest(StatusManifestacao status, String observacoes) {
        this.status = status;
        this.observacoes = observacoes;
    }
    
    public StatusManifestacao getStatus() {
        return status;
    }
    
    public void setStatus(StatusManifestacao status) {
        this.status = status;
    }
    
    public String getObservacoes() {
        return observacoes;
    }
    
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
