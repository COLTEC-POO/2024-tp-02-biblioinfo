public class Main {
    public static void main(String[] args) {
        System.out.println("============================================");
        Livro l1 = new Livro("a culpa e de info", "samuel", "fe em deus", 2007);

        System.out.println("Livros cadastrados:");

        l1.imprimir();

        Livro l2 = new Livro("O Auto da Compadecida","Ariano suassuna","Nova Fronteira",1955);
        Livro l3 = new Livro("O Santo e a Porca","Ariano suassuna","Nova Fronteira",1957);
        Livro l4 = new Livro("O Estalo","Luís Dill","Positivo",2020);
        Livro l5 = new Livro("Como Evitar um Desastre Climático","Bill Gates","Companhia da Letras",2021);
        Livro l6 = new Livro("Bíblia Sagrada","Deus","Editora Getsêmani",-1400);
        Livro l7 = new Livro("Os 7 Hábitos dos Adolescentes Altamente Eficazes","Sean Covey","Best Seller",2009);
        Livro l8 = new Livro("Logo Logo: Dez novas tecnologias que vão melhorar e/ou arruinar tudo","Kelly Weinersmith e Zach Weinersmith","Intrinseca",2018);
        Livro l9 = new Livro("Le Petit Prince","Antoine de Saint-Exupéry","BN Publishing",2012);
        Livro l10 = new Livro("O desperat do universo consciente", "marcelo Gleiser", "Record", 2019);
        Livro l11 = new Livro("O livro dos misterios","Jonathan Cahn","Editora Vida", 2024);
        Livro l12 = new Livro("Os meninos que enganavam nazistas","Joseph Joffo","Vestigio", 2017);
        Livro l13 = new Livro("Cristianismo Puro e simples","C.S Lewis","Thomas Nelson Brasil", 1952);
        //Livro l14 = new Livro("","","",);
        //Livro l15 = new Livro("","","",);
        //Livro l16 = new Livro("","","",);
        //Livro l17 = new Livro("","","",);
        //Livro l18 = new Livro("","","",);
        //Livro l19 = new Livro("","","",);
        //Livro l20 = new Livro("","","",);
        Usuario p1 = new Aluno("Samuel", "1234567890", "14/09/1977", 0,"Colégio Técnico da Universidade Federeal de Minas Gerais");
        Usuario p2 = new Professor("Fantini", "0987654321", "13/05/1900", 1, "Ciencia da computacao");
        p1.pegarLivro(l8);
        p1.pegarLivro(l9);
        p1.pegarLivro(l2);
        p1.pegarLivro(l1);
        p1.pegarLivro(l6);
        boolean a = p1.pegarLivro(l5);
        System.out.println(a);
        boolean b = p1.devolverLivro(l9);
        System.out.println(b);
        boolean c = p1.pegarLivro(l5);
        System.out.println(c);

        //usuario p2 alugando livros
        p2.pegarLivro(l3);
        p2.pegarLivro(l4);
        p2.pegarLivro(l7);
        p2.pegarLivro(l10);
        p2.pegarLivro(l12);
        p2.pegarLivro(l13);
        p2.pegarLivro(l11);

        p1.imprimirLivrosUsuario();

        p2.imprimirLivrosUsuario();


    }
}