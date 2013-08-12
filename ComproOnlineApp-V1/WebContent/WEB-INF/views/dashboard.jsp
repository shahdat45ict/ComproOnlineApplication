<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:url value="/resources/css/style.css" var="cssURL" />
<link rel="stylesheet" type="text/css" media="screen" href="${cssURL}" />
<title>Compro Online Application - Dashboard</title>
</head>
<body>
	<div id="wrapper">
		<div id="wrapper_in">
			<div id="header">
				<span class="logo"><a href="/ComproOnlineApplication">Compro
						Online Application</a></span> <img
					src="/ComproOnlineApplication/resources/images/header.png"
					width="1000" height="160" />
			</div>
			<div id="wrapper_middle">
				<div id="wrapper_left">

					<h1 class="admin-title">Search For Applicant</h1>
					<form method="post" action="search-applicant" id="formSearch"
						class="cmxform">
						Email : <input type="text" name="email" /> <input type="submit"
							value="Search" class="button"
							style="width: auto; margin-left: 10px; padding: 2px 4px" />
					</form>
					<br style="clear: both" />

					<h1 class="admin-title">Submitted Applications</h1>

					<c:choose>
						<c:when test="${empty submittedApplications}">
                                  There is no submitted application to show
                        </c:when>
						<c:otherwise>
							<table border="1">
								<thead>
									<tr align="center">
										<th>Name</th>
										<th>Email</th>
										<th>Status</th>
										<th>Details</th>
									</tr>
								</thead>
								<c:forEach var="application" items="${submittedApplications}">
									<tr>
										<td style="padding: 10px">${application.personalInfo.firstName}
											${application.personalInfo.middleName}
											${application.personalInfo.surName}</td>
										<td style="padding: 10px"><div class="title">${application.personalInfo.email}</div></td>
										<td style="padding: 10px"><div class="title">${application.disposition}</div></td>
										<td style="padding: 10px"><div class="title">
												<a href="application-detail/${application.id}">View
													Detail</a>
											</div></td>
									</tr>
								</c:forEach>

							</table>
						</c:otherwise>
					</c:choose>

					<br style="clear: both" /> <br style="clear: both" /> <br
						style="clear: both" />
					<h1 class="admin-title">Un Submitted Applications</h1>
					<c:choose>
						<c:when test="${empty unSubmittedApplications}">
                            There is no Un Submitted application to show
                        </c:when>
						<c:otherwise>
							<table border="1">
								<thead>
									<tr align="center">
										<th>Name</th>
										<th>Email</th>
										<th>Status</th>
										<th>Details</th>
									</tr>
								</thead>
								<c:forEach var="application" items="${unSubmittedApplications}">
									<tr>
										<td style="padding: 10px"><c:choose>
												<c:when test="${empty application.personalInfo.firstName}">
                                                         ${application.user.firstName} ${application.user.lastName}
                                                    </c:when>
												<c:otherwise>
													    ${application.personalInfo.firstName}
														${application.personalInfo.middleName}
														${application.personalInfo.surName}
                                                    </c:otherwise>
											</c:choose></td>
										<td style="padding: 10px"><div class="title">
												<c:choose>
													<c:when test="${empty application.personalInfo.email}">
                                                         ${application.user.email}
                                                    </c:when>
													<c:otherwise>
                                                         ${application.personalInfo.email}
                                                    </c:otherwise>
												</c:choose>
											</div></td>
										<td style="padding: 10px"><div class="title">${application.disposition}</div></td>
										<td style="padding: 10px"><div class="title">
												<a href="application-detail/${application.id}">View
													Detail</a>
											</div></td>
									</tr>
								</c:forEach>

							</table>
						</c:otherwise>
					</c:choose>


				</div>

				<div id="wrapper_right">
					<h3 class="widget-title">Meta</h3>
					<ul>
						<li><a href="logout">Log Out</a></li>
					</ul>
				</div>

			</div>
			<div id="footer">
				<div id="colophon">
					<div id="site-info">
						<a rel="home" title="Compro Online Application"
							href="/ComproOnlineApplication">Compro Online Application</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>