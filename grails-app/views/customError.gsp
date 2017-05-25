<%@ page import="org.grails.exceptions.ExceptionUtils" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="layout" content="nav" />
<title>MusiQ App</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<asset:stylesheet src="custom.css" />
</head>

<body>
	<div class="container">
		<div class="jumbotron transparent">

			<h1>Something went terribly wrong!</h1>

			<p class="lead">We're sending our tech monkeys to fix the
				problem. Please write down below error message and hand it with a
				banana to the monkey upon their arrival.</p>
			<g:img dir="images" alt="Happy-Monkeys" file="error-monkey.jpg"
				width="300" height="200" />
		</div>

		<div class="well transparent">
			<h2>Error message</h2>
			<br> ${ExceptionUtils.getRootCause(exception).message}
		</div>
	</div>
</body>
</html>