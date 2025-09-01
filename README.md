# Portal de Ouvidoria Simples

Backend em Java 17 com Spring Boot 3.5.5 para o sistema de ouvidoria municipal, implementado com arquitetura MVC e banco de dados versionado via Flyway.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.5**
- **Spring Web** - Para APIs REST
- **Spring Validation** - Para validação de dados
- **Spring Data JPA** - Para persistência de dados
- **Flyway** - Para versionamento de banco de dados
- **springdoc-openapi** - Para documentação da API
- **MySQL 8.0** - Banco de dados principal

## Estrutura do Projeto

```
com.cidadecidada.ouvidoria
└── domain
    ├── domain
    │   ├── model          # Entidades JPA
    │   ├── dto            # Objetos de transferência de dados
    │   └── request        # Objetos de requisição
    ├── controller         # Controladores REST
    ├── repository         # Repositórios de dados
    └── service            # Lógica de negócio
```

## Arquitetura

O projeto segue o padrão **MVC (Model-View-Controller)** com as seguintes camadas:

- **Model**: Entidades JPA (`Manifestacao`, `TipoManifestacao`, `StatusManifestacao`)
- **View**: DTOs e objetos de resposta da API
- **Controller**: Controladores REST para exposição dos endpoints
- **Service**: Camada de lógica de negócio
- **Repository**: Camada de acesso a dados

## Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- MySQL 8.0 ou superior
- Docker (opcional, para executar MySQL)

### Configuração do Banco de Dados

#### Opção 1: Docker (Recomendado para desenvolvimento)

```bash
# Executar MySQL 8.0
docker run -e MYSQL_ROOT_PASSWORD=root --name mysql_local -p 3306:3306 -d mysql:8.0

# Verificar se está rodando
docker ps
```

#### Opção 2: Instalação Local

1. Instale MySQL 8.0
2. Crie um usuário ou use o root
3. Configure as credenciais no arquivo `application.yml`

### Execução da Aplicação

```bash
# Clonar o repositório
git clone <repository-url>
cd cidadecidada

# Executar a aplicação
mvn spring-boot:run
```

## Endpoints da API

### Manifestações

- `POST /api/manifestacoes` - Criar nova manifestação
- `GET /api/manifestacoes/{id}` - Buscar manifestação por ID
- `GET /api/manifestacoes/protocolo/{protocolo}` - Buscar por protocolo
- `GET /api/manifestacoes` - Listar manifestações (com paginação)
- `GET /api/manifestacoes/status/{status}` - Listar por status
- `GET /api/manifestacoes/tipo/{tipo}` - Listar por tipo
- `GET /api/manifestacoes/email/{email}` - Listar por email
- `PUT /api/manifestacoes/{id}/status` - Atualizar status
- `GET /api/manifestacoes/periodo` - Buscar por período
- `GET /api/manifestacoes/hoje` - Manifestações de hoje
- `GET /api/manifestacoes/contagem/status/{status}` - Contar por status
- `GET /api/manifestacoes/contagem/tipo/{tipo}` - Contar por tipo

### Informações da API

- `GET /api/info` - Informações gerais da API
- `GET /api/health` - Health check
- `GET /api/status` - Status da aplicação

## Documentação da API

- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/api-docs

## Banco de Dados

### Configuração

- **Host**: localhost:3306
- **Database**: ouvidoria_dev
- **Usuário**: root
- **Senha**: root
- **Driver**: com.mysql.cj.jdbc.Driver

## Configurações

### Arquivo de Configuração

- `application.yml` - Configurações gerais da aplicação

### Configurações Principais

- Banco MySQL local
- Logs detalhados
- Validação de esquema Flyway
- Criação automática do banco se não existir
- Documentação Swagger habilitada
- CORS configurado

## Funcionalidades

### Tipos de Manifestação

- **Denúncia**: Reportar irregularidades
- **Reclamação**: Expressar insatisfação
- **Sugestão**: Propor melhorias
- **Elogio**: Reconhecer bons serviços
- **Solicitação**: Solicitar serviços
- **Informação**: Buscar informações

### Status das Manifestações

- **Aberta**: Manifestação recebida
- **Em Análise**: Sendo analisada
- **Em Andamento**: Sendo processada
- **Resolvida**: Manifestação atendida
- **Cancelada**: Manifestação cancelada
- **Arquivada**: Manifestação arquivada

## Funcionalidades Principais

1. **Criação de Manifestações**: Sistema gera protocolo único automaticamente
2. **Consulta por Protocolo**: Permite cidadãos acompanharem suas manifestações
3. **Atualização de Status**: Funcionários podem atualizar o andamento
4. **Filtros e Buscas**: Por tipo, status, email, período
5. **Paginação**: Para grandes volumes de dados
6. **Validações**: Dados são validados antes de serem processados
7. **Tratamento de Erros**: Respostas padronizadas de erro
8. **Documentação**: API completamente documentada com Swagger

## Segurança

- Validação de entrada de dados
- Tratamento de exceções
- CORS configurado
- Logs de auditoria

