package cn.edu.qdu.todo.servlet.bean;

public class Todo {
    //主键
    private String id;
    //事项
    private String todoItem;
    //创建时间
    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(String todoItem) {
        this.todoItem = todoItem;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
