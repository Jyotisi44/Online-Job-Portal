<%@page import="com.entity.Jobs"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h5 class="text-center text-primary">All Jobs</h5>

				<%
				String location = request.getParameter("location");
				String category = request.getParameter("category");
				String msg = " ";

				JobDaoImp dao = new JobDaoImp(ConnectionFactory.getCon());
				List<Jobs> list = null;
				if ("lo".equals(location) && "ca".equals(category)) {
					list = new ArrayList<Jobs>();
					msg = "Search mt kr salle";
				} else if ("lo".equals(location) || "ca".equals(category)) {
					list = dao.getJobsORLocationAndCate(category, location);
				} else {
					list = dao.getJobsAndLocationAndCate(category, location);
				}

				if(list.isEmpty()){
				%>	
				<h4 class="text-center text-danger">Bole n job nhi h</h4>
				<% 
				}
				if (list != null) {

					for (Jobs j : list) {
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
						<br>
						<h5>
							Publish Date:<%=j.getPdate().toString()%></h5>
						<div class="text-center">
							<a href="one_view.jsp?id=<%=j.getId()%>"
								class="btn btn-sm bg-success text-white">View More</a>
						</div>
					</div>
				</div>
				<%
				}
				} else {
				%>
				<h4 class="text-center text-danger"><%=msg%></h4>
				<%
				}
				%>
			</div>
		</div>
	</div>

</body>
</html>