# Chikenitos API
<p align="center">
<img src="https://user-images.githubusercontent.com/50127863/114079121-2b064880-9880-11eb-8aa6-08681a28fe31.png">
</p>
CKN Api é uma aplicação Spring de baixa complexidade utilizada para consultar o preço de produtos, por meio do JPA armazena os dados que posteriormente serão catalizados para consumo para consumo da API.
[![Heroku](https://heroku-badge.herokuapp.com/?app=ckn-api)]



Tabela de conteúdos
=================
- [Contexto](#contexto)
- [Tecnologia](#tecnologia)
  * [Back-End](#Back-end)
    + [Spring](#Spring)
    + [Heroku](#Heroku)
  * [Front-End](#Front-End)
    + [React](#React)
    + [Vercel](#Vercel)
- [Dashboard](#Dashboard)



## Contexto

 Em um contexto descontraido entre amigos era discutido a utilização do preço do chikenitos, também conhecido como nugget de frango, como parametro para o preço de produtos vendidos. "Isso está muito caro, sabe quantos chikenitos eu consigo comprar com esse valor?", se tornou uma frases comum entre as conversas. Estrapolando a piada e se tornando então uma unidade em si, foi necessário uma padronização e logo surgiu a ideia de criar uma aplicação para definir preço atual do chikenitos.

## Tecnologia

 Apesar de ser uma ferramenta simples,  fora utilizadas iversas erramentas para sua aplicação, tanto no backend, quanto no front end.

### Back-end

#### Spring

 Para desenvolvimento do back-end foi utilizado o framework Spring. Para fazer a configuração e inicialização da aplicação foi utilizada a versão 2.3.8 do Spring Boot e Spring Data JPA.
 No planejamento do projeto foi primordialmente idealizado uma estrutura UML, a estrutura de classes de domínio ficou da seguinte forma:
  
 <p align="center">
<img src="https://user-images.githubusercontent.com/50127863/114086762-66f1db80-9889-11eb-902e-174f8b8d5fc6.png">
</p>

Foi planejado segmentar a aplicação em três blocos distintos:

### Pesquisa
Responsável pela persistência dos dados minerados pela aplicação, cada consulta realizada é salva como um objeto Pesquisa no contexto de persistência do projeto, algumas classes foram desenvolvidas para uma futura implementação de security e podem estar comentadas no código final, a estrutura do bloco é descrito pelo UML abaixo:
<p align="center">
<img src="https://user-images.githubusercontent.com/50127863/114090161-71ae6f80-988d-11eb-8663-4a8f9c8a2203.png">
</p>

### Mineracao 
Responsável pela busca dos dados atraves do Jsoup, através da estrutura HTML da pagina, ele busca através de classes ou chaves de texto o preço do produto, após obter o dado, é instanciada a classe PesquisaRoot para realizar a persistência dos dados, a estrutura do bloco é descrito pelo UML abaixo:

<p align="center">
<img src="https://user-images.githubusercontent.com/50127863/114091692-5b091800-988f-11eb-871d-4ef9f94c8dc9.png">
</p>

A inversão de dependência neste bloco foi essencial para a estruturação e legibilidade do código, caso queira entender um pouco mais sobre este conceito, recomendo que leia meu artigo sobre o assunto, que pode ser acessado <a href="https://dev.to/danieldjgomes/injecao-de-dependencias-com-spring-ib"> aqui<a/>.

### Relatorio
Responsável pela combinação das pesquisas de forma que gere relatórios de valor diário, semanal e mensal da média das pesquisas naquele periodo, deste modo é estipulado o valor da moeda, a estrutura do bloco é descrito pelo UML abaixo:

<p align="center">
<img src="https://user-images.githubusercontent.com/50127863/114093056-06669c80-9891-11eb-9ae6-237e81db3fe9.png">
</p>


#### Heroku

This is an h3 heading

### Front-end

This is an h2 heading


#### React

This is an h3 heading

#### Vercel

This is an h3 heading

## Dashboardd

This is an h1 heading



