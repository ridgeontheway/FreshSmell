<%--
  To change this template use Preferences | File and Code Templates | Other.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Upload Multiple File Request Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">

    <spring:url value="/resources/static/scripts/uploadMultipleScripts.js" var="uploadMultipleScripts" />
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${uploadMultipleScripts}"></script>
</head>
<body>
        <form action="uploadMultipleFiles" enctype="multipart/form-data" method="post">
            <div class="file-upload">
                <input type="file" name="file"><br />
                <input type="file" name="file"><br />
            </div>
            <input type="submit" value="Upload"> Upload Files
        </form>
<button class="btn btn-primary add-upload">Add Me</button>
</body>
</html>
