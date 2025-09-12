import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Livro> livrosCadastrados = new ArrayList<>();
    static ArrayList<Cliente> clientesCadastrados = new ArrayList<>();
    static ArrayList<Emprestimo> emprestimoCadastrados = new ArrayList<>();

    public static void main(String[] args) {
        livrosCadastrados.add(new Livro("1", "Dom Casmurro", "Machado de Assis", 1899));
        livrosCadastrados.add(new Livro("2", "Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881));
//        livrosCadastrados.add(new Livro("3", "A Hora da Estrela", "Clarice Lispector", 1977));
//        livrosCadastrados.add(new Livro("4", "O Cortiço", "Aluísio Azevedo", 1890));
//        livrosCadastrados.add(new Livro("5", "Vidas Secas", "Graciliano Ramos", 1938));


        clientesCadastrados.add(new Cliente(1, "Sofia", "Sofia@email.com"));
        clientesCadastrados.add(new Cliente(2, "Gabriel", "Gabriel@email.com"));
        clientesCadastrados.add(new Cliente(3, "Bruno", "Bruno@email.com"));
        clientesCadastrados.add(new Cliente(4, "Lucas", "Lucas@email.com"));
        clientesCadastrados.add(new Cliente(5, "Ana", "Ana@email.com"));

//        emprestimoCadastrados.add(new Emprestimo(1, new Livro("1", "Dom Casmurro", "Machado de Assis", 1899),
//                new Cliente(1, "Sofia", "Sofia@email.com"), LocalDate.now(),LocalDate.now() ));
//
//
//        emprestimoCadastrados.add(new Emprestimo(2, new Livro("2", "Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881),
//                new Cliente(1, "Sofia", "Sofia@email.com"), LocalDate.now(),LocalDate.now() ));



        Menu();
    }

    public static int lerOpcao() {
        while (true) {
            String entrada = sc.nextLine();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Opção inválida, digite apenas números: ");
            }
        }
    }

    public static void SubmenuLivros(){
        System.out.println("=====LIVROS=====");
        System.out.println("1. Cadastrar livro");
        System.out.println("2. Listar livros");
        System.out.println("3. Buscar por ISBN");
        System.out.println("4. Atualizar livro");
        System.out.println("5. Remover livro");
        System.out.println("6. Voltar ao menu");
        int opcaoLivro = lerOpcao();

        switch (opcaoLivro) {
            case 1:
                LivroService.cadastrarLivro(livrosCadastrados);
                break;
            case 2:
                LivroService.listarLivrosCadastrados(livrosCadastrados);
                break;
            case 3:
                LivroService.buscarPorISBN(livrosCadastrados);
                break;
            case 4:
                LivroService.atualizarLivro(livrosCadastrados);
                break;
            case 5:
                LivroService.removerLivro(livrosCadastrados);
                break;
            case 6:
                Menu();
                break;
            default:
                System.out.println("Opção inválida!");
                System.out.println("Tente novamente ");
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
        System.out.println("6. Voltar ao menu");

        int opcaoClinte = lerOpcao();

        switch (opcaoClinte) {
            case 1:
                ClienteService.cadastrarCliente(clientesCadastrados);
                break;
            case 2:
                ClienteService.listaCliente(clientesCadastrados);
                break;
            case 3:
                ClienteService.buscarPorId(clientesCadastrados);
                break;
            case 4:
                ClienteService.atualizarCliente(clientesCadastrados);
                break;
            case 5:
                ClienteService.removerCliente(clientesCadastrados);
                break;
            case 6:
                Menu();
                break;
            default:
                System.out.println("Opção inválida!");
                System.out.println("Tente novamente ");
                break;

        }
    }

    public static void SubmenuEmprestimo(){
        System.out.println("=====EMPRÉSTIMO=====");
        System.out.println("1. Fazer empréstimo");
        System.out.println("2. Devolver livro");
        System.out.println("3. Listar abertos");
        System.out.println("4. Histórico por cliente");
        System.out.println("5. Voltar ao menu");

        int opcaoEmprestimo = lerOpcao();

        switch (opcaoEmprestimo) {
            case 1:
                EmprestimoService.emprestar(emprestimoCadastrados, livrosCadastrados, clientesCadastrados);
                break;
            case 2:
              EmprestimoService.devolver(emprestimoCadastrados, livrosCadastrados, clientesCadastrados);
                break;
            case 3:
              EmprestimoService.listarAbertos(emprestimoCadastrados);
                break;
            case 4:
              EmprestimoService.historicoCliente(emprestimoCadastrados, livrosCadastrados, clientesCadastrados);
                break;
            case 5:
                Menu();
                break;
            default:
                System.out.println("Opção inválida!");
                System.out.println("Tente novamente ");
                break;

        }

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
        try {
            do {
                MenuPrincipal();
                opcao = lerOpcao();

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
                        System.out.println("Opção inválida!!!");
                        System.out.println("Tente novamente ");

                        break;

                }
            } while (opcao != 0);

        } catch (Exception e) {
            System.out.println("Informação inválida tente novamente");
        } finally {
            Menu();
        }


    }



}