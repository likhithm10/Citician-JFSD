<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Citician</title>
        <link rel="stylesheet" href="css/respond.css">
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

    <div class="container">
        <h2>Respond to Issue</h2>
        <table>
            <tr>
               <th>Report Id</th>
                        <th>Subject</th>
                        <th>Village/ City/Town</th>
                        <th>Assembly</th>
                        <th>Parliment</th>
                        <th>Issue</th>
                        <th>Status</th>
                        <th>Remarks</th>
                <th>Action</th>
            </tr>
             <c:forEach items="${issues}" var="issue">
            <tr>
               <form action="updateIssue" method="post">
                        <td><input type="hidden" name="reportId" id="reportId" value="<c:out value='${issue.reportId}'/>">
            <c:out value="${issue.reportId}"/></td>
                        <td><c:out value="${issue.subject}"></c:out></td>
                        <td><c:out value="${issue.location}"></c:out></td>
                        <td><c:out value="${issue.assembly}"></c:out></td>
                        <td><c:out value="${issue.parliment}"></c:out></td>
                        <td><c:out value="${issue.issue}"></c:out></td>
                        <td>
                            <select name="status" id="status">
                            <option value="<c:out value="${issue.status}"></c:out>"><c:out value="${issue.status}"></c:out></option>
                                <option value="Not Solved">Not Solved</option>
                                <option value="InProgress">In Progress</option>
                                <option value="Solved">Solved</option>
                            </select>
                        </td>
                        <td>
                            <textarea name="remarks" id="remarks"><c:out value="${issue.remarks}"></c:out></textarea>
                        </td>
                        <td>
                            <button type="submit" class="update-btn">Update</button>
                        </td>
                    </form>
            </tr>
            </c:forEach>
        </table>
    </div>
    <script src="script.js"></script>
</body>
</html>
