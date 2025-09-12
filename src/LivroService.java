import java.util.ArrayList;
import java.util.Scanner;

public class LivroService {

    static Scanner sc = new Scanner(System.in);

    public static Boolean isEmpty(ArrayList<Livro> listaLivros){
        if (listaLivros.isEmpty()) {
            System.out.println("A lista está vazia");
            return true;
        } else {
            return false;
        }

    }

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

        System.out.println("✅ Livro cadastrado com sucesso!");


    }

    public static void listarLivrosCadastrados(ArrayList<Livro> listaLivros){
        String mostrarLivroCadastrados = "";


        if (isEmpty(listaLivros).equals(false)) {
            System.out.println("LISTA DE LIVROS: ");

            for (Livro livroCadastrado: listaLivros){
                mostrarLivroCadastrados +=  livroCadastrado.toString() + "\n";

            }

            System.out.println(mostrarLivroCadastrados);
        }

    }

    public static Livro buscarPorISBN(ArrayList<Livro> buscarLivro){
        boolean verificaIsbn = true;
        do {
            if (!isEmpty(buscarLivro)) {
                System.out.println("Digite o código do ISBN do livro: ");
                String isbn = sc.next();
                for (Livro buscaLivro : buscarLivro) {
                    if (buscaLivro.getIsbn().equals(isbn)) {
                        System.out.println(buscaLivro);
                        return buscaLivro;
                    } else {
                        verificaIsbn = false;
                    }

                }

            }
        } while (!verificaIsbn);
        return null;
    }

    public static void atualizarLivro(ArrayList<Livro> atualizarLivro) {
        Livro livroAlterar = buscarPorISBN(atualizarLivro);

        if (atualizarLivro.isEmpty()){
            System.out.print("");
        } else {
            System.out.println("O que gostaria de atualizar?");
            System.out.println("1. Nome do livro");
            System.out.println("2. Nome do autor");
            System.out.println("3. Ano de lançamento");
            int opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Digite o nome do livro: ");
                    String nomeLivro = sc.next();
                    sc.nextLine();
                    livroAlterar.setTitulo(nomeLivro);
                    System.out.println(livroAlterar);
                    break;
                case 2:
                    System.out.println("Digite o nome do autor: ");
                    String nomeAutor = sc.next();
                    livroAlterar.setAutor(nomeAutor);
                    System.out.println(livroAlterar);
                    break;
                case 3:
                    System.out.println("Digite o ano de lançamento: ");
                    int ano = sc.nextInt();
                    livroAlterar.setAno(ano);
                    System.out.println(livroAlterar);
                    break;
                default:
                    break;
            }
            System.out.println("✅ Livro atualizado com sucesso!");
        }
    }

    public static void removerLivro(ArrayList<Livro> listaRemoverLivro){
        Livro removerLivro = buscarPorISBN(listaRemoverLivro);
        if (listaRemoverLivro.isEmpty()){
            System.out.print("");
        } else {
            listaRemoverLivro.remove(removerLivro);
            System.out.println("✅ Livro removido com sucesso!");
        }

    }
}

