package controllersDoadores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DoadoresDAO;

@WebServlet("/DoadorDestroy")
public class DoadorDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoadorDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int doadorId = Integer.parseInt(request.getParameter("Id_doador"));
		DoadoresDAO.deletarDoador(doadorId);
		response.sendRedirect("pages/login.jsp");
		DoadorCreateAndFind doadorCAndFind = new DoadorCreateAndFind();
		doadorCAndFind.doGet(request, response);
		
	}
}
