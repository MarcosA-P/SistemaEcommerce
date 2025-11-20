
# Sistema E-commerce

## Integrantes do grupo:
### Cicero Nathan, Marcos Avelino, Anna Beatriz.


Descrição do Sistema: Sistema de e-commerce completo desenvolvido em Java que permite:
- Cadastro e gestão de clientes, funcionários e administradores
- Controle de produtos e estoque com categorias
- Carrinho de compras integrado
- Processamento de pedidos com múltiplos status
- Sistema de pagamento (Cartão, Boleto, PIX)
- Relatórios de vendas por período
- Persistência de dados via serialização
- Validações de CPF e estoque

# Como Executar
- Pré requisitos: Java 17 ou superior
- Terminal/Command Prompt
- 1- Clone o repositório: git clone [url-do-repositorio]
- 2- Compile todos os arquivos: javac *.java
- 3- Execute o sistema: java MenuPrincipal

# Conceitos Implementados:
Programação Orientada a Objetos:
- Herança: Pessoa → Cliente, Funcionario, Administrador.
- Polimorfismo: Método getTipo() nas subclasses.
- Encapsulamento: Atributos privados com getters/setters.
- Abstração: Classe Pessoa abstrata.

Relacionamentos entre Classes:
- 1:N: Categoria → Produto, Cliente → Pedido.
- N:N: Pedido ↔ Produto (via ItemPedido).
- 1:1: Cliente ↔ Carrinho, Pedido ↔ Pagamento.

Padrões e Técnicas:
- Serialização: ArquivoDAO para persistência
- Generics: ArquivoDAO<T> para reutilização
- Enums: Pedido.Status, Pagamento.Metodo
- Exceptions Personalizadas: CPFInvalidoException, EstoqueInsuficienteException

## 🎯 Conceitos Implementados (MAPEAMENTO COMPLETO)

### 1️⃣ Estruturas Lógicas
- **Onde:** MenuPrincipal.java (linhas X-Y) - switch cases e loops
- **Onde:** Validador.java (linhas X-Y) - if/else para validações

### 2️⃣ Construtores
- **Onde:** Pessoa.java - 2 construtores implementados
- **Onde:** Cliente.java - 2 construtores implementados

### 3️⃣ Encapsulamento
- **Onde:** TODAS as classes - atributos privados + getters/setters
- **Onde:** Cliente.setCpf() - validação no setter

### 4️⃣ Herança + Abstract
- **Onde:** Pessoa (abstract) → Cliente, Funcionario, Administrador
- **Onde:** Método abstrato getTipo() implementado nas filhas

### 5️⃣ Polimorfismo + ArrayList + Relacionamentos
- **Onde:** ArrayList<Pessoa> para lista polimórfica
- **Onde:** 1:N - Categoria → Produto
- **Onde:** N:N - Pedido ↔ Produto (via ItemPedido)

### 6️⃣ Serialização
- **Onde:** ArquivoDAO.java - salvar/carregar objetos
- **Onde:** Classes implementam Serializable

### 7️⃣ Exception + Entrada/Saída
- **Onde:** CPFInvalidoException.java - exception customizada
- **Onde:** EstoqueInsuficienteException.java - exception customizada
- **Onde:** MenuPrincipal - try/catch blocks
- **Onde:** Relatórios em .txt



