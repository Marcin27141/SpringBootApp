let birdIsLiked = false;

function onFavouritesClicked() {
    const likedButton = document.querySelector('.favourites-button');
    if (!birdIsLiked) {
        likedButton.innerText = 'Added';
        birdIsLiked = true;
    } else {
        likedButton.innerText = 'Add to favourites';
        birdIsLiked = false;
    }
}