# 📚 FórumHub - API REST para Gerenciamento de Tópicos

Um sistema de fórum completo desenvolvido com Spring Boot, permitindo aos usuários criar, ler, atualizar e deletar tópicos de discussão. Ideal para plataformas educacionais onde alunos e professores podem compartilhar conhecimento e tirar dúvidas.

## 📖 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Execução](#execução)
- [Documentação da API](#documentação-da-api)
- [Exemplos de Uso](#exemplos-de-uso)
- [Scripts SQL Úteis](#scripts-sql-úteis)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Autor](#autor)
- [Licença](#licença)

## 🎯 Sobre o Projeto

O FórumHub é uma API REST desenvolvida para replicar o funcionamento de um fórum de discussões, similar ao utilizado na plataforma Alura. O projeto implementa um sistema completo de CRUD (Create, Read, Update, Delete) para gerenciamento de tópicos, com autenticação JWT, autorização por roles e persistência de dados em banco de dados relacional.

### Principais Características

✅ CRUD Completo para tópicos  
✅ Autenticação JWT segura  
✅ Autorização por Roles (USER, ADMIN, MODERATOR)  
✅ Migrations com Flyway para versionamento do banco  
✅ Validações de Negócio com Bean Validation  
✅ Documentação Swagger interativa  
✅ Tratamento Global de Exceções  
✅ Pool de Conexões com HikariCP  

## ✨ Funcionalidades

### Tópicos

- 📝 Criar novo tópico
- 👁️ Listar todos os tópicos
- 🔍 Buscar tópico por ID
- ✏️ Atualizar tópico existente
- 🗑️ Deletar tópico

### Autenticação

- 🔐 Login com JWT
- 👤 Registro de novos usuários
- 🛡️ Proteção de endpoints

### Segurança

- 🔒 Senhas criptografadas com BCrypt
- 🎫 Tokens JWT para autenticação
- 👮 Autorização baseada em roles

## 🛠️ Tecnologias Utilizadas

### Backend

- **Java 17** - Linguagem de programação
- **Spring Boot 3.2.0** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Security** - Segurança da aplicação
- **Spring Validation** - Validações

### Banco de Dados

- **MySQL 8.0** - Banco de dados relacional
- **Flyway 9.22.3** - Gerenciamento de migrations
- **HikariCP** - Pool de conexões

### Segurança

- **JWT (JSON Web Token)** - Autenticação
- **BCrypt** - Criptografia de senhas

### Documentação

- **Swagger/OpenAPI 3** - Documentação da API

### Build & Dependencies

- **Maven** - Gerenciamento de dependências
- **Lombok** - Redução de boilerplate code

## 📋 Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:

- Java JDK 17 ou superior
- Maven 3.6+
- MySQL 8.0 ou superior
- IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)
- Postman ou Insomnia (para testar a API)

### Verificar Instalações
```bash
# Verificar versão do Java
java -version

# Verificar versão do Maven
mvn -version

# Verificar versão do MySQL
mysql --version
```

## 🚀 Instalação

### 1. Clonar o Repositório
```bash
git clone https://github.com/marcuslaf/challenge_java_forumhub_alura.git
cd forumhub
```

### 2. Configurar o Banco de Dados MySQL

#### Opção A: Usando Script SQL

Crie o banco de dados executando o script:
```bash
mysql -u root -p < scripts/criar_banco_mysql.sql
```

#### Opção B: Manualmente
```sql
CREATE DATABASE forumhub_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. Configurar Credenciais

Edite o arquivo `src/main/resources/application.properties`:
```properties
# Configurações do Banco de Dados MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/forumhub_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=sua_senha_mysql
```

## ⚙️ Configuração

### Estrutura de Pastas
```
forumhub/
├── src/main/
│   ├── java/br/com/alura/forumhub/
│   │   ├── config/         # Configurações (Security, Swagger)
│   │   ├── controller/     # Controllers REST
│   │   ├── dto/            # Data Transfer Objects
│   │   ├── entity/         # Entidades JPA
│   │   ├── exception/      # Tratamento de exceções
│   │   ├── repository/     # Repositórios JPA
│   │   ├── security/       # Segurança (JWT, UserDetails)
│   │   └── service/        # Lógica de negócio
│   └── resources/
│       ├── application.properties
│       └── db/migration/   # Scripts Flyway
├── pom.xml
└── README.md
```

### Scripts de Migração

Os scripts de migração estão localizados em `src/main/resources/db/migration/`:

| Versão | Descrição |
|--------|-----------|
| V1 | Criação da tabela users |
| V2 | Criação da tabela topics |
| V3 | Adição de chave estrangeira |
| V4 | Inserção de usuários padrão |
| V5 | Adição de índices para performance |
| V6 | Criação da tabela replies |

## ▶️ Execução

### 1. Build do Projeto
```bash
mvn clean install
```

### 2. Executar a Aplicação
```bash
mvn spring-boot:run
```

Ou execute diretamente da sua IDE.

### 3. Verificar se está Funcionando

A aplicação iniciará na porta 8080. Verifique os logs:
```
Started ForumhubApplication in X.XXX seconds
Tomcat started on port 8080
```

## 📚 Documentação da API

### Swagger UI

Acesse a documentação interativa da API:
```
http://localhost:8080/swagger-ui/index.html
```

### OpenAPI Specification
```
http://localhost:8080/v3/api-docs
```

## 🔌 Endpoints Disponíveis

### Autenticação

#### Registrar Usuário
```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "novo_usuario",
  "password": "senha123",
  "role": "USER"
}
```

#### Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "user",
  "password": "password123"
}
```

**Resposta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "username": "user",
  "role": "USER"
}
```

### Tópicos

#### Listar Todos os Tópicos
```http
GET /api/topics
Authorization: Bearer {token}
```

#### Buscar Tópico por ID
```http
GET /api/topics/{id}
Authorization: Bearer {token}
```

#### Criar Novo Tópico
```http
POST /api/topics
Authorization: Bearer {token}
Content-Type: application/json

{
  "title": "Minha dúvida sobre Spring Boot",
  "message": "Como configurar o Spring Security corretamente?",
  "course": "Spring Boot Avançado"
}
```

#### Atualizar Tópico
```http
PUT /api/topics/{id}
Authorization: Bearer {token}
Content-Type: application/json

{
  "title": "Título atualizado",
  "message": "Mensagem atualizada",
  "status": "SOLUCIONADO"
}
```

#### Deletar Tópico
```http
DELETE /api/topics/{id}
Authorization: Bearer {token}
```

## 💡 Exemplos de Uso

### Exemplo 1: Login e Criar Tópico (cURL)
```bash
# 1. Fazer login
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "username": "user",
    "password": "password123"
  }'

