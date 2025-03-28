<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>글쓰기</title>
</head>
<body>
<h1>📝 새 글 작성</h1>
<form:form method="POST" modelAttribute="post" action="/post/posts">
    <table>
        <tr>
            <td>제목</td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><form:textarea path="content" rows="5" cols="40"/></td>
        </tr>
        <tr>
            <td>작성자</td>
            <td><form:input path="author"/></td>
        </tr>
    </table>
    <input type="submit" value="등록"/>
</form:form>
<a href="/post/posts">목록으로 돌아가기</a>
</body>
</html>
