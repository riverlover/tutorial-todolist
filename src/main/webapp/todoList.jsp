<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>待办任务列表</title>
    </head>

    <body>
        <header>
            <!-- 提交待办的表单项 -->
            <form action="add" method="post">
                <input type="text" name="todoItem" placeholder="请输入待办事项"/>
                <input type="submit" value="添加"/>
            </form>
        </header>

        <hr>
        <h3>正在进行中的 ${requestScope.ongoingList.size()}项任务</h3>
        <ol>
            <c:forEach var="entry" items="${requestScope.ongoingList}">
                <li>${entry.value.todoItem}  ${entry.value.createdAt} <a href="complete?id=${entry.key}">已完成</a></li>
            </c:forEach>
<!--            <li>吃饭  <a href="#">已完成</a></li>-->
<!--            <li>上课  <a href="#">已完成</a></li>-->
<!--            <li>睡觉  <a href="#">已完成</a></li>-->
        </ol>

        <hr>
        <h3>已经完成的${requestScope.completedList.size()}项任务</h3>
        <ol>
            <c:forEach var="entry" items="${requestScope.completedList}">
                <li>${entry.value.todoItem}  ${entry.value.createdAt} <a href="delete">删除</a></li>
            </c:forEach>
<!--            <li>小目标1 <a href="#">删除</a></li>-->
<!--            <li>小目标2 <a href="#">删除</a></li>-->
        </ol>

    </body>
</html>