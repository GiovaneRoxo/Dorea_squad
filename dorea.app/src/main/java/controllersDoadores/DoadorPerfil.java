package controllersDoadores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DoadoresDAO;
import model.Doadores;


@WebServlet("/Perfil")
public class DoadorPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoadorPerfil() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int doadorId = Integer.parseInt(request.getParameter("doadorId"));
		Doadores doador = DoadoresDAO.findByPk(doadorId);
		request.setAttribute("doador", doador);
		RequestDispatcher despachar = request.getRequestDispatcher("pages/doadorLogado/PerfilDoador.jsp");
		despachar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
