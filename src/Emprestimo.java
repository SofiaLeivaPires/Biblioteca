import java.time.LocalDate;
import java.time.LocalDateTime;

public class Emprestimo {
    private int id;
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataSaida;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolvida;


    public Emprestimo(int id, Livro livroEmprestado, Cliente clienteEmprestimo, LocalDateTime dataSaida, LocalDateTime dataPrevista, LocalDateTime dataDevolucao) {
    }

    public Emprestimo(int id, Livro livro, Cliente cliente, LocalDate dataSaida, LocalDate dataDevolucaoPrevista, LocalDate dataDevolvida) {
        this.id = id;
        this.livro = livro;
        this.cliente = cliente;
        this.dataSaida = dataSaida;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolvida = null;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Emprestimo{" +
                "id=" + id +
                ", dataSaida=" + dataSaida +
                ", dataDevolucaoPrevista=" + dataDevolucaoPrevista +
                ", dataDevolvida=" + dataDevolvida +
                '}';
    }
}
