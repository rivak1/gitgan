<%@include file="include/navbarTop.jsp" %>
	<div class="container space">
		<div class="row">
			<div class="col-md-3">
			</div>
			<div class="col-md-6 formPart">
				<div class="space">
					<h5 class="text-center text-muted">Vechile Registration From</h5>
				</div>
				<div class="container">
				  <form action="/action_page.php">
				    <div class="form-group">
				      <label for="name">Name:</label>
				      <input type="email" class="form-control" id="name" placeholder="Enter email" name="name">
				    </div>
				    <div class="form-group">
				      <label for="pwd">Password:</label>
				      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="Password">
				    </div>
				   	<div class="form-group">
				      <label for="email">Confirm Password:</label>
				      <input type="password" class="form-control" id="email" placeholder="Enter password" name="Email">
				    </div>
				    <div class="form-group">
				      <label for="email">Email:</label>
				      <input type="password" class="form-control" id="email" placeholder="Enter password" name="Email">
				    </div> 
				    <div class="form-group">
				      <label for="contactNumber">Mobile Number:</label>
				      <input type="password" class="form-control" id="contactNumber" placeholder="Enter password" name="contactNumber">
				    </div>
				    <div class="form-group">
				      <label for="gender">Gender:&nbsp &nbsp</label>
				      <input type="radio"  id="gender" placeholder="Enter password" name="gender" value="Male">Male &nbsp &nbsp
				      <input type="radio"  id="gender" placeholder="Enter password" name="gender" value="Female">Female &nbsp &nbsp
				      <input type="radio"  id="gender" placeholder="Enter password" name="gender" value="Other">Other
				    </div>
				    
				    <div class="form-group">
				    	<select id="organisation" name="organisation" class="form-control">
				    		<option value="METACUBE">MetaCube</option>
				    		<option value="TCS">TCS</option>
				    		<option value="INFOSYS">INFOSYS</option>
				    		<option value="SHARVIS">SHARVIS</option>
				   		</select>
				    </div>
				    <button type="submit" class="btn btn-primary">Register</button>
				  </form>
			   </div>
			</div>
			<div class="col-md-3">
			</div>
		</div>
	</div>
	
<%@include file="include/navbarBottom.jsp" %>
