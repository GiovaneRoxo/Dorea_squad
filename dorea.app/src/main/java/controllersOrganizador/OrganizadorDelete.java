package controllersOrganizador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.OrganizadorDAO;

@WebServlet("/OrganizadorDestroy")
public class OrganizadorDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrganizadorDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int organizadorId = Integer.parseInt(request.getParameter("organizadorId"));
		OrganizadorDAO.deletarOrganizador(organizadorId);
		response.sendRedirect("pages/loginAdm.jsp");
		OrganizadorCreateAndFind organizadorCAndFind = new OrganizadorCreateAndFind();
		organizadorCAndFind.doGet(request, response);
		
	}
}
