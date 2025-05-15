package sosanimais.com.example.app.model.db;

import java.sql.Connection;
import java.sql.SQLException;

public class SingletonDB {

    private static Conexao conexao = null;

    private SingletonDB() {
    }

    public static boolean conectar() {
        if (conexao == null || !conexao.getStatConexao()) {
            conexao = new Conexao();
            return conexao.conectar("jdbc:postgresql://localhost:5432/", "Sos_animais_DB", "postgres", "postgres123");
        }
        return true;
    }

    public static Connection getConnection() throws SQLException {
        if (conexao == null || !conexao.getStatConexao()) {
            if (!conectar()) {
                throw new SQLException("Não foi possível conectar ao banco de dados.");
            }
        }
        return conexao.getConnection();
    }

    public static void fechar() {
        if (conexao != null) {
            conexao.fechar();
            conexao = null;
        }
    }
}