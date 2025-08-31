package com.cidadecidada.ouvidoria.service;

import com.cidadecidada.ouvidoria.domain.dto.ManifestacaoDTO;
import com.cidadecidada.ouvidoria.domain.model.Manifestacao;
import com.cidadecidada.ouvidoria.domain.model.StatusManifestacao;
import com.cidadecidada.ouvidoria.domain.model.TipoManifestacao;
import com.cidadecidada.ouvidoria.domain.request.AtualizarStatusRequest;
import com.cidadecidada.ouvidoria.domain.request.CriarManifestacaoRequest;
import com.cidadecidada.ouvidoria.repository.ManifestacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ManifestacaoService {
    
    @Autowired
    private ManifestacaoRepository manifestacaoRepository;
    
    private static final DateTimeFormatter PROTOCOLO_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    

    public ManifestacaoDTO criarManifestacao(CriarManifestacaoRequest request) {
        String protocolo = gerarProtocolo();
        
        while (manifestacaoRepository.existsByProtocolo(protocolo)) {
            protocolo = gerarProtocolo();
        }
        
        Manifestacao manifestacao = new Manifestacao();
        manifestacao.setProtocolo(protocolo);
        manifestacao.setNomeSolicitante(request.getNomeSolicitante());
        manifestacao.setEmail(request.getEmail());
        manifestacao.setTelefone(request.getTelefone());
        manifestacao.setAssunto(request.getAssunto());
        manifestacao.setDescricao(request.getDescricao());
        manifestacao.setTipo(request.getTipo());
        
        Manifestacao saved = manifestacaoRepository.save(manifestacao);
        return converterParaDTO(saved);
    }
    

    @Transactional(readOnly = true)
    public Optional<ManifestacaoDTO> buscarPorId(Long id) {
        return manifestacaoRepository.findById(id)
                .map(this::converterParaDTO);
    }
    

    @Transactional(readOnly = true)
    public Optional<ManifestacaoDTO> buscarPorProtocolo(String protocolo) {
        return manifestacaoRepository.findByProtocolo(protocolo)
                .map(this::converterParaDTO);
    }
    

    @Transactional(readOnly = true)
    public Page<ManifestacaoDTO> listarManifestacoes(Pageable pageable) {
        return manifestacaoRepository.findAll(pageable)
                .map(this::converterParaDTO);
    }
    
    
    @Transactional(readOnly = true)
    public List<ManifestacaoDTO> listarPorStatus(StatusManifestacao status) {
        return manifestacaoRepository.findByStatus(status)
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    

    @Transactional(readOnly = true)
    public List<ManifestacaoDTO> listarPorTipo(TipoManifestacao tipo) {
        return manifestacaoRepository.findByTipo(tipo)
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    

    @Transactional(readOnly = true)
    public List<ManifestacaoDTO> listarPorEmail(String email) {
        return manifestacaoRepository.findByEmailOrderByDataCriacaoDesc(email)
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    

    public Optional<ManifestacaoDTO> atualizarStatus(Long id, AtualizarStatusRequest request) {
        Optional<Manifestacao> optManifestacao = manifestacaoRepository.findById(id);
        
        if (optManifestacao.isPresent()) {
            Manifestacao manifestacao = optManifestacao.get();
            manifestacao.setStatus(request.getStatus());
            manifestacao.setObservacoes(request.getObservacoes());
            
            Manifestacao saved = manifestacaoRepository.save(manifestacao);
            return Optional.of(converterParaDTO(saved));
        }
        
        return Optional.empty();
    }
    

    @Transactional(readOnly = true)
    public List<ManifestacaoDTO> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return manifestacaoRepository.findByDataCriacaoBetween(inicio, fim)
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    

    @Transactional(readOnly = true)
    public List<ManifestacaoDTO> buscarManifestacoesHoje() {
        LocalDateTime inicioHoje = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime fimHoje = inicioHoje.plusDays(1);
        
        return manifestacaoRepository.findManifestacoesHoje(inicioHoje, fimHoje)
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    

    @Transactional(readOnly = true)
    public long contarPorStatus(StatusManifestacao status) {
        return manifestacaoRepository.countByStatus(status);
    }
    

    @Transactional(readOnly = true)
    public long contarPorTipo(TipoManifestacao tipo) {
        return manifestacaoRepository.countByTipo(tipo);
    }
    

    private String gerarProtocolo() {
        LocalDateTime now = LocalDateTime.now();
        return "PROT" + now.format(PROTOCOLO_FORMATTER);
    }


    private ManifestacaoDTO converterParaDTO(Manifestacao manifestacao) {
        return new ManifestacaoDTO(
                manifestacao.getId(),
                manifestacao.getProtocolo(),
                manifestacao.getNomeSolicitante(),
                manifestacao.getEmail(),
                manifestacao.getTelefone(),
                manifestacao.getAssunto(),
                manifestacao.getDescricao(),
                manifestacao.getTipo(),
                manifestacao.getStatus(),
                manifestacao.getDataCriacao(),
                manifestacao.getDataAtualizacao(),
                manifestacao.getObservacoes()
        );
    }
}
