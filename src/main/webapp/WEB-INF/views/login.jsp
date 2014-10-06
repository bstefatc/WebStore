<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ include file="../layouts/taglib.jsp"%>
<br>
<br>


<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h3 class="text-center login-title">Sign in please</h3>
            <div class="account-wall">
            
               <c:if test="${param.error != null}">        
        <div class="alert alert-danger"> Error login </div>
     
    </c:if>
                    
                <form action="" class="form-signin" role="form" method="post">  
                <br>
                <input type="text" id="username" name="username" class="form-control" placeholder="login"required autofocus/>	
      			 <br>
    		    <input type="password" id="password" name="password" class="form-control" placeholder="password" required/>	
				<br>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign in</button>
                     <br>
                </form>
            </div>
            <a href="/register" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>
