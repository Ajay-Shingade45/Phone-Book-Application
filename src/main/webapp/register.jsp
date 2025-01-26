<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="Component/allCssJs.jsp"%>
</head>
<body>
	<%@include file="Component/navbar.jsp"%>
	<div class="conatiner-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-danger">Register Page</h4>
						<%
					     String sucssMsg=(String) session.getAttribute("succMsg");
					     String erroMsg=(String) session.getAttribute("failed");
					     
					     if(sucssMsg != null){
					     %>
					     <p class="text-success text-center"><%=sucssMsg%></p>
					     <%
					     session.removeAttribute("succMsg");
					     }
					     
					     else  if(erroMsg == null){
					     %>
					     <p class="text-danger text-center"><%=erroMsg%></p>
					     <%
					     session.removeAttribute("failed");
					     }
					     %>
					     
						<form action="register" method="post">

							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input
									name="name" type="text" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email id</label> <input
									name="email" type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									name="password" type="password" class="form-control"
									id="exampleInputPassword1">
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-primary">Register</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>