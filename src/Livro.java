public class Livro {
    private String isbn;
    private String titulo;
    private String autor;
    private int ano;
    private boolean disponivel = true;

    public Livro() {
        this.disponivel = true;
    }

    public Livro(String isbn, String titulo, String autor, int ano) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;

    }



    public String getIsbn() {
        return isbn;
   }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
        return disponivel;
    }

    @Override
    public String toString() {
        return "\n----------------------------------" +
                "\n📖 Livro #" + isbn +
                "\n   Título: " + titulo +
                "\n   Autor: " + autor +
                "\n   Ano: " + ano +
                "\n   Disponível: " + (disponivel ? "Sim ✅" : "Não ❌") +
                "\n----------------------------------";
    }

    public void set(String nomeLivro) {
    }
}
