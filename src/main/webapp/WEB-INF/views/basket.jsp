<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="с"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<br>
<div class="container">
	<br>
	<div class="row">
		<c:url var="firstUrl"
			value="/cart/1?countItems=${countItems}" />
		<c:url var="lastUrl"
			value="/cart/${content.totalPages}?countItems=${countItems}" />
		<c:url var="prevUrl"
			value="/cart/${currentIndex - 1}?countItems=${countItems}" />
		<c:url var="nextUrl"
			value="/cart/${currentIndex + 1}?countItems=${countItems}&" />
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th> № </th>
						<th> Picture </th>
						<th> Name  	</th>
						<th> Price </th>
					</tr>
				</thead>
				<tbody>
					<с:forEach items="${content.content}" var="lot">
						<tr>
							<td><br> <br>&#10022;</td>
							<td>
								<div class="imageSmall">
									<div class="trickSmall"></div>
									 <img src="resources/images/img.png"
										class="img">
								</div>
							</td>
							<td><h5>
									<br> <br>${lot.lotName}</h5></td>
							<td><h5>
									<br> <br>${lot.price}</h5></td>
							
							<td onmouseover="this.style.backgroundColor='#E9E9E9';"><a
								class="text-center"
								href="<spring:url value="/basket?lotId=${lot.lotId}"/>">
									<h3>
										<span class="glyphicon glyphicon-remove"></span>
									</h3>
							</a></td>
						</tr>
					</с:forEach>
				</tbody>
			</table>
		</div>
		
		<p class="text-center"><i>The total price is </i>  <code>${totalPrice}</code></p>
		    
				
			<ul class="pagination pull-right">
				<c:choose>
					<c:when test="${currentIndex == 1}">
						<li class="disabled"><a href="#">&lt;&lt;</a></li>
						<li class="disabled"><a href="#">&lt;</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${firstUrl}">&lt;&lt;</a></li>
						<li><a href="${prevUrl}">&lt;</a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
					<c:url var="pageUrl"
						value="/basket/${i}?countItems=${countItems}" />

					<c:choose>
						<c:when test="${i == currentIndex}">
							<li class="active"><a href="${pageUrl}"><c:out
										value="${i}" /></a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${currentIndex == content.totalPages}">
						<li class="disabled"><a href="#">&gt;</a></li>
						<li class="disabled"><a href="#">&gt;&gt;</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${nextUrl}">&gt;</a></li>
						<li><a href="${lastUrl}">&gt;&gt;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>
</div>