package sosanimais.com.example.app.model.Dal;

import sosanimais.com.example.app.model.db.SingletonDB;
import sosanimais.com.example.app.model.entity.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAL {

    //Cadastrar novo funcionário
    public boolean registrar(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (id, matricula, login, senha, pessoa_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = SingletonDB.getConnection().prepareStatement(sql)) {
            stmt.setLong(1, funcionario.getId());
            stmt.setInt(2, funcionario.getMatricula());
            stmt.setString(3, funcionario.getLogin());
            stmt.setString(4, funcionario.getSenha());
            stmt.setLong(5, funcionario.getPessoa().getId()); // assumindo que PessoaInformacao tem id

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Verificando se o login e senha existem e são verdadeiros
    public Funcionario validarLogin(String login, String senha) {
        String sql = "SELECT * FROM funcionario WHERE login = ? AND senha = ?";
        Funcionario funcionario = null;

        try (PreparedStatement stmt = SingletonDB.getConnection().prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);  //Atenção: para produção, use hash e nunca armazene senha em texto puro

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                funcionario = mapearFuncionario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    }


    //Atualizar dados do funcionário existente
    public boolean atualizar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET matricula = ?, login = ?, senha = ?, pessoa_id = ? WHERE id = ?";

        try (PreparedStatement stmt = SingletonDB.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, funcionario.getMatricula());
            stmt.setString(2, funcionario.getLogin());
            stmt.setString(3, funcionario.getSenha());
            stmt.setLong(4, funcionario.getPessoa().getId());
            stmt.setLong(5, funcionario.getId());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Buscar funcionário por ID
    public Funcionario buscarPorId(Long id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        Funcionario funcionario = null;

        try (PreparedStatement stmt = SingletonDB.getConnection().prepareStatement(sql)) {
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                funcionario = mapearFuncionario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    }

    //Listando todos os funcionários
    public List<Funcionario> listarTodos() {
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> lista = new ArrayList<>();

        try (PreparedStatement stmt = SingletonDB.getConnection().prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario f = mapearFuncionario(rs);
                lista.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    //Método auxiliar para mapear o "ResultSet" para Funcionario
    private Funcionario mapearFuncionario(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        int matricula = rs.getInt("matricula");
        String login = rs.getString("login");
        String senha = rs.getString("senha");
        Long pessoaId = rs.getLong("pessoa_id");

        // Aqui você pode buscar a PessoaInformacao pelo id (se quiser)
        // Exemplo simplificado, deixando null por enquanto
        // PessoaInformacao pessoa = buscarPessoaInformacaoPorId(pessoaId);

        return new Funcionario(id, null, matricula, login, senha);
    }

    //Exemplo de método para buscar PessoaInformacao (opcional)
    /*
    private PessoaInformacao buscarPessoaInformacaoPorId(Long id) {
        // Implemente o acesso ao banco para PessoaInformacao
    }
    */
}

