<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="stag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMS - Employee List</title>
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
   <table style="margin-top: 0px;margin-left: 100px; ">
       <tr>
           <th>ID</th>
           <th>${master}</th>
           <th></th>
           <th></th>
       </tr>
       <c:forEach items="${masterList}" var="m">
       <tr>
           <td>${m.mId}</td>
           <td>${m.mName}</td>
           <td>
              <a href="${master}/edit/${m.mId}">Edit</a>
           </td>
           <td>
              <form action="${master}/delete/${m.mId}" method="post">
                <input type="submit" value="Delete" style="background:none;border:0px;cursor: pointer;"/>
              </form>
           </td>
       </tr>
       </c:forEach>
 </table>
</body>
</html>
</html>