-- V1__Create_manifestacoes_table.sql
-- Criação da tabela de manifestações
-- Compatível com MySQL 8.0

CREATE TABLE manifestacoes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    protocolo VARCHAR(20) NOT NULL UNIQUE,
    nome_solicitante VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    assunto VARCHAR(200) NOT NULL,
    descricao VARCHAR(2000) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    data_atualizacao TIMESTAMP NULL,
    observacoes VARCHAR(1000)
);

-- Índices para melhorar performance
CREATE INDEX idx_manifestacoes_protocolo ON manifestacoes(protocolo);
CREATE INDEX idx_manifestacoes_email ON manifestacoes(email);
CREATE INDEX idx_manifestacoes_status ON manifestacoes(status);
CREATE INDEX idx_manifestacoes_tipo ON manifestacoes(tipo);
CREATE INDEX idx_manifestacoes_data_criacao ON manifestacoes(data_criacao);

-- Comentários da tabela (MySQL)
-- ALTER TABLE manifestacoes COMMENT = 'Tabela para armazenar manifestações da ouvidoria';
-- ALTER TABLE manifestacoes MODIFY COLUMN id BIGINT COMMENT 'Identificador único da manifestação';
-- ALTER TABLE manifestacoes MODIFY COLUMN protocolo VARCHAR(20) COMMENT 'Protocolo único da manifestação';
-- ALTER TABLE manifestacoes MODIFY COLUMN nome_solicitante VARCHAR(100) COMMENT 'Nome completo do solicitante';
-- ALTER TABLE manifestacoes MODIFY COLUMN email VARCHAR(100) COMMENT 'Email do solicitante';
-- ALTER TABLE manifestacoes MODIFY COLUMN telefone VARCHAR(20) COMMENT 'Telefone do solicitante';
-- ALTER TABLE manifestacoes MODIFY COLUMN assunto VARCHAR(200) COMMENT 'Assunto da manifestação';
-- ALTER TABLE manifestacoes MODIFY COLUMN descricao VARCHAR(2000) COMMENT 'Descrição detalhada da manifestação';
-- ALTER TABLE manifestacoes MODIFY COLUMN tipo VARCHAR(20) COMMENT 'Tipo da manifestação (DENUNCIA, RECLAMACAO, SUGESTAO, ELOGIO, SOLICITACAO, INFORMACAO)';
-- ALTER TABLE manifestacoes MODIFY COLUMN status VARCHAR(20) COMMENT 'Status atual da manifestação (ABERTA, EM_ANALISE, EM_ANDAMENTO, RESOLVIDA, CANCELADA, ARQUIVADA)';
-- ALTER TABLE manifestacoes MODIFY COLUMN data_criacao TIMESTAMP COMMENT 'Data e hora de criação da manifestação';
-- ALTER TABLE manifestacoes MODIFY COLUMN data_atualizacao TIMESTAMP COMMENT 'Data e hora da última atualização';
-- ALTER TABLE manifestacoes MODIFY COLUMN observacoes VARCHAR(1000) COMMENT 'Observações adicionais sobre a manifestação';
