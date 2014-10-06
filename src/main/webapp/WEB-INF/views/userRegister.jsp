<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../layouts/taglib.jsp"%>
<br>
<br>
<div class="row">
	<div class="col-md-offset-4 col-md-5">
		<div class="row text-center">
			<h2>
				Registration
			</h2>
		</div>
	</div>
	<c:if test="${param.success eq true }">
		<div class="row text-center">
			<div class="col-md-offset-4 col-md-5">
				<div class="alert alert-success">
					Success registration
				</div>
			</div>
		</div>
	</c:if>
	<form:form commandName="user"
		cssClass="form-horizontal registrationForm">
		<div class="form-group">
			<label for="login" class="col-sm-4 control-label">Login</label>
			<div class="col-sm-5">
				<form:input path="login" cssClass="form-control" />
				<form:errors path="login" />
			</div>
		</div>

		<div class="form-group">
			<label for="email" class="col-sm-4 control-label">Email</label>
			<div class="col-sm-5">
				<form:input path="email" cssClass="form-control" />
				<form:errors path="email" />
			</div>
		</div>

		<div class="form-group">
			<label for="password" class="col-sm-4 control-label">Password</label>
			<div class="col-sm-5">
				<form:password path="password" cssClass="form-control" />
				<form:errors path="password" />
			</div>
		</div>

		<div class="form-group">
			<label for="password" class="col-sm-4 control-label">re-Password</label>
			<div class="col-sm-5">
				<input type="password" name="password_again" id="password_again"
					class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label for="phoneNumber" class="col-sm-4 control-label">Phone number </label>
			<div class="col-sm-5">
				<form:input path="phoneNumber" cssClass="form-control"
					placeholder="0XX-XXX-XX-XX" />
				<form:errors path="phoneNumber" />
			</div>
		</div>

		<div class="form-group modal-footer">
			<div class="col-md-9">
				<input type="submit"
					value="Sign up"
					class="btn btn-large btn-primary">
			</div>
		</div>
	</form:form>
</div>

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".registrationForm")
								.validate(
										{
											rules : {
												login : {
													required : true,
													minlength : 3,
													remote : {
														url : "<c:url value='/register/availableLogin.html'/>",
														type : "POST",
														data : {
															login : function() {
																return $(
																		"#login")
																		.val();
															}
														}
													}
												},
												phoneNumber : {
													required : true,
													minlength : 10,
													maxlength : 10,
													remote : {
														url : "<c:url value='/register/availablePhoneNumber.html'/>",
														type : "POST",
														data : {
															login : function() {
																return $(
																		"#phoneNumber")
																		.val();
															}
														}
													}
												},

												email : {
													required : true,
													email : true,
													remote : {
														url : "<c:url value='/register/availableEmail.html'/>",
														type : "POST",
														data : {
															login : function() {
																return $(
																		"#email")
																		.val();
															}
														}
													}
												},
												password : {
													required : true,
													minlength : 4
												},

												password_again : {
													required : true,
													equalTo : "#password"
												}
											},
											messages : {
												login : {
													required : "Required Field",
													minlength : "Short Login Error",
													remote : "Not Avaliable Login"
												},
												phoneNumber : {
													required : "Required Field",
													minlength : "Phone Number Error",
													maxlength : "Phone Number Error",
													remote : "Not Avaliable Phone Number"
												},
												email : {
													required : "Required Field",
													email : "Email Error",
													remote : "Not Avaliable Email"
												},
												password : {
													minlength : "New Password Error",
													required : "Required Field"
												},
												password_again : {
													equalTo : "Password Again Error",
													required : "Required Field"
												}

											},
											highlight : function(element) {
												$(element).closest(
														'.form-group')
														.removeClass(
																'has-success')
														.addClass('has-error');
											},
											unhighlight : function(element) {
												$(element)
														.closest('.form-group')
														.removeClass(
																'has-error')
														.addClass('has-success');
											}
										});
					});
</script>