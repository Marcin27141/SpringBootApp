<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Birds page</title>
    <link rel="stylesheet" href="css/general_styling.css">
    <link rel="stylesheet" href="css/create_bird.css">
</head>
<body>
<div class="navbar">
    <a class="left" href="website1.html">Home</a>
    <a class="left" href="about.html">About</a>
    <a class="right" href="login.html">Login</a>
    <a class="right" href="login.html">Register</a>
</div>
<h1 class="welcome-message">Create a bird</h1>
<div class="form-container">
    <form:form method="post" modelAttribute="bird">
        <label>Name:</label>
        <form:input type="text" path="name" required="required"/>

        <label>Latin name:</label>
        <form:input type="text" path="latinName" required="required"/>

        <label>Wingspan in cm:</label>
        <form:input type="number" path="wingspanCm" required="required"/>
        <form:errors path="wingspanCm"/>

        <div class="extinction-div">
            <label>Conservation status:</label>
            <form:select path="conservationStatus" required="required">
                <option value="0">Least Concern</option>
                <option value="1">Near threatened</option>
                <option value="2">Vulnerable</option>
                <option value="3">Endangered</option>
                <option value="4">Critically Endangered</option>
                <option value="5">Extinct</option>
            </form:select>
        </div>

        <div class="continents-div">
            <label>Habitat:</label>
            <form:select path="continents" multiple="multiple" required="required">
                <option value="0">Europe</option>
                <option value="1">Asia</option>
                <option value="2">Africa</option>
                <option value="3">North America</option>
                <option value="4">South America</option>
                <option value="5">Australia</option>
                <option value="6">Antarctica</option>
            </form:select>
        </div>

        <div class="colors-div">
            <label>Colors:</label>
            <form:select path="colors" multiple="multiple" required="required">
                <option>Black</option>
                <option>White</option>
                <option>Red</option>
                <option>Green</option>
                <option>Blue</option>
                <option>Yellow</option>
                <option>Grey</option>
                <option>Brown</option>
            </form:select>
        </div>


        <div>
            <label>Diet:</label>
            <div class="radio-group">
                <form:radiobutton path="diet" id="0" value="0" checked="checked"/>
                <label for="0">Herbivorous</label>

                <form:radiobutton path="diet" id="1" value="1"/>
                <label for="1">Carnivorous</label>

                <form:radiobutton path="diet" id="2" value="2"/>
                <label for="2">Scavenger</label>

                <form:radiobutton path="diet" id="3" value="3"/>
                <label for="3">Omnivorous</label>
            </div>
        </div>

        <label>Photo URL:</label>
        <form:input type="text" path="imageSrc"/>
        <form:errors path="imageSrc"/>

        <label>Article URL:</label>
        <form:input type="text" path="article"/>
        <form:errors path="article"/>

        <label>Trivia:</label>
        <form:textarea path="trivia" rows="8" cols="50"/>
        <form:errors path="trivia"/>

        <input type="submit" value="Submit">
    </form:form>
</div>
</body>
</html>