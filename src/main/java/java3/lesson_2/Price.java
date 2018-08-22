package java3.lesson_2;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Price {

    public void enterCommand() throws SQLException, ClassNotFoundException {
        ArrayList<StringBuilder> command = new ArrayList<StringBuilder>();
        command.add(new StringBuilder("/price item"));
        command.add(new StringBuilder("/change price item"));
        command.add(new StringBuilder("/prices between"));
        System.out.println("Введите команду:");
        Scanner scanner = new Scanner(System.in);
        StringBuilder str = new StringBuilder(scanner.nextLine());
        if (!str.toString().equals("q")) {
            StringBuilder number = new StringBuilder("");
            int i = str.length()-1;
            char c = str.charAt(i);
            while ((Character.isDigit(c) || (c == ' ') && i > 10)) {
                number.append(str.charAt(i));
                str.deleteCharAt(i);
                i--;
                c = str.charAt(i);
            }
            if (i < 10 || number.toString().equals("")) {
                System.out.println("Wrong command");
                enterCommand();
            } else {
                number.reverse();
                if (str.toString().equals(command.get(0).toString())) {
                    getPrice(number);
                } else if (str.toString().equals(command.get(1).toString())) {
                    setPrice(number);
                } else if (str.toString().equals(command.get(2).toString())) {
                    getBetween(number);
                } else {
                    System.out.println("Wrong command");
                    enterCommand();
                }
            }
        }
    }

    public void getPrice(StringBuilder number) throws SQLException, ClassNotFoundException {
        Connect con1 = new Connect();
        con1.connect();
        ResultSet rs;
        String result = number.toString();
        rs = con1.getStatement().executeQuery("SELECT price FROM products WHERE title='Item" + result + "';");
        if (!rs.next()) {
            System.out.println("There is no Item with this number");
        }
        else {
            System.out.println("Item" + result + " price is: " + rs.getInt("price"));
        }
    }

    public void setPrice(StringBuilder number) throws SQLException, ClassNotFoundException {
        String result = number.toString();
        String[] two = result.split(" ");
        if (two.length!=2) {
            System.out.println("Can't change the price!");
        } else {
            Connect con1 = new Connect();
            con1.connect();
            int res = con1.getStatement().executeUpdate("UPDATE products SET price=" + two[1] +
                    " WHERE title='Item" + two[0] + "';");
            if (res==0) {
                System.out.println("There is no item with this number");
            } else {
                System.out.println("Ок!");
            }
        }
    }

    public void getBetween(StringBuilder number) throws SQLException, ClassNotFoundException {
        String result = number.toString();
        String[] two = result.split(" ");
        if (two.length!=2) {
            System.out.println("Very bad command!");
        } else {
            Connect con1 = new Connect();
            con1.connect();
            ResultSet rs;
            rs = con1.getStatement().executeQuery("SELECT title FROM products WHERE price BETWEEN "
                    + two[0] + " AND " + two[1]);
            if (!rs.next()) {
                System.out.println("There is no item with this number");
                rs.previous();
            } else {
                System.out.println("List of items with this price:");
                while (rs.next()) {
                    System.out.println(rs.getString("title"));
                }
            }
        }
    }
}
