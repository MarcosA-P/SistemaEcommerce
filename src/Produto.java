import java.io.Serializable;

public class Produto implements Serializable {
    private String id;
    private String nome;
    private double preco;
    private int estoque;
    
    public Produto() {}
    public Produto(String id, String nome, double preco, int estoque) {
        this.id = id; this.nome = nome; this.preco = preco; this.estoque = estoque;
    }
    
    public String getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getEstoque() { return estoque; }
    
    public void reduzirEstoque(int q) {
        if(q > estoque) throw new RuntimeException("Estoque insuficiente");
        estoque -= q;
    }
}