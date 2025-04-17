# 🚀 Notifica - Cidades Inteligentes

Sistema de gerenciamento de coleta e resíduos, voltado para cidades inteligentes. Desenvolvido com Spring Boot, segurança JWT, CI/CD via GitHub Actions e deploy containerizado com Docker.

---

## 📦 Tecnologias Utilizadas

- Java 21 + Spring Boot
- Spring Security com JWT
- JPA / Hibernate
- Oracle Database (com suporte ao Flyway)
- Docker + Docker Compose
- GitHub Actions (CI/CD)
- Lombok

---

## 🛠️ Como Rodar o Projeto

### ✅ Pré-requisitos

- Java 21
- Maven
- Docker e Docker Compose

### 🔧 Build do projeto (local)

```bash
./mvnw clean package

### 🐳 Rodando com Docker Compose

docker compose up --build

O projeto será exposto em: http://localhost:8080

###  🔐 Autenticação
O projeto utiliza JWT (JSON Web Token) para autenticação e autorização de usuários.

Endpoints públicos:
POST /auth/login – Login de usuário

POST /auth/register – Registro de novo usuário

Após o login:
O endpoint retorna um token JWT

Use o token nos demais endpoints, via Header:

Authorization: Bearer SEU_TOKEN_AQUI

📋 Endpoints Protegidos
Verifique a classe SecurityConfig.java para as regras completas


###  🔁 Pipeline CI/CD
A automação de build e deploy é feita com GitHub Actions:

ci-cd-pipeline.yml realiza:

Build da imagem Docker

Push para Docker Hub

Deploy automatizado com Docker Compose

###  📂 Estrutura

notifica/
├── src/
├── Dockerfile
├── docker-compose.yml
├── .github/
│   └── workflows/
│       └── ci-cd-pipeline.yml
└── README.md

###  🐙 GitHub Actions (CI/CD)
Sempre que um push for feito na branch main, a pipeline será executada:

Criação de imagem Docker

Login no Docker Hub

Push da imagem

## 🛠️ Variáveis de ambiente

Arquivo `application.properties`:

```properties
minha.chave.secreta=${JWT.SECRET:fiap}
```

Você pode definir `JWT.SECRET` como variável de ambiente para mudar o segredo do token.

Projeto desenvolvido por Bruna Mendes da Cunha Passos

Para a disciplina de DevOps e CI/CD — FIAP




