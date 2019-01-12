package chapter_1.com.flexible;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:多綫程使用策略模式,实现单已职责
 * User: chendom
 * Date: 2019-01-11
 * Time: 8:22
 */
public class StrategyDemo {
    private final Connection connection;
    public StrategyDemo(Connection connection) {
        this.connection = connection;
    }

    /**
     * 负责查询数据
     * @param handler
     * @param sql
     * @param params
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T> T query(RowHandler<T> handler,String sql,Object... params) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            int index=1;
            for (Object param:params){
                stmt.setObject(index++,param);
            }
            ResultSet resultSet = stmt.executeQuery();
            return handler.handl(resultSet);
        }
    }



    public static void main(String[] args) {
        StrategyDemo strategyDemo = new StrategyDemo(null);
        try {
            strategyDemo.query(new RowHandler<String>() {
                @Override
                public String handl(ResultSet rs) {
                    return "";
                }
            },"xxx",new String[]{"1","2"});
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 这个类的只负责处理数据
     * @param <T>
     */
    public interface RowHandler<T>{
        T handl(ResultSet rs);
    }
}
