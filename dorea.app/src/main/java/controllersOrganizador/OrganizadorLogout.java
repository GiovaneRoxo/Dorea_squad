package controllersOrganizador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sairAdm")
public class OrganizadorLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrganizadorLogout() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		session.invalidate(); 
		response.sendRedirect("pages/loginAdm.html");
	}
}
