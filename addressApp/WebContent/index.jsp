<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="model.AddressModel"%>
<%
	ArrayList addressCollection = (ArrayList) request.getAttribute("addressCollection");
	ArrayList zipCollection = (ArrayList) request.getAttribute("zipCollection");
	String uncover = (String) request.getAttribute("uncover");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Tyope" content="text/html; charset=ISO-8859-1">
<title>AddressApp</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- JSP -->
<script>
	$(function() {
		$("#user").click(function() {
			$("#collapseUser").toggle();
			$("#collapseAdmin").hide();
		});
	});
	$(function() {
		$("#admin").click(function() {
			$("#collapseUser").hide();
			$("#collapseAdmin").toggle();
		});
	});
	$(function() {
		$("#home").click(function() {
			$("#collapseUser").hide();
			$("#collapseAdmin").hide();
		});
	});
</script>
<!-- Quick CSS -->
<style>
body, html {
	height: 100%;
	margin: 0;
}

.bg {
	/* The image used */
	background-image: url("AddressAppLogo.png");
	/* Full height */
	height: 100%;
	/* Center and scale the image nicely */
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>

</head>
<body class="bg">
	<nav id="navbar-example2" class="navbar navbar-light bg-light">
		<a id="home" class="navbar-brand" href="#home">AddressApp</a>
		<ul class="nav nav-pills">
			<li class="nav-item"><a id="user" class="navbar-brand"
				href="#collapseUser"> User </a></li>
			<li class="nav-item">
				<form action="${pageContext.request.contextPath}/addressList"
					method="post">
					<a id="admin" href="#collapseAdmin"> <input type="submit"
						class="navbar-brand"
						style="border: none; background-color: Transparent;"
						value="Administrator">
					</a>
				</form>
			</li>
		</ul>
	</nav>
	<div class="collapse" id="collapseUser">
		<div class="card card-body">
			<div class="container">
				<h4>User</h4>
				<div class="row">
					<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
						<div class="card card-signin my-5">
							<div class="card-body">
								<h5 class="card-title text-center">Enter an Address</h5>
								<form action="${pageContext.request.contextPath}/addressapp"
									method="post" class="form-signin">
									<div class="form-label-group">
										<label for="validationDefault01">Street One</label> <input
											type="text" class="form-control" placeholder="Street address"
											name="streetOne" required autofocus>
									</div>
									<div class="form-label-group">
										<label for="validationDefault01">Street Two</label> <input
											type="text" class="form-control"
											placeholder="Apartment/Suite/Unit/etc" name="streetTwo"
											autofocus>
									</div>
									<div class="form-label-group">
										<label for="validationDefault01">City</label> <input
											type="text" class="form-control" placeholder="City/Town"
											name="city" required autofocus>
									</div>
									<div class="form-label-group">
										<label for="validationDefault01">State</label> <input
											type="text" class="form-control"
											placeholder="State/Province/Region" name="state" required
											autofocus>
									</div>
									<div class="form-label-group">
										<label for="validationDefault01">Zip</label> <input
											type="text" class="form-control" placeholder="Zip Code"
											max="99999" pattern="^\s*?\d{5}(?:[-\s]\d{4})?\s*?$"
											name="zip" required autofocus>
									</div>
									<div class="form-label-group">
										<label for="validationDefault01">Country</label> Country: <input
											type="text" class="form-control" placeholder="Country"
											list="countrys" name="country" maxlength="3" required
											autofocus>
										<datalist id="countrys">
											<option value="DZA">Algeria</option>
											<option value="ASM">American Samoa</option>
											<option value="AND">Andorra</option>
											<option value="BRA">Brazil</option>
											<option value="CHN">China</option>
											<option value="IND">India</option>
											<option value="IDN">Indonesia</option>
											<option value="MNG">Mongolia</option>
											<option value="MOZ">Mozambique</option>
											<option value="PRY">Paraguay</option>
											<option value="PER">Peru</option>
											<option value="PHL">Philippines</option>
											<option value="PRT">Portugal</option>
											<option value="PRI">Puerto Rico</option>
											<option value="WSM">Samoa</option>
											<option value="ESP">Spain</option>
											<option value="THA">Thailand</option>
											<option value="GBR">United Kingdom</option>
											<option value="USA">United States</option>
											<option value="URY">Uruguay</option>
											<option value="VEN">Venezuela</option>
										</datalist>
									</div>
									<hr class="my-4">
									<input class="btn btn-primary btn-sm" type="submit"
										value="submit">
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<div class="collapse <%=uncover%>" id="collapseAdmin">
		<div class="card card-body">
			<div class="container">
				<h4>Administrator</h4>
				<div class="card card-body">
					<div class="container">
						<div class="row">
							<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
								<div class="card card-signin my-5">
									<div class="card-body">
										<h5 class="card-title text-center">Add an Address</h5>
										<form action="${pageContext.request.contextPath}/add"
											method="post" class="form-signin">
											<div class="container-fluid">
												<div class="form-label-group">
													<label for="validationDefault01">Zip</label>
													<div class="row">
														<div class="col">
															<input type="text" class="form-control"
																placeholder="Zip Code" max="99999"
																pattern="^\s*?\d{5}(?:[-\s]\d{4})?\s*?$" name="zip"
																required autofocus>
														</div>
														<div class="col-md-auto">
															<input class="btn btn-primary" type="submit"
																value="submit">
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
							<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
								<div class="card card-signin my-5">
									<div class="card-body">
										<h5 class="card-title text-center">Remove an Address</h5>
										<form action="${pageContext.request.contextPath}/remove"
											method="post" class="form-signin">
											<div class="container-fluid">
												<div class="form-label-group">
													<label for="validationDefault01">Zip</label>
													<div class="row">
														<div class="col">
															<input type="text" class="form-control"
																placeholder="Zip Code" max="99999"
																pattern="^\s*?\d{5}(?:[-\s]\d{4})?\s*?$" name="zip"
																required autofocus>
														</div>
														<div class="col-md-auto">
															<input class="btn btn-primary" type="submit"
																value="submit">
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
						<hr class="my-4">
						<div class="row">
							<div class="col-sm-12 col-md-10 col-lg-8 mx-auto">
								<div class="table-responsive shadow p-3 mb-5 bg-white rounded">
									<table class="table table-striped table-sm">
										<h5 class="card-title text-center">User Addresses</h5>
										<thead>
											<tr>
												<th>ID</th>
												<th>STREET 1</th>
												<th>STREET 2</th>
												<th>CITY</th>
												<th>STATE</th>
												<th>ZIP-CODE</th>
												<th>COUNTRY</th>
											</tr>
										</thead>
										<tbody>
											<%
												if (addressCollection != null) {
													for (int i = 0; i < addressCollection.size(); i++) {
														AddressModel addressModel = (AddressModel) addressCollection.get(i);
											%>
											<tr>
												<td><%=addressModel.getId()%></td>
												<td><%=addressModel.getStreetOne()%></td>
												<td><%=addressModel.getStreetTwo()%></td>
												<td><%=addressModel.getCity()%></td>
												<td><%=addressModel.getState()%></td>
												<td><%=addressModel.getZip()%></td>
												<td><%=addressModel.getCountry()%></td>
											</tr>
											<%
												}
												} else {

												}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="col-sm-6 col-md-4 col-lg-3 mx-auto">
							<div class="table-responsive shadow p-3 mb-5 bg-white rounded">
								<table class="table table-striped table-sm">
									<h5 class="card-title text-center">Available Zip Codes</h5>
									<thead>
										<tr>
											<th>ID</th>
											<th>ZIP-CODE</th>
										</tr>
									</thead>
									<tbody>
										<%
											if (zipCollection != null) {
												for (int i = 0; i < zipCollection.size(); i++) {
													AddressModel addressModelZip = (AddressModel) zipCollection.get(i);
										%>
										<tr>
											<td><%=addressModelZip.getId()%></td>
											<td><%=addressModelZip.getZip()%></td>
										</tr>
										<%
											}
											} else {

											}
										%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>