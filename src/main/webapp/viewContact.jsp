<%@page import="com.dao.ContactDao"%>
<%@page import="com.conn.DbConnect"%>
<%@page import="java.util.*"%>
<%@page import="com.entity.Contact"%>
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
	<h1 class="text-center text-danger">View Contact</h1>
	<%
	String sucssMsg = (String) session.getAttribute("succMsg");
	String erroMsg = (String) session.getAttribute("failed");

	if (sucssMsg != null) {
	%>
	<p class="text-primary text-center"><%=sucssMsg%></p>
	<%
	session.removeAttribute("succMsg");
	}

	if (erroMsg != null) {
	%>
	<p class="text-danger text-center"><%=erroMsg%></p>
	<%
	session.removeAttribute("failed");
	}
	%>

	<div class="row p-4">
		<%
		ContactDao dao = new ContactDao(DbConnect.getConnection());
		List<Contact> li = dao.getContact();

		for (Contact c : li) {
		%>
		<div class="col-md-4">
			<div class="card">
				<div class="card-body">
					<h5>
						Name:
						<%=c.getName()%></h5>
					<p>
						Email:
						<%=c.getEmail()%></p>
					<p>
						phone:
						<%=c.getPhon()%></p>
					<p>
						about:
						<%=c.getAbout()%></p>
					<div class="text-center">
						<a href="edit.jsp?id=<%=c.getId()%>"
							class="btn btn-primary btn-sm text-white">Edit</a> <a
							href="delete?id=<%=c.getId()%>"
							class="btn btn-danger btn-sm text-white">Delete</a>
					</div>
				</div>
			</div>
		</div>
		<%
		}
		%>


	</div>

</body>
</html>