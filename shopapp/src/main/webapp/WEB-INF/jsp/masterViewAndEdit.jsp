<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMS - Employee Registration</title>
<style>
td, th {
  font-family: arial, sans-serif;
}
</style>
<script type="text/javascript">
$(document).ready(function () {
	if("${action}"=="Make update"){
		$("#mName").val("${masterItem.mName}");
		}
	});
</script>
</head>
<body style="background-color: #FFFFE0;">
<div id="header">
    <jsp:include page="nav_bar.jsp"/>
</div>
<div style="margin-top:50px; margin-left:250px; height:50px;"><h2>${master} <c:out value="${masterItem.mId != null ? 'Update' : 'Entry' }" /></h2></div>
  <form action ="/application-management/${master}" method="post" id="mmaster"  name="mmaster"  onsubmit="return OnSubmitForm();" >
 
     <table style="vertical-align: center; margin-left:20%;">
 
        <tr>
          <input type="hidden" name="mId" value="${masterItem.mId}">
            <input type="hidden" id="action" name="action" value="${master_action}">
        </tr>
        <tr>
            <td>${master} Name :</td>
            <td><input  id="mName" name="mName" value="${masterItem.mName}"/></td>
        </tr>
        <tr>
             <td colspan="2"><input type="submit"  value="<c:out value="${masterItem.mId != null ? 'Make Update' : 'Add Entry' }" />"
             id="btn" onclick="document.pressed=this.value" >&nbsp;&nbsp; <a href="/application-management/${master}">${master} List</a>&nbsp;
            <c:if test="${masterItem.mId ne null}"><b>|</b></c:if>
         </td>
    </tr>
</table>
</form>


</body>
</html>