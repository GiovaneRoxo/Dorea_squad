package controllersDoacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DoacaoDAO;
import DAO.ProjetoDAO;
import model.Doacao;
import model.Projetos;

@WebServlet("/doar")
public class DoarProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("projetoId"));
	        Projetos listProjetos = ProjetoDAO.buscaByPk(id); 
	        request.setAttribute("projeto", listProjetos);
	        RequestDispatcher despachar = request.getRequestDispatcher("pages/doadorLogado/Doacao.jsp");
	        despachar.forward(request, response);
	}
	
	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       Doacao doacao = new Doacao();
	       doacao.setValor(Double.parseDouble(request.getParameter("valor")));
	       doacao.setFk_Doadores_Id_doadores(Integer.parseInt(request.getParameter("doadorId")));
	       doacao.setFk_Projetos_Id_projeto(Integer.parseInt(request.getParameter("projetoId")));
	       DoacaoDAO.criarDoacao(doacao);
	       response.sendRedirect("./Home");
	    }

}
