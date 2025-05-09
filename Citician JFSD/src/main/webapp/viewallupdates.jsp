<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Citician</title>
    <link rel="stylesheet" href="css/viewallpoliticians.css">
</head>
<body>
    <div class="header">
        <div class="logo-container">
            <a href="adminhome"> <img src="images/image (1).png" alt="Logo" class="logo"></a>
            <h1 class="citician-title">Citician</h1>
        </div>
        <div class="nav">
            <a href="adminhome" class="nav-item home">Home</a>
            <a href="addpolitician" class="nav-item addpolitician">Add Politician</a>
            <a href="adminprofile" class="nav-item profile">Profile</a>
            <a href="adminlogin" class="nav-item logout">Logout</a>
        </div>
    </div>
</br>
<center><h2>Updates</h2></center>

<div class="main-content">
    <div class="updates">
        <table>
                <thead>
                    <tr>
                        <th>Update Id</th>
                        <th>Subject</th>
                        <th>Area/Constituency</th>
                        <th>MLA/MP</th>
                        <th>Update</th>
                        <th>Date</th>
                        <th>Remarks</th>
                    </tr>
                </thead>
                <c:forEach items="${updates}" var="update">
                <tbody>
                    <tr>
                        <td><c:out value="${update.updateId}"></c:out></td>
                        <td><c:out value="${update.subject}"></c:out></td>
                        <td><c:out value="${update.areaconstituency}"></c:out></td>
                        <td><c:out value="${update.mpmla}"></c:out></td>
                        <td><c:out value="${update.update}"></c:out></td>
                        <td><c:out value="${update.date}"></c:out></td>
                        <td><c:out value="${update.remarks}"></c:out></td>
                    </tr>
                </tbody>
                </c:forEach>
            </table>
    </div>
</div>
</body>
</html>
