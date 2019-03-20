<%--
  To change this template use Preferences | File and Code Templates | Other.
--%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to CodeSmeller</title>
</head>
<body>
    <h1>Welcome to CodeSmeller</h1>
    <%--@elvariable id="SourceFile" type=""--%>
    <form:form modelAttribute="SourceFile">
        <label for="textinput1">Enter File Name:</label>
        <form:input path="name" />
        <br>
        <input type="submit" class="btn" value="Enter">
    </form:form>
</body>
</html>
