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
        //Livro l10 = new Livro("","","",);
        //Livro l11 = new Livro("","","",);
        //Livro l12 = new Livro("","","",);
        Usuario p1 = new Aluno("Montandon", "1234567890", "14/09/1977", 0,"Colégio Técnico da Universidade Federeal de Minas Gerais");
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
    }

}

