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
<title>Edit Jobs</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<c:if test="${userobj.role ne 'admin' }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>


	<%@include file="all_component/navbar.jsp"%>


	<div class="row p-2">
		<div class="col-md-10 offset-md-1">
			<div class="card">
				<div class="card-body">
					<div class="text-center text-success">
						<i class="fas fa-user-friends fa-3x"></i>

						<%
						String id = request.getParameter("id");
						JobDaoImp dao = new JobDaoImp(ConnectionFactory.getCon());
						Jobs j = dao.getJobById(id);
						%>

						<h4>Edit Jobs</h4>
					</div>

					<form action="update" method="post">
						<div class="form-group">
							<input type="text" name="id" required class="form-control"
								value="<%=j.getId()%>">
						</div>


						<div class="form-group">
							<label>Enter Title</label> <input type="text" name="title"
								required class="form-control" value="<%=j.getTitle()%>">
						</div>

						<div class="form-row">
							<div class="form-group col-md-4">
								<label>Location</label> <select name="location"
									class="custom-select" id="inlineFormCustomSelectPref">
									<option value="<%=j.getLocation()%>"><%=j.getLocation()%></option>
									<option value="MadhyaPradesh">MadhyaPradesh</option>
									<option value="Odisha">Odisha</option>
									<option value="Jharkhand">Jharkhand</option>
									<option value="Gujurat">Gujurat</option>
									<option value="Bhubaneswar">Bhubaneswar</option>
									<option value="Delhi">Delhi</option>
									<option value="Banglore">Banglore</option>
									<option value="Chennai">Chennai</option>
									<option value="Hydradad">Hydradad</option>
									<option value="Maharashtra">Maharashtra</option>
								</select>
							</div>

							<div class="form-group col-md-4">
								<label>Category</label> <select class="custom-select"
									id="inlineFormCustomSelectPref" name="category">
									<option value="<%=j.getCategory()%>"><%=j.getCategory()%></option>
									<option value="IT">IT</option>
									<option value="Devloper">Devloper</option>
									<option value="Banking">Banking</option>
									<option value="Enginner">Enginner</option>
									<option value="Teacher">Teacher</option>
								</select>
							</div>

							<div class="form-group col-md-4">
								<label>Status</label> <select class="custom-control"
									name="status">
									<option class="Active" value="<%=j.getStatus()%>"><%=j.getStatus()%></option>
									<option class="Active" value="Active">Active</option>
									<option class="Inactive" value="Inactive">Inactive</option>
								</select>
							</div>
						</div>

						<div class="form-group ">
							<label>Enter Description</label>
							<textarea required rows="6" cols="" name="desc"
								class="form-control"><%=j.getDescription()%></textarea>

						</div>
						<button class="btn btn-success">Update Job</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>