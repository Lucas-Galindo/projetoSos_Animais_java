package sosanimais.com.example.app.controller.services;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sosanimais.com.example.app.controller.FuncionarioService;
import sosanimais.com.example.app.model.entity.Funcionario;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private FuncionarioService funcionarioService;

    @Override
    public void init() throws ServletException {
        super.init();
        funcionarioService = new FuncionarioService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recebe parâmetros do formulário
        String login = request.getParameter("email");
        String senha = request.getParameter("password");

        try {
            // Aqui você precisa implementar a busca do funcionário pelo login e senha
            Funcionario funcionario = funcionarioService.buscarPorLoginSenha(login, senha);

            if (funcionario != null) {
                // Login OK: cria sessão e redireciona para página principal
                request.getSession().setAttribute("usuarioLogado", funcionario);
                response.sendRedirect(request.getContextPath() + "/home.jsp");  // Ajuste a URL da página principal
            } else {
                // Login inválido: redireciona para login com mensagem de erro
                response.sendRedirect(request.getContextPath() + "/login.html?error=Usuário ou senha inválidos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/login.html?error=Erro interno no sistema");
        }
    }

    // Você pode implementar o método doGet para redirecionar para a página de login se desejar
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/login.html");
    }
}
