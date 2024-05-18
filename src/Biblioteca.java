import java.util.ArrayList;
import java.util.List;
public class Biblioteca {

    //Atributos
    private List<Livro> livros;
    private int maxQtdLivAlug; // Máxima Quantidade de Livrods Alugados
    private List<Usuario> usuarios;
    private String nome;
    Livro[] livrosAlugados = new Livro[0];

    //Metodos
    void cadastrarLivro() { //deverá cadastrar um novo livro na biblioteca
        livros.add(new Livro("a culpa e de info", "samuel", "fe em deus", 2007));
        livros.add(new Livro("O Auto da Compadecida", "Ariano suassuna", "Nova Fronteira", 1955));
        livros.add(new Livro("O Santo e a Porca", "Ariano suassuna", "Nova Fronteira", 1957));
        livros.add(new Livro("O Estalo", "Luís Dill", "Positivo", 2020));
        livros.add(new Livro("Como Evitar um Desastre Climático", "Bill Gates", "Companhia da Letras", 2021));
        livros.add(new Livro("Bíblia Sagrada", "Deus", "Editora Getsêmani", -1400));
        livros.add(new Livro("Os 7 Hábitos dos Adolescentes Altamente Eficazes", "Sean Covey", "Best Seller", 2009));
        livros.add(new Livro("Logo Logo: Dez novas tecnologias que vão melhorar e/ou arruinar tudo", "Kelly Weinersmith e Zach Weinersmith", "Intrinseca", 2018));
        livros.add(new Livro("Le Petit Prince", "Antoine de Saint-Exupéry", "BN Publishing", 2012));
        livros.add(new Livro("O desperat do universo consciente", "marcelo Gleiser", "Record", 2019));
        livros.add(new Livro("O livro dos misterios", "Jonathan Cahn", "Editora Vida", 2024));
        livros.add(new Livro("Os meninos que enganavam nazistas", "Joseph Joffo", "Vestigio", 2017));
        livros.add(new Livro("Cristianismo Puro e simples", "C.S Lewis", "Thomas Nelson Brasil", 1952));
        //livros.add(new Livro("","","",));
        //livros.add(new Livro("","","",));
        //livros.add(new Livro("","","",));
        //livros.add(new Livro("","","",));
        //livros.add(new Livro("","","",));
        //livros.add(new Livro("","","",));
        //livros.add(new Livro("","","",));
    }

    void cadastrarUsuario(List<Usuario> usuarios) { //deverá cadastrar um novo usuário na biblioteca
        Usuario p1 = new Aluno("Samuel", "1234567890", "14/09/1977", 0,"Colégio Técnico da Universidade Federeal de Minas Gerais");
        Usuario p2 = new Professor("Fantini", "0987654321", "13/05/1900", 1, "Ciencia da computacao");
        usuarios.add(p1);
        usuarios.add(p2);
        p1.pegarLivro(livros.get(7));
        p1.pegarLivro(livros.get(8));
        p1.pegarLivro(livros.get(1));
        p1.pegarLivro(livros.get(0));
        p1.pegarLivro(livros.get(5));
        boolean a = p1.pegarLivro(livros.get(4));
        System.out.println(a);
        boolean b = p1.devolverLivro(livros.get(8));
        System.out.println(b);
        boolean c = p1.pegarLivro(livros.get(4));
        System.out.println(c);

        //usuario p2 alugando livros
        p2.pegarLivro(livros.get(2));
        p2.pegarLivro(livros.get(3));
        p2.pegarLivro(livros.get(6));
        p2.pegarLivro(livros.get(9));
        p2.pegarLivro(livros.get(11));
        p2.pegarLivro(livros.get(12));
        p2.pegarLivro(livros.get(10));
    }

    boolean pegarLivro(Livro livro) {
        if (!(livro.alugado)) { // Para o usario n pegar emprestado um livro já emprestado
            int qt = 0;
            for (Livro livroAlu : this.livrosAlugados) {
                qt++;
            } // Conta a quantidade de livros já alugados
            if (qt == this.maxQtdLivAlug) {
                System.out.println("Você não pode pegar mais livros pois excedeu a quantidade de livros permitida : " + this.maxQtdLivAlug);
                return false;
            } else {
                Livro[] new_livrosAlugados = new Livro[qt + 1];
                for (int i = 0; i < qt; i++) {
                    new_livrosAlugados[i] = this.livrosAlugados[i];
                }
                new_livrosAlugados[qt] = livro;
                this.livrosAlugados = new_livrosAlugados;
                livro.alugado = true;
                return true;
            }

        }
        System.out.println("O livro " + livro.getTitulo() + " já está alugado");
        return false;
    }

    void realizarDevolucao() { // deverá iniciar o processo de devolução

    }

    void imprimirLivrosDisponiveis() { //deverá imprimir todos os livros disponíveis na biblioteca

            System.out.println("Livros disponiveis para alugar:");
            int quantidadeLivros = 0;
            for(Livro livros : this.livrosAlugados) {
                if (!(livros.alugado)) {
                    System.out.println(livros.getTitulo() + " - " + livros.getAno_publicacao());
                    quantidadeLivros++;
                }
            }
            if(quantidadeLivros == 0) {
                System.out.println("Não possui livros disponíveis para alugar!!!");
            }
    }

    public static void main(String[] args) {
    } //método por onde iniciará a execução do programa
    public void setUsuarios(List<Usuario> usuarios) {

        this.usuarios = usuarios;
    }

    public void setLivros(List<Livro> livros) {

        this.livros = livros;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {

        return usuarios;
    }

    public List<Livro> getLivros() {

        return livros;
    }

    public String getNome() {

        return nome;
    }
}

