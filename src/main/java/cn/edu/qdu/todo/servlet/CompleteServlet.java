package cn.edu.qdu.todo.servlet;

import cn.edu.qdu.todo.servlet.bean.Todo;
import cn.edu.qdu.todo.servlet.dao.TodoDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CompleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        //new 对象！！！！
        TodoDao todoDao = new TodoDao();
        Todo todo = todoDao.getTodo(id);
        todoDao.complete(todo);

        req.setAttribute("ongoingList", todoDao.getOngoingList());
        req.setAttribute("completedList", todoDao.getCompletedList());

        req.getRequestDispatcher("todoList.jsp").forward(req, resp);
    }
}
