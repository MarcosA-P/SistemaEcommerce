import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Carrinho implements Serializable {
    private List<ItemPedido> itens = new ArrayList<>();
    
    public List<ItemPedido> getItens() { return itens; }
    
    public void addProduto(Produto p, int q) {
        itens.add(new ItemPedido(p, q));
    }
    
    public double getTotal() {
        double total = 0;
        for(ItemPedido item : itens) total += item.getSubtotal();
        return total;
    }
    
    public void limpar() { itens.clear(); }
    public boolean vazio() { return itens.isEmpty(); }
}