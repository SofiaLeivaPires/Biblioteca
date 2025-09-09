import java.util.ArrayList;
import java.util.Scanner;

public class LivroService {

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

    public static void listarLivrosCadastrados(ArrayList<Livro> listaLivros){
        String mostrarLivroCadastrados = "";
        if (listaLivros.isEmpty()){
            System.out.println("A lista está vazia");
        } else {
            System.out.println("LISTA DE LIVROS: ");
        }
        for (Livro livroCadastrado: listaLivros){
            mostrarLivroCadastrados +=  livroCadastrado.toString() + "\n";

        }

        System.out.println(mostrarLivroCadastrados);
    }

    public static String buscarPorISBN(ArrayList<Livro> buscarLivro){
        String mostrarLivro = "";

        boolean teste = true;

        do {
            System.out.println("Digite o código do ISBN: ");
            String isbn = sc.next();
            for (Livro buscaLivro : buscarLivro) {
                if (buscaLivro.getIsbn().equals(isbn)) {
                    mostrarLivro = buscaLivro.toString();
                    System.out.println(mostrarLivro);
                    teste = true;
                    break;
                } else {
                    teste = false;
                }

            }
        } while (teste == false);

        return mostrarLivro;
    }

    public static void atualizarLivro(ArrayList<Livro> atualizarLivro) {
        buscarPorISBN(atualizarLivro);
        System.out.println("O que gostaria de atualizar?");
        System.out.println("1. Nome do livro");
        System.out.println("2. Nome do autor");
        System.out.println("3. Ano de lançamento");
        int opcao = sc.nextInt();

        for (Livro atualizaLivro: atualizarLivro){
            switch (opcao){
                case 1:
                    atualizaLivro.getTitulo();
                    System.out.println("Digite o nome do livro: ");
                    String nomeLivro = sc.next();
                    sc.nextLine();
                    atualizaLivro.setTitulo(nomeLivro);
                    System.out.println(atualizaLivro);
                    break;
                case 2:
                    atualizaLivro.getAutor();
                    System.out.println("Digite o nome do autor: ");
                    String nomeAutor = sc.next();
                    atualizaLivro.setAutor(nomeAutor);
                    System.out.println(atualizaLivro);
                    break;
                case 3:
                    atualizaLivro.getAno();
                    System.out.println("Digite o ano de lançamento: ");
                    int ano = sc.nextInt();
                    atualizaLivro.setAno(ano);
                    System.out.println(atualizaLivro);
                    break;
                default:
                    break;

            }
            break;


        }
        System.out.println("-----------------------------");
        System.out.println("Livro atualizado com sucesso!");
        System.out.println("-----------------------------\n");


    }


    public static void removerLivro(ArrayList<Livro> listaRemoverLivro){
        buscarPorISBN(listaRemoverLivro);

        for (Livro removeLivro: listaRemoverLivro) {
            listaRemoverLivro.remove(removeLivro);
            System.out.println("-----------------------------");
            System.out.println("Livro removido com sucesso");
            System.out.println("-----------------------------\n");
            break;
        }



    }
}
