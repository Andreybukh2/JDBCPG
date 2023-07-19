<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All people</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">


</head>
<body>

<div class="container text-center">
    <div><h1>Peoples list</h1></div>
    <div th:each="oneUser : ${allUsers}">
        <a class="row mt-1 btn btn-primary btn-sm" th:href="@{/movie/{id}(id=${oneMovie.getId()})}"
           th:text="${oneMovie.getName()}"></a>
    </div>

    <br/>

    <a class="row btn btn-success" th:href="@{/movie/new}">Create new people</a>

</div>
</body>
</html>
