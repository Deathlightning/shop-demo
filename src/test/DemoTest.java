import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import org.junit.Test;
import xyz.kingsword.shopdemo.model.bean.Good;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wzh date: 2019-05-10 21:08
 * @version: 1.0
 **/
public class DemoTest {
    @Test
    public void test() {
        long t1 = System.currentTimeMillis();
        String url = "jdbc:mysql://10.32.6.132:3306/shopdemo?useUnicode=true&characterEncoding=utf-8&useSSL=false&rewriteBatchedStatements=true";
        String username = "root";
        String password = "123456";
        try {
            String sql = "insert into goods values(?,?,?,?,?,?,?,?)";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            for (int i = 0; i < 1000; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, "商品");
                preparedStatement.setString(3, "http");
                preparedStatement.setString(4, "description");
                preparedStatement.setString(5, "classify");
                preparedStatement.setDouble(6, 1.1);
                preparedStatement.setInt(7, 10);
                preparedStatement.setString(8, "[]");
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("用时：" + (t2 - t1) + "ms");
    }

    @Test
    public void DbUtil() {
        long t1 = System.currentTimeMillis();
        String sql = "insert into goods values(?,?,?,?,?,?,?,?)";
        Object[][] objects = new Object[1000][8];
        for (int i = 0; i < 1000; i++) {
            objects[i][0] = i;
            objects[i][1] = "商品";
            objects[i][2] = "http";
            objects[i][3] = "description";
            objects[i][4] = "classify";
            objects[i][5] = 1;
            objects[i][6] = 10;
            objects[i][7] = "[]";
        }
        try {
            Db.use().executeBatch(sql, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("用时：" + (t2 - t1) + "ms");
    }

    @Test
    public void DbUtil2() {
        long t1 = System.currentTimeMillis();
        List<Entity> entityList = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            Good good = new Good();
            good.setId(i);
            good.setName("商品");
            good.setNumber(20);
            good.setAttributes("[]");
            good.setClassify("分类");
            good.setDescription("description");
            good.setPhoto("http::");
            good.setPrice(10.2);
            Entity entity = Entity.create("goods").parseBean(good);
            entityList.add(entity);
        }
        try {
            Db.use().insert(entityList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("用时：" + (t2 - t1) + "ms");
    }

}
