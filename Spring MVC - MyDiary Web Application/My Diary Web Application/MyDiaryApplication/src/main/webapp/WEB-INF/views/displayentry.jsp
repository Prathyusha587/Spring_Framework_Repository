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
<img src="<c:url value="/resources/images/book.jpg"/>" width="40"
				height="40">
</div>

<div class="bodypart2">
<h1>VIEW ENTRY</h1><br/><br/><br/>
<TABLE>
<tr><td>Date:</td><td>${entry.entrydate}</td></tr>
<tr><td>Description:</td><td>${entry.description}</td></tr>
</TABLE>


<br/><br/><br/>
<a href="./userhome"><button type="button">BACK TO HOME </button></a>

</div>




</div>

</body>
</html>