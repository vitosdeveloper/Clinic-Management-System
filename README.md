# Clinic Management System

## Descrição

O **Clinic Management System** é um sistema de gestão de consultas médicas. Ele permite que pacientes marquem consultas
com médicos de diferentes especialidades, visualizem o histórico de consultas e recebam notificações de lembrete. O
sistema também oferece um painel administrativo para gerenciar médicos, horários e especialidades, além de integrar com
APIs externas para envio de notificações via email ou SMS.

### Funcionalidades principais:

- Cadastro de usuários (pacientes, médicos e administradores)
- Sistema de autenticação e autorização
- Agendamento de consultas com verificação de disponibilidade
- Cancelamento e reagendamento de consultas
- Painel administrativo para gerenciamento de médicos, horários e especialidades
- Histórico de consultas para pacientes e médicos
- Integração com APIs externas para notificações

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **JPA/Hibernate** para persistência de dados
- **Spring Security** para autenticação e autorização
- **REST API** para comunicação entre frontend e backend
- **Banco de dados relacional** (MySQL ou PostgreSQL)
- **JUnit** para testes unitários

## Instalação

### Pré-requisitos

- **Java 17** instalado
- **Docker** instalado

### Passos

1. Clone o repositório para o seu ambiente local:
    ```bash
    git clone https://github.com/seu-usuario/clinic-management.git
    ```

2. Navegue até a pasta do projeto:
    ```bash
    cd clinic-management
    ```

3. Crie um arquivo `.env` na raiz do projeto, com base no arquivo `.env.example`. Defina as variáveis de ambiente
   necessárias, como conexão com o banco de dados.

4. Inicie o banco de dados utilizando Docker:
    ```bash
    docker-compose up -d
    ```

5. Instale as dependências do projeto (Java 17 necessário para o Spring Boot):
    - Se você estiver usando um IDE como IntelliJ IDEA, importe o projeto como um projeto Maven e ele cuidará de baixar
      as dependências automaticamente.

6. Inicie o servidor Spring Boot:
    ```bash
    ./mvnw spring-boot:run
    ```

   Ou, se você já tiver o Maven instalado:
    ```bash
    mvn spring-boot:run
    ```

## Uso

Depois de executar o projeto, ele estará disponível em `http://localhost:8080`. Use um client REST ou a interface
frontend (se aplicável) para interagir com o sistema.

## Contribuição

Se quiser contribuir com o projeto, sinta-se à vontade para abrir uma issue ou enviar um pull request. Toda ajuda é
bem-vinda!

---

© 2024 Vitor Fernandes - Todos os direitos reservados.
