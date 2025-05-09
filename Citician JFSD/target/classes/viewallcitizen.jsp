<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Citician</title>
        <link rel="stylesheet" href="css/viewallcitizen.css">
    </head>
    <body>
        <div class="header">
            <div class="logo-container">
                <a href="politicianhome"> <img src="images/image (1).png" alt="Logo" class="logo"></a>
                <h1 class="citician-title">Citician</h1>
            </div>
            <div class="nav">
                <a href="politicianhome" class="nav-item home">Home</a>
                <a href="#" class="nav-item about">About</a>
                <a href="politicianprofile" class="nav-item profile">Profile</a>
                <a href="politicianlogin" class="nav-item logout">Logout</a>
            </div>
        </div>
    </br>
    <center><h2>View All Citizens</h2></center>
    <div class="main-content">
        
        <div class="updates">
       <table>
        <tr>
            <th>EPIC Number</th>
            <th>Full Name</th>
            <th>Phone Number</th>
            <th>Village/City/Town</th>
            <th>Assembly</th>
            <th>Parliament</th>
            <th>State</th>
        </tr>
        <c:forEach items="${citizens}" var="citizen">
        <tr>
            <td><c:out value="${citizen.epicCardNumber}"></c:out></td>
            <td><c:out value="${citizen.fullName}"></c:out></td>
            <td><c:out value="${citizen.mobileNumber}"></c:out></td>
            <td><c:out value="${citizen.villageCityTown}"></c:out></td>
            <td><c:out value="${citizen.assembly}"></c:out></td>
            <td><c:out value="${citizen.parliament}"></c:out></td>
            <td><c:out value="${citizen.state}"></c:out></td>
        </tr>
        </c:forEach>
    </table>
    </div>
    
    <script src="script.js"></script>
</body>
</html>
