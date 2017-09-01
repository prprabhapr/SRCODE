<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="robots" content="noindex, nofollow">

    <title>THIS IS ADDCATEGORY.JSP</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <style type="text/css">
    
    </style>
    <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        $( document ).ready(function() {
          var iframe_height = parseInt($('html').height()); 
          window.parent.postMessage( iframe_height, 'https://bootsnipp.com');
        });
    </script>
</head>
<%@ include file = "header.jsp" %>
<body>
<form class="form-horizontal" commandName="category" method="post" action="updateCategory1">
<legend>Category</legend>
<br><br><center>
<br><br>
 <div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
          <h1 class="text-center">UPDATE CATEGORY</h1>
        </div>
         <div class="modal-body">  
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Category Name</label>  
  <div class="col-md-4">
  <input id="name" name="name" type="text" value="${category.name}" placeholder="Enter your cname" class="form-control input-md" required="">
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="description">Category Description</label>  
  <div class="col-md-4">
  <input id="description" name="description" type="text" value="${category.description}"placeholder="Enter your cdescription" class="form-control input-md" required="">
  <br><center><button id="add" name="add" class="btn btn-success">Update</button></center>
  </div>
  
</div></div></div></div>
 </form>
 <br><br><br><br><br><%@ include file = "footer.jsp" %>
</body>
</html>