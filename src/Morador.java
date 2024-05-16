import java.util.Date;
public class Morador extends Usuario{
    Morador(String nome, String cpf,String data_nascimento, int id){
        this.nome = nome;
        this.cpf = cpf;
        try{ // Converte String para Date
            this.data_nascimento = formatoData.parse(data_nascimento);
        }catch (Exception e){
            System.out.println("Erro ao criar data");
        }
        this.id = id;
        setMaxQtdLivAlu(2);
    }
}
