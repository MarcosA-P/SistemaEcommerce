import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable {
    private String id;
    private Cliente cliente;
    private List<ItemPedido> itens = new ArrayList<>();
    private LocalDate data;
    private String status;
    
    public Pedido() {}
    public Pedido(String id, Cliente cliente, LocalDate data) {
        this.id = id; this.cliente = cliente; this.data = data; 
        this.status = "PENDENTE";
    }
    
    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItens() { return itens; }
    public LocalDate getData() { return data; }
    public String getStatus() { return status; }
    
    public void addItem(ItemPedido item) { itens.add(item); }
    public void setStatus(String status) { this.status = status; }
    
    public double getTotal() {
        double total = 0;
        for(ItemPedido item : itens) total += item.getSubtotal();
        return total;
    }
    
    public void processar() {
        for(ItemPedido item : itens) item.getProduto().reduzirEstoque(item.getQuantidade());
        status = "PROCESSANDO";
    }
}