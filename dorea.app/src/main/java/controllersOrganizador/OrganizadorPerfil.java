package controllersOrganizador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.OrganizadorDAO;
import model.Organizador;


@WebServlet("/PerfilAdm")
public class OrganizadorPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrganizadorPerfil() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int organizadorId = Integer.parseInt(request.getParameter("Id"));
		Organizador organizador = OrganizadorDAO.findByPk(organizadorId);
		request.setAttribute("organizador", organizador);
		RequestDispatcher despachar = request.getRequestDispatcher("pages/organizadorLogado/PerfilAdm.jsp");
		despachar.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Organizador organizador = new Organizador();
		organizador.setId_organizador(Integer.parseInt(request.getParameter("id")));
		organizador.setNome(request.getParameter("nome"));
		organizador.setCnpj(request.getParameter("cnpj"));
		organizador.setEmail(request.getParameter("email"));
		organizador.setTelefone(request.getParameter("telefone"));
		organizador.setSenha(request.getParameter("senha"));
		OrganizadorDAO.updateAdm(organizador);
		OrganizadorCreateAndFind organizadorCAndFind = new OrganizadorCreateAndFind();
		organizadorCAndFind.doGet(request, response);
		response.sendRedirect("./Inicio");
	}

}
