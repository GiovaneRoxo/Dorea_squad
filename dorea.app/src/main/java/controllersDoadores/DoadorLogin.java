package controllersDoadores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DoadoresDAO;
import DAO.ProjetoDAO;
import model.Projetos;

@WebServlet("/Logado")
public class DoadorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoadorLogin() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		HttpSession session_nome = request.getSession();
		HttpSession session_id = request.getSession();
		RequestDispatcher dispatcher = null;
		
		if(DoadoresDAO.loginValidar(email, senha) == true) {
			String nome = DoadoresDAO.returnarNomeByEmail(email);
			int doadorId = DoadoresDAO.findIdByEmail(email);
			session_nome.setAttribute("name", nome);
			session_id.setAttribute("Id", doadorId);
			
	        List<Projetos> listProjetos = ProjetoDAO.listarTodos(); 
	        request.setAttribute("projetos", listProjetos);
			
			dispatcher = request.getRequestDispatcher("/pages/doadorLogado/Logado.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/pages/login.jsp");
		}
		
		doGet(request, response);
		
	}

}
