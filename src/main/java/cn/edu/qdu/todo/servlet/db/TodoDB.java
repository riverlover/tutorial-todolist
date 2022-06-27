package cn.edu.qdu.todo.servlet.db;

import cn.edu.qdu.todo.servlet.bean.Todo;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟数据库
 */
public class TodoDB {
    //正在进行中的表
    public final static Map<String, Todo> ongoingList = new HashMap<>();
    //已经完成的表
    public final static Map<String, Todo> completedList = new HashMap<>();
}
