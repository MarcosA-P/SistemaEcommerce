public class Validador {
    public static boolean cpfValido(String cpf) {
        return cpf != null && cpf.replaceAll("\\D", "").length() == 11;
    }
}