package controllersProjetos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProjetoDAO;

@WebServlet("/deletar")
public class DeletarProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int projetoId = Integer.parseInt(request.getParameter("projetoId"));
		ProjetoDAO.deletarProjeto(projetoId);
		response.sendRedirect("pages/organizadorLogado/MeusProjetos.jsp");
	}

}
