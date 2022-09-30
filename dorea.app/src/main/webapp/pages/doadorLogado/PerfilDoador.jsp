<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	if(session.getAttribute("name") == null) {
		response.sendRedirect("pages/login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
	                    <li><a class="dropdown-item" href="sair">Sair</a></li>
	                    <li><a class="dropdown-item" href="Perfil?doadorId=<%= session.getAttribute("Id") %>">Perfil</a></li>
	                    <li><a class="dropdown-item" href="#">#</a></li>
                    </ul>
               	  </div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </section>
  </header>
<br>
<div class="container">
	<div class="row">
		<div class="cold-md-7">
		<hr>
		<h3>Atualização de dados</h3>
		<hr>
		<form name="cadastro" action="${pageContext.request.contextPath}/Perfil" method="post">
			<input value="${doador.id_doadores}" style="visibility:hidden" name="id">
			<div class="form-floating mb-3">
				<input value="${doador.nome}" name="nome" required maxlength="40" type="text" class="form-control" id="floatingInput1"> 
				<label>Nome</label>
			</div>
			<div class="form-floating mb-3">
				<input value="${doador.sobrenome}" name="sobrenome" required maxlength="40" type="text" class="form-control" id="floatingInput1"> 
				<label>Sobrenome</label>
			</div>
			<div class="form-floating mb-3">
				<input value="${doador.cpf}" id="cpf" name="cpf" required maxlength="14" type="text" class="form-control" onkeyup="somenteNumeros(this);"> 
				<label>CPF</label>
			</div>
			<div class="form-floating mb-3">
				<input value="${doador.email}" id="email" name="email" required maxlength="50" type="text" class="form-control"onclick="ValidateEmail(document.cadastro.text1)"> 
				<label>Email</label>
			</div>
			<div class="form-floating mb-3">
				<input value="${doador.telefone}" name="telefone" required maxlength="11" type="text" class="form-control"> 
				<label>Celular: (DDD)xxxxx-xxxx </label>
			</div>
			<div class="form-floating mb-3">
				<input value="${doador.senha}" name="senha" required maxlength="16" type="password" class="form-control" onkeyup='confereSenha();'> 
				<label>Senha</label>
			</div>
			<button class="btn btn-primary" type="submit">Atualizar Doadores</button>
			<a class="btn btn-secondary" href="DoadorDestroy?Id_doador=${doador.id_doadores}">Deletar conta</a>
		</form>
		</div>
	</div>	
</div>
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
</body>
</html>