<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile page</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body style="background-color: #f7f7f7;">

	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>

	<%@include file="all_component/navbar.jsp"%>

	<div class="continer-fluid ">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x"></i>
							<h4>Edit Profile</h4>
						</div>

						<form action="update_profile" method="post">
						
<%-- 							<input type="hidden" name="id" value="${userobj.id }">    --%>
							
							<div class="form-group">
								<label>Enter ID</label><input type="hidden"
									required="required" class="form-control" id="exampleInputEmail1"  
									aria-describedby="emailHelp" name="id" value="${userobj.id }">
							</div>
							
							<div class="form-group">
								<label>Enter Full Name</label> <input type="text"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="name" value="${userobj.name }">
							</div>
							<div class="form-group">
								<label>Enter Qualification</label><input type="text"
									required="required" class="form-control" id="exampleInputEmail1"  
									aria-describedby="emailHelp" name="qua" value="${userobj.qualification }]">
							</div>
							<div class="form-group">
								<label>Enter Email</label> <input type="email"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="email" value="${userobj.email }">

							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Enter Password</label><input
									 required="required" type="password" class="form-control"
									 id="exampleInputPassword1" name="ps" value="${userobj.password }">
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Update</button>
					
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="margin-top: 50px;">
	<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>