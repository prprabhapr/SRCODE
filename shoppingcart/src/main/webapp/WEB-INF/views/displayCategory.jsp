<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
<body>
 
<form:form action="manageCategory" method="GET">
 <br>
 <h3> category list</h3>
  <table border="2" width="70%" cellpadding="2"> 
 <tr>
 <td>category id</td>
 <td>category name</td>
 <td>category description<td>
 </tr>
 <c:forEach items="${list}" var="category">
 <tr>
 <td>${category.id}</td>
 <td>${category.name}</td>
 <td>${category.description}</td>
 <td><a href="#">
          <span class="glyphicon glyphicon-edit"></span>
        </a></td>
        <td><a href="#">
          <span class="glyphicon glyphicon-remove"></span>
        </a></td>
        </tr>
 </c:forEach>
 </table>
  </form:form>
</body>
</html>