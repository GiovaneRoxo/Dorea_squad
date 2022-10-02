package controllersProjetos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProjetoDAO;
import model.Projetos;

@WebServlet("/editar")
public class ProjetoEditar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("projetoId"));
		Projetos projeto = ProjetoDAO.buscaByPk(id);
		request.setAttribute("projeto", projeto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/organizadorLogado/EditarProjeto.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Projetos projeto = new Projetos();
		projeto.setNome(request.getParameter("nome"));
		projeto.setObjetivo(Double.parseDouble(request.getParameter("objetivo")));
		projeto.setId_projeto(Integer.parseInt(request.getParameter("projetoId")));
		ProjetoDAO.Atualizar(projeto);
		response.sendRedirect("pages/organizadorLogado/MeusProjetos.jsp");
	}

}
