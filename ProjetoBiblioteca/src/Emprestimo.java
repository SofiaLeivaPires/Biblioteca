import java.time.LocalDate;

public class Emprestimo {
    private int id;
//    livro
//    cliente
    private LocalDate dataSaida;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolvida;

    public Emprestimo(int id, LocalDate dataSaida, LocalDate dataDevolucaoPrevista, LocalDate dataDevolvida){
        this.id = id;
        this.dataSaida = dataSaida;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.dataDevolvida = dataDevolvida;

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
