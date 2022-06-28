package cn.edu.qdu.todo.servlet.db;

import cn.edu.qdu.todo.servlet.bean.Todo;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class DBUtils {
    private static DataSource ds = null;
    private static final Properties PROPERTIES = new Properties();
    static {
        try {
            PROPERTIES.load(DBUtils.class.getResourceAsStream("/db.properties"));
            ds = DruidDataSourceFactory.createDataSource(PROPERTIES);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDs(){
        return ds;
    }

    public static void main(String[] args) throws SQLException {


        QueryRunner qr = new QueryRunner(DBUtils.getDs());
        List<Map<String, Object>> query = qr.query("select * from todo t", new MapListHandler());
        for (Map<String, Object> stringObjectMap : query) {
            System.out.println(stringObjectMap);
        }


        Todo query1 = qr.query("select * from todo t limit 1", new BeanHandler<>(Todo.class));
        System.out.println(query1.getId() + query1.getTodoItem());

    }
}
