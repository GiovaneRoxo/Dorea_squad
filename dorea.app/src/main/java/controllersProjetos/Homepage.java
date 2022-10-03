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

@WebServlet(name = "/Home_p", urlPatterns={"/index.html"})
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Homepage() {
        super();
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = null;
        List<Projetos> listProjetos = ProjetoDAO.listarTodos(); 
        request.setAttribute("projetos", listProjetos);
        
        dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
