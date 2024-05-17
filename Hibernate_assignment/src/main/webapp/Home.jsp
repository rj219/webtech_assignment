<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
<span class="text-success">${msg}</span>
<div class="row">
<div class="col-md-5">
<form action="reg" method="post">
<div class="form-group">
<label>First Name</label>
<input type="text" placeholder="Enter fname" name="fname" class="form-control">
</div>
<div class="form-group">
<label>Last name</label>
<input type="text" placeholder="Enter Lname" name="lname" class="form-control">
</div>

<div class="form-group">
<label>Email</label>
<input type="text" placeholder="Enter email" name="email" class="form-control">
</div>

<div class="form-group">
<label>Mobile</label>
<input type="text" placeholder="Enter mobile" name="mobile" class="form-control">
</div>


<div class="form-group">
<label>Gender</label>
<input type="radio" name="gender" value="male">Male
<input type="radio" name="gender" value="female">Female
</div>

<div class="form-group">
<label>Password</label>
<input type="text" placeholder="Enter Password" name="password" class="form-control"> 
</div>

<div class="form-group">
<input type="submit" class="btn btn-success">
<a href="viewdata">ViewData</a>
</div>
</form>
</div>
</div>
</div>
</body>
</html>