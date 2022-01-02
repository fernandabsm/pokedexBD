<h1>Pokédex</h1>

### Um sistema de controle de Pokémons. A ideia por trás desse projeto é: 
#### Com o aumento do número de membros em uma equipe, consequentemente houve o aumento das movimentações de Pokémons. Esse sistema fará o registro de captura de novos Pokémons, bem como permitirá a exclusão de Pokémons perdidos e também a inclusão e exclusão de treinadores. O objetivo da equipe é alavancar seu desempenho em campeonatos. Para isso foram convocados vários novos treinadores. Com esse novo sistema, terão um banco de dados dos Pokémons que todos os treinadores capturaram, com isso poderão garantir que os Pokémons sejam treinados e usados por todos os membros quando assim for necessário, não apenas por quem capturou. Ou seja, se um treinador fará uma batalha com o treinador de outra equipe, poderá usar quaisquer Pokémons que estejam disponíveis para batalha.

## Especificações

Este projeto foi criado utilizando a linguagem Java e os conceitos de programação orientada a objetos. Para guardar, manipular e consultar os dados foi utilizado um banco de dados criado utilizando o SGBD MySQL Workbench 8.0.

Ele está dividido em pacotes, cada qual com uma responsabilidade. Escolhemos nomeá-los de forma padrão, começando por br.com.pokedex e terminando por um termo que representa sua responsabilidade:<br>

📁 br.com.pokedex.view <br> <br>
Contém as classes que são responsáveis pela interação com o usuário. São elas:
+ LoginForm -> É a tela de login, esta oferece a opção de logar ou cadastrar, recebe como dados o e-mail e senha de um treinador. É primeira tela a ser exibida pelo sistema.
+ CadastroForm -> É a tela de cadastro. Recebe como dados o e-mail, senha e CPF de um treinador. Essa tela é exibida caso deseje-se cadastrar um novo login para um treinador.
+ MenuForm -> Caso o login seja efetuado com sucesso, essa é a tela seguinte. Para o usuário com nível de acesso "Integrante", possui os menus: Pokémons - submenu: Acesso aos Pokémons, Configurações - submenu: Trocar de Usuário, e Sair. Para o nível de acesso "Líder", além destes, também possui o menu Treinadores com submenu Acesso aos Treinadores.  
+ PokemonForm -> Tela de acesso aos pokémons. Essa tela contém as abas "Dados Cadastrais" e "Pesquisar". Nela, um treinador é capaz de adicionar um novo Pokémon ao banco de dados, acessar a lista de Pokémons, pesquisar por um Pokémon específico, atualizar os dados de um Pokémon e excluir.
+ TreinadorForm -> Tela de acesso aos treinadores. Apenas os líderes tem acesso. Contém as mesmas abas e funcionalidades da tela de Pokémons, porém para os treinadores.
+ GinasioForm -> Tela de acesso aos ginásios. Contém as mesmas abas e funcionalidades da tela de Pokémons e Treinadores.
+ BatalhaForm -> Tela de acesso às batalhas. Contém as mesmas abas e funcionalidades das demais telas, exceto a possibilidade de exclusão.<br><br>

📁 br.com.pokedex.model <br> <br>
Pacote que contém os objetos do sistema. Os dados que são recebidos através das telas de interação são encapsulados nesses objetos. São eles: 
- Pokemon -> Objeto que representa um Pokémon. Possui os atributos:<br>
◻️ nome<br>
◻️ tipo<br>
◻️ localCaptura<br>
◻️ dataCaptura<br>
◻️ evolucao<br>
◻️ idPokemon <br>
◻️ cpfTreinador <br>
</ul></li>

<ul><li> Treinador -> Objeto que representa um Treinador. Possui os atributos:<br>
◻️ nome<br>
◻️ cpf<br>
◻️ endereco<br>
◻️ ranking<br>
</ul></li>

<ul><li> Ginasio -> Objeto que representa um Ginasio. Possui os atributos:<br>
◻️ endereco<br>
◻️ nome<br>
◻️ tipo<br>
</ul></li>

<ul><li> Treinador -> Objeto que representa uma Batalha. Possui os atributos:<br>
◻️ enderecoGinasio<br>
◻️ cpfTreinador<br>
◻️ adversario<br>
◻️ status<br>
◻️ vencedor<br>
</ul></li>

📁 br.com.pokedex.dao <br> <br>
Pacote que recebe os objetos criados e encapsulados no pacote model e interage com o banco de dados, ou seja, é nesse pacote que serão criados os comandos SQL, bem como serão implementados os métodos que executam esses comandos. A sigla DAO vem de <i>Data Access Object</i>. Possui as classes:
- PokemonDAO -> Implementa os métodos que executam as ações que foram citadas na descrição do pacote br.com.pokedex.view para o caso dos Pokémons, interagindo com a tabela pokemon do BD.
- TreinadorDAO -> Implementa os métodos que executam as ações que foram citadas na descrição do pacote br.com.pokedex.view para o caso dos Treinadores, interagindo com a tabela treinador do BD.<br> <br>
- GinasioDAO -> Implementa os métodos que executam as ações que foram citadas na descrição do pacote br.com.pokedex.view para o caso dos Ginásios, interagindo com a tabela ginasio do BD.<br> <br>
- BatalhaDAO -> Implementa os métodos que executam as ações que foram citadas na descrição do pacote br.com.pokedex.view para o caso das Batalhas, interagindo com a tabela batalha do BD.<br> <br>
- LoginDAO -> Implementa os métodos que executam as ações que foram citadas na descrição do pacote br.com.pokedex.view para o caso do Login, interagindo com a tabela batalha do BD.<br> <br>

📁 br.com.pokedex.jdbc <br> <br>
Pacote responsável por criar a conexão entre a IDE e o MySQL através da classe ConnectionFactory.<br> <br>

📁 images <br> <br>
Este pacote é um pacote extra dos demais e não segue o mesmo padrão pois sua única responsabilidade é armazenar as imagens e ícones a serem utilizadas na interface.<br> <br>

## Instalação do projeto 
#### ⚠️ Por questões envolvendo a interface, recomenda-se fortemente o uso da IDE <a target="_blank" href="https://netbeans.apache.org/download/nb124/nb124.html">NetBeans</a> para a execução desse projeto.

✔️ Inclua a biblioteca <a target="_blank" href="https://drive.google.com/file/d/1GaijUqzwA_Fv-UFC8bQqwCM9roym7yV4/view?usp=sharing">mysql-connector-java-8.0.25</a> à sua IDE para poder conectá-la ao BD. <br>
✔️ Caso não possua, instale o <a target="_blank" href="https://dev.mysql.com/downloads/connector/j/">MySQL</a>. <br>
✔️ Execute o script <a target="_blank" href="https://github.com/fernandabsm/pokedexScriptSQL">PokedexScript</a>. <br>
✔️ Instale a fonte <a target="_blank" href="https://pt.ffonts.net/NATS.font.download">NATS</a> no seu SO. <br>
✔️ Clone este repositório na sua máquina. <br>
✔️ Crie um primeiro usuário com ranking "Líder" executando a classe <b>TreinadorForm</b>.<br>
✔️ Execute o projeto a partir da classe <b>LoginForm</b>.<br>

Tendo testado pela IDE, você já está pronto para criar o arquivo executável. 🥳

