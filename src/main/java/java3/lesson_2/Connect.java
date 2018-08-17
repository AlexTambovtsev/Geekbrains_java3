package java3.lesson_2;

import java.sql.*;

public class Connect {
    private Connection connection;
    private Statement statement;
//    private PreparedStatement pstm;
//
//    public PreparedStatement getPstm() {
//        return pstm;
//    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:my.db");
        statement = connection.createStatement();
    }

    public void disconnect() throws SQLException {
        connection.close();
    }
}
