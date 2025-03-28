<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>게시글 목록</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: 20px auto; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
    </style>
</head>
<body>
    <h1 style="text-align: center;">📋 게시글 목록</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th><th>제목</th><th>작성자</th><th>작성일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="post" items="${posts}">
                <tr>
                    <td>${post.id}</td>
                    <td>${post.title}</td>
                    <td>${post.author}</td>
                    <td>${post.createdAt}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
