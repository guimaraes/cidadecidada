package com.cidadecidada.ouvidoria.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Tag(name = "Informações da API", description = "Endpoints para informações gerais da API")
public class InfoController {
    
    @Value("${spring.application.name:ouvidoria}")
    private String applicationName;
    
    @Value("${spring.application.description:Portal de Ouvidoria Simples}")
    private String applicationDescription;
    
    @GetMapping("/info")
    @Operation(summary = "Informações da API", 
               description = "Retorna informações gerais sobre a API")
    public ResponseEntity<Map<String, Object>> getApiInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("nome", applicationName);
        info.put("descricao", applicationDescription);
        info.put("versao", "1.0.0");
        info.put("timestamp", LocalDateTime.now());
        info.put("status", "ativo");
        info.put("ambiente", System.getProperty("spring.profiles.active", "dev"));
        
        return ResponseEntity.ok(info);
    }
    
    @GetMapping("/health")
    @Operation(summary = "Health Check", 
               description = "Verifica o status de saúde da aplicação")
    public ResponseEntity<Map<String, Object>> healthCheck() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("timestamp", LocalDateTime.now());
        health.put("application", applicationName);
        
        return ResponseEntity.ok(health);
    }
    
    @GetMapping("/status")
    @Operation(summary = "Status da API", 
               description = "Retorna o status atual da API")
    public ResponseEntity<Map<String, Object>> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("status", "operacional");
        status.put("timestamp", LocalDateTime.now());
        status.put("uptime", System.currentTimeMillis());
        
        return ResponseEntity.ok(status);
    }
}
