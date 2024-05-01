# Anotagções Importantes

- Acesso ao banco de dados H2 in-memory: `localhost:8080/h2-console/`

**Sumário:**

- [Anotagções Importantes](#anotagções-importantes)
  - [1 - Configurando Ambiente](#1---configurando-ambiente)
  - [2 - Criando Estrutura de Projeto](#2---criando-estrutura-de-projeto)
  - [3 - Entendendo Estrutura](#3---entendendo-estrutura)
  - [4 - Entendendo o que é Controller](#4---entendendo-o-que-é-controller)
  - [5 - Funcionalidade de usuário](#5---funcionalidade-de-usuário)
  - [6 - Getters e Setters](#6---getters-e-setters)
  - [7 - Lombok](#7---lombok)
  - [8 - Banco de Dados](#8---banco-de-dados)
  - [9 - Criando Tabela Usuário](#9---criando-tabela-usuário)

## 1 - Configurando Ambiente

Neste mini-curso, você criará uma API para controle de Tasks, um To-Do List. Irá aprender a criar rotas HTTP, receber e validar parâmetros, integrar com banco de dados e autenticação com JWT, utilizando o Spring Security. Por fim, irá realizar o deploy na plataforma Render.

Nesta aula, vamos aprender a configurar o ambiente de desenvolvimento para a nossa aplicação. Você terá acesso a uma documentação com um passo a passo detalhado de como configurar o Java, o Maven e a sua IDE (no caso, o VS Code). Além disso, você pode optar por instalar uma extensão de cliente REST no VS Code, como o API Dog, Insomnia ou Postman. Certifique-se de ter esses quatro pontos configurados antes de prosseguir para a próxima aula. A documentação também explica como verificar se o Java está configurado corretamente e como instalar o Maven. Por fim, é importante instalar as extensões necessárias no VS Code para utilizar o Spring Boot.

## 2 - Criando Estrutura de Projeto

Nesta aula, vamos aprender a criar a estrutura de uma aplicação em Spring Boot. Existem várias formas de fazer isso, mas vamos utilizar o Spring Initializer, um site disponibilizado pela Spring que nos permite configurar nosso projeto e adicionar as dependências necessárias. No Spring Initializer, selecionamos o tipo de gerenciador de pacotes (Maven ou Gradle), a linguagem (Java, Kotlin, Groovy), a versão do Spring Boot e as informações do projeto, como o grupo, o nome e a descrição. Também podemos escolher o tipo de empacotamento (JAR ou WAR) e adicionar as dependências necessárias, como a Spring Web para criar uma aplicação RESTful. Depois de gerar o projeto, podemos compartilhar o link com outras pessoas. Na aula, também menciono outras formas de criar uma aplicação em Spring Boot, como utilizar o Maven pelo terminal.

## 3 - Entendendo Estrutura

Nesta aula, vamos entender a estrutura de um projeto Spring Boot. Vamos analisar as pastas principais que são criadas ao construir um projeto, como a pasta .mvn, que contém o gerenciador de pacotes. Também vamos explorar a pasta src, que contém as pastas Main e Test, onde colocamos o código da aplicação e os testes, respectivamente. Vamos entender como as dependências são gerenciadas pelo Spring Boot e como as annotations são utilizadas para configurar a aplicação. Por fim, vamos analisar a estrutura de pacotes e importações de classes no Java.

## 4 - Entendendo o que é Controller

Nesta aula, vamos criar a primeira rota em nossa aplicação usando o Spring Boot. Para isso, precisamos entender a estrutura de uma rota no Spring Boot. Vamos criar uma classe chamada `MinhaPrimeiraController` dentro de uma pasta chamada `controller`. A controller é responsável por receber as requisições do usuário e encaminhá-las para as demais camadas da aplicação. Existem duas formas de criar uma controller: utilizando o `@Controller` ou o `@RestController`. A diferença entre eles é que o `@Controller` permite retornar páginas, enquanto o `@RestController` é utilizado para construir uma API. Vamos definir a rota utilizando a anotação `@RequestMapping` e o método HTTP que queremos utilizar (GET, POST, PUT, DELETE, PATCH). Em seguida, definimos o método que será chamado quando essa rota for acessada. É importante lembrar que os pacotes devem estar corretamente estruturados para que o Spring possa gerenciá-los adequadamente.

## 5 - Funcionalidade de usuário

Nesta aula, começamos a criar as funcionalidades da nossa aplicação. Removemos a pasta Controller e criamos um novo pacote chamado User para centralizar tudo relacionado ao usuário. Começamos criando o `UserController` e explicamos como definir o nome da classe e do arquivo. Em seguida, falamos sobre os tipos de dados em Java, como string, integer, double, float, char e date. Também mencionamos o tipo void quando não há retorno. Criamos o método create, que recebe os dados do usuário a ser cadastrado. Explicamos como criar um objeto `UserModel` para representar o usuário e como receber os dados em formato JSON no corpo da requisição. Por fim, utilizamos o System.out.println para exibir o nome do usuário no terminal e definimos o método como POST usando a anotação `@PostMapping`.

## 6 - Getters e Setters

Nesta aula, vamos aprender sobre os métodos getters e setters em Java. Quando definimos atributos como privados em uma classe, precisamos informar como esses atributos podem ser acessados por outras classes. Os getters são usados para buscar informações dos atributos, enquanto os setters são usados para atualizar ou inserir valores nos atributos. No Spring Boot, ele já faz todo o gerenciamento desses métodos, então só precisamos definir os atributos e o Spring Boot cuidará do resto. Vamos criar os getters e setters para os atributos username, name e password na classe UserModel. Depois, podemos utilizar esses métodos para recuperar e atribuir valores aos atributos.

## 7 - Lombok

Nesta aula, vamos aprender sobre o **Lombok**, uma biblioteca do Java que nos permite otimizar a criação de getters, setters e outros métodos, como construtores e `toString`. O **Lombok** utiliza annotations para definir quais métodos queremos incluir em nosso projeto. Para utilizá-lo, precisamos adicionar a dependência do **Lombok** em nosso arquivo `.xml`. Podemos utilizar a annotation `@Data` para gerar automaticamente os getters e setters para todos os atributos de uma classe. Também é possível utilizar as annotations `@Getter` e `@Setter` para gerar apenas os *getters* ou *setters*, respectivamente. O **Lombok** nos ajuda a deixar nosso código mais limpo e legível.

## 8 - Banco de Dados

Nesta aula, vamos aprender como armazenar informações de usuários em um banco de dados usando o **Spring Data JPA**. O **Spring Data JPA** é um projeto do Spring que nos permite fazer a comunicação com o banco de dados e manipular os dados de forma fácil. Ele utiliza o conceito de ORM (Mapeamento Objeto-Relacional) para transformar objetos em uma forma que o banco de dados entenda. Vamos utilizar o H2 como banco de dados em memória para fins de aprendizado, mas em produção, você pode usar outros bancos de dados como PostgreSQL ou MySQL. Vamos configurar as dependências no arquivo pom.xml e também configurar o H2 no arquivo application.properties. Depois de configurado, podemos acessar o console do H2 para verificar se está tudo funcionando corretamente. Nas próximas aulas, vamos construir as tabelas e entender como o **Spring Data JPA** se comunica com o banco de dados.

## 9 - Criando Tabela Usuário

Nesta aula, começamos a criar a tabela de usuários em nossa aplicação usando o conceito de ORM (Object-Relational Mapping). Definimos a entidade "User" como nossa tabela de usuários no banco de dados. Também adicionamos a chave primária, que é um ID único gerado automaticamente usando o tipo UUID. Além disso, definimos outros atributos como colunas na tabela, como "Username", "Password", "Name" e "CreatedAt". Observamos que o banco de dados utiliza o padrão de separação de palavras com underline.
