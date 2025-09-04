import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Livro> livrosCadastrados = new ArrayList<>();

    public static void main(String[] args) {
//        Livro anneFrank = new Livro("123","Anne","Anne",1984, true);
//        livrosCadastrados.add(anneFrank);
        Menu();
    }

    public static void SubmenuLivros(){
        System.out.println("=====LIVROS=====");
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Listar livros");
        System.out.println("3. Buscar por ISBN");
        System.out.println("4. Atualizar livro");
        System.out.println("5. Remover livro");
        int opcaoLivro = sc.nextInt();

        switch (opcaoLivro) {
//            Cadastro livro
            case 1:
                LivroService.cadastrarLivro(livrosCadastrados);
                break;
            case 2:
                LivroService.listarLivrosCadastrados(livrosCadastrados);
                break;
        }
    }

    public static void SubmenuClientes(){
        System.out.println("=====CLIENTES=====");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Listar cliente");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Atualizar cliente");
        System.out.println("5. Remover cliente");

    }

    public static void SubmenuEmprestimo(){
        System.out.println("=====EMPRÉSTIMO=====");
        System.out.println("1. Emprestar livro");
        System.out.println("2. Devolver livro");
        System.out.println("3. Listar abertos");
        System.out.println("4. Histórico por cliente");

    }

    public static void MenuPrincipal() {
        System.out.println("=========BIBLIOTECA=========");
        System.out.println("O que você desejaria fazer?");
        System.out.println("1. Livros");
        System.out.println("2. Clientes");
        System.out.println("3. Empréstimos");
        System.out.println("0. Sair");
        System.out.print("Opção: ");
    }

    public static void Menu() {
        int opcao;
        do {
            MenuPrincipal();
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    SubmenuLivros();
                    break;
                case 2:
                    SubmenuClientes();
                    break;
                case 3:
                    SubmenuEmprestimo();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }
        } while (opcao != 0);


    }



}