public class Administrador extends Pessoa {
    public Administrador() { super(); }
    public Administrador(int id, String nome, String email) {
        super(id, nome, email);
    }
    
    @Override
    public String getTipo() { return "Administrador"; }
}