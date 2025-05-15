package sosanimais.com.example.app.controller;

import sosanimais.com.example.app.model.Dal.FuncionarioDAL;
import sosanimais.com.example.app.model.entity.Funcionario;

import java.util.List;

public class FuncionarioController{

    private final FuncionarioDAL funcionarioDAL;

    public FuncionarioController() {
        this.funcionarioDAL = new FuncionarioDAL();
    }

    //Verifica o login do funcionário
    public Funcionario validarLogin(String login, String senha) {
        return funcionarioDAL.validarLogin(login, senha);
    }

    //Registra novo funcionario
    public boolean registra(Funcionario funcionario) {
        return funcionarioDAL.registrar(funcionario);
    }

    //Atualiza dados do funcionário existente
    public boolean atualizar(Funcionario funcionario) {
        return funcionarioDAL.atualizar(funcionario);
    }

    //Buscar funcionário por ID
    public Funcionario buscarPorId(Long id) {
        return funcionarioDAL.buscarPorId(id);
    }

    //Lista todos os funcionários
    public List<Funcionario> listarTodos() {
        return funcionarioDAL.listarTodos();
    }
}
