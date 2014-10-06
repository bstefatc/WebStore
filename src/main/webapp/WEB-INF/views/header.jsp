<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="userId" value="${user.userId}" />


	<div class="container">
		<div class="row">
			<div class="nav navbar-nav navbar-left col-md-5">
				<ul class="nav navbar-nav navbar-left">
				
					<li><a href="<spring:url value="/" />">Main</a></li>
																
					<security:authorize access="! isAuthenticated()">
						<li><a href="<spring:url value="/login" />">login</a></li>
					</security:authorize>
					
					<security:authorize access="isAuthenticated()">
						<li><a href="<spring:url value="/logout" />">log out</a></li>
					</security:authorize>
					
					<security:authorize access="! isAuthenticated()">
						<li><a href="<spring:url value="/register" />">sign up</a></li>
					</security:authorize>
					
					<security:authorize access="isAuthenticated() && !hasRole('ROLE_ADMIN')">
						<li><a href="<spring:url value="/basket/1" />">basket</a></li>
					</security:authorize>
				</ul>
			</div>
			<div class="nav navbar-nav navbar-left col-md-5">
				<ul class="nav navbar-nav navbar-right" style="margine: 60px">
					<security:authorize access="isAuthenticated()">
						<li><br>Hello <code>${pageContext.request.userPrincipal.name}</code></li>
					</security:authorize>
				</ul>
			</div>
		</div>
	</div>

