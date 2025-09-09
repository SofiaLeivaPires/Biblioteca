import java.util.ArrayList;
import java.util.Scanner;


public class ClienteService {

    static Scanner sc = new Scanner(System.in);
    static int id = 0;


        public static Boolean isEmpty(ArrayList<Cliente> listaCliente){
        if (listaCliente.isEmpty()) {
            System.out.println("A lista está vazia");
            return true;
        } else {
            return false;
        }

    }
    public static void cadastrarCliente(ArrayList<Cliente> listaClienteCadastro) {
        id = id + 1;
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = sc.next();
        sc.nextLine();
        System.out.println("Digite o email do cliente: ");
        String emailCliente = sc.next();
        sc.nextLine();

        Cliente clienteCadastrar = new Cliente(id, nomeCliente,emailCliente);
        listaClienteCadastro.add(clienteCadastrar);

        System.out.println(clienteCadastrar);
        System.out.println("-----------------------------");
        System.out.println("Cliente cadastrado com suceso");
        System.out.println("-----------------------------");


    }

    public static void listaCliente(ArrayList<Cliente> listarClientes){
        String mostrarClientesCadastrados = "";

        if (isEmpty(listarClientes).equals(false)){
            System.out.println("LISTA DE CLIENTES");

            for (Cliente clienteCadastrado: listarClientes){
                mostrarClientesCadastrados += clienteCadastrado.toString() + "\n";
            }

            System.out.println(mostrarClientesCadastrados);
        }

    }

    public static String buscarPorId(ArrayList<Cliente> buscarCliente){
        String mostrarCliente = "";
        boolean verificarId = true;

        do {
            if (isEmpty(buscarCliente).equals(false)){
                System.out.println("Digite o código ID: ");
                int id = sc.nextInt();
                for (Cliente buscaCliente : buscarCliente){
                    if (buscaCliente.getId() == id) {
                        mostrarCliente = buscaCliente.toString();
                        System.out.println(mostrarCliente);
                        verificarId = true;
                        break;
                    } else {
                        verificarId = false;
                        break;

                    }
                }
            }
        } while (verificarId == false);


        return mostrarCliente;
    }

    public static void atualizarCliente(ArrayList<Cliente> atualizarCliente) {
        buscarPorId(atualizarCliente);

        if (atualizarCliente.isEmpty()) {
            System.out.print("");
        } else {

            System.out.println("O que gostaria de atualizar?");
            System.out.println("1. Nome do cliente");
            System.out.println("2. Email do cliente");
            int atualiza = sc.nextInt();

            for (Cliente atualizaCliente : atualizarCliente) {
                switch (atualiza) {
                    case 1:
                        atualizaCliente.getNome();
                        System.out.println("Digite o nome do cliente: ");
                        String nomeCliente = sc.next();
                        sc.nextLine();
                        atualizaCliente.setNome(nomeCliente);
                        System.out.println(atualizaCliente);
                        break;
                    case 2:
                        atualizaCliente.getEmail();
                        System.out.println("Digite o email do cliente: ");
                        String emailCliente = sc.next();
                        atualizaCliente.setEmail(emailCliente);
                        System.out.println(atualizaCliente);
                        break;
                    default:
                        break;

                }
                break;


            }
            System.out.println("-----------------------------");
            System.out.println("Cliente atualizado com sucesso!");
            System.out.println("-----------------------------\n");

        }

    }

    public static void removerCliente(ArrayList<Cliente> listaRemoverCliente){
        buscarPorId(listaRemoverCliente);

        for (Cliente removeCliente: listaRemoverCliente) {
            listaRemoverCliente.remove(removeCliente);
            System.out.println("-----------------------------");
            System.out.println("Cliente removido com sucesso");
            System.out.println("-----------------------------\n");
            break;
        }

    }


}
