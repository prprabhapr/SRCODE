<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:out value="${pageContext.request.contextPath}"/>/styles/displaytag.css"/>
<title>JDAL Spring MVC and DisplayTag Sample</title>
</head>
<body>
 
<form:form action="manageCategory" method="GET">
 <br>
 <h3> category list</h3>
  <table class="tg">
 <tr>
 <th width="80">category id</th>
 <th width="80">category name</th>
 <th width="80">category description</th>
 </tr>
 <c:forEach items="${list}" var="category">
 <tr>
 <td>${category.id}</td>
 <td>${category.name}</td>
 <td>${category.description}</td>
 </c:forEach>
 </table>
  </form:form>
</body>
</html>