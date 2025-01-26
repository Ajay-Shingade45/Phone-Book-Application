<%@page import="com.entity.Contact"%>
<%@page import="com.dao.ContactDao"%>
<%@page import="com.conn.DbConnect"%>
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
						<h4 class="text-center text-danger">Update page</h4>
						
					     <%
					     int id=Integer.parseInt(request.getParameter("id"));
					     ContactDao dao = new ContactDao(DbConnect.getConnection());
					     Contact c=dao.getContactById(id);
					     
					     %>
						<form action="update" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input
									name="name" type="text" value="<%=c.getName()%>" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">

							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email id</label> <input
									name="email" type="email" value="<%=c.getEmail()%>" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Phone Number</label> <input
									name="phone" type="number" value="<%=c.getPhon()%>" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter About</label> <input
									name="about" type="text" value="<%=c.getAbout()%>" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp">

							</div>
							<input type="hidden" name="id" value="<%=c.getId()%>"> 
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Update
									Contact</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>