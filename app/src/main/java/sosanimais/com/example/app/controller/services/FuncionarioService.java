package sosanimais.com.example.app.controller.services;


import org.springframework.http.ResponseEntity;
import sosanimais.com.example.app.model.db.IDAO;
import sosanimais.com.example.app.model.entity.Funcionario;

import java.util.List;

public class FuncionarioService implements IDAO{


    @Override
    public boolean save(Object entidade) {
        //metodo
        return false;
    }

    @Override
    public boolean update(Object entidade) {
        return false;
    }

    @Override
    public boolean delete(Object entidade) {
        return false;
    }

    @Override
    public List<Object> getAll() {
        return List.of();
    }

    @Override
    public boolean get(int id) {
        return false;
    }

    @Override
    public List get(String filtro) {
        return List.of();
    }
}
