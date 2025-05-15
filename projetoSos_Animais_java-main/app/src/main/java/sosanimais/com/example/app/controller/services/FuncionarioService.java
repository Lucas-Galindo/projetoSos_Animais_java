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

    public Funcionario buscarPorLoginSenha(String login, String senha) throws SQLException {
        Funcionario func = null;
        String sql = "SELECT * FROM funcionario WHERE func_login = ? AND func_senha = ?";

        // Obtém a conexão do SingletonDB
        var conexao = SingletonDB.getConexao().getConnection();

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                func = new Funcionario(
                        rs.getLong("pess_id"),
                        rs.getInt("func_matricula"),
                        rs.getString("func_login"),
                        rs.getString("func_senha")
                );
            }
        }

        return func;
    }
}
