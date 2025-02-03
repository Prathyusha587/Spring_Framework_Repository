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
	<br />
	<br />

	<hr />
	<br />
	

	<div class="userhome">Welcome <span style="color:darkblue"> ${user.username}</span> 
	<a href="" style="color:maroon;float:right">Signout</a>
	
	<br/><br/><br/><br/>
	
	<span class="heading">List of past entries</span>
	<a href="./addentry"><button  type="button" class="addbtn">Add Entry</button></a>
	</div>

<br/> <br/>
<table border="1">
<tr>
<th>Date</th>
<th colspan="3">Actions</th>
</tr>

<c:if test="${entrieslist.size()==0}">
<tr><td style="font-size:20px; color:darkgreen;font-weight:bold;text-align:center" colspan="4">User has not added any Diary entries.</td></tr>
</c:if>


<c:forEach items="${entrieslist}" var="e">
<tr>

<td> ${e.entrydate} </td>
<td> <a href="./viewentry?id=${e.id}">View</a> </td>
<td> <a href="./updateentry?id=${e.id}">Update</a> </td>
<td> <a href="./deleteentry?id=${e.id}">Delete</a> </td>
</tr>

</c:forEach>

</table>
</body>
</html>