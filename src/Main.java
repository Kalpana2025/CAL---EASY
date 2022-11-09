import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Main {
    static Connection connection;

    public static void main(String[] args) {
        double result=0;
        Scanner sc = new Scanner(System.in);
        String[] testString = new String[1];

        for(int i=0;i<testString.length;i++){
            testString[i] = sc.nextLine();
        }

        expANDeval converter = new expANDeval();


        for (int i=0; i<testString.length; i++) {
            result = converter.evaluate( converter.convertToPostfix(testString[i]));
        }
        System.out.println(result);


        connection = getConnection();
        try{
            Statement s=connection.createStatement();
            String query ="insert into history(input,output) VALUES('"+Arrays.toString(testString)+"',"+result+")";
       s.execute(query);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static Connection getConnection() {
        if (connection != null) return connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/dummy";
            connection = DriverManager.getConnection(url, "root", "12345678");
            System.out.println("Database connected");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}