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
<!--Container for bird descirption and photo-->
<div>
    <h2>${bird.name}</h2>
    <a target="_blank"  class="article_href" href=${bird.article}>
        <img alt=${bird.name} class="bird-image" width="450" height="300"
             src=${bird.imageSrc}>
    </a>
    <div class="bird-description">
        <h4>Latin name: ${bird.latinName}</h4>
        <h4>Wingspan: ${bird.wingspanCm}</h4>
        <h4>Diet: ${bird.diet}</h4>
        <h4>Habitat: ${bird.continents}</h4>
        <h4>Conservation status: ${bird.conservationStatus}</h4>
        <h4>Dominant colors: ${bird.colors}</h4>
        <p>
            ${bird.trivia}
        </p>
    </div>
</div>
</body>
</html>