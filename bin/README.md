
# Chikenitos API
<p align="center">
<img src="https://user-images.githubusercontent.com/50127863/114096293-eb962700-9894-11eb-9f44-3d08eb02ff0d.png">
</p>
CKN Api é uma aplicação Spring de baixa complexidade utilizada para consultar o preço de produtos, por meio do JPA armazena os dados que posteriormente serão catalizados para consumo para consumo da API.

Para a visualização foi criado um dashboard, Chikenitos Coin, que pode ser acessado através deste  <a href="https://dashboard-ckn-dhe84s063-danieldjgomes.vercel.app/"> link<a/>. 
 
<p align="center">
<img src="https://user-images.githubusercontent.com/50127863/114095663-12a02900-9894-11eb-92c2-2633073f3339.png">
</p>





Tabela de conteúdos
=================
- [Contexto](#contexto)
- [Tecnologia](#tecnologia)
  * [Back-End](#back-end)
    + [Spring](#spring)
    + [Heroku](#heroku)
  * [Front-End](#front-end)
    + [React](#react)
    + [Vercel](#vercel)



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
A plataforma selecionada para o deploy da aplicação foi o Heroku, o deploy é feito de forma contínua através deste repositorio. Foram utilizados dois add-ons, ClearDB MySQL, para persistencia de dados utilizando MySql e LogDNA, que facilita a leitura de logs da aplicação.


### Front-end

O front end foi feita de forma simplificada e minimalista, voltado para ser um dashboard demonstrativo da api, o diretório do front end pode ser encontrada <a href="https://github.com/danieldjgomes/Dashboard-CKN"> aqui<a/>. 


#### React

Foi utilizado o React para desenvolver o front end, trata-se uma Single-Page application contendo componentes da biblioteca Charts Js 3.0.2 para gerar e personalizar o grafico de valores por tempo.

#### Vercel

Foi realizado o deploy do front end foi realizado utilizando Vercel, o deploy é feito de forma contínua pelo diretório do github do dashboard.





