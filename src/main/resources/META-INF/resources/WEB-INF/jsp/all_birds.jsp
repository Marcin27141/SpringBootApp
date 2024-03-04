<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/general_styling.css">
    <link rel="stylesheet" href="/css/all_birds_styling.css">
</head>
<body>
<%@ include file="common/navbar.jspf" %>
<div class="main-container" id="main-container">
    <div class="header">
        <h1 class="welcome-message">Most interesting birds out there</h1>
        <h6 class="clarification-message">(In my humble opinion)</h6>
    </div>

    <div class="bird-cards">
        <c:forEach items="${birds}" var="bird">
            <a href="/${bird.id}" style="text-decoration: none; color: inherit; text-transform: none">
                <div class="birdbox left">
                    <img src="${bird.imageSrc}" alt="${bird.name}" style="width:100%">
                    <div class="birdbox-content">
                        <h4 class="name">${bird.name}</h4>
                        <p class="name latinName">${bird.latinName}</p>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>
</body>
</html>