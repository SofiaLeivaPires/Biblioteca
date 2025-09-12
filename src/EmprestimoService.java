import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class EmprestimoService {
    static Scanner sc = new Scanner(System.in);

    public static int adiciondarId(ArrayList<Emprestimo> listaEmprestimo){
        int novoId;

        if (listaEmprestimo.isEmpty()){
            novoId = 1;
        } else {
            int ultimoId = listaEmprestimo.get(listaEmprestimo.size() - 1).getId();
            novoId = ultimoId + 1;
        }
        return novoId;

    }

    public static void emprestar(ArrayList<Emprestimo> listaEmprestimo,
                                 ArrayList<Livro> livrosCadastrados,
                                 ArrayList<Cliente> clientesCadastrados) {

        System.out.println("=====EMPRÉSTIMO=====");
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
        LocalDate dataDevolucao = null;


        Emprestimo emprestimo = new Emprestimo(
                adiciondarId(listaEmprestimo),
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


    public static void devolver(ArrayList<Emprestimo> listaEmprestimo,
                                 ArrayList<Livro> livrosCadastrados,
                                 ArrayList<Cliente> clientesCadastrados) {

        System.out.println("=====DEVOLUÇÃO=====");
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

        if (livroEmprestimo.isDisponivel()) {
            System.out.println("Livro indisponível para devolução.");
            return;
        }
        LocalDate dataDevolvida = LocalDate.now();
        for (Emprestimo emprestimoCadastro: listaEmprestimo) {
            if (emprestimoCadastro.getLivro().equals(livroEmprestimo)){
                emprestimoCadastro.setDataDevolvida(dataDevolvida);
            }
        }
        livroEmprestimo.setDisponivel(true);
        System.out.println("✅ Devolução realizada com sucesso!");
        System.out.println(livroEmprestimo);

    }

    public static void listarAbertos(ArrayList<Emprestimo> listaEmprestimo){
        if(listaEmprestimo.isEmpty()){
            System.out.println("Sua lista está vazia");
        }

        String mostrarEmprestimosAbertos = "";
        int devolvidos = 0;


        for (Emprestimo emprestimoCadastro: listaEmprestimo){
            if (emprestimoCadastro.getDataDevolvida() == null){
                mostrarEmprestimosAbertos += emprestimoCadastro.toString();
            } else {
                devolvidos++;
            }

        }
        System.out.println("Livros em abertos: ");
        System.out.println(mostrarEmprestimosAbertos);
        System.out.println( "Quantidade livros devolvidos: " + devolvidos);
    }

    public static void historicoCliente(ArrayList<Emprestimo> listaEmprestimo,
                                        ArrayList<Livro> livrosCadastrados,
                                        ArrayList<Cliente> clientesCadastrados){

        System.out.println("=====HISTÓRICO POR CLIENTE=====");
        Cliente clienteEmprestimo = ClienteService.buscarPorId(clientesCadastrados);

        if (clienteEmprestimo == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        String mostrarEmprestimos = "";
        boolean encontrouHistorico = false;

        for (Emprestimo emprestimoCadastro: listaEmprestimo) {
            if (clienteEmprestimo.getId() == emprestimoCadastro.getCliente().getId()){
                mostrarEmprestimos += emprestimoCadastro.toString() + "\n";
                encontrouHistorico = true;

            }
        }

        if (encontrouHistorico) {
            System.out.println(mostrarEmprestimos);
        } else {
            System.out.println("Nenhum empréstimo encontrado para este cliente.");
        }


    }
}
