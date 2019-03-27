<%--
  To change this template use Preferences | File and Code Templates | Other.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Upload File Request Page</title>
</head>
<body>
<form action="uploadFile" enctype="multipart/form-data" method="post">
    File to upload:
    <input type="file" name="file" /><br />
    <%--Name:--%>
    <%--<label>--%>
        <%--<input type="text" name="name">--%>
    <%--</label>--%>
    <br /> <br />
    <input type="submit" name="submit" value="Upload">
</form>
</body>
</html>