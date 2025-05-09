<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Citician</title>
        <link rel="stylesheet" href="css/postupdate.css">
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
<center><h2>Post an Update</h2></center>

<div class="main-content">
        
    <form class="update-form" method="post" action="addupdate">
        
        <div class="form-group">
            <label for="subject">Subject<span class="required">*</span>:</label>
            <input type="text" id="subject" name="subject" required>
        </div>
        
        <div class="form-group">
            <label for="update">Update<span class="required">*</span>:</label>
            <textarea id="update" name="update" rows="4" required></textarea>
        </div>
        <div class="form-group">
            <label for="remarks">Remarks<span class="required">*</span>:</label>
            <textarea id="remarks" name="remarks" rows="2"></textarea>
        </div>
        <button type="submit" class="submit-button">Submit</button>
    </form>
</div>
  
     

    <script src="script.js"></script>
</body>
</html>
