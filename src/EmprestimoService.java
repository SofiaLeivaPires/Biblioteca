import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class EmprestimoService {
    static Scanner sc = new Scanner(System.in);

    public static void emprestar(ArrayList<Emprestimo> listaEmprestimo,
                                 ArrayList<Livro> livrosCadastrados,
                                 ArrayList<Cliente> clientesCadastrados) {

        Cliente clienteEmprestimo = ClienteService.buscarPorId(clientesCadastrados);
        Livro livroEmprestimo = LivroService.buscarPorISBN(livrosCadastrados);

        if (livroEmprestimo == null) {
            System.out.println("Livro não encontrado!");
            return;
        }

        if (clienteEmprestimo == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        if (!livroEmprestimo.isDisponivel()) {
            System.out.println("Livro indisponível para empréstimo.");
            return;
        }

        LocalDate dataSaida = LocalDate.now();
        LocalDate dataPrevista = dataSaida.plusWeeks(1);
        LocalDateTime dataDevolucao = null;

        int novoId;

        if (listaEmprestimo.isEmpty()){
            novoId = 1;
        } else {
            int ultimoId = listaEmprestimo.get(listaEmprestimo.size() - 1).getId();
            novoId = ultimoId + 1;
        }

        Emprestimo emprestimo = new Emprestimo(
                novoId,
                livroEmprestimo,
                clienteEmprestimo,
                dataSaida,
                dataPrevista

        );

        listaEmprestimo.add(emprestimo);
        livroEmprestimo.setDisponivel(false);

        System.out.println("✅ Empréstimo realizado com sucesso!");
        System.out.println(emprestimo);
    }

    public static void devolver(ArrayList<Emprestimo> listaEmprestimo){


    }


    public static void listarAbertos(ArrayList<Emprestimo> listaEmprestimo){
        String mostrarEmprestimosAbertos = "";
        int devolvidos = 0;

        for (Emprestimo emprestimoCadastro: listaEmprestimo){
            if (emprestimoCadastro.getDataDevolvida() == null){
                mostrarEmprestimosAbertos += emprestimoCadastro.toString();
            } else {
                devolvidos++;

            }
            if(listaEmprestimo.isEmpty()){
                System.out.println("Sua lista está vazia");
            }

        }
        System.out.println(mostrarEmprestimosAbertos);
        System.out.println( "Quantidade livros devolvidos: " + devolvidos);
    }
}
