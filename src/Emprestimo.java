import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataSaida;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolvida;

    public Emprestimo(int id, Livro livro, Cliente cliente,
                      LocalDate dataSaida, LocalDate dataDevolucaoPrevista, LocalDate dataDevolvida) {
        this.id = id;
        this.livro = livro;
        this.cliente = cliente;
        this.dataSaida = dataSaida;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolvida = dataDevolvida; // normalmente null no início
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolvida() {
        return dataDevolvida;
    }

    public void setDataDevolvida(LocalDate dataDevolvida) {
        this.dataDevolvida = dataDevolvida;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return "\n----------------------------------" +
                "\n📚 Empréstimo #" + id +
                "\n👤 Cliente: " + cliente.getNome() +
                "\n📖 Livro: " + livro.getTitulo() + " (" + livro.getAutor() + ")" +
                "\n📅 Data de saída: " + dataSaida.format(formatter) +
                "\n📅 Data de devolução prevista: " + dataDevolucaoPrevista.format(formatter) +
                "\n📅 Data devolvida: " + (dataDevolvida == null ? "Ainda não devolvido" : dataDevolvida.format(formatter)) +
                "\n----------------------------------";
    }

}
