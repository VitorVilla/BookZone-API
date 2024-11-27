
# Bookzone API com Docker

Este repositório contém a aplicação **Bookzone API** com Docker para facilitar a orquestração da API, banco de dados PostgreSQL e Grafana. A seguir, estão os passos necessários para compilar e subir os containers, além de configurar o acesso ao Grafana.

## Passos para Build e Execução

### 1. Build do `.jar` sem rodar os testes

Primeiro, é necessário compilar o código e gerar o arquivo `.jar`. Para isso, você pode executar o comando abaixo no diretório do projeto:

#### Usando Maven:

```bash
mvn clean package -DskipTests
```

Este comando vai gerar o arquivo `.jar` na pasta `target/` do projeto, **ignorando a execução dos testes**.

#### Usando Gradle:

```bash
./gradlew build -x test
```

Este comando vai gerar o arquivo `.jar` na pasta `build/libs/`, **ignorando a execução dos testes**.

### 2. Instalando o Docker

Se você ainda não tem o Docker instalado, siga os passos abaixo:

#### Para sistemas Linux:

1. **Instalar o Docker**:
   - Atualize o repositório de pacotes:

     ```bash
     sudo apt-get update
     ```

   - Instale o Docker:

     ```bash
     sudo apt-get install docker.io
     ```

2. **Verificar se o Docker foi instalado corretamente**:

   ```bash
   docker --version
   ```

#### Para Windows/Mac:

1. Baixe o **Docker Desktop** para [Windows](https://www.docker.com/products/docker-desktop) ou [Mac](https://www.docker.com/products/docker-desktop).
2. Siga as instruções de instalação no site.
3. Após a instalação, abra o Docker Desktop e aguarde ele inicializar.

### 3. Subindo os Containers com Docker Compose

Agora, com o Docker e o Docker Compose instalados, você pode subir os containers definidos no arquivo `docker-compose.yml` que orquestra a API, o banco de dados PostgreSQL e o Grafana.

#### Subir os containers:

No diretório raiz do projeto, onde está o arquivo `docker-compose.yml`, execute o comando:

```bash
docker-compose up --build
```

Este comando vai:
- Construir os containers se necessário (com `--build`).
- Subir a API, o banco de dados PostgreSQL e o Grafana.

### 4. Acessando a API e Grafana

#### API

Após os containers estarem em execução, você pode acessar a **Bookzone API** no seguinte endereço:

```
http://localhost:8080
```

#### Grafana

O Grafana estará disponível na porta **3000**. Para acessar o Grafana, abra o navegador e vá para:

```
http://localhost:3000
```

##### Login no Grafana:

- **Usuário**: `admin`
- **Senha**: `admin` (esta senha pode ser alterada no arquivo `docker-compose.yml`)

### 5. Parar os Containers

Para parar os containers quando terminar, use o comando:

```bash
docker-compose down
```

Este comando irá parar e remover os containers criados pelo Docker Compose.

---

## Considerações Finais

Agora sua aplicação e banco de dados devem estar em execução dentro de containers Docker. Lembre-se de sempre **não** versionar arquivos sensíveis como o arquivo `.env` ou informações de banco de dados diretamente no Git. Utilize variáveis de ambiente ou um arquivo `.env` para garantir que credenciais não sejam expostas.

Se você encontrar algum problema, verifique os logs do Docker para obter mais informações:

```bash
docker-compose logs
```
