<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="stag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RCA</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 60%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
</style>
</head>
<body style="background-color: #FFFFE0;">

<div style="margin-top:50px; margin-left:200px; height:50px;"><h2>${master} List</h2></div>
<form action="" method="post">
<div>
  <select id="application" name="application">
  <option value="0">--SELECT--</option>
  <c:forEach items="${applicationList}" var="application">
    <option value="${application.mId}">${application.mName}</option>
   </c:forEach>
  </select>
</div>
<div>
  <select id="environment" name="environment">
  <option value="0">--SELECT--</option>
  <c:forEach items="${EnvironmentList}" var="environment">
    <option value="${environment.mId}">${environment.mName}</option>
   </c:forEach>
  </select>
</div>
<div>
  <select id="status" name="status">
  <option value="0">--SELECT--</option>
  <c:forEach items="${StatusList}" var="status">
    <option value="${status.mId}">${status.mName}</option>
   </c:forEach>
  </select>
</div>
<div>
	<input type = "text" name = "description" id="description" />
</div>
  <input type="submit" value="Submit">
</form>
</body>
</html>
</html>