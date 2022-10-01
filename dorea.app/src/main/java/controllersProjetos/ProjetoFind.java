package controllersProjetos;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProjetoDAO;
import model.Projetos;

@WebServlet("/ProjetoF")
public class ProjetoFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProjetoFind() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Projetos> listProjetos = ProjetoDAO.findByPk(Integer.parseInt(request.getParameter("organizadorId"))); 
		request.setAttribute("projetos", listProjetos);
		RequestDispatcher despachar = request.getRequestDispatcher("pages/organizadorLogado/MeusProjetos.jsp");
		despachar.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
