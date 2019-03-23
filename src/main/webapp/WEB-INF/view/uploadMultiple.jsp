<%--
  To change this template use Preferences | File and Code Templates | Other.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Upload Multiple File Request Page</title>
</head>
<body>
<form action="uploadMultipleFiles" enctype="multipart/form-data" method="post">
    <%--Note that file and name are the same input, so we have to parse them--%>
    File1 to upload: <input type="file" name="file"><br />
    File2 to upload: <input type="file" name="file"><br />
    <input type="submit" value="Upload"> Press here to upload the file!
</form>
</body>
</html>