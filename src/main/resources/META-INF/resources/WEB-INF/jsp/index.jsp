<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Birds page</title>
    <link rel="stylesheet" href="css/general_styling.css">
    <link rel="stylesheet" href="css/index_styling.css">
    <script src="/js/index.js"></script>
</head>
<body>
<%@ include file="common/navbar.jspf" %>
<h1 class="welcome-message">Welcome on the bird encyclopedia webpage!</h1>
<!--Container for bird descirption and photo-->
<div>
    <!--Bird introduction-->
    <div class="bird-description">
        <h2>Bird of the day:</h2>
        <h3>${birdOfTheDay.name}</h3>
        <p>
            ${birdOfTheDay.trivia}
        </p>
    </div>
    <!--Bird photo with a link and buttons-->
    <div>
        <a target="_blank"  class="article_href" href=${birdOfTheDay.article}>
            <img alt=${birdOfTheDay.name} class="bird-image" width="450" height="300"
                 src=${birdOfTheDay.imageSrc}>
        </a>
        <!--Buttons below the photo-->
        <div class="bird-of-the-day-buttons">
            <button class="favourites-button" onclick="
          onFavouritesClicked();
          ">
                Add to favourites
            </button>
        </div>
    </div>
</div>
</body>
</html>