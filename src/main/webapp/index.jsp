
<%@page import="com.DB.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_component/all_css.jsp"%>
<style type="text/css">
.back-img {
	background: url("img/jobportalimg.jpg");
	width: 100%;
	height: 80vh;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>

<body>
	<%@include file="all_component/navbar.jsp"%>

    <%Connection con=ConnectionFactory.getCon(); %>
    
	<div class="container-fluid back-img">
		<div class="text-center">
			<h1 class="text-black p-4">
				<i class="fa-solid fa-book"></i> Online job Portal
			</h1>
		</div>
	</div>
	
	<%@include file="all_component/footer.jsp"%>
</body>
</html>