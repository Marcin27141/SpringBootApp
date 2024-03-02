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
<div class="navbar">
    <a class="left" href="website1.html">Home</a>
    <a class="left" href="about.html">About</a>
    <a class="right" href="login.html">Login</a>
    <a class="right" href="login.html">Register</a>
</div>
<%--<div class="bird-details-container hidden" id="birds-details">--%>
<%--    <div class="bird-intro">--%>
<%--        <img class="bird-details-image" src="https://janadamski.eu/wp-content/uploads/2021/02/modrosojka_06.jpg" alt="Bird picture" style="width:100%">--%>
<%--        <h1 class="details-name">Blue jay</h1>--%>
<%--        <h3 class="details-latin-name">Cyanocitta cristata</h3>--%>
<%--    </div>--%>
<%--    <div class="bird-trivia">--%>
<%--        The blue jay (Cyanocitta cristata) is a passerine bird in the family Corvidae, native to eastern North America. It lives in most of the eastern and central United States; some eastern populations may be migratory. Resident populations are also in Newfoundland, Canada; breeding populations are found across southern Canada. It breeds in both deciduous and coniferous forests, and is common in residential areas.--%>
<%--    </div>--%>
<%--    <div class="button-container">--%>
<%--        <button onclick="hideBirdsDetails()">Close</button>--%>
<%--    </div>--%>
<%--</div>--%>
<div class="main-container" id="main-container">
    <div class="header">
        <h1 class="welcome-message">Most interesting birds out there</h1>
        <h6 class="clarification-message">(In my humble opinion)</h6>
    </div>

    <div class="bird-cards">
        <c:forEach items="${birds}" var="bird">
            <div class="birdbox left">
                <img src="${bird.imageSrc}" alt="${bird.name}" style="width:100%">
                <div class="birdbox-content">
                    <h4 class="name">${bird.name}</h4>
                    <p class="name latinName">${bird.latinName}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<%--<script src="scripts/birdsList.js"></script>--%>
<%--<script>--%>
<%--    function showBirdsDetails(latinName) {--%>
<%--        const foundBird = birdsList.find(bird => bird.latinName === latinName);--%>
<%--        birdsDetailsImage.src = foundBird.photo;--%>
<%--        birdsDetailsName.textContent = foundBird.name;--%>
<%--        birdsDetailsLatinName.textContent = foundBird.latinName;--%>
<%--        birdsDetailsTrivia.textContent = foundBird.trivia;--%>

<%--        birdsDetails.classList.remove("hidden");--%>
<%--        mainContainer.classList.add("background");--%>
<%--    }--%>

<%--    function hideBirdsDetails() {--%>
<%--        birdsDetails.classList.add("hidden");--%>
<%--        mainContainer.classList.remove("background");--%>
<%--    }--%>

<%--    /*birdsList.forEach(bird => {--%>
<%--        console.log(bird.latinName)--%>
<%--    });*/--%>

<%--    let birdsDetails = document.getElementById("birds-details");--%>
<%--    let birdsDetailsImage = birdsDetails.querySelector(".bird-details-image");--%>
<%--    let birdsDetailsName = birdsDetails.querySelector(".details-name");--%>
<%--    let birdsDetailsLatinName = birdsDetails.querySelector(".details-latin-name");--%>
<%--    let birdsDetailsTrivia = birdsDetails.querySelector(".bird-trivia");--%>

<%--    let mainContainer = document.getElementById("main-container");--%>
<%--    let elements = document.getElementsByClassName("birdbox");--%>

<%--    for (let i = 0; i < elements.length; i++) {--%>
<%--        let birdbox = elements[i];--%>
<%--        let latinNameElement = birdbox.querySelector(".latinName");--%>
<%--        if (latinNameElement) {--%>
<%--            let latinNameValue = latinNameElement.textContent;--%>
<%--            birdbox.addEventListener("click", () => showBirdsDetails(latinNameValue));--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>