import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoDAO<T> {
    public void salvar(List<T> lista, String arquivo) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            out.writeObject(lista);
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<T> carregar(String arquivo) throws IOException, ClassNotFoundException {
        File f = new File(arquivo);
        if(!f.exists()) return new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<T>) in.readObject();
        }
    }
}