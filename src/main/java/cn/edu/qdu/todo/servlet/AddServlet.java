package cn.edu.qdu.todo.servlet;

import cn.edu.qdu.todo.servlet.bean.Todo;
import cn.edu.qdu.todo.servlet.dao.TodoDao;
import cn.edu.qdu.todo.servlet.db.TodoDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class AddServlet extends HttpServlet {
    private final static DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String todoItem = req.getParameter("todoItem");

        Todo todo = new Todo();
        todo.setId(UUID.randomUUID().toString());
        todo.setTodoItem(todoItem);
        todo.setCreatedAt(df.format(new Date()));

        //new 对象！！！！
        TodoDao todoDao = new TodoDao();
        todoDao.add(todo);

        req.setAttribute("ongoingList", todoDao.getOngoingList());

        req.getRequestDispatcher("todoList.jsp").forward(req, resp);
    }
}
