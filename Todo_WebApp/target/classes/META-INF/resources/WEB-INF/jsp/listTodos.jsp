<%@include file="common/header.jspf"%>
<%@include file="common/navbar.jspf"%>
<div class="container">
	<h1>Welcome ${user} to your To-do list Page!</h1>
	<hr>
	<h3>Your To-dos are:</h3>
	<a href="dashboard" class="btn btn-warning m-3">Back</a> <a
		href="add-todo" class="btn btn-info m-3">Add new To-do</a>
	<table class="table table-hover">
		<thead class="table-dark">
			<tr>
				<th>Id</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="delete-todo?id=${todo.id }"
						class="btn btn-danger">Delete</a></td>
					<td><a href="update-todo?id=${todo.id }"
						class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@include file="common/footer.jspf"%>
