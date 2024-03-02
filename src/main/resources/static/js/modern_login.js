
const bodyContainer = document.getElementById('body-container');
const signUpButton = document.getElementById('sign-up-button');
const logInButton = document.getElementById('log-in-button');

signUpButton.addEventListener('click', () => {
    bodyContainer.classList.add("active");
});

logInButton.addEventListener('click', () => {
    bodyContainer.classList.remove("active");
});