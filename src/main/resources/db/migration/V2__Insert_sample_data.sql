-- V2__Insert_sample_data.sql
-- Inserção de dados de exemplo para testes

INSERT INTO manifestacoes (
    protocolo, 
    nome_solicitante, 
    email, 
    telefone, 
    assunto, 
    descricao, 
    tipo, 
    status, 
    data_criacao, 
    observacoes
) VALUES 
(
    'PROT20241201120000',
    'João Silva',
    'joao.silva@email.com',
    '(11) 99999-1111',
    'Solicitação de iluminação pública',
    'Gostaria de solicitar a instalação de iluminação pública na rua das Flores, número 123. A rua está muito escura à noite, o que compromete a segurança dos moradores.',
    'SOLICITACAO',
    'ABERTA',
    '2024-12-01 12:00:00',
    'Manifestação recebida e será analisada pela equipe técnica.'
),
(
    'PROT20241201120100',
    'Maria Santos',
    'maria.santos@email.com',
    '(11) 99999-2222',
    'Reclamação sobre buracos na rua',
    'Existem vários buracos na rua das Palmeiras que estão causando problemas para os motoristas e pedestres. Já faz mais de um mês que foram reportados.',
    'RECLAMACAO',
    'EM_ANALISE',
    '2024-12-01 12:01:00',
    'Equipe de manutenção foi notificada para avaliação.'
),
(
    'PROT20241201120200',
    'Pedro Oliveira',
    'pedro.oliveira@email.com',
    '(11) 99999-3333',
    'Sugestão para parque municipal',
    'Sugiro a criação de um parque municipal na região central da cidade. Seria um espaço de lazer muito importante para as famílias e contribuiria para a qualidade de vida.',
    'SUGESTAO',
    'ABERTA',
    '2024-12-01 12:02:00',
    'Sugestão será analisada pelo departamento de planejamento urbano.'
),
(
    'PROT20241201120300',
    'Ana Costa',
    'ana.costa@email.com',
    '(11) 99999-4444',
    'Elogio ao atendimento da prefeitura',
    'Gostaria de parabenizar a equipe da prefeitura pelo excelente atendimento prestado na solicitação de alvará de funcionamento. O processo foi rápido e eficiente.',
    'ELOGIO',
    'RESOLVIDA',
    '2024-12-01 12:03:00',
    'Elogio registrado e será encaminhado para a equipe responsável.'
),
(
    'PROT20241201120400',
    'Carlos Ferreira',
    'carlos.ferreira@email.com',
    '(11) 99999-5555',
    'Denúncia de descarte irregular de lixo',
    'Estou denunciando o descarte irregular de lixo na esquina da rua das Margaridas com a rua das Rosas. Pessoas estão jogando lixo doméstico no local.',
    'DENUNCIA',
    'EM_ANDAMENTO',
    '2024-12-01 12:04:00',
    'Fiscalização foi acionada para verificar a situação.'
);
