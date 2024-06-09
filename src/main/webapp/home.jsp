<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@page import="com.entity.Jobs"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.ConnectionFactory"%>
<%@page import="com.dao.JobDaoImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User: Home</title>
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

				<c:if test="${not empty succMsg }">
					<div class="alert alert-success" role="alert">${succMsg }</div>
					<c:remove var="succMsg" />
				</c:if>

				<div class="card">
					<div class="card-body">
						<form class="form-inline" action="more_view.jsp" method="get">
							<div class="form-group col-md-5 mt-1">
								<h5>Location</h5>
							</div>

							<div class="form-group col-md-5 mt-1">
								<h5>Category</h5>
							</div>

							<div class="form-group col-md-5">
								<select name="location" class="custom-select"
									id="inlineFormCustomSelectPref">
									<option selected value="lo">Choose....</option>
									<option value="MadhyaPradesh">MadhyaPradesh</option>
									<option value="Odisha">Odisha</option>
									<option value="Jharkhand">Jharkhand</option>
									<option value="Gujarat">Gujarat</option>
									<option value="Bhubaneswar">Bhubaneswar</option>
									<option value="Delhi">Delhi</option>
									<option value="Banglore">Banglore</option>
									<option value="Chennai">Chennai</option>
									<option value="Hydrabad">Hydrabad</option>
									<option value="Maharashtra">Maharashtra</option>
								</select>

							</div>
							<div class="form-group col-md-5">
								<select class="custom-select" id="inlineFormCustomSelectPref"
									name="category">
									<option selected value="ca">Choose....</option>
									<option value="IT">IT</option>
									<option value="Devloper">Devloper</option>
									<option value="Banking">Banking</option>
									<option value="Enginner">Enginner</option>
									<option value="Teacher">Teacher</option>
								</select>
							</div>
							<button class="btn btn-success">Submit</button>
						</form>
					</div>
				</div>
				<%
				JobDaoImp dao = new JobDaoImp(ConnectionFactory.getCon());
				List<Jobs> list = dao.getAllJobsForUser();

				for (Jobs j : list) {
				%>
				<div class="card mt-2">
					<div class="card-body">
						<div class="text-center text-primary">
							<i class="far fa-clipboard fa-2x"></i>
						</div>

						<h6><%=j.getTitle()%></h6>
						<%
						if (j.getDescription().length() > 0 && j.getDescription().length() < 120) {
						%>
						<p><%=j.getDescription()%></p>
						<%
						} else {
						%>
						<p><%=j.getDescription().substring(0, 120)%>....
						</p>
						<%
						}
						%>
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
							Publish Date:<%=j.getPdate().toString()%></h5>
						<div class="text-center">
							<a href="one_view.jsp?id=<%=j.getId()%>"
								class="btn btn-sm bg-success text-white">View More</a>
						</div>
					</div>
				</div>
				<%
				}
				%>

			</div>
		</div>
	</div>
	
</body>
</html>