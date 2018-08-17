package java3.lesson_2;

import java.sql.*;

public class MainClass {

    public static void main(String[] args) {
        Connect con1 = new Connect();
        try {
            con1.connect();
            con1.getStatement().executeUpdate("CREATE TABLE IF NOT EXISTS products (" +
                                                    "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                                                    "prodId INTEGER NOT NULL," +
                                                    "title TEXT NOT NULL," +
                                                    "price INTEGER NOT NULL);");
            con1.getStatement().executeUpdate("DELETE FROM products;");
            PreparedStatement pstm;
            pstm = con1.getConnection().prepareStatement("INSERT INTO products (prodId, title, price)" +
                                                                                  "VALUES (?,?,?);");
            con1.getConnection().setAutoCommit(false);
            for (int i = 1; i < 10001; i++) {
                pstm.setInt(1, i);
                pstm.setString(2, "Item" + i);
                pstm.setInt(3, i*10);
                pstm.addBatch();
            }
            pstm.executeBatch();
            con1.getConnection().setAutoCommit(true);
            new Price().enterCommand();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
        } finally {
            try {
                con1.disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

//        try {
//            connect();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                disconnect();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

//    }
//
//    public static void connect() throws ClassNotFoundException, SQLException {
//        Class.forName("org.sqlite.JDBC");
//        connection = DriverManager.getConnection("jdbc:sqlite:my.db");
//        stmt = connection.createStatement();
//    }
//    public static void disconnect() throws SQLException {
//        connection.close();
//    }
    }
}
