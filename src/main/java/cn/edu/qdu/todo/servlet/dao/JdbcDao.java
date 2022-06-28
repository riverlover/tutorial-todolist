package cn.edu.qdu.todo.servlet.dao;

import cn.edu.qdu.todo.servlet.bean.Todo;
import cn.edu.qdu.todo.servlet.db.DBUtils;
import cn.edu.qdu.todo.servlet.db.TodoDB;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcDao implements Dao {
    private final DataSource ds = DBUtils.getDs();

    //查询全部
    public Map<String, Todo> getOngoingList() throws SQLException {
        Map<String, Todo> ongoingList = new HashMap<>();
        QueryRunner qr = new QueryRunner(ds);
        List<Map<String, Object>> maps = qr.query("select * from todo", new MapListHandler());
        for (Map<String, Object> map : maps) {
            Todo todo = new Todo();
            todo.setId(map.get("id").toString());
            todo.setTodoItem(map.get("todo_item").toString());
            todo.setCreatedAt(map.get("created_at").toString());
            ongoingList.put(todo.getId(), todo);
        }
        return ongoingList;
    }

    //添加待办
    public String add(Todo todo){
        TodoDB.ongoingList.put(todo.getId(), todo);
        return todo.getId();
    }

    /**
     * 根据id获取正在进行的待办项
     * @param id 待办项记录ID
     * @return 待办项
     */
    public Todo getTodo(String id){
        Todo todo = TodoDB.ongoingList.get(id);
        return todo;
    }

    /**
     *
     * @param todox
     * @return
     */
    public boolean complete(Todo todo){
        TodoDB.ongoingList.remove(todo.getId());
        TodoDB.completedList.put(todo.getId(), todo);
        return true;
    }

    public Map<String, Todo> getCompletedList() {
        return TodoDB.completedList;
    }
}
