import java.util.Scanner;

//O main está no fim da classe

public class Biblioteca {

    //Constantes
    public static final int PROFESSOR = 3;
    public static final int ALUNO = 2;
    public static final int MORADOR = 1;

    //Atributos
    private Livro[] livros = new Livro[0];
    private Usuario[] usuarios = new Usuario[0];
    private String nome;

    //Métodos

    //Cadastra um novo usuário na biblioteca
    void cadastrarUsuario(int tipoDoUsuario, String nome, String cpf, String nascimento, int id, String... formacaoEscola) {

        redimensionarVetorUsuario();

        if(tipoDoUsuario == PROFESSOR) {
            this.usuarios[this.usuarios.length - 1] =  new Professor(nome, cpf, nascimento, id, formacaoEscola[0]);

        } else if(tipoDoUsuario == ALUNO) {
            this.usuarios[this.usuarios.length - 1] =  new Aluno(nome, cpf, nascimento, id, formacaoEscola[0]);

        } else {
            this.usuarios[this.usuarios.length - 1] =  new Morador(nome, cpf, nascimento, id);
        }
    }

    //Cadastra um novo livro na biblioteca
    void cadastrarLivro(String titulo, String autor, String editora, int anoPublicação) {

        redimensionarVetorLivro();

        this.livros[this.livros.length - 1] = new Livro(titulo, autor, editora, anoPublicação);
    }

    //Realiza o processo de empréstimo
    boolean realizarEmprestimo(Usuario usuario, Livro livro){
        return usuario.pegarLivro(livro);
    }

    //Realiza o processo de devolução
    boolean realizarDevolucao(Usuario usuario, Livro livro) {
        return usuario.devolverLivro(livro);
    }

    //Imprimi todos os livros disponíveis na biblioteca
    void imprimirLivros() {

        int quantLivrosDisponiveis = 0;

        for(Livro livroAtual: this.livros) {
            if(livroAtual.alugado == false) {
                quantLivrosDisponiveis++;
            }
        }

        if(quantLivrosDisponiveis > 0) {
            System.out.println("=====");
            System.out.println("LIVROS DISPONÍVEIS");

            for(Livro livroAtual: this.livros) {
                if(livroAtual.alugado == false) {
                    livroAtual.imprimir();
                }
            }
        } else {
            System.out.println();
            System.out.println("Não há livros disponíveis");
            System.out.println();
        }
    }

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

    private void redimensionarVetorUsuario() {
        Usuario[] newArray = new Usuario[this.usuarios.length + 1];
        for (int i = 0; i < this.usuarios.length; i++) {
            newArray[i] = this.usuarios[i];
        }
        this.usuarios = newArray;
    }

    private void redimensionarVetorLivro() {
        Livro[] newArray = new Livro[this.livros.length + 1];
        for (int i = 0; i < this.livros.length; i++) {
            newArray[i] = this.livros[i];
        }
        this.livros = newArray;
    }

    //Método por onde iniciará a execução do programa
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        int opcao;
        Scanner entrada = new Scanner(System.in);

        //Variaveis para o cadastro do usuário
        String nome;
        String cpf;
        String nascimento;
        int id;

        //Variaveis para emprestimo, devolução e impressao de livros especificos
        String nomeDigitado = null;
        boolean achouNome = false;
        String livroDigitado = null;
        boolean achoulivro = false;
        Usuario usuarioAchado = null;
        Livro livroAchado = null;

        //Variaveis para o cadastro do livro
        String titulo;
        String autor;
        String editora;
        int anoPublicacao;

        System.out.println();
        System.out.println("Olá caro Bibliotecário, qual é o nome da biblioteca?");
        System.out.print("Nome: ");
        biblioteca.setNome(entrada.nextLine());
        System.out.println();
        System.out.println("Bem-vindo à " +biblioteca.getNome());
        System.out.println();

