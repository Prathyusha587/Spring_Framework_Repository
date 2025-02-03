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
	<h1>Welcome <span style="color:darkblue"> ${user.username}</span> </h1> 
	<a href="./signout" style="color:maroon;float:right">Signout</a>
	

	<div class="bodypart">

		<div class="bodypart1">
			<img src="<c:url value="/resources/images/book.jpg"/>">
		</div>

		<div class="bodypart2">
			<h1>ADD ENTRY</h1><br/><br/>
			<form action="http://localhost:8080/MyDiaryApplication/saveentry" method="POST">
			<label>Date</label> <input type="date" name="entrydate" class="formcontrol"><br/><br/>
			<label>Description</label>
			<textarea rows="10" cols="30" name="description" >
			</textarea>
			<input type="hidden" name="userid" value="${user.id}">
			<br/><br/><br/>
			<button type="submit">SAVE ENTRY</button>
			</form>
			
		
		</div>
	</div>

</body>
</html>