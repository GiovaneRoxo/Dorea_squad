# Projeto Doreá

## 📖 Sobre o Projeto

Doreá é uma plataforma web desenvolvida como parte de um projeto na [Recode](https://recode.org.br/) em 2022. O objetivo é facilitar a conexão entre doadores e projetos que necessitam de recursos, contribuindo assim para a agenda de desenvolvimento sustentável da ONU, especificamente no que tange ao acesso igualitário a recursos escolares.

A plataforma permite que organizadores cadastrem seus projetos e que doadores possam visualizar esses projetos e realizar doações.

**Missão:** Reduzir o acesso desigual aos recursos escolares.
**Visão:** Suprir a desigualdade e promover o acesso aos estudos.
**Valores:** Gerar oportunidades a todos, com igualdade e equidade.

*(Baseado nas informações de `sobre.html`)*

## ✨ Tecnologias Utilizadas

* **Backend:** Java (Servlet API 4.0)
* **Frontend:** JSP (JavaServer Pages), HTML, CSS, JavaScript, Bootstrap 5
* **Bibliotecas Java:** JSTL 1.2 (para tags JSP - confirmar URI nos JSPs)
* **Servidor de Aplicação:** Apache Tomcat 9.0
* **Banco de Dados:** MySQL
* **IDE:** Eclipse IDE for Enterprise Java and Web Developers
* **Driver Banco:** MySQL Connector/J

## ⚙️ Pré-requisitos

Antes de começar, garanta que você tem as seguintes ferramentas instaladas:

1.  **Java Development Kit (JDK):** Versão 18 ou superior (o projeto foi configurado com facet 18, mas o Tomcat pode rodar com versões mais novas como 21). Recomenda-se alinhar a versão usada pelo Tomcat e pelo compilador do Eclipse com a do projeto (18).
2.  **Apache Tomcat:** Versão 9.0.x.
3.  **MySQL Server:** Versão 5.7 ou superior (recomendado 8.x).
4.  **Eclipse IDE:** Preferencialmente a versão "for Enterprise Java and Web Developers".
5.  **MySQL Connector/J:** O driver JDBC para conectar Java com MySQL.

## 🚀 Instalação e Execução

Siga estes passos para configurar e rodar o projeto localmente:

### 1. Configuração do Banco de Dados

1.  **Acesse seu MySQL** (via linha de comando, MySQL Workbench, etc.).
2.  **Crie o banco de dados `dorea`:**
    ```sql
    CREATE DATABASE dorea;
    USE dorea;
    ```
3.  **Crie as tabelas:** Você precisará criar as tabelas `organizador`, `doadores`, `projetos`, e `doacao`. Use os arquivos `.java` nas pastas `model` e `DAO` como referência para as colunas e tipos de dados. Abaixo, exemplos básicos (ajuste os tipos e tamanhos conforme necessário):
    ```sql
    -- Tabela Organizador
    CREATE TABLE organizador (
        Id_organizador INT AUTO_INCREMENT PRIMARY KEY,
        Nome VARCHAR(255) NOT NULL,
        Cnpj VARCHAR(20) UNIQUE NOT NULL,
        Email VARCHAR(100) UNIQUE NOT NULL,
        Telefone VARCHAR(20),
        Senha VARCHAR(50) NOT NULL
    );

    -- Tabela Doadores
    CREATE TABLE doadores (
        Id_doadores INT AUTO_INCREMENT PRIMARY KEY,
        Nome VARCHAR(40) NOT NULL,
        Sobrenome VARCHAR(40) NOT NULL,
        Cpf VARCHAR(14) UNIQUE NOT NULL,
        Email VARCHAR(50) UNIQUE NOT NULL,
        Telefone VARCHAR(15),
        Senha VARCHAR(16) NOT NULL
    );

    -- Tabela Projetos
    CREATE TABLE projetos (
        Id_projeto INT AUTO_INCREMENT PRIMARY KEY,
        Nome VARCHAR(255) NOT NULL,
        Objetivo DOUBLE DEFAULT 0.0,
        Arrecadado DOUBLE DEFAULT 0.0,
        fk_Organizador_Id_organizador INT,
        FOREIGN KEY (fk_Organizador_Id_organizador) REFERENCES organizador(Id_organizador) ON DELETE CASCADE -- Exclui projetos se o organizador for deletado
    );

    -- Tabela Doacao
    CREATE TABLE doacao (
        Id_doacao INT AUTO_INCREMENT PRIMARY KEY,
        Valor DOUBLE NOT NULL,
        fk_Doadores_Id_doadores INT,
        fk_Projetos_Id_projeto INT,
        FOREIGN KEY (fk_Doadores_Id_doadores) REFERENCES doadores(Id_doadores) ON DELETE SET NULL, -- Mantém a doação se o doador for deletado
        FOREIGN KEY (fk_Projetos_Id_projeto) REFERENCES projetos(Id_projeto) ON DELETE CASCADE -- Exclui doações se o projeto for deletado
    );
    ```
4.  **Verifique as Credenciais:** O arquivo `src/main/java/db/MySqlConnection.java` usa as seguintes credenciais:
    * URL: `jdbc:mysql://localhost:3306/dorea`
    * Usuário: `root`
    * Senha: `17fd2210`
    Certifique-se de que seu usuário `root` do MySQL tenha essa senha ou altere a senha no arquivo `MySqlConnection.java`.

### 2. Configuração no Eclipse IDE

1.  **Importe o Projeto:**
    * Abra o Eclipse.
    * `File` > `Import...` > `General` > `Existing Projects into Workspace`.
    * Selecione o diretório raiz onde está a pasta `dorea.app` (a pasta que contém `src`, não a pasta `dorea.app` em si).
    * Marque o projeto `dorea.app` e clique em `Finish`.
    * *Alternativa:* Se o Eclipse não reconhecer como projeto, crie um novo `Dynamic Web Project` (conforme instruções anteriores) e copie os arquivos/pastas para a estrutura correta (`src/main/java`, `src/main/webapp`).
2.  **Configure o Servidor Tomcat:**
    * Vá na view "Servers" (`Window` > `Show View` > `Servers`).
    * Crie um novo servidor `Apache Tomcat v9.0`, apontando para o diretório onde você instalou o Tomcat.
3.  **Adicione as Bibliotecas (JARs):**
    * Crie a pasta `src/main/webapp/WEB-INF/lib` se ela não existir.
    * Copie os seguintes arquivos JAR para dentro desta pasta `lib`:
        * **MySQL Connector/J:** O arquivo `.jar` do driver JDBC do MySQL (ex: `mysql-connector-j-8.X.XX.jar`).
        * **JSTL:** Se seus JSPs usam a URI `http://java.sun.com/jsp/jstl/core`, copie o `jstl-1.2.jar`. Se usam `jakarta.tags.core`, copie os JARs `jakarta.servlet.jsp.jstl-api-2.0.0.jar` e `jakarta.servlet.jsp.jstl-2.0.0.jar` (ou versões mais recentes). **Use apenas um conjunto!**
    * Clique com o botão direito no projeto > `Refresh`.
4.  **Verifique a Versão Java e Facets:**
    * Botão direito no projeto > `Properties`.
    * `Project Facets`: Garanta que "Dynamic Web Module" está marcado (versão 4.0) e "Java" está marcado (versão 18).
    * `Java Compiler`: Defina o "Compiler compliance level" para `18`.
    * `Java Build Path`: Na aba `Libraries`, confira se o "Apache Tomcat v9.0" e "Web App Libraries" (com seus JARs dentro) estão listados.

### 3. Executando o Projeto

1.  **Adicione o Projeto ao Servidor:**
    * Na view "Servers", clique com o botão direito no seu Tomcat > `Add and Remove...`.
    * Mova `dorea-app` para a coluna "Configured".
    * Clique em `Finish`.
2.  **Inicie o Servidor:**
    * Na view "Servers", clique com o botão direito no Tomcat > `Start`.
    * Acompanhe a saída no "Console" para verificar se há erros durante a inicialização e o deploy da aplicação.
3.  **Acesse a Aplicação:**
    * Abra seu navegador e acesse: `http://localhost:8080/dorea-app/`
    * *(O nome `/dorea-app/` pode variar se você alterou o "Context root" do projeto nas configurações do Eclipse ou do servidor).*

## ⚠️ Observação Importante: Arquivos JSP

A análise inicial dos arquivos fornecidos indica que vários arquivos `.jsp` (como `index.jsp`, `Logado.jsp`, `PerfilDoador.jsp`, `LogadoAdm.jsp`, etc.) são referenciados pelos Servlets (Controllers), mas o conteúdo desses arquivos `.jsp` pode não ter sido incluído no conjunto de arquivos original enviado.

**Para que a aplicação funcione completamente, é essencial que você possua todos os arquivos `.jsp` necessários e os coloque na estrutura de pastas correta dentro de `src/main/webapp/` (geralmente dentro de `pages` e suas subpastas como `doadorLogado`, `organizadorLogado`). Sem eles, você provavelmente encontrará erros 404 ao tentar acessar as páginas correspondentes.**

## 🏗️ Estrutura do Projeto (Simplificada)

* `src/main/java`: Contém todo o código fonte Java.
    * `db`: Classe de conexão com o banco de dados (`MySqlConnection.java`).
    * `model`: Classes que representam os dados (POJOs como `Doadores.java`, `Projetos.java`).
    * `DAO`: Classes responsáveis pelo acesso e manipulação dos dados no banco (ex: `DoadoresDAO.java`).
    * `controllers*`: Servlets Java que controlam o fluxo da aplicação, recebem requisições e enviam respostas (geralmente encaminhando para JSPs).
* `src/main/webapp`: Contém os arquivos que rodam no lado do cliente e arquivos de configuração web.
    * `css`: Arquivos de estilo CSS.
    * `js` ou `scriptjs`: Arquivos JavaScript.
    * `pages`: Arquivos HTML e JSP que compõem as telas da aplicação.
    * `WEB-INF`: Diretório especial para configurações e bibliotecas.
        *
