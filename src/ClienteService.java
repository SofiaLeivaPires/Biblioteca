import java.util.ArrayList;
import java.util.Scanner;


public class ClienteService {

    static Scanner sc = new Scanner(System.in);


    public static Boolean isEmpty(ArrayList<Cliente> listaCliente){
        if (listaCliente.isEmpty()) {
            System.out.println("A lista está vazia");
            return true;
        } else {
            return false;
        }

    }
    public static void cadastrarCliente(ArrayList<Cliente> listaClienteCadastro) {
        int novoId;

        if (listaClienteCadastro.isEmpty()){
            novoId = 1;
        } else {
            int ultimoId = listaClienteCadastro.getLast().getId();
            novoId = ultimoId + 1;
        }
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = sc.next();
        sc.nextLine();

        System.out.println("Digite o email do cliente: ");
        String emailCliente = sc.next();
        sc.nextLine();

        Cliente clienteCadastrar = new Cliente(novoId, nomeCliente,emailCliente);
        listaClienteCadastro.add(clienteCadastrar);

        System.out.println(clienteCadastrar);
        System.out.println("✅ Cliente cadastrado com sucesso!");


    }

    public static void listaCliente(ArrayList<Cliente> listarClientes){
        String mostrarClientesCadastrados = "";

        if (isEmpty(listarClientes).equals(false)){
            System.out.println("LISTA DE CLIENTES: ");

            for (Cliente clienteCadastrado: listarClientes){
                mostrarClientesCadastrados += clienteCadastrado.toString() + "\n";
            }

            System.out.println(mostrarClientesCadastrados);
        }

    }

    public static Cliente buscarPorId(ArrayList<Cliente> buscarCliente){
        boolean verificarId = true;
        do {
            if (isEmpty(buscarCliente).equals(false)){
                System.out.println("Digite o código ID do cliente: ");
                int id = sc.nextInt();
                for (Cliente buscaCliente : buscarCliente){
                    if (buscaCliente.getId() == id) {
                        System.out.println(buscaCliente);
                        return buscaCliente;
                    } else {
                        verificarId = false;
                    }
                }
            }
        } while (verificarId == false);
        return null;
    }

    public static void atualizarCliente(ArrayList<Cliente> atualizarCliente) {
        Cliente clienteAlterar = buscarPorId(atualizarCliente);

        if (atualizarCliente.isEmpty()) {
            System.out.print("");
        } else {

            System.out.println("O que gostaria de atualizar?");
            System.out.println("1. Nome do cliente");
            System.out.println("2. Email do cliente");
            int atualiza = sc.nextInt();


            switch (atualiza) {
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    String nomeCliente = sc.next();
                    sc.nextLine();
                    clienteAlterar.setNome(nomeCliente);
                    System.out.println(clienteAlterar);
                    break;
                case 2:
                    System.out.println("Digite o email do cliente: ");
                    String emailCliente = sc.next();
                    clienteAlterar.setEmail(emailCliente);
                    System.out.println(clienteAlterar);
                    break;
                default:
                    break;
            }

            System.out.println("✅ Cliente atualizado com sucesso!");

        }
    }

    public static void removerCliente(ArrayList<Cliente> listaRemoverCliente){
        Cliente clienteRemover = buscarPorId(listaRemoverCliente);
        if (listaRemoverCliente.isEmpty()){
            System.out.print("");
        } else {
            listaRemoverCliente.remove(clienteRemover);
            System.out.println("✅ Cliente removido com sucesso!");
        }
    }


}
