<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Upload Multiple File Request Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
    <link href="<c:url value="/resources/static/css/mainStylesheet.css" />" rel="stylesheet">
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="main-header">
        Fresh Smell
    </div>
    <div class="container d-flex h-100">
        <div class="main container-fluid d-flex row justify-content-center align-self-center">
            <form action="uploadFiles" enctype="multipart/form-data" method="post" class="upload-form">
                <label for="file-upload" class="custom-file-upload">
                    <i class="fa fa-cloud-upload"></i> Select Files
                </label>
                    <input id="file-upload" class="my-button" type="file" name="file" multiple="multiple"><br />
                <input class="my-button" type="submit" value="Smell">
            </form>
        </div>
        <%--<div class="uploaded-files-area">--%>
            <%--Files to Smell:--%>
            <%--<% for (int i=0; i<files.size(); i+=1) %>--%>
            <%--<tr>--%>
                <%--<td>${files.get(i).getName()}</td>--%>
            <%--</tr>--%>
            <%--<% } %>--%>
        <%--</div>--%>
    </div>
</body>
</html>


