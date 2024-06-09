<%@page import="com.entity.Jobs"%>
<%@page import="com.DB.ConnectionFactory"%>
<%@page import="com.dao.JobDaoImp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_component/all_css.jsp"%>

</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<%@include file="all_component/navbar.jsp"%>

	                  <%
						String id =request.getParameter("id");
						JobDaoImp dao = new JobDaoImp(ConnectionFactory.getCon());
						Jobs j = dao.getJobById(id);
						%>

	<div class="card mt-2">
		<div class="card-body">
			<div class="text-center text-primary">
				<i class="far fa-clipboard fa-2x"></i>
			</div>

			<h6><%=j.getTitle()%></h6>
			<p><%=j.getDescription()%></p>
			<br>
			<div class="form-row">
				<div class="form-group col-md-3">
					<input type="text" class="form-control form-control-sm"
						value="Location:<%=j.getLocation()%>" readonly>
				</div>

				<div class="form-group col-md-3">
					<input type="text" class="form-control form-control-sm"
						value="Category:<%=j.getCategory()%>" readonly>
				</div>

			</div>
			<br> <br>
			<h5>
				Publish Date:<%=j.getPdate().toString() %>
				</h5>
		</div>
	</div>
	

</body>
</html>