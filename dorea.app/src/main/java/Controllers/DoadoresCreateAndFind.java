package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DoadoresDAO;
import model.Doadores;


@WebServlet("/CreateAndFind")
public class DoadoresCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoadoresCreateAndFind() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Doadores doador = new Doadores();
		doador.setNome(request.getParameter("nome"));
		doador.setSobrenome(request.getParameter("sobrenome"));
		doador.setCpf(request.getParameter("cpf"));
		doador.setEmail(request.getParameter("email"));
		doador.setTelefone(request.getParameter("telefone"));
		doador.setSenha(request.getParameter("senha"));
		DoadoresDAO.criarDoador(doador);
		response.sendRedirect("pages/logado/menulogin.html");
		doGet(request, response);
	}

}
