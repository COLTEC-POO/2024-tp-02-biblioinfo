import java.text.SimpleDateFormat;
import java.util.Date;

public class Professor extends Usuario{
    String formacao;
    Professor(String nome, String cpf,String data_nascimento, int id,String formacao){
        this.formacao = formacao;
        this.nome = nome;
        this.cpf = cpf;
        try{ // Converte String para Date
            this.data_nascimento = formatoData.parse(data_nascimento);
        }catch (Exception e){
            System.out.println("Erro ao criar data");
        }
        this.id = id;
        setMaxQtdLivAlu(10);
    }
}
