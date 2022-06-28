package cn.edu.qdu.todo.servlet;

import cn.edu.qdu.todo.servlet.bean.Todo;
import cn.edu.qdu.todo.servlet.dao.Dao;
import cn.edu.qdu.todo.servlet.dao.DaoFactory;
import cn.edu.qdu.todo.servlet.dao.Factory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class AddServlet extends HttpServlet {
    private final static DateFormat df = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

    private Dao dao;

    public AddServlet(Factory factory) {
        this.dao = factory.getDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String todoItem = req.getParameter("todoItem");

        Todo todo = new Todo();
        todo.setId(UUID.randomUUID().toString());
        todo.setTodoItem(todoItem);
        todo.setCreatedAt(df.format(new Date()));
//提到成员变量区域
//        TodoDao todoDao = new TodoDao();
        dao.add(todo);

        try {
            req.setAttribute("ongoingList", dao.getOngoingList());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("todoList.jsp").forward(req, resp);
    }
}
