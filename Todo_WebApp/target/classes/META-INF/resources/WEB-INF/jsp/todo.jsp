<%@include file="common/header.jspf"%>
<%@include file="common/navbar.jspf"%>
<div class="container">
	<h1>New To-do Generator</h1>
	<hr>
	<a class="btn btn-warning m-3" href="list-todos">Back</a>
	<h3>Enter To-do details below:</h3>
	<form:form class="row g-3" method="post" modelAttribute="todo">
		<fieldset class="mb-3 col-7">
			<form:label path="description" class="form-label ">Description</form:label>
			<form:input type="text" path="description" class="form-control"
				required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>
		<fieldset class="mb-3 col-5">
			<form:label path="targetDate" class="form-label">Target Date</form:label>
			<form:input type="text" path="targetDate" class="form-control"
				required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		<fieldset>
			<form:input type="hidden" path="id"></form:input>
			<form:input type="hidden" path="done"></form:input>
		</fieldset>
		<figure class="text-center">
			<div class="">
				<button type="submit" class="btn btn-success ">Submit</button>
			</div>
		</figure>
	</form:form>
</div>

<script type="text/javascript">
	$('#targetDate').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>
<%@include file="common/footer.jspf"%>