package cn.edu.qdu.todo.servlet.dao;

import cn.edu.qdu.todo.servlet.bean.Todo;
import cn.edu.qdu.todo.servlet.db.TodoDB;

import java.util.Map;

public class TodoDao implements Dao {

    //查询全部
    public Map<String, Todo> getOngoingList(){
        return TodoDB.ongoingList;
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
