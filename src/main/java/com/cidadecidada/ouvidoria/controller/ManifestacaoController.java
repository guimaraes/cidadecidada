package com.cidadecidada.ouvidoria.controller;

import com.cidadecidada.ouvidoria.domain.dto.ManifestacaoDTO;
import com.cidadecidada.ouvidoria.domain.model.StatusManifestacao;
import com.cidadecidada.ouvidoria.domain.model.TipoManifestacao;
import com.cidadecidada.ouvidoria.domain.request.AtualizarStatusRequest;
import com.cidadecidada.ouvidoria.domain.request.CriarManifestacaoRequest;
import com.cidadecidada.ouvidoria.service.ManifestacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/manifestacoes")
@Tag(name = "Manifestações", description = "API para gerenciamento de manifestações da ouvidoria")
@CrossOrigin(origins = "*")
public class ManifestacaoController {
    
    @Autowired
    private ManifestacaoService manifestacaoService;
    
    @PostMapping
    @Operation(summary = "Criar nova manifestação", 
               description = "Cria uma nova manifestação na ouvidoria")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Manifestação criada com sucesso",
                    content = @Content(schema = @Schema(implementation = ManifestacaoDTO.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<ManifestacaoDTO> criarManifestacao(
            @Valid @RequestBody CriarManifestacaoRequest request) {
        ManifestacaoDTO manifestacao = manifestacaoService.criarManifestacao(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(manifestacao);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Buscar manifestação por ID", 
               description = "Retorna uma manifestação específica pelo seu ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Manifestação encontrada",
                    content = @Content(schema = @Schema(implementation = ManifestacaoDTO.class))),
        @ApiResponse(responseCode = "404", description = "Manifestação não encontrada")
    })
    public ResponseEntity<ManifestacaoDTO> buscarPorId(
            @Parameter(description = "ID da manifestação") @PathVariable Long id) {
        return manifestacaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/protocolo/{protocolo}")
    @Operation(summary = "Buscar manifestação por protocolo", 
               description = "Retorna uma manifestação específica pelo seu protocolo")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Manifestação encontrada",
                    content = @Content(schema = @Schema(implementation = ManifestacaoDTO.class))),
        @ApiResponse(responseCode = "404", description = "Manifestação não encontrada")
    })
    public ResponseEntity<ManifestacaoDTO> buscarPorProtocolo(
            @Parameter(description = "Protocolo da manifestação") @PathVariable String protocolo) {
        return manifestacaoService.buscarPorProtocolo(protocolo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping
    @Operation(summary = "Listar manifestações", 
               description = "Lista todas as manifestações com paginação")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de manifestações retornada com sucesso")
    })
    public ResponseEntity<Page<ManifestacaoDTO>> listarManifestacoes(
            @Parameter(description = "Número da página (0-based)") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "Tamanho da página") @RequestParam(defaultValue = "10") int size,
            @Parameter(description = "Campo para ordenação") @RequestParam(defaultValue = "dataCriacao") String sortBy,
            @Parameter(description = "Direção da ordenação") @RequestParam(defaultValue = "desc") String sortDir) {
        
        Sort.Direction direction = "desc".equalsIgnoreCase(sortDir) ? 
                Sort.Direction.DESC : Sort.Direction.ASC;
        
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        Page<ManifestacaoDTO> manifestacoes = manifestacaoService.listarManifestacoes(pageable);
        
        return ResponseEntity.ok(manifestacoes);
    }
    
    @GetMapping("/status/{status}")
    @Operation(summary = "Listar manifestações por status", 
               description = "Lista todas as manifestações de um status específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de manifestações retornada com sucesso")
    })
    public ResponseEntity<List<ManifestacaoDTO>> listarPorStatus(
            @Parameter(description = "Status das manifestações") @PathVariable StatusManifestacao status) {
        List<ManifestacaoDTO> manifestacoes = manifestacaoService.listarPorStatus(status);
        return ResponseEntity.ok(manifestacoes);
    }
    
    @GetMapping("/tipo/{tipo}")
    @Operation(summary = "Listar manifestações por tipo", 
               description = "Lista todas as manifestações de um tipo específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de manifestações retornada com sucesso")
    })
    public ResponseEntity<List<ManifestacaoDTO>> listarPorTipo(
            @Parameter(description = "Tipo das manifestações") @PathVariable TipoManifestacao tipo) {
        List<ManifestacaoDTO> manifestacoes = manifestacaoService.listarPorTipo(tipo);
        return ResponseEntity.ok(manifestacoes);
    }
    
    @GetMapping("/email/{email}")
    @Operation(summary = "Listar manifestações por email", 
               description = "Lista todas as manifestações de um email específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de manifestações retornada com sucesso")
    })
    public ResponseEntity<List<ManifestacaoDTO>> listarPorEmail(
            @Parameter(description = "Email do solicitante") @PathVariable String email) {
        List<ManifestacaoDTO> manifestacoes = manifestacaoService.listarPorEmail(email);
        return ResponseEntity.ok(manifestacoes);
    }
    
    @PutMapping("/{id}/status")
    @Operation(summary = "Atualizar status da manifestação", 
               description = "Atualiza o status e observações de uma manifestação")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Status atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = ManifestacaoDTO.class))),
        @ApiResponse(responseCode = "404", description = "Manifestação não encontrada")
    })
    public ResponseEntity<ManifestacaoDTO> atualizarStatus(
            @Parameter(description = "ID da manifestação") @PathVariable Long id,
            @Valid @RequestBody AtualizarStatusRequest request) {
        return manifestacaoService.atualizarStatus(id, request)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/periodo")
    @Operation(summary = "Buscar manifestações por período", 
               description = "Lista manifestações criadas em um período específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de manifestações retornada com sucesso")
    })
    public ResponseEntity<List<ManifestacaoDTO>> buscarPorPeriodo(
            @Parameter(description = "Data/hora de início (formato: yyyy-MM-ddTHH:mm:ss)") 
            @RequestParam String inicio,
            @Parameter(description = "Data/hora de fim (formato: yyyy-MM-ddTHH:mm:ss)") 
            @RequestParam String fim) {
        
        LocalDateTime dataInicio = LocalDateTime.parse(inicio);
        LocalDateTime dataFim = LocalDateTime.parse(fim);
        
        List<ManifestacaoDTO> manifestacoes = manifestacaoService.buscarPorPeriodo(dataInicio, dataFim);
        return ResponseEntity.ok(manifestacoes);
    }
    
    @GetMapping("/hoje")
    @Operation(summary = "Buscar manifestações de hoje", 
               description = "Lista manifestações criadas hoje")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de manifestações retornada com sucesso")
    })
    public ResponseEntity<List<ManifestacaoDTO>> buscarManifestacoesHoje() {
        List<ManifestacaoDTO> manifestacoes = manifestacaoService.buscarManifestacoesHoje();
        return ResponseEntity.ok(manifestacoes);
    }
    
    @GetMapping("/contagem/status/{status}")
    @Operation(summary = "Contar manifestações por status", 
               description = "Retorna o total de manifestações de um status específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Contagem retornada com sucesso")
    })
    public ResponseEntity<Long> contarPorStatus(
            @Parameter(description = "Status das manifestações") @PathVariable StatusManifestacao status) {
        long contagem = manifestacaoService.contarPorStatus(status);
        return ResponseEntity.ok(contagem);
    }
    
    @GetMapping("/contagem/tipo/{tipo}")
    @Operation(summary = "Contar manifestações por tipo", 
               description = "Retorna o total de manifestações de um tipo específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Contagem retornada com sucesso")
    })
    public ResponseEntity<Long> contarPorTipo(
            @Parameter(description = "Tipo das manifestações") @PathVariable TipoManifestacao tipo) {
        long contagem = manifestacaoService.contarPorTipo(tipo);
        return ResponseEntity.ok(contagem);
    }
}
