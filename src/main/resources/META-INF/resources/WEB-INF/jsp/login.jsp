<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/login_modern.css">

</head>
<body>
    <div class="body-container" id="body-container">
        <div class="form-container log-in-container">
            <form method="post">
                <h1>Log in</h1>
                <input type="text" placeholder="Username" name="username">
                <input type="password" placeholder="Password" name="password">
                <span class="errorMsg">${loginFailed}</span>
                <a href="#">Forgot your password?</a>
                <button type="submit">Log in</button>
            </form>
        </div>
        <div class="form-container sign-up-container">
            <form method="post">
                <h1>Sign up</h1>
                <input type="email" placeholder="Email" name="email">
                <input type="text" placeholder="Username" name="username">
                <input type="password" placeholder="Password" name="password">
                <button type="submit">Sign up</button>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-right">
                    <h1>Welcome!</h1>
                    <p>Sign up for the beautiful journey!</p>
                    <button class="hidden" id="sign-up-button">Sign up</button>
                </div>
                <div class="toggle-panel toggle-left">
                    <h1>Great to see you again!</h1>
                    <p>Sign in to continue your journey!</p>
                    <button class="hidden" id="log-in-button">Log in</button>
                </div>
            </div>
        </div>
    </div>
    <script src="js/modern_login.js"></script>
</body>
</html>