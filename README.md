# Sistema de Gerenciamento – Estruturas de Dados em Java

## 👨‍💻 Autor

Hugo Leonardo Pereira de Souza Leal

---

## 🚀 Como compilar e executar o programa

1. Certifique-se de que a estrutura do projeto esteja assim:

```
src/
 ├── app/
 │     └── App.java
 │
 ├── classes/
 │     ├── ArvoreServicos.java
 │     ├── Chamado.java
 │     ├── Servico.java
 │     ├── Cliente.java
 │     └── Operacao.java
 │
 ├── menus/
 │     ├── MenuArvoreServicos.java
 │     ├── MenuCliente.java
 │     ├── MenuFilaChamada.java
 │     ├── MenuOperacoes.java
 │     └── MenuPrincipal.java
 │
 └── util/
       └── Util.java   (métodos estáticos de apoio, como notificações e modelos de titulos)


2. Compile o projeto pelo terminal:
javac -d bin src/app/App.java


3. Execute o programa:
java -cp bin app.App

```


## 🧱 Estruturas de Dados Utilizadas

O sistema foi desenvolvido para demonstrar o uso prático de **Fila**, **Pilha**, **Lista** e **Árvore Binária**, cada uma aplicada em um módulo do menu principal.



### 🔹 1. Fila de Chamados

Estrutura usada: **Queue (Fila)**

* **Inserir novo chamado:** adiciona o chamado no fim da fila.
* **Atender próximo chamado:** remove o chamado da no inicio da fila (FIFO).
* **Listar fila de espera:** exibe todos os chamados aguardando atendimento.

A fila simula um atendimento real, o primeiro que chega é o primeiro que sai.


### 🔹 2. Pilha de Operações

Estrutura usada: **Stack (Pilha)**

* **Registrar operação manualmente:** empilha uma nova operação.
* **Desfazer última operação:** remove a operação do topo da pilha (LIFO).
* **Listar histórico:** mostra todas as operações registradas.

A pilha funciona como um histórico, armazena toda as ações realizadas pelas outras funções.


### 🔹 3. Lista de Clientes

Estrutura usada: **Lista**

* **Cadastrar novo cliente:** insere um cliente na lista.
* **Remover cliente pelo ID:** percorre a lista e remove o item com ID correspondente.
* **Buscar cliente pelo ID:** percorre a lista até encontrar o elemento.
* **Exibir todos os clientes:** mostra a lista completa.


---

### 🔹 4. Árvore de Serviços

Estrutura usada: **Árvore Binária de Busca (BST)**

* **Inserir serviço:** coloca o serviço na posição correta com base no código.
* **Buscar serviço por código:** percorre a árvore comparando valores.
* **Listar serviços em ordem crescente:** percorrimento **in-order**, exibindo os códigos em ordem.

---

## 📌 Observações finais

O sistema foi projetado com menus simples e independentes, permitindo testar cada estrutura separadamente conforme solicitado na avaliação.
