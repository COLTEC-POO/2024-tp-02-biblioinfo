public class Usuario{
    String nome,cpf;
    Date data_nascimento;
    int id;
    Livro[] livrosAlugados;

    boolean devolverLivro(Livro livro){
        return false;
    }
    boolean pegarLivro(Livro livro){
        return false;
    }
    void imprimirLivros(){

    }
}