# Resposta: {"token":"eyJhbGciOiJIUzI1NiJ9...","username":"user","role":"USER"}

# 2. Criar tópico (substitua {token} pelo token recebido)
curl -X POST http://localhost:8080/api/topics \
  -H "Authorization: Bearer {token}" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Meu primeiro tópico",
    "message": "Esta é minha dúvida sobre Java",
    "course": "Java Básico"
  }'
```

### Exemplo 2: Usando Postman

**Login:**

1. Method: `POST`
2. URL: `http://localhost:8080/api/auth/login`
3. Body (raw, JSON):
```json
{
  "username": "admin",
  "password": "password123"
}
```

4. Copie o token da resposta

**Criar Tópico:**

1. Method: `POST`
2. URL: `http://localhost:8080/api/topics`
3. Headers:
   - `Authorization: Bearer {token}`
   - `Content-Type: application/json`
4. Body (raw, JSON):
```json
{
  "title": "Meu primeiro tópico",
  "message": "Esta é minha dúvida sobre Java",
  "course": "Java Básico"
}
```

### Exemplo 3: Python com Requests
```python
import requests

# Login
login_data = {
    "username": "user",
    "password": "password123"
}

response = requests.post("http://localhost:8080/api/auth/login", json=login_data)
token = response.json()["token"]

# Criar tópico
headers = {
    "Authorization": f"Bearer {token}",
    "Content-Type": "application/json"
}

topic_data = {
    "title": "Minha dúvida sobre Python",
    "message": "Como integrar com APIs REST?",
    "course": "Python Avançado"
}

response = requests.post("http://localhost:8080/api/topics", json=topic_data, headers=headers)
print(response.json())
```

## 🗄️ Scripts SQL Úteis

### Verificar Tabelas Criadas
```sql
USE forumhub_db;
SHOW TABLES;
```

### Verificar Usuários
```sql
SELECT id, username, role, created_at FROM users;
```

### Verificar Tópicos
```sql
SELECT 
    t.id,
    t.title,
    t.status,
    t.course,
    u.username as author,
    t.created_at
FROM topics t
JOIN users u ON t.author_id = u.id
ORDER BY t.created_at DESC;
```

### Verificar Migrações do Flyway
```sql
SELECT 
    version,
    description,
    success,
    execution_time,
    installed_on
FROM flyway_schema_history
ORDER BY installed_rank;
```

### Inserir Novo Usuário Manualmente
```sql
INSERT INTO users (username, password, role)
VALUES ('novo_user', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGzqz93Bdr34fLCLjyqRqQZKhP/t3i', 'USER');
-- Senha: password123
```

