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
<span class="logo"><a href="/ComproOnlineApplication">Compro Online Application</a></span>
<img src="/ComproOnlineApplication/resources/images/berries.jpg" width="1000" height="198" />
</div>
<div id="wrapper_middle">
<div id="wrapper_left">
  <div class="post">
    <h1 class="admin-title dashboard">Dashboard</h1>
	<h1 class="admin-title">My Blog Posts</h1>
	<table border="1">
	
	<c:forEach var="post" items="${posts}">	
	<tr>	
	<td style="padding: 10px"><div class="title">${post.title}</div></td>
	<td style="padding: 10px"><div class="content">${post.content}</div></td>
	<td style="padding: 10px"><a href="posts/${post.id}">edit</a></td>
	</tr>
	</c:forEach>
	
	</table>	
	<a href="addnewpost" class="admin-command-link"> Add New Post</a>
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