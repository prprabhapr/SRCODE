<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head><title>THIS IS DISPLAYCAT.JSP</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  <%@ include file = "header.jsp" %><br><br><br>
<body  style="background-color:powderblue;">
<center>
 <form:form action="manageCategory" method="GET">
 <style>h2 {color:red;}</style><%--THIS STYLE TAG FOR h2--%>
 <h2> CATEGORY LIST</h2>
 <table border="4" width="40%" cellpadding="2"> 
 <tr>
 <td><center><b>CID</b></center></td>
 <td><center><b>CNAME</b></center></td>
 <td><center><b>CDESCRIPTION</b></center></td>
 </tr>
 <c:forEach items="${list}" var="category">
 <tr>
 <td><center>${category.id}</center></td>
 <td><center>${category.name}</center></td>
 <td><center>${category.description}</center></td>
 <td><center><a href="<c:url value='/manage_category_edit?id=${category.id}'/>"><span class="glyphicon glyphicon-edit"></span></a></center></td>
 <td><center><a href="<c:url value='/manage_category_delete?id=${category.id}'/>"><span class="glyphicon glyphicon-remove"></span></a></center></td>
 </tr>
 </c:forEach>
 </table>
 </form:form>
 </center>
 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><%@ include file = "footer.jsp" %>
</body>
</html>