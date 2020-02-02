<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sample</title>
<link rel="stylesheet" href="css/custom.css">
<script type="text/javascript">

	function onInsert() {
		document.getElementById("insert").style.display ="block"; 
		document.getElementById("update").style.display ="none"; 
		document.getElementById("delete").style.display ="none"; 
		alert("Insert data into database");
	}
	
	function onUpdate() {
		document.getElementById("insert").style.display ="none"; 
		document.getElementById("update").style.display ="block"; 
		document.getElementById("delete").style.display ="none"; 
		alert("Update data of database");
	}
	
	function onDelete() {
		document.getElementById("insert").style.display ="none"; 
		document.getElementById("update").style.display ="none"; 
		document.getElementById("delete").style.display ="block"; 
		alert("Delete data from database");
	}
</script>

<%@page import ="com.example.akash.demo.Users,java.util.List,com.example.akash.demo.HibernateUtil" %>
</head>
<body>

	<div id="first">Users' Database</div>
	
	<% 
		List<Users> users = new HibernateUtil().findAll();
		out.println("<table>");
			out.println("<tr>");
				out.println("<th>Id</th>");
				out.println("<th>Name</th>");
				out.println("<th>Age</th>");
				out.println("<th>City</th>");
			out.println("</tr>");
			for(Users u : users) {
				out.println("<tr>");
					out.println("<td>"+u.getId()+"</td>");
					out.println("<td>"+u.getName()+"</td>");
					out.println("<td>"+u.getAge()+"</td>");
					out.println("<td>"+u.getCity()+"</td>");
				out.println("</tr>");
			}
		out.println("</table>"); 
	%>
	 
	
	<button onclick="onInsert();">Insert</button>
	<button onclick="onUpdate();">Update</button>
	<button onclick="onDelete();">Delete</button>
	
	<div id="insert">
		<strong>Enter Details for inserting an entry</strong>
		<form action="doInsert" method="get">
			<div id="inner">
				<label for="name">Enter Name : </label>
				<input type="text" name="uname1" value="" required="required">
			</div>
			<div id="inner">
				<label for="age">Enter Age : </label>
				<input type="text" name="uage1" value="" required="required" pattern="[0-9]{1,3}">
			</div>
			<div id="inner">
				<label for="city">Enter City : </label>
				<input type="text" name="ucity1" value="" required="required">
			</div>
			<input id="btn" type="submit" value="submit" />
		</form>
	</div>
	
	<div id="update">
		<strong>Enter Details for updating an existing entry</strong>
		<form action="doUpdate" method="get">
			<div id="inner">
				<label for="name">Enter Id : </label>
				<input type="text" name="uid2" value="" required="required" pattern="[0-9]{1,3}">
			</div>
			<div id="inner">
				<label for="name">Enter Name : </label>
				<input type="text" name="uname2" value="" required="required">
			</div>
			<div id="inner">
				<label for="age">Enter Age : </label>
				<input type="text" name="uage2" value="" required="required" pattern="[0-9]{1,3}">
			</div>
			<div id="inner">
				<label for="city">Enter City : </label>
				<input type="text" name="ucity2" value="" required="required">
			</div>
			<input id="btn" type="submit" value="submit" />
		</form>
	</div>
	
	<div id="delete">
		<strong>Enter Details for deleting an entry</strong>
		<form action="doDelete" method="get">
			<div id="inner">
				<label for="id">Enter Id : </label>
				<input type="text" name="uid3" value="" required="required" pattern="[0-9]{1,3}">
			</div>
			<input id="btn" type="submit" value="submit" />
		</form>
	</div>
</body>
</html>