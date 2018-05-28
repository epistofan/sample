<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Simple Login Form</title>


<link rel="stylesheet" type="text/css" href="resources/reset.css">
<link rel="stylesheet" type="text/css" href="resources/structure.css">
</head>

<body>
<center><h1>${msg}<h2></center>
<br>
<center><h1>${failMessage}<h2></center>


        <form:form method="POST" action="/myProject/checkUser" modelAttribute="user" class="box login">
         <fieldset class="boxBody">
                    <form:label path="userName">Username</form:label>
                    <form:input path="userName" tabindex="1" required="required" placeholder="PremiumPixel"/>

         	  <label><a href="#" class="rLink" tabindex="5">Forget your password?</a></label>

                    <form:label path="userPassword">Password</form:label>
                    <form:password path="userPassword" tabindex="2" required="required"/>
         	</fieldset>
         	<footer>
         	  <label><input type="checkbox" tabindex="3">Keep me logged in</label>
         	  <input type="submit" class="btnLogin" value="Login" tabindex="4">
         	</footer>
        </form:form>

<footer id="main">
  <a href="http://wwww.cssjunction.com">Simple Login Form (HTML5/CSS3 Coded) by CSS Junction</a> | <a href="http://www.premiumpixels.com">PSD by Premium Pixels</a>
</footer>

</body>
</html>
