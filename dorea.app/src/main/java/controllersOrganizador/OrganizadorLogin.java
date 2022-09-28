package controllersOrganizador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DoadoresDAO;
import DAO.OrganizadorDAO;

@WebServlet("/OrganizadorLogado")
public class OrganizadorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrganizadorLogin() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		HttpSession session_nome = request.getSession();
		HttpSession session_id = request.getSession();
		RequestDispatcher dispatcher = null;
		if(OrganizadorDAO.loginValidar(email, senha) == true) {
			String nome = OrganizadorDAO.returnarNomeByEmail(email);
			int organizadorId = OrganizadorDAO.findIdByEmail(email);
			session_nome.setAttribute("name", nome);
			session_id.setAttribute("organizadorId", organizadorId);
			dispatcher = request.getRequestDispatcher("/pages/organizadorLogado/Logado.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/pages/login.jsp");
		}
		doGet(request, response);
	}

}
