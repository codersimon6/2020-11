package jdbctest;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.*;
import java.sql.*;

public class jdbcTest {
    public static void main(String[] args) {
        query("孙");
    }

    public static void query(String queryName)  {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //使用DataSource创建数据库连接
            DataSource dataSource = new MysqlDataSource();
            ((MysqlDataSource)dataSource).setURL("jdbc:mysql://localhost:3306/stu?user=root&password=qq1234&useUnicode=true&characterEncoding=UTF-8");
            connection =  dataSource.getConnection();


            // 加载JDBC驱动程序：反射，这样调用初始化com.mysql.jdbc.Driver类，即将该类加载到JVM方法区，并执行该类的静态方法块、静态属性。
            //Class.forName("com.mysql.jdbc.Driver");
            // 1.创建数据库连接。
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu?user=root&password=qq1234&useUnicode=true&characterEncoding=UTF-8");

            // 2.创建操作命令对象(带占位符sql在数据库预编译，可以提高效率。占位符的方式防止SQL注入)
            String sql = "select id,name,sn,qq_mail from student  where name like ?";
            //statement = connection.createStatement();
            statement = connection.prepareStatement(sql);

            //替换占位符
            statement.setString(1,queryName+"%");

            // 3.执行
            resultSet = statement.executeQuery();

            // 4.处理结果集（ 类似List<Map<String,字段类型>> ）
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int sn = resultSet.getInt("sn");
                String name = resultSet.getString("name");
                String qq_mail = resultSet.getString("qq_mail");
                System.out.printf("id = %s,sn = %s,name = %s,qq_mail = %s\n",id,sn,name,qq_mail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 5.关闭连接（反向）
                if(resultSet != null)resultSet.close();
                if(statement != null)statement.close();
                if(connection != null)connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
