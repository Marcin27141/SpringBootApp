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
    <form method="post">
        <label>Name:</label>
        <input type="text" name="name" required="required">

        <label>Latin name:</label>
        <input type="text" name="latinName" required="required">

        <label>Wingspan in cm:</label>
        <input type="number" name="wingspanCm" required="required">

        <div class="extinction-div">
            <label>Conservation status:</label>
            <select name="conservationStatus" required="required">
                <option value="0">Least Concern</option>
                <option value="1">Near threatened</option>
                <option value="2">Vulnerable</option>
                <option value="3">Endangered</option>
                <option value="4">Critically Endangered</option>
                <option value="5">Extinct</option>
            </select>
        </div>

        <div class="continents-div">
            <label>Habitat:</label>
            <select name="continents" multiple required="required">
                <option value="0">Europe</option>
                <option value="1">Asia</option>
                <option value="2">Africa</option>
                <option value="3">North America</option>
                <option value="4">South America</option>
                <option value="5">Australia</option>
                <option value="6">Antarctica</option>
            </select>
        </div>


        <div>
            <label>Diet:</label>
            <div class="radio-group">
                <input type="radio" name="diet" id="0" value="0" checked="checked">
                <label for="0">Herbivorous</label>

                <input type="radio" name="diet" id="1" value="1">
                <label for="1">Carnivorous</label>

                <input type="radio" name="diet" id="2" value="2">
                <label for="2">Scavenger</label>

                <input type="radio" name="diet" id="3" value="3">
                <label for="3">Omnivorous</label>
            </div>
        </div>

        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>