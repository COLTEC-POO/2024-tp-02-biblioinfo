public class Biblioteca {

    //Atributos
    private Livro[] livros;
    private Usuario[] usuarios;
    private String nome;

    //Métodos
    static void main(String[] args) {
    } //método por onde iniciará a execução do programa

    void cadastrarLivro() {

    } //deverá cadastrar um novo livro na biblioteca

    void cadastrarUsuario() {

    } //deverá cadastrar um novo usuário na biblioteca

    void realizarEmprestimo(){

    } // deverá inicializar o processo de empréstimo

    void realizarDevolucao() {

    } // deverá iniciar o processo de devolução

    void imprimirLivros() {

    } //deverá imprimir todos os livros disponíveis na biblioteca


    public void setUsuarios(Usuario[] usuarios) {

        this.usuarios = usuarios;
    }

    public void setLivros(Livro[] livros) {

        this.livros = livros;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public Usuario[] getUsuarios() {

        return usuarios;
    }

    public Livro[] getLivros() {

        return livros;
    }

    public String getNome() {

        return nome;
    }
}

