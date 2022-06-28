package cn.edu.qdu.todo.servlet.dao;

import cn.edu.qdu.todo.servlet.bean.Todo;
import cn.edu.qdu.todo.servlet.db.TodoDB;

import java.sql.SQLException;
import java.util.Map;

public interface Dao {
    //查询全部
    Map<String, Todo> getOngoingList() throws SQLException;
    //添加待办
    String add(Todo todo);
    Todo getTodo(String id);
    boolean complete(Todo todo);
    Map<String, Todo> getCompletedList();
}
