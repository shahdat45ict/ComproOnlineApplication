<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/resources/css/style.css" var="cssURL" />  
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />  
<title>Add New Post</title>
</head>
<body>
<div id="wrapper">
<div id="wrapper_in">
<div id="header">
<span class="logo"><a href="/ComproOnlineApplication">My Blog</a></span>
<img src="http://localhost:8080/MyBlog/resources/images/berries.jpg" width="1000" height="198" />
</div>
<div id="wrapper_middle">
<div id="wrapper_left">
  <div class="post">
    <a href="posts" class="admin-command-link"> Go To Dash Board</a>
    <h1 class="admin-title">New Post</h1>
	
	<form action="posts" method="post">
		<table>
			<tr>
				<td>Title:</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td>Content:</td>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td><select name="status">
						<option value="publish">Publish</option>
						<option value="draft">Draft</option>
				</select></td>
			</tr>
			<tr style="display: none">
				<td>Date:</td>
				<td>
				<% java.util.Date today = new java.util.Date(); %>
				<input type="text" name="modified" value="<%= today %>" />
				
				</td>
			</tr>
			<tr style="display: none">
				<td>Author:</td>
				<td><input type="text" name="author" value="0" /></td>
			</tr>
		</table>
		<input type="submit" value="save" class="button" />
	</form>
	
</div>
</div>
<div id="wrapper_right">
</div>
</div>	
<div id="footer">
  <div id="colophon">
	  <div id="site-info">
	    <a rel="home" title="Lincoln's Blog" href="/MyBlog"> Lincoln's Blog For Enterprise Architecture Project</a>
	  </div>
  </div>
</div>	
</div>	
</div>
</body>
</html>
