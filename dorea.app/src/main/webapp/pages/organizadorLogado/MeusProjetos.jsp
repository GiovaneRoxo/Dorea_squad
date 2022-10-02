<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("name") == null) {
		response.sendRedirect("pages/loginAdm.html");
	}
%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DOREA</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<header class="container-fluid bg-color3">
	    <section class="container d-flex ">
	      <div class="container">
	        <nav class="navbar navbar-dark navbar-expand-md">    
	          <div class="container">
	            <h3 class="txt-color" style="width: 125px;">Dorea</h3>
	            <a class="navbar-brand">
	            </a>
	            <button class="navbar-toggler order-first" type="button" data-bs-toggle="collapse" data-bs-target="#navcol-1">
	              <span class="visually-hidden">toggle navigation</span>
	              <span class="navbar-toggler-icon"></span>
	            </button>
	            <div id="navcol-1" class="collapse navbar-collapse">
	              <ul class="navbar-nav mb-2 mb-lg-0">
	                <li class="nav-item"><a href="#" class="nav-link active txt-color hover-color">Home</a></li>
	                <li class="nav-item"><a href="#" class="nav-link active txt-color">Sobre</a></li>
	                <li class="nav-item"><a href="#" class="nav-link active txt-color">Parceiros</a></li>
	                <li class="nav-item"><a href="#" class="nav-link active txt-color">Contato</a></li>
	              </ul>
	            </div>
	          </div>
	        </nav>
	      </div>
	      <div class="container d-flex">
	        <div class="container">
	          <ul class="nav justify-content-end" style="margin-top: 15px;">
	            <li class="nav-item" style="margin-top: 0px">
	              <div class="hover-color">
	                  <div class="dropdown mb-2 mt-md-2">
	                    <a class="dropdown-toggle login txt-color" data-bs-toggle="dropdown"><%= session.getAttribute("name") %>
			                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
			                	<path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/>
			                </svg>
		              	</a>
	                    <ul class="dropdown-menu">
		                    <li><a class="dropdown-item" href="sairAdm">Sair</a></li>
		                    <li><a class="dropdown-item" href="PerfilAdm?Id=<%= session.getAttribute("organizadorId") %>">Perfil</a></li>
		                    <li><a class="dropdown-item" href="">Meus projetos</a></li>
		                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/pages/organizadorLogado/CriarProjeto.jsp">Criar novo projeto</a></li>
	                    </ul>
	               	  </div>
	              </div>
	            </li>
	          </ul>
	        </div>
	      </div>
	    </section>
    </header>
	<main>
	  <section class="py-5 text-center container">
	    <div class="row py-lg-5">
	      <div class="col-lg-6 col-md-8 mx-auto">
	        <h1 class="fw-light">Esses sao alguns dos seus projetos</h1>
	       	<p>
	          <a href="#" class="btn btn-primary my-2">Criar um novo projeto</a>
	        </p>
	      </div>
	    </div>
	  </section>
	  <div class="album py-5 bg-light">
	    <div class="container">
	      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
	        <c:forEach items="${projeto}" var="projeto">
		        <div class="col">
		          <div class="card shadow-sm">
		            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
		            <div class="card-body">
		              <h2>${projeto.nome}</h2>
		              <p class="card-text">R$ ${projeto.objetivo}</p>
		              <div class="d-flex justify-content-between align-items-center">
		                <div class="btn-group">
		                  <a href="editar?projetoId=${projeto.id_projeto}" class="btn btn-sm btn-outline-secondary">Editar</a>
		                  <a href="deletar?projetoId=${projeto.id_projeto}" class="btn btn-sm btn-outline-secondary">Deletar</a>
		                </div>
		              </div>
		            </div>
		          </div>
		        </div>
	       </c:forEach>
	      </div>
	    </div>
	   </div>
	</main>
<footer class="bg-color3">
    <div class="container d-flex flex-wrap justify-content-between align-items-center py-3">
      <div class="col-md-4 d-flex align-items-center">
        <span class="mb-3 mb-md-0 txt-color">© 2022</span>
      </div>
      <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
        <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#twitter"></use></svg></a></li>
        <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#instagram"></use></svg></a></li>
        <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#facebook"></use></svg></a></li>
      </ul>
    </div>
</footer>
<script type="text/javascript" src="${pageContext.request.contextPath}/scriptjs/script.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>