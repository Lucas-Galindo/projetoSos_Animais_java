package sosanimais.com.example.app.model.entity;

import sosanimais.com.example.app.model.Produto_Informacao;

public class Produto {
    private int id;
    private Produto_Informacao produto;

    public Produto(int id, Produto_Informacao produto) {
        this.id = id;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto_Informacao getProduto() {
        return produto;
    }

    public void setProduto(Produto_Informacao produto) {
        this.produto = produto;
    }
}
