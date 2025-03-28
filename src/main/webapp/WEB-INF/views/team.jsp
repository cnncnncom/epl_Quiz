
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Premier League Quiz</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
        }
        .quiz-container {
            background-color: #f4f4f4;
            padding: 20px;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div class="quiz-container">
    <h1>Premier League Quiz</h1>
    <p>${quizQuestion}</p>

    <form method="POST" action="/submit">
        <input type="text" name="answer" placeholder="Your answer">
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>