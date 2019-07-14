<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Tyope" content="text/html; charset=ISO-8859-1">
<title>AddressApp</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<nav id="navbar-example2" class="navbar navbar-light bg-light">
  <a class="navbar-brand" href="#">AddressApp</a>
  <ul class="nav nav-pills">
    <li class="nav-item">
        <a class="navbar-brand" data-toggle="collapse" href="#collapseUser" aria-expanded="false" aria-controls="collapseExample">
    		User
  		</a>
    </li>
    <li class="nav-item">
      <a class="navbar-brand" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
	    Administrator
	  </a>
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
            <form action="${pageContext.request.contextPath}/addressapp" method="post" class="form-signin">
              
              <div class="form-label-group">
              	<label for="inputEmail">Street One</label>
                <input type="text" class="form-control" placeholder="Street address" name="streetOne" required autofocus>
              </div>
              
              <div class="form-label-group">
              	<label for="inputEmail">Street Two</label>
                <input type="text" class="form-control" placeholder="Apartment/Suite/Unit/etc" name="streetTwo" autofocus>
              </div>
              
              <div class="form-label-group">
              	<label for="inputEmail">City</label>
                <input type="text" class="form-control" placeholder="City/Town" name="city" required autofocus>
              </div>
              
              <div class="form-label-group">
              	<label for="inputEmail">State</label>
                <input type="text" class="form-control" placeholder="State/Province/Region" name="state" required autofocus>
              </div>
              
              <div class="form-label-group">
              	<label for="inputEmail">Zip</label>
                <input type="text" class="form-control" placeholder="Zip Code" max="99999" pattern="^\s*?\d{5}(?:[-\s]\d{4})?\s*?$" name="zip" required autofocus>
              </div>

              <div class="form-label-group">
              	<label for="inputPassword">Country</label>
                Country: <input type = "text" class="form-control" placeholder="Country" list = "countrys" name="country" required autofocus> 
	      		<datalist id = "countrys">
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
			  <input class="btn btn-primary btn-sm" type="submit" value="submit">
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  	
  </div>
</div>
<div class="collapse" id="collapseExample">
	<div class="card card-body">
  	  <div class="container">
  	  <h4>Administrator</h4>
    	<p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson
    	 ad squid. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt 
    	 sapiente ea proident.</p>
	  </div>
	 </div>
</div>

</body>
</html>