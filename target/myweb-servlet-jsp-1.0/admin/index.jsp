<%-- 
    Document   : index
    Created on : Oct 21, 2020
    Author     : Dawn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link href="index.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <p> Hello, <%= session.getAttribute("userID") %> </p>
        
        <div class="row">
            <div class="leftcolumn">
                <ul class="list-group">
                    <li>Dashboard</li>
                    <li>Staff Manager</li>
                </ul>
            </div>
            <div class="rightcolumn">
                <p>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</p>
            </div>
        </div>
    </body>
</html>
