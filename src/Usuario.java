import java.text.SimpleDateFormat;
import java.util.Date;
public class Usuario {
    private String nome;
    String cpf;
    Date data_nascimento;
    int id;
    private int maxQtdLivAlug; // Máxima Quantidade de Livrods Alugados
    Livro[] livrosAlugados = new Livro[0];
    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy"); // Para converter String para Date

    // Encapsulamento
    void setMaxQtdLivAlu(int qtd) {
        this.maxQtdLivAlug = qtd;
    }

    public String getNome() {
        return nome;
    }
    //
    
    boolean devolverLivro(Livro livro) {
        for (Livro livroAlu : this.livrosAlugados) {
            if (livro == livroAlu) {
                livro.alugado = false;
                // Retira o livro dos alugados
                int qt = 0;
                for (Livro livroAlu2 : this.livrosAlugados) {
                    qt++;
                } // Conta a quantidade de livros já alugados
                Livro[] new_livrosAlugados = new Livro[qt - 1];
                int j = 0;
                for (int i = 0; i < qt; i++) {
                    if (!(this.livrosAlugados[i].alugado)) {
                        i++;
                    }
                    new_livrosAlugados[j] = this.livrosAlugados[i];
                    j++;
                }
                this.livrosAlugados = new_livrosAlugados;
                return true;
            }
        }
        return false;
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

    void imprimirLivrosUsuario() {
        System.out.println("Exibindo livros do usuario " + getNome());
        int quantidadeLivrosUsuario = 0;
        System.out.println("=====================================================================");
        for (Livro livroAlu : this.livrosAlugados) {
            System.out.println(livroAlu.getTitulo() + " - " + livroAlu.getAno_publicacao());
            quantidadeLivrosUsuario++;
        }
        if(quantidadeLivrosUsuario == 0) {
            System.out.println("O usuario nao tem livros alugados!");
        }
        System.out.println("=====================================================================");
    }
}