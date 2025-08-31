package com.cidadecidada.ouvidoria.repository;

import com.cidadecidada.ouvidoria.domain.model.Manifestacao;
import com.cidadecidada.ouvidoria.domain.model.StatusManifestacao;
import com.cidadecidada.ouvidoria.domain.model.TipoManifestacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ManifestacaoRepository extends JpaRepository<Manifestacao, Long> {

    Optional<Manifestacao> findByProtocolo(String protocolo);

    boolean existsByProtocolo(String protocolo);

    List<Manifestacao> findByStatus(StatusManifestacao status);

    List<Manifestacao> findByTipo(TipoManifestacao tipo);

    List<Manifestacao> findByEmailOrderByDataCriacaoDesc(String email);

    List<Manifestacao> findByDataCriacaoBetween(LocalDateTime inicio, LocalDateTime fim);

    Page<Manifestacao> findAll(Pageable pageable);

    Page<Manifestacao> findByStatus(StatusManifestacao status, Pageable pageable);

    Page<Manifestacao> findByTipo(TipoManifestacao tipo, Pageable pageable);

    @Query("SELECT m FROM Manifestacao m WHERE LOWER(m.assunto) LIKE LOWER(CONCAT('%', :assunto, '%'))")
    List<Manifestacao> findByAssuntoContaining(@Param("assunto") String assunto);

    long countByStatus(StatusManifestacao status);

    long countByTipo(TipoManifestacao tipo);

    @Query("SELECT m FROM Manifestacao m WHERE m.dataCriacao >= :inicioHoje AND m.dataCriacao < :fimHoje")
    List<Manifestacao> findManifestacoesHoje(@Param("inicioHoje") LocalDateTime inicioHoje, 
                                             @Param("fimHoje") LocalDateTime fimHoje);
    

    @Query("SELECT m FROM Manifestacao m WHERE m.dataCriacao BETWEEN :inicio AND :fim")
    Page<Manifestacao> findByPeriodo(@Param("inicio") LocalDateTime inicio, 
                                     @Param("fim") LocalDateTime fim, 
                                     Pageable pageable);
}
