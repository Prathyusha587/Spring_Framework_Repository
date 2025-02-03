<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value="/resources/styles/styless.css"/>">
</head>
<body>


	<div class="header">
		<div class="first">
			<img src="<c:url value="/resources/images/book.jpg"/>" width="40"
				height="40">
		</div>

		<div class="second">MyDiary App</div>

	</div>
	<br/>
	<br/>
	
	<hr/>

	<div class="bodypart">

		<div class="bodypart1">
			<img src="<c:url value="/resources/images/book.jpg"/>">
		</div>

		<div class="bodypart2">
			<h1>REGISTRATION FORM</h1><br/><br/>
			<form action="./saveuser" method="post">
			<label>Username</label> <input type="text" name="username" class="formcontrol"><br/><br/>
			<label>Password </label><input type="password" name="password" class="formcontrol"><br/><br/><br/>
			<button type="submit">REGISTER</button>
			</form>
			<br/><br/>
			
			
           Existing User? <a href="./home ">Login</a> here
		</div>
	</div>

</body>
</html>