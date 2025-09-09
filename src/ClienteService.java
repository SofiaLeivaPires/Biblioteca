import java.util.ArrayList;
import java.util.Scanner;


public class ClienteService {

    static Scanner sc = new Scanner(System.in);

    public static void cadastrarLivro(ArrayList<Livro> listaLivroCadastrar) {
        System.out.println("Digite o nome do livro: ");
        String nomeLivro = sc.next();
        sc.nextLine();
        System.out.println("Digite o nome do autor: ");
        String nomeAutor = sc.next();
        sc.nextLine();
        System.out.println("Digite o código do ISBN: ");
        boolean teste = true;
        String isbn;
        do {
            isbn = sc.next();
            for (Livro verificaIsbn : listaLivroCadastrar) {
                if (verificaIsbn.getIsbn().equals(isbn)) {
                    System.out.println("Esse código isbn já existe, tente novamente: ");
                    teste = false;
                } else {
                    teste = true;
                }

            }
        } while (teste == false);
        sc.nextLine();
        System.out.println("Digite o ano de lançamento: ");
        int ano = sc.nextInt();
        sc.nextLine();
        Livro livroCadastrar = new Livro(isbn, nomeLivro, nomeAutor, ano);
        listaLivroCadastrar.add(livroCadastrar);

        System.out.println("-----------------------------");
        System.out.println("Livro cadastrado com suceso");
        System.out.println("-----------------------------");


    }
}