        do {
            System.out.println("=====");
            System.out.println("O que você deseja fazer?");
            System.out.println("\t1 - Cadastrar novo usuário");
            System.out.println("\t2 - Cadastrar novo livro");
            System.out.println("\t3 - Realizar empréstimo de um livro");
            System.out.println("\t4 - Realizar devolução de um livro");
            System.out.println("\t5 - Imprimir livros disponíveis");
            System.out.println("\t6 - Imprimir livros emprestadados para determinado usuário");
            System.out.println("\t0 - Sair");
            System.out.println("Digite o número correspondente a opcão desejada.");
            System.out.print("Opção: ");

            opcao = entrada.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println();
                    System.out.println("Tenha um otímo dia, caro Bibliotecário. Até breve!");
                    break;
                case 1:
                    int opcao2;

                    System.out.println("=====");
                    System.out.println("Quem é o novo usuário?");
                    do {
                        System.out.println("\t1 - Morador");
                        System.out.println("\t2 - Aluno");
                        System.out.println("\t3 - Professor");
                        System.out.println("Digite o número correspondente a opcão desejada.");
                        System.out.print("Opção: ");

                        opcao2 = entrada.nextInt();

                        if(opcao2 != 1 && opcao2 != 2 && opcao2 != 3) {
                            System.out.println();
                            System.out.println("Opção inválida, tente novamente.");
                            System.out.println();
                            continue;
                        }

                        System.out.println("Insira os dados do novo usuário");
                        System.out.print("Nome: ");
                        entrada.nextLine();
                        nome = entrada.nextLine();
                        System.out.print("CPF: ");
                        cpf = entrada.nextLine();
                        System.out.print("Data de nascimento (dd/MM/yyyy): ");
                        nascimento = entrada.nextLine();
                        System.out.print("ID: ");
                        id = entrada.nextInt();

                        switch (opcao2) {
                            case MORADOR:
                                biblioteca.cadastrarUsuario(MORADOR, nome, cpf, nascimento, id);
                                break;
                            case ALUNO:
                                String escola;

                                entrada.nextLine();
                                System.out.print("Escola: ");
                                escola = entrada.nextLine();
                                biblioteca.cadastrarUsuario(ALUNO, nome, cpf, nascimento, id, escola);
                                break;
                            case PROFESSOR:
                                String formacao;

                                entrada.nextLine();
                                System.out.print("Formação: ");
                                formacao = entrada.nextLine();

                                biblioteca.cadastrarUsuario(PROFESSOR, nome, cpf, nascimento, id, formacao);
                                break;
                            default:
                                break;
                        }

                        System.out.println();
                        System.out.println("O cadastro de " +biblioteca.usuarios[biblioteca.usuarios.length - 1].nome+ " foi realizado com sucesso.");
                        System.out.println();

                    } while(opcao2 != 1 && opcao2 != 2 && opcao2 != 3);
                    break;
                case 2:
                    System.out.println("=====");
                    System.out.println("Insira os dados do novo livro");
                    System.out.print("Título: ");
                    entrada.nextLine();
                    titulo = entrada.nextLine();
                    System.out.print("Autor: ");
                    autor = entrada.nextLine();
                    System.out.print("Editora: ");
                    editora = entrada.nextLine();
                    System.out.print("Ano de publicação: ");
                    anoPublicacao = entrada.nextInt();

                    biblioteca.cadastrarLivro(titulo, autor, editora, anoPublicacao);

                    System.out.println();
                    System.out.println("O cadastro de \"" +biblioteca.livros[biblioteca.livros.length - 1].titulo+ "\" foi realizado com sucesso.");
                    System.out.println();

                    break;
                case 3:
                    if(biblioteca.usuarios.length == 0 && biblioteca.livros.length > 0) {

                        System.out.println();
                        System.out.println("Nenhum usuário foi cadastrado até o momento");
                        System.out.println();
                    } else if (biblioteca.usuarios.length > 0 && biblioteca.livros.length == 0){

                        System.out.println();
                        System.out.println("Nenhum livro foi cadastrado até o momento");
                        System.out.println();
                    } else if (biblioteca.usuarios.length == 0 && biblioteca.livros.length == 0){

                    System.out.println();
                    System.out.println("Nenhum livro nem usuário foi cadastrado até o momento");
                    System.out.println();

                    } else {
                        nomeDigitado = null;
                        achouNome = false;
                        livroDigitado = null;
                        achoulivro = false;
                        usuarioAchado = null;
                        livroAchado = null;

                        entrada.nextLine();
                        System.out.println("=====");
                        System.out.println("Quem irá realizar o emprestimo?");
                        System.out.print("Nome do usuario (exatamente como cadastrado): ");
                        nomeDigitado = entrada.nextLine();

                        for (Usuario usuarioAtual : biblioteca.usuarios) {
                            if (nomeDigitado.equals(usuarioAtual.nome)) {
                                achouNome = true;
                                usuarioAchado = usuarioAtual;
                            }
                        }

                        if (achouNome) {
                            System.out.println("Qual livro será emprestado?");
                            System.out.print("Título do livro (exatamente como cadastrado): ");
                            livroDigitado = entrada.nextLine();

                            for (Livro livroAtual : biblioteca.livros) {
                                if (livroDigitado.equals(livroAtual.titulo)) {
                                    achoulivro = true;
                                    livroAchado = livroAtual;
                                }
                            }

                            if (achoulivro) {
                                if (biblioteca.realizarEmprestimo(usuarioAchado, livroAchado)) {
                                    System.out.println();
                                    System.out.println(usuarioAchado.nome + " emprestou o livro \"" + livroAchado.titulo + "\" com sucesso.");
                                    System.out.println();
                                } else {
                                    System.out.println();
                                    System.out.println("O empréstimo não foi realizado :(");
                                    System.out.println();
                                }

                            } else {
                                System.out.println();
                                System.out.println("Livro não encontraddo :(");
                                System.out.println();
                            }

                        } else {
                            System.out.println();
                            System.out.println("Usuário não encontraddo :(");
                            System.out.println();
                        }
                    }

                    break;
                case 4:
                    if(biblioteca.usuarios.length == 0 && biblioteca.livros.length > 0) {

                        System.out.println();
                        System.out.println("Nenhum usuário foi cadastrado até o momento");
                        System.out.println();
                    } else if (biblioteca.usuarios.length > 0 && biblioteca.livros.length == 0){

                        System.out.println();
                        System.out.println("Nenhum livro foi cadastrado até o momento");
                        System.out.println();
                    } else if (biblioteca.usuarios.length == 0 && biblioteca.livros.length == 0){

                        System.out.println();
                        System.out.println("Nenhum livro nem usuário foi cadastrado até o momento");
                        System.out.println();

                    } else {
                        achouNome = false;
                        achoulivro = false;
                        usuarioAchado = null;
                        livroAchado = null;

                        entrada.nextLine();
                        System.out.println("=====");
                        System.out.println("Quem irá realizar a devolução?");
                        System.out.print("Nome do usuario (exatamente como cadastrado): ");
                        nomeDigitado = entrada.nextLine();

                        for (Usuario usuarioAtual : biblioteca.usuarios) {
                            if (nomeDigitado.equals(usuarioAtual.nome)) {
                                achouNome = true;
                                usuarioAchado = usuarioAtual;
                            }
                        }

                        if (achouNome) {
                            System.out.println("Qual livro será devolvido?");
                            System.out.print("Título do livro (exatamente como cadastrado): ");
                            livroDigitado = entrada.nextLine();

                            for (Livro livroAtual : biblioteca.livros) {
                                if (livroDigitado.equals(livroAtual.titulo)) {
                                    achoulivro = true;
                                    livroAchado = livroAtual;
                                }
                            }

                            if (achoulivro) {
                                if (biblioteca.realizarDevolucao(usuarioAchado, livroAchado)) {
                                    System.out.println();
                                    System.out.println(usuarioAchado.nome + " devolveu o livro \"" + livroAchado.titulo + "\" com sucesso.");
                                    System.out.println();
                                } else {
                                    System.out.println();
                                    System.out.println("A devolução não foi realizada :(");
                                    System.out.println();
                                }

                            } else {
                                System.out.println();
                                System.out.println("Livro não encontraddo :(");
                                System.out.println();
                            }

                        } else {
                            System.out.println();
                            System.out.println("Usuário não encontraddo :(");
                            System.out.println();
                        }
                    }

                    break;
                case 5:
                    biblioteca.imprimirLivros();
                    break;
                case 6:
                    if(biblioteca.usuarios.length == 0 && biblioteca.livros.length > 0) {

                        System.out.println();
                        System.out.println("Nenhum usuário foi cadastrado até o momento");
                        System.out.println();
                    } else {
                        nomeDigitado = null;
                        achouNome = false;
                        usuarioAchado = null;

                        entrada.nextLine();
                        System.out.println("De quem voce quer imprimir os livros emprestados?");
                        System.out.print("Nome do usuário: ");
                        nomeDigitado = entrada.nextLine();

                        for (Usuario usuarioAtual : biblioteca.usuarios) {
                            if (nomeDigitado.equals(usuarioAtual.nome)) {
                                achouNome = true;
                                usuarioAchado = usuarioAtual;
                            }
                        }

                        if (achouNome) {
                            if(usuarioAchado.livrosAlugados.length > 0) {
                                System.out.println("Livros emprestados para " +usuarioAchado.nome);

                                for(Livro livroAtual : usuarioAchado.livrosAlugados) {
                                    livroAtual.imprimir();
                                }
                            } else {
                                System.out.println();
                                System.out.println(usuarioAchado.nome+ " não tem livros alugados");
                                System.out.println();
                            }

                        } else {
                            System.out.println();
                            System.out.println("Usuário não encontraddo :(");
                            System.out.println();
                        }
                        break;
                    }
                default:
                    System.out.println();
                    System.out.println("Opção inválida, tente novamente.");
                    System.out.println();
                    break;
            }

        } while(opcao != 0);
    }
}