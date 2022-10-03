<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("name") == null) {
		response.sendRedirect("../parceiros.html");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Doreá</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/stylesheet.css">
</head>
<body>

  <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="facebook" viewBox="0 0 16 16">
      <path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"></path>
    </symbol>
    <symbol id="instagram" viewBox="0 0 16 16">
        <path d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z"></path>
    </symbol>
    <symbol id="twitter" viewBox="0 0 16 16">
      <path d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"></path>
    </symbol>
  </svg>
  
 <header class="container-fluid bg-color1">
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
                <li class="nav-item"><a href="${pageContext.request.contextPath}/Home" class="nav-link active txt-color hover-color"><i class="bi bi-house-fill"></i> Home</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/pages/doadorLogado/sobre.jsp" class="nav-link active txt-color"><i class="bi bi-list-nested"></i> Sobre</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/pages/doadorLogado/parceiros.jsp" class="nav-link active txt-color"><i class="bi bi-hand-thumbs-up-fill"></i> Parceiros</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/pages/doadorLogado/contato.jsp" class="nav-link active txt-color"><i class="bi bi-envelope-fill"></i> Contato</a></li>
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
	                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/sair">Sair</a></li>
	                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/Perfil?doadorId=<%= session.getAttribute("Id") %>">Perfil</a></li>
	                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/listaDoacao?doadorId=<%= session.getAttribute("Id") %>">Minhas doações</a></li>
                    </ul>
               	  </div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </section>
  </header>
  
  <main class="container d-flex align-items-center main-tamanho">
    <div class="container pt-5">
      <section class="mb-12 mt-6 text-center">
        <h2 class="fw-bold mb-5">Nossos&nbsp;<span class="txt-color2">Parceiros</span></h2>
      </section>
      <div class="row mb-lg-5">
        <div class="col-sm-6 p-4 justify-content-center">
          <p class="pt-lg-5">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Accusantium quis asperiores aliquam
            debitis eaque consectetur. Reiciendis sint ullam, perferendis laboriosam facere quae quos ipsum
            ea nihil, id aperiam voluptatibus expedita!
          </p>
        </div>
        <div class="col-sm-6 mb-3 mt-3">
          <div class="row">
            <div class="col-6 mb-5 mb-lg-0">
              <img src="${pageContext.request.contextPath}/img/logo 1.png" class="img-fluid grayscale px-4 px-md-5" alt="" aria-controls="#picker-editor">
            </div>
            <div class="col-6 col-6 mb-5 mb-lg-0"> <img src="${pageContext.request.contextPath}/img/logo 2.png" class="img-fluid grayscale px-4 px-md-5" alt="" aria-controls="#picker-editor"> </div>
            <div class="row-2 col-6 mt-5 mb-lg-0"> <img src="${pageContext.request.contextPath}/img/logo 3.png" class="img-fluid grayscale px-4 px-md-5" alt="" aria-controls="#picker-editor"> </div>
            <div class="row-2 col-6 mt-5 mb-lg-0"> <img src="${pageContext.request.contextPath}/img/logo 4.png" class="img-fluid grayscale px-4 px-md-5" alt="" aria-controls="#picker-editor"> </div>
          </div>
        </div>
      </div>
    </div>
  </main>
  
  <footer class="bg-color1">
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