### Limpar Dados de Teste
```sql
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE replies;
TRUNCATE TABLE topics;
TRUNCATE TABLE users;
SET FOREIGN_KEY_CHECKS = 1;
```

## 📁 Estrutura do Projeto
```
forumhub/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/
│   │   │       └── com/
│   │   │           └── alura/
│   │   │               └── forumhub/
│   │   │                   ├── ForumhubApplication.java
│   │   │                   ├── config/
│   │   │                   │   ├── SecurityConfig.java
│   │   │                   │   └── SwaggerConfig.java
│   │   │                   ├── controller/
│   │   │                   │   ├── AuthController.java
│   │   │                   │   └── TopicController.java
│   │   │                   ├── dto/
│   │   │                   │   ├── LoginRequest.java
│   │   │                   │   ├── LoginResponse.java
│   │   │                   │   ├── TopicRequest.java
│   │   │                   │   └── TopicResponse.java
│   │   │                   ├── entity/
│   │   │                   │   ├── Topic.java
│   │   │                   │   └── User.java
│   │   │                   ├── exception/
│   │   │                   │   ├── GlobalExceptionHandler.java
│   │   │                   │   └── ResourceNotFoundException.java
│   │   │                   ├── repository/
│   │   │                   │   ├── TopicRepository.java
│   │   │                   │   └── UserRepository.java
│   │   │                   ├── security/
│   │   │                   │   ├── JwtAuthenticationFilter.java
│   │   │                   │   ├── JwtTokenProvider.java
│   │   │                   │   └── UserDetailsServiceImpl.java
│   │   │                   └── service/
│   │   │                       ├── AuthService.java
│   │   │                       └── TopicService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/
│   │           └── migration/
│   │               ├── V1__Create_users_table.sql
│   │               ├── V2__Create_topics_table.sql
│   │               ├── V3__Add_foreign_key.sql
│   │               ├── V4__Insert_default_users.sql
│   │               ├── V5__Add_indexes.sql
│   │               └── V6__Create_replies_table.sql
│   └── test/
│       └── java/
│           └── br/
│               └── com/
│                   └── alura/
│                       └── forumhub/
│                           └── ForumhubApplicationTests.java
├── scripts/
│   └── criar_banco_mysql.sql
├── .gitignore
├── pom.xml
├── LICENSE
└── README.md
```

## 🔑 Usuários Padrão

Após a execução das migrations, os seguintes usuários são criados:

| Username | Password | Role | Descrição |
|----------|----------|------|-----------|
| admin | password123 | ADMIN | Administrador com acesso total |
| user | password123 | USER | Usuário padrão |
| moderador | password123 | MODERATOR | Moderador com permissões especiais |

## 🐛 Troubleshooting

### Problema: Erro de Conexão com MySQL

**Erro:**
```
Communications link failure
```

**Solução:**

1. Verifique se o MySQL está rodando:
```bash
   sudo systemctl status mysql
```
2. Verifique as credenciais no `application.properties`
3. Verifique se o banco de dados existe

### Problema: Flyway Migration Error

**Erro:**
```
FlywayException: Validate failed
```

**Solução:**
```sql
-- Limpar histórico do Flyway (CUIDADO: apaga histórico)
DROP TABLE flyway_schema_history;

-- Ou reverter última migração manualmente
```

### Problema: Porta 8080 já em uso

**Solução:**

Altere a porta no `application.properties`:
```properties
server.port=8081
```

Ou pare o processo usando a porta 8080

## 🤝 Contribuindo

Contribuições são bem-vindas! Siga estes passos:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 📝 TODO

- [ ] Implementar endpoints para respostas
- [ ] Adicionar paginação nos endpoints de listagem
- [ ] Implementar busca e filtros avançados
- [ ] Adicionar testes unitários e de integração
- [ ] Implementar cache com Redis
- [ ] Adicionar logs estruturados
- [ ] Implementar métricas e monitoramento

## 📄 Licença

Este projeto está licenciado sob a MIT License - veja o arquivo LICENSE para detalhes.

## 👨‍💻 Autor

Desenvolvido com ❤️ por **Marcus Lafaiete**

- GitHub: [@marcuslaf](https://github.com/marcuslaf)
- LinkedIn: [linkedin.com/in/marcuslaf](https://linkedin.com/in/marcuslaf)
- Email: marcuslaf@hotmail.com

## 🙏 Agradecimentos

- Alura por disponibilizar o desafio
- Spring Boot Team pela excelente documentação
- Comunidade open-source por compartilhar conhecimento

---

⭐ Se este projeto foi útil para você, considere dar uma estrela!
