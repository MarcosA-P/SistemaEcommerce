import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class SistemaEcommerce {
    private static Scanner sc = new Scanner(System.in);
    private static List<Pessoa> pessoas = new ArrayList<>();
    private static List<Produto> produtos = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static ArquivoDAO<Pessoa> daoPessoa = new ArquivoDAO<>();
    private static ArquivoDAO<Produto> daoProduto = new ArquivoDAO<>();
    private static ArquivoDAO<Pedido> daoPedido = new ArquivoDAO<>();

    public static void main(String[] args) {
        carregarDados();
        menu();
    }

    private static void menu() {
        while(true) {
            System.out.println("\n=== E-COMMERCE ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Funcionario");
            System.out.println("3. Cadastrar Administrador");
            System.out.println("4. Cadastrar Produto");
            System.out.println("5. Listar Pessoas");
            System.out.println("6. Listar Produtos");
            System.out.println("7. Adicionar Carrinho");
            System.out.println("8. Fazer Pedido");
            System.out.println("9. Listar Pedidos");
            System.out.println("10. Relatorio");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            String op = sc.nextLine();

            switch(op) {
                case "1": cadastrarCliente(); break;
                case "2": cadastrarFuncionario(); break;
                case "3": cadastrarAdministrador(); break;
                case "4": cadastrarProduto(); break;
                case "5": listarPessoas(); break;
                case "6": listarProdutos(); break;
                case "7": addCarrinho(); break;
                case "8": fazerPedido(); break;
                case "9": listarPedidos(); break;
                case "10": relatorio(); break;
                case "0": salvarSair(); return;
                default: System.out.println("Opcao invalida!");
            }
        }
    }

    private static void cadastrarCliente() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("CPF: ");
            String cpf = sc.nextLine();

            if(!Validador.cpfValido(cpf)) {
                System.out.println("CPF invalido!");
                return;
            }

            pessoas.add(new Cliente(id, nome, email, cpf));
            System.out.println("Cliente cadastrado!");
        } catch(Exception e) {
            System.out.println("Erro de cadastro" + e.getMessage());
        }
    }

    private static void cadastrarFuncionario() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Cargo: ");
            String cargo = sc.nextLine();

            pessoas.add(new Funcionario(id, nome, email, cargo));
            System.out.println("Funcionario cadastrado!");
        } catch(Exception e) {
            System.out.println("Erro de cadastro " + e.getMessage());
        }
    }

    private static void cadastrarAdministrador() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();

            pessoas.add(new Administrador(id, nome, email));
            System.out.println("Administrador cadastrado!");
        } catch(Exception e) {
            System.out.println("Erro de cadastro" + e.getMessage());
        }
    }

    private static void cadastrarProduto() {
        try {
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Preco: ");
            double preco = Double.parseDouble(sc.nextLine());
            System.out.print("Estoque: ");
            int estoque = Integer.parseInt(sc.nextLine());

            produtos.add(new Produto(id, nome, preco, estoque));
            System.out.println("Produto cadastrado!");
        } catch(Exception e) {
            System.out.println("Erro de cadastro" + e.getMessage());
        }
    }

    private static void listarPessoas() {
        System.out.println("\n--- PESSOAS CADASTRADAS ---");
        if(pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }
        for(Pessoa p : pessoas) {
            System.out.println(p.getId() + " | " + p.getNome() + " | " +
                    p.getEmail() + " | " + p.getTipo());
        }
    }

    private static void listarProdutos() {
        System.out.println("\n--- PRODUTOS CADASTRADOS ---");
        if(produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for(Produto p : produtos) {
            System.out.println(p.getId() + " | " + p.getNome() +
                    " | R$" + p.getPreco() + " | Estoque: " + p.getEstoque());
        }
    }

    private static void addCarrinho() {
        try {
            System.out.print("CPF do Cliente: ");
            String cpf = sc.nextLine();
            Cliente c = buscarCliente(cpf);
            if(c == null) {
                System.out.println("Cliente nao encontrado!");
                return;
            }

            System.out.print("ID do Produto: ");
            String id = sc.nextLine();
            Produto p = buscarProduto(id);
            if(p == null) {
                System.out.println("Produto nao encontrado!");
                return;
            }

            System.out.print("Quantidade: ");
            int q = Integer.parseInt(sc.nextLine());

            if(q <= 0) {
                System.out.println("Quantidade deve ser maior que zero!");
                return;
            }

            c.getCarrinho().addProduto(p, q);
            System.out.println("Produto adicionado ao carrinho!");
        } catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void fazerPedido() {
        try {
            System.out.print("CPF do Cliente: ");
            String cpf = sc.nextLine();
            Cliente c = buscarCliente(cpf);
            if(c == null) {
                System.out.println("Cliente nao encontrado!");
                return;
            }

            Carrinho car = c.getCarrinho();
            if(car.vazio()) {
                System.out.println("Carrinho vazio!");
                return;
            }

            Pedido ped = new Pedido("PED" + (pedidos.size()+1), c, LocalDate.now());
            for(ItemPedido item : car.getItens()) {
                ped.addItem(item);
            }

            ped.processar();
            pedidos.add(ped);
            c.addPedido(ped);
            car.limpar();

            System.out.println("Pedido criado com sucesso!");
            System.out.println("Numero: " + ped.getId());
            System.out.println("Total: R$" + ped.getTotal());
            System.out.println("Status: " + ped.getStatus());

        } catch(Exception e) {
            System.out.println("Erro ao criar pedido: " + e.getMessage());
        }
    }

    private static void listarPedidos() {
        System.out.println("\n--- PEDIDOS REALIZADOS ---");
        if(pedidos.isEmpty()) {
            System.out.println("Nenhum pedido realizado.");
            return;
        }
        for(Pedido p : pedidos) {
            System.out.println(p.getId() + " | " + p.getCliente().getNome()
                    + " | R$ " + p.getTotal() + " | " + p.getStatus());
        }
    }

    private static void relatorio() {
        try {
            String arquivo = "relatorio_pedidos.txt";
            PrintWriter pw = new PrintWriter(new FileWriter(arquivo));

            pw.println("=== RELATORIO DE PEDIDOS ===");
            pw.println("Data: " + LocalDate.now());
            pw.println("============================");

            for(Pedido p : pedidos) {
                pw.println(p.getId() + " | " + p.getCliente().getNome() +
                        " | R$" + p.getTotal() + " | " + p.getStatus());
            }

            pw.close();
            System.out.println("Relatorio salvo em: " + arquivo);

        } catch(Exception e) {
            System.out.println("Erro ao gerar relatorio: " + e.getMessage());
        }
    }

    private static void salvarSair() {
        try {
            daoPessoa.salvar(pessoas, "pessoas.dat");
            daoProduto.salvar(produtos, "produtos.dat");
            daoPedido.salvar(pedidos, "pedidos.dat");
            System.out.println("Dados salvos com sucesso! Saindo...");
        } catch(Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private static void carregarDados() {
        try {
            pessoas = daoPessoa.carregar("pessoas.dat");
            produtos = daoProduto.carregar("produtos.dat");
            pedidos = daoPedido.carregar("pedidos.dat");
            System.out.println("Dados anteriores carregados!");
        } catch(Exception e) {
            System.out.println("Iniciando com dados novos...");
        }
    }

    private static Cliente buscarCliente(String cpf) {
        for(Pessoa p : pessoas) {
            if(p instanceof Cliente) {
                Cliente c = (Cliente) p;
                if(c.getCpf().equals(cpf)) return c;
            }
        }
        return null;
    }

    private static Produto buscarProduto(String id) {
        for(Produto p : produtos) {
            if(p.getId().equals(id)) return p;
        }
        return null;
    }
}