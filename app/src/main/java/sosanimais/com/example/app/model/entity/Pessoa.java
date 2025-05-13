package sosanimais.com.example.app.model.entity;

import sosanimais.com.example.app.model.PessoaInformacao;

public class Pessoa {
    private int id;
    private PessoaInformacao pessoa;

    public Pessoa(int id, PessoaInformacao pessoa) {
        this.id = id;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PessoaInformacao getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaInformacao pessoa) {
        this.pessoa = pessoa;
    }
}
