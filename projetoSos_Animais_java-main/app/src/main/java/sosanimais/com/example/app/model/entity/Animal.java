package sosanimais.com.example.app.model.entity;

import sosanimais.com.example.app.model.Animal_Informacao;

public class Animal {

    private int id;
    private int idBaia;
    private int idAcolhimento;
    private Animal_Informacao informacao;

    public Animal(int id, int idBaia, int idAcolhimento, Animal_Informacao informacao) {
        this.id = id;
        this.idBaia = idBaia;
        this.idAcolhimento = idAcolhimento;
        this.informacao = informacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBaia() {
        return idBaia;
    }

    public void setIdBaia(int idBaia) {
        this.idBaia = idBaia;
    }

    public int getIdAcolhimento() {
        return idAcolhimento;
    }

    public void setIdAcolhimento(int idAcolhimento) {
        this.idAcolhimento = idAcolhimento;
    }

    public Animal_Informacao getInformacao() {
        return informacao;
    }

    public void setInformacao(Animal_Informacao informacao) {
        this.informacao = informacao;
    }
}
