<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<script src="Validation.js"></script>
<link rel="stylesheet" href="style.css">
<head>
  <title>Prime Number Calculator</title>
</head>
<body>
<h1>Prime Number Calculator</h1>
<form action="calculate" method="post" novalidate > <!-- onsubmit="return validateForm();" -->
  <laba>Enter the upper boundary: </laba>
  <input type="number" name="upperBound" id="upperBound">
  <input type="submit" value="Calculate">
</form>

<p id="clientErrorMessage" style="color: red;"></p>


<%
  List<Integer> primes = (List<Integer>) request.getAttribute("primes");
  Integer upperBound = (Integer) request.getAttribute("upperBound");
  String errorMessage = (String) request.getAttribute("errorMessage");
%>

<% if (errorMessage != null) { %>
<p style="color: red;"><%= errorMessage %></p>
<% } %>

<div id="primeNumbersSection">
  <% if (upperBound != null && primes != null && !primes.isEmpty()) { %>
  <p>Prime numbers up to <%= upperBound %>: <%= primes.toString() %></p>
  <% } %>
</div>

<footer>Batuhan Seyhan</footer>
</body>
</html>
