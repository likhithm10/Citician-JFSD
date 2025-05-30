<%@page import="com.klef.jfsd.springboot.model.Politician"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%
 Politician p = (Politician)session.getAttribute("politician");
    %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Citician</title>
        <link rel="stylesheet" href="css/politicianhome.css">
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
    </br></br>
    &nbsp;Welcome <%= p != null ? p.getFullName() : "" %>
    <div class="main-content">
        <div class="section">
    
            
                <a href="respond" class="card">
                <div class="card-content">
                    <img src="images/report.jpg" alt="Respond to an Issue" class="card-image">
                    <div class="card-text">
                        <h2 class="card-title">Respond to an Issue</h2>
                        <p>Respond to the problem that people are facing in your constituency</p>
                    </div>
                </div>
                </a>
    </br>
    <a href="viewallcitizen" class="card">
        <div class="card-content">
            <img src="images/track.jpg" alt="View all Citizens" class="card-image">
            <div class="card-text">
                <h2 class="card-title">View all citizens</h2>
                <p>View all the citizens of your constituency</p>
            </div>
        </div>
</a>
    </div>


<div class="section">
    <a href="postupdate" class="card">
        <div class="card-content">
        <img src="images/update.jpg" alt="Post updates" class="card-image">
        <div class="card-text">
        <h2 class="card-title">Post Updates</h2>
        <p >Post all the updates of your constituency</p>
        </div>
    </div>
    </a>
</br>
<a href="feedbackpage" class="card">
        <div class="card-content">
        <img src="images/feedback.jpg" alt="View Feedback" class="card-image">
        <div class="card-text">
        <h2 class="card-title">View Feedback</h2>
        <p >You can View all feedbacks on resolving issues or on governance</p>
    </div>
        </div>
</a>
</div>

<div class="word-cloud">
    <img src="images/6336694401358742282.jpg" alt="Word Cloud">
</div>
</div>

<footer>
    <div class="footer-content">
        <p>****</p>
        <p>@All Rights reserved</p>
    </div>
</footer>

<script src="script.js"></script>
</body>
</html>
