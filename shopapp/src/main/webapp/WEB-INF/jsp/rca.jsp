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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	if("${action}"=="update"){
		$("#issueInAPI").val("${RCAdata.issueAPI}");
		$("#issueTitle").val("${RCAdata.title}");
		$("#description").val("${RCAdata.description}");
		$("#im_jiraId").val("${RCAdata.jira_imId}");
		$("#actionTaken").val("${RCAdata.actionTaken}");
		$("#resolverGroup").val("${RCAdata.resolverGroup}");
		$("#application").val("${RCAdata.applicationMaster.mId}");
		$("#application").val("${RCAdata.applicationMaster.mId}");
		$("#environment").val("${RCAdata.environmentMaster.mId}");
		$("#status").val("${RCAdata.statusMaster.mId}");
		$("#reportedDate").val("${RCAdata.reportedDate}");
		$("#resolvedDate").val("${RCAdata.resolvedDate}");
		}
	});
</script>
</head>
<body style="background-color: #FFFFE0;">

<div style="margin-top:50px; margin-left:200px; height:50px;"><h2>${master} List</h2></div>
<form action="/application-management/rca" method="post" enctype="multipart/form-data">
<input type="hidden" id="action" name="action" value="${action}">
<input type="hidden" id="rcaid" name="rcaid" value="${rcaid}">
<table id="myTable" style="margin-top: 0px;margin-left: 100px;"> 
<tr>
    <td><label>Application</label></<td>
    <td>
		<select id="application" name="application">
			<option value="0">--SELECT--</option>
			<c:forEach items="${applicationList}" var="application">
			<option value="${application.mId}">${application.mName}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr>
    <td><label>Environment</label></<td>
    <td>
		<select id="environment" name="environment">
			<option value="0">--SELECT--</option>
			<c:forEach items="${EnvironmentList}" var="environment">
			<option value="${environment.mId}">${environment.mName}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr>
    <td><label>Issue in API</label> </<td>
    <td><input type = "text" name = "issueInAPI" id="issueInAPI" /></td>
</tr>
<tr>
    <td><label>Title</label> </<td>
    <td><input type = "text" name = "issueTitle" id="issueTitle" /></td>
</tr>
<tr>
    <td><label>Description</label> </<td>
    <td><input type = "text" name = "description" id="description" /></td>
</tr>
<tr>
    <td><label>IM/Jira ID</label> </<td>
    <td><input type = "text" name = "im_jiraId" id="im_jiraId" /></td>
</tr>
<tr>
    <td><label>Action Taken</label> </<td>
    <td><input type = "text" name = "actionTaken" id="actionTaken" /></td>
</tr>
<tr>
    <td><label>Status</label> </<td>
    <td>
		<select id="status" name="status">
			<option value="0">--SELECT--</option>
			<c:forEach items="${StatusList}" var="status">
			<option value="${status.mId}">${status.mName}</option>
			</c:forEach>
		</select>
	</td>
</tr>
<tr>
    <td><label>Resolver Group</label> </<td>
    <td><input type = "text" name = "resolverGroup" id="resolverGroup" /></td>
</tr>
<tr>
    <td><label>Reported Date</label> </<td>
    <td><input type="date" name = "reportedDate" id="reportedDate" /></td>
</tr>
<tr>
    <td><label>Resolved Date</label> </<td>
    <td><input type="date" name = "resolvedDate" id="resolvedDate" /></td>
</tr>
<tr>
<td><label>Attachments</label>
</td>
<td>
  <input type="file" class="form-control" id="files" 
                placeholder="Upload Multiple Files"  name="files" multiple></input>
                <c:forEach items="${AttachementList}" var="attach">
       
           
              <a href="/application-management/rca/attachment/${attach.mId}">${attach.fileName}</a>&nbsp;<b>|</b>
         
       </c:forEach>
</td>
</tr>
<tr>
    <td></<td>
    <td><input type="submit" value="Submit"></td>
    
</tr>
</table>

 
</form>
</body>
</html>
</html>