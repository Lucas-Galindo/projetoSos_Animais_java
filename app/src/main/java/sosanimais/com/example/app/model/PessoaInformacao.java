package sosanimais.com.example.app.model;

public class PessoaInformacao {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Endereco adress;

    public PessoaInformacao(String nome,String cpf,String telefone,String email,String rua, int numero, String cep, String complemento){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;    
        this.adress = new Endereco(rua, numero, cep, complemento);
    }
}
