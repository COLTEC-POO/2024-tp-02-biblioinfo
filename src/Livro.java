public class Livro {
    String titulo;
    String autor;
    String editora;
    int ano_publicacao;

    Livro(String titulo,String autor,String editora,int ano_publicacao){

        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ano_publicacao = ano_publicacao;
    }

    void imprimir(){
        System.out.println("=============================================");
        System.out.println("Titulo do livro:" + titulo);
        System.out.println("Autor do livro:" + autor);
        System.out.println("Editora do livro:" + editora);
        System.out.println("Ano de publicacao do livro:" + ano_publicacao);
        System.out.println("============================================");
    }

}


