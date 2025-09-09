import java.util.ArrayList;
import java.util.Scanner;

public class EmprestimoService {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Livro> livrosCadastrados = new ArrayList<>();
    static ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
    public static void emprestar(ArrayList<Emprestimo> listaEmprestimo) {
        ClienteService.buscarPorId(clientesCadastrados);
        LivroService.buscarPorISBN(livrosCadastrados);

        
    }
}
