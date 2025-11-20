
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



