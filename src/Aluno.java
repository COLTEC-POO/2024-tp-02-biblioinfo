import java.util.Date;

public class Aluno extends Usuario{
    String escola;
    public Aluno(String nome, String cpf,String data_nascimento, int id,String escola){
        this.escola = escola;
        this.nome = nome;
        this.cpf = cpf;
        try{ // Converte String para Date
            this.data_nascimento = formatoData.parse(data_nascimento);
        }catch (Exception e){
            System.out.println("Erro ao criar data");
        }
        this.id = id;
        setMaxQtdLivAlu(5);
    }
}
