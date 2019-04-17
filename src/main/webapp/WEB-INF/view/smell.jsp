<%--@elvariable id="report" type="org.wasps.viewmodel.ProjectSmellReportViewModel"--%>
<%--@elvariable id="classes" type="org.wasps.viewmodel.ClassViewModel"--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<html>
<head>
    <title>Fresh Smell</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
    <link href="<c:url value="/resources/static/css/smellsViewStylesheet.css" />" rel="stylesheet">
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="main-header">
    Fresh Smell
</div>
<div class="container d-flex h-100">
<div class="row container-fluid d-flex justify-content-center align-self-center">
    <div class="col-sm-6">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${report.finalScore}</h5>
                <p class="card-text">
                    <c:forEach items="${report.classes}" var="classModel">
                        <c:out value="${classModel.name}<br>"/>
                    </c:forEach>
                </p>
                <a href="#" class="btn btn-primary">View Details</a>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>


