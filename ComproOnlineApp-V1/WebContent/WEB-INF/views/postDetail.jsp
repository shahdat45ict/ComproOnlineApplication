<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/resources/css/style.css" var="cssURL" />  
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />  
<title>MyBlog-${post.title}</title>
</head>
<body>
<div id="wrapper">
<div id="wrapper_in">
<div id="header">
<span class="logo"><a href="/MyBlog">My Blog</a></span>
<img src="http://localhost:8080/MyBlog/resources/images/berries.jpg" width="1000" height="198" />
</div>
<div id="wrapper_middle">
<div id="wrapper_left">
  <div class="post">
	<h1 class="title">${post.title}</h1>
	<p class="content">${post.content}</p>	
  </div>
  
<h3 class="reply-title">Leave a Reply</h3>	
	<form action="../admin/comments" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Website:</td>
				<td><input type="text" name="website" /></td>
			</tr>
			<tr>
				<td>Comment:</td>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr style="display: none">
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
				<input type="text" name="date" value="<%= today %>" />
				
				</td>
			</tr>
			<tr style="display: none">
				<td>Approval:</td>
				<td><input type="text" name="approval" value="1" /></td>
			</tr>			
			<tr style="display: none">
				<td>Parent:</td>
				<td><input type="text" name="parent" value="${post.id}" /></td>
			</tr>
		</table>
		<input type="submit" value="Post Comment" class="button" />
	</form>
	
</div>
<div id="wrapper_right">
<h3 class="widget-title">Meta</h3>
<ul>
	<li><a href="/MyBlog">Register</a></li>
	<li><a href="/MyBlog/admin/posts">Log in</a></li>
</ul>
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