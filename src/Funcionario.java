public class Funcionario extends Pessoa {
    private String cargo;
    
    public Funcionario() { super(); }
    public Funcionario(int id, String nome, String email, String cargo) {
        super(id, nome, email); this.cargo = cargo;
    }
    
    public String getCargo() { return cargo; }
    
    @Override
    public String getTipo() { return "Funcionario"; }
}