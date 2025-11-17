import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private String cpf;
    private Carrinho carrinho = new Carrinho();
    private List<Pedido> pedidos = new ArrayList<>();
    
    public Cliente() { super(); }
    public Cliente(int id, String nome, String email, String cpf) {
        super(id, nome, email); this.cpf = cpf;
    }
    
    public String getCpf() { return cpf; }
    public Carrinho getCarrinho() { return carrinho; }
    public List<Pedido> getPedidos() { return pedidos; }
    public void addPedido(Pedido p) { pedidos.add(p); }
    
    @Override
    public String getTipo() { return "Cliente"; }
}