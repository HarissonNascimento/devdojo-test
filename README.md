<img src="https://img.shields.io/github/workflow/status/HarissonNascimento/devdojo-test/devdojo-test%20CI" alt="Project Workflow Badge"/>

## 💬O que há neste documento
* [Missão do projeto]()
* [Mapeamento]()
* [Dados para autenticação]()
* [Executando o projeto com Docker]()
* [Executando o projeto localmente]()
* [Endpoints dispoiveis]()

## 🔨Missão do projeto
Dentro de 48 horas desenvolver um endpoint que retorne uma lista de transações bancárias mapeando o json para os campos descritos na [tabela abaixo](https://github.com/HarissonNascimento/devdojo-test#mapeamento) (coluna Mapeamento no DevDojo).

A requisição deverá ser feita para /transactions/{accountId} e o endpoint deverá retornar o conteúdo do arquivo [transactions.json]() mapeado para os campos

Observação

    • Somente usuários autenticados poderão acessar esse endpoint.
    • Cada usuário deve ter 1 accountId e ele deve ser único por usuário. Exemplo: William tem uma conta 123,  David tem uma conta 890. O usuário William não poderá ver as transações da conta 890 e o usuário David não poderá ver as transações da conta 123. Caso tente, deverá ser retornado o status 403.
    • Não tem problema retornar as mesmas transações para ambas as contas, disponíveis no arquivo transactions.json
   
## 📰Mapeamento

|        Campos originais      	|             Mapeamento no DevDojo            	|
|:----------------------------:	|:--------------------------------------------:	|
| encodedKey                   	| id                                           	|
| parentAccountKey             	| arrangementId                                	|
| creationDate                 	| bookingDate                                  	|
| type                         	| type                                         	|
| valueDate                    	| valueDate                                    	|
| amount                       	| amount                                       	|
| currencyCode                 	| currencyCode                                 	|
| currencyCode                 	| currency                                     	|
| amount                       	| creditDebitIndicator (DEBIT < 0, CREDIT >=0) 	|
| accountBalances.totalBalance 	| runningBalance                               	|
| id                           	| counterPartyAccountNumber                    	|
| parentAccountKey             	| reference                                    	|
| type                         	| typeGroup                                    	|
| amount                        | instructedAmount                              |

## 👮Dados para autenticação

Assim que o projeto é executado, é inserido no banco de dados 4 usuários, são eles

|   Username   |   Senha   |
|:------------:|:----------|
| admin        | root      |
| Harisson     | harisson  |
| William      | william   |
| David        | david     |

## 🐳Executando o projeto com Docker

* Requisito: [Docker](https://docs.docker.com/get-docker/)

Execute o docker, abra o terminal em '.../devdojo-test' e execute o comando:

```sh
docker-compose up
```

## 💻Executando o projeto localmente
* Requisito: [Maven](https://maven.apache.org/download.cgi)

Abra o terminal em '.../devdojo-test' e execute:

```sh
mvn clean install
```
Após terminal a instalação, execute:

```sh
mvn spring-boot:run
```

## 🔥Endpoints dispoiveis
Após executar o projeto você terá a aplicação rodando em **http://localhost:8080/<endpoint>**

|           endpoint          	|                                 função                                 	|
|:---------------------------:	|:----------------------------------------------------------------------:	|
|            /login           	|                             pagina de login                            	|
|            /login?logout     	|                             pagina de logout                           	|
| /transactions/\<accountId\> 	|                     lista as transações do usuário                     	|
|        /admin/listAll       	| lista todas as contas dos usuários(necessário estar logado como admin) 	|

>>NOTA: Para recuperar o accountId de uma conta basta logar como admin e acessar /admin/listAll

