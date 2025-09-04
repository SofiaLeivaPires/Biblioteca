import java.util.ArrayList;
import java.util.Scanner;

public class LivroService {

    static Scanner sc = new Scanner(System.in);

    public static String cadastrarLivro(ArrayList<Livro> listaLivroCadastrar) {
        System.out.println("Digite o nome do livro: ");
        String nomeLivro = sc.next();
        System.out.println("Digite o nome do autor: ");
        String nomeAutor = sc.next();
        System.out.println("Digite o código do ISBN: ");
        String isbn = sc.next();
        System.out.println("Digite o ano de lançamento: ");
        int ano = sc.nextInt();

        Livro livroCadastrar = new Livro(isbn, nomeLivro, nomeAutor, ano);
        listaLivroCadastrar.add(livroCadastrar);

        return "Livro cadastrado com suceso";

    }

    public static void listarLivrosCadastrados(ArrayList<Livro> listaLivros){
        String mostrarLivroCadastrados = "";
        for (Livro livroCadastrado: listaLivros){
            mostrarLivroCadastrados += "\n" + livroCadastrado.toString();
        }
        System.out.println(mostrarLivroCadastrados);
    }

}
