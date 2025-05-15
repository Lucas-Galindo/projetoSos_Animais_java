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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getAdress() {
        return adress;
    }

    public void setAdress(Endereco adress) {
        this.adress = adress;
    }
}
