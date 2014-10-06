<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link rel="stylesheet" href="/resources/css/tinycarousel.css" />

<div class="row">

	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 main-block">
		<div class="row">
			<c:forEach items="${lots}" var="lot">
				<div class="col-md-4 col-xs-12 col-sm-12 col-lg-4"
					style="heigth: 310px; width: 300px; margin: 10px; border: 1.7px solid white; border-radius: 25px; background-color: white">
					<div class="image " style="margin-top: 15px;">
						<div class="trick"></div>
					<img src="resources/images/img.png" class="img-circle">
						
		<security:authorize access="isAuthenticated()">
			<div class="pagination pull-right">
					<spring:url value="/lots/${lot.lotId}/addToBasket" var="addHref" />
					<a href="${addHref}" type="btn btn-default btn-sm"
						data-loading-text="${adding}"
						class="btn btn-primary watchButton ${addBtnClass}">
						AddtoBasket </a>
			</div>
		</security:authorize>
					</div>
					<br>
					<div class="pagination pull-left">
					 ${lot.lotName}  <br> Price:  ${lot.price} ₴</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
</div>