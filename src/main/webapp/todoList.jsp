<%@ page pageEncoding="utf-8" %>
<html>
    <head>
        <title>待办任务列表</title>
    </head>

    <body>
        <header>
            <!-- 提交待办的表单项 -->
            <form>
                <input type="text" placeholder="请输入待办事项"/>
                <input type="submit" value="添加"/>
            </form>
        </header>

        <hr>
        <h3>正在进行中的3项任务</h3>
        <ol>
            <li>吃饭  <a href="#">已完成</a></li>
            <li>上课  <a href="#">已完成</a></li>
            <li>睡觉  <a href="#">已完成</a></li>
        </ol>

        <hr>
        <h3>已经完成的2项任务</h3>
        <ol>
            <li>小目标1 <a href="#">删除</a></li>
            <li>小目标2 <a href="#">删除</a></li>
        </ol>

    </body>
</html>