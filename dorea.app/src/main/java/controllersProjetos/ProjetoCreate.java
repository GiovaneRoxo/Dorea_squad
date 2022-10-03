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

@WebServlet("/ProjetosCAF")
public class ProjetoCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProjetoCreate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Projetos projetos = new Projetos();
		projetos.setFk_Organizador_Id_organizador(Integer.parseInt(request.getParameter("organizadorId")));
		request.setAttribute("projetos", projetos);
		RequestDispatcher despachar = request.getRequestDispatcher("pages/organizadorLogado/CriarProjeto.jsp");
		despachar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Projetos projeto = new Projetos();
		projeto.setNome(request.getParameter("nome"));
		projeto.setObjetivo(Double.parseDouble(request.getParameter("objetivo")));
		projeto.setFk_Organizador_Id_organizador(Integer.parseInt(request.getParameter("organizadorId")));
		projeto.setArrecadado(0.00);
		ProjetoDAO.criarProjeto(projeto);
		response.sendRedirect("./Inicio");
	}

